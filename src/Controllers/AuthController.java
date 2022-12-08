/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Auth.*;
import Layouts.AuthLayout;
import javax.swing.JPanel;

/**
 *
 * @author pongp
 */
public class AuthController extends Router {

    private LayoutController layController;
    private AuthLayout authLayout;
    private JPanel signup, signin;

    public AuthController(LayoutController layController) {
        this.layController = layController;
        authLayout = new AuthLayout(this.layController);

        signup = new SignUpForm(this);
        signin = new SignInForm(this);

        changeRoute("signinform");
    }

    public AuthLayout getLayout() {
        return this.authLayout;
    }

    public void SignUp(String username, String password) {
        System.out.println(username + " " + password);
        layController.changeRoute("mainlayout");
    }

    public void SignIn(String displayName, String username, String password, String confirmPassword) {
        System.out.println(displayName + " " + username + " " + password);
        changeRoute("signinform");
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
