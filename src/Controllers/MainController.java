/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Layouts.MainLayout;
import Pages.*;
import javax.swing.JPanel;

/**
 *
 * @author pongp
 */
public class MainController extends Router {

    private MainLayout mainLayout;

    private JPanel Queue, Records, Cashier, Setting;

    public MainController(LayoutController layController) {
        mainLayout = new MainLayout(layController, this);

        Queue = new Queue();
        Records = new Records();
        Cashier = new Cashier();
        Setting = new Setting();

        changeRoute("queue");
    }

    @Override
    public void changeRoute(String name) {
        name = name.toLowerCase();
        if (name.equals(getClassName(Queue))) {
            replacePanel(mainLayout.getPanel(), Queue);
        } else if (name.equals(getClassName(Records))) {
            replacePanel(mainLayout.getPanel(), Records);
        } else if (name.equals(getClassName(Cashier))) {
            replacePanel(mainLayout.getPanel(), Cashier);
        } else if (name.equals(getClassName(Setting))) {
            replacePanel(mainLayout.getPanel(), Setting);
        }
    }

    public MainLayout getLayout() {
        return this.mainLayout;
    }

}
