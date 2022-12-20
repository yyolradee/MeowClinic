/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Auth.*;
import GeneralClass.User;
import Layouts.AuthLayout;
import Model.AuthModel;
import java.util.regex.Pattern;
import javax.swing.JPanel;

/**
 *
 * @author pongp
 */
public class AuthController extends Router implements Controller {

    private LayoutController layController;
    private AuthLayout authLayout;
    private SignUpForm signup;
    private SignInForm signin;

    private AuthModel auth;

    public AuthController(LayoutController layController) {
        this.layController = layController;
        authLayout = new AuthLayout(this.layController);

        signup = new SignUpForm(this);
        signin = new SignInForm(this);

        auth = new AuthModel();

        changeRoute("signinform");
    }

    @Override
    public AuthLayout getLayout() {
        return this.authLayout;
    }

    public void SignIn(String username, String password) {
        signin.setError("");
        User userLogin = auth.checkUsernameAndPassword(username, password);
        LayoutController.setUser(userLogin);
        if (userLogin != null) {
            this.signin.clearForm();
            layController.changeRoute("mainlayout");
        } else {
            signin.setError("Error: username or password is wrong");
        }
    }

    public void SignUp(String displayName, String username, String password, String confirmPassword) {
        signup.setError("");
        if (displayName.equals("") || username.equals("") || password.equals("") || confirmPassword.equals("")) {
            signup.setError("Error: please fill out the form");
        } else if (username.length() < 6) {
            signup.setError("Error: username must be at least 6 letter");
        } else if (!Pattern.matches("^[A-Za-z0-9_.]+$", username)) {
            signup.setError("Error: username format is incorrect (a-z, 0-9, _, .)");
        } else if (auth.checkExistUsername(username)) {
            signup.setError("Error: username already taken");
        } else if (password.length() < 6) {
            signup.setError("Error: password must be at least 6 letter");
        } else if (!password.equals(confirmPassword)) {
            signup.setError("Error: password not match");
        } else {
            auth.addUser(username, displayName, password);
            this.signup.clearForm();
            changeRoute("signinform");
        }
    }

    @Override
    public void changeRoute(String name) {
        name = name.toLowerCase();
        if (name.equals(getClassName(signup))) {
            replacePanel(authLayout.getPanel(), signup);
        } else if (name.equals(getClassName(signin))) {
            replacePanel(authLayout.getPanel(), signin);
        }
    }

}
