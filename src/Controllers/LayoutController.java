/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import GeneralClass.User;
import Model.Database;
import View.MainView;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author pongp
 */
public class LayoutController extends Router implements WindowListener, Controller {

    private static User user;

    private MainView mainView;

    private static AuthController authController;
    private static MainController mainController;

    Database database;

    public LayoutController() {
        loadUserFromPc();
        database = new Database();

        mainView = new MainView();
        mainView.getFrame().addWindowListener(this);

        authController = new AuthController(this);

        if (LayoutController.user != null) {
            mainController = new MainController(this);
            changeRoute("mainlayout");
        } else {
            changeRoute("authlayout");
        }

    }

    public static void setUser(User user) {
        LayoutController.user = user;
    }

    public static User getUser() {
        return LayoutController.user;
    }

    private void loadUserFromPc() {
        File f = new File("./user.dat");
        if (f.exists()) {
            try ( FileInputStream fin = new FileInputStream(f);  ObjectInputStream in = new ObjectInputStream(fin)) {
                LayoutController.user = (User) in.readObject();
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
            }
        }
    }

    private void saveUserToPc() {
        try ( FileOutputStream fOut = new FileOutputStream("./user.dat");  ObjectOutputStream oout = new ObjectOutputStream(fOut)) {
            oout.writeObject(LayoutController.user);
            System.out.println("Saved user");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    @Override
    public void changeRoute(String name) {
        name = name.toLowerCase();
//        if login success (if create MainController while user is null will error)
        if (LayoutController.user != null) {
            mainController = new MainController(this);
        }
        
        if (name.equals(getClassName(authController.getLayout()))) {
            replacePanel(mainView.getPanel(), authController.getLayout());
        } else if (mainController != null && name.equals(getClassName(mainController.getLayout()))) {
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
        saveUserToPc();
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
