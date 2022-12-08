package View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pongp
 */
public class MainView {
    
    private JFrame fr;
    private JPanel panel;
    
    public MainView() {
        fr = new JFrame("Meow Clinic");
        this.panel = new JPanel();
        this.panel.setLayout(new BorderLayout());
        fr.setContentPane(this.panel);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(1280, 720);
        fr.setResizable(false);
        fr.setVisible(true);
    }
    
    public JFrame getFrame() {
        return this.fr;
    }
    
    public JPanel getPanel() {
        return this.panel;
    }
    
}
