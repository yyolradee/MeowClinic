/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import javax.swing.JPanel;

/**
 *
 * @author pongp
 */
public abstract class Router {

    public abstract void changeRoute(String name);

    public String getClassName(Object obj) {
        return String.valueOf(obj.getClass()).split("\\.")[1].toLowerCase();
    }

    public void replacePanel(JPanel panel1, JPanel panel2) {
        panel1.removeAll();
        panel1.add(panel2);
        panel1.repaint();
        panel1.revalidate();
    }
}
