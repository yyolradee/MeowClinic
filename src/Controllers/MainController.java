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

    private JPanel page1, page2;

    public MainController(LayoutController layController) {
        mainLayout = new MainLayout(layController, this);

        page1 = new Page1();
        page2 = new Page2();

        changeRoute("page1");
    }

    @Override
    public void changeRoute(String name) {
        name = name.toLowerCase();
        if (name.equals(getClassName(page1))) {
            replacePanel(mainLayout.getPanel(), page1);
        } else if (name.equals(getClassName(page2))) {
            replacePanel(mainLayout.getPanel(), page2);
        }
    }

    public MainLayout getLayout() {
        return this.mainLayout;
    }

}
