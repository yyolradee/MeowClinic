/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.PageController;

import Controllers.Controller;
import Pages.Cashier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pongp
 */
public class CashierController implements Controller, ActionListener {

    private Cashier cashier;

    public CashierController() {
        cashier = new Cashier();
    }

    @Override
    public Cashier getLayout() {
        return this.cashier;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
