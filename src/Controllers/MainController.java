/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Layouts.MainLayout;
import Pages.*;
import Controllers.PageController.*;

/**
 *
 * @author pongp
 */
public class MainController extends Router implements Controller {

    private MainLayout mainLayout;

    private QueueController Queue;
    private RecordsController Records;
    private CashierController Cashier;
    private SettingController Setting;

    public MainController(LayoutController layController) {
        mainLayout = new MainLayout(layController, this);

        Queue = new QueueController();
        Records = new RecordsController();
        Cashier = new CashierController();
        Setting = new SettingController(layController);

        changeRoute("queue");
    }

    @Override
    public void changeRoute(String name) {
        name = name.toLowerCase();
        if (name.equals(getClassName(Queue.getLayout()))) {
            replacePanel(mainLayout.getPanel(), Queue.getLayout());
        } else if (name.equals(getClassName(Records.getLayout()))) {
            replacePanel(mainLayout.getPanel(), Records.getLayout());
        } else if (name.equals(getClassName(Cashier.getLayout()))) {
            replacePanel(mainLayout.getPanel(), Cashier.getLayout());
        } else if (name.equals(getClassName(Setting.getLayout()))) {
            replacePanel(mainLayout.getPanel(), Setting.getLayout());
        }
    }

    @Override
    public MainLayout getLayout() {
        return this.mainLayout;
    }

}
