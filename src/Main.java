
import Layout.*;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class Main {
    
    private JFrame fr;
    private AuthLayout auth;
    private MainLayout main;

    public Main() {
        fr = new JFrame("Meow Clinic");
        auth = new AuthLayout();
        main = new MainLayout();
        fr.add(auth);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(1280, 720);
        fr.setResizable(false);
        fr.setVisible(true);
    }

    public static void main(String args[]) {
        new Main();
    }
}
