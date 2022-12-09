/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.Database;
import View.MainView;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JPanel;

/**
 *
 * @author pongp
 */
public class LayoutController extends Router implements WindowListener, Controller {

    private MainView mainView;

    private AuthController authController;
    private MainController mainController;

    Database database;

    public LayoutController() {
        database = new Database();

        mainView = new MainView();
        mainView.getFrame().addWindowListener(this);

        authController = new AuthController(this);
        mainController = new MainController(this);

        changeRoute("mainlayout");
    }

    @Override
    public void changeRoute(String name) {
        name = name.toLowerCase();
        if (name.equals(getClassName(authController.getLayout()))) {
            replacePanel(mainView.getPanel(), authController.getLayout());
        } else if (name.equals(getClassName(mainController.getLayout()))) {
            replacePanel(mainView.getPanel(), mainController.getLayout());
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Close connection");
        database.closeConnection();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public JPanel getLayout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
