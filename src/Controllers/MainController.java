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

    private JPanel page1, Cashier;

    public MainController(LayoutController layController) {
        mainLayout = new MainLayout(layController, this);

        page1 = new Page1();
        Cashier = new Cashier();

        changeRoute("page1");
    }

    @Override
    public void changeRoute(String name) {
        name = name.toLowerCase();
        if (name.equals(getClassName(page1))) {
            replacePanel(mainLayout.getPanel(), page1);
        } else if (name.equals(getClassName(Cashier))) {
            replacePanel(mainLayout.getPanel(), Cashier);
        }
    }

    public MainLayout getLayout() {
        return this.mainLayout;
    }

}
