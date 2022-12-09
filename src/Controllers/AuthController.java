/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Auth.*;
import Layouts.AuthLayout;
import Model.UserModel;
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

    private UserModel user;

    public AuthController(LayoutController layController) {
        this.layController = layController;
        authLayout = new AuthLayout(this.layController);

        signup = new SignUpForm(this);
        signin = new SignInForm(this);

        user = new UserModel();

        changeRoute("signinform");
    }

    @Override
    public AuthLayout getLayout() {
        return this.authLayout;
    }

    public void SignUp(String username, String password) {
        if (user.checkUsernameAndPassword(username, password)) {
            layController.changeRoute("mainlayout");
        } else {
            signin.setError("Error: username or password is wrong");
        }
    }

    public void SignIn(String displayName, String username, String password, String confirmPassword) {
        signup.setError("");
        if (displayName.equals("") || username.equals("") || password.equals("") || confirmPassword.equals("")) {
            signup.setError("Error: please fill out the form");
        } else if (user.checkExistUsername(username)) {
            signup.setError("Error: username already taken");
        } else if (password.length() < 6) {
            signup.setError("Error: password must be at least 6 letter");
        } else if (!password.equals(confirmPassword)) {
            signup.setError("Error: password not match");
        } else {
            System.out.println(displayName + " " + username + " " + password);
            user.addUser(username, displayName, password);
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
