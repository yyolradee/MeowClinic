
import Model.Database;
import Layout.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class Main implements WindowListener {

    private JFrame fr;
    private AuthLayout auth;
    private MainLayout main;
    Database database;

    public Main() {
        database = new Database();
        fr = new JFrame("Meow Clinic");
        auth = new AuthLayout();
        main = new MainLayout();
        fr.add(auth);
        fr.addWindowListener(this);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(1280, 720);
        fr.setResizable(false);
        fr.setVisible(true);
    }

    public static void main(String args[]) {
        new Main();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
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
}
