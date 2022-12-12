/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.PageController;

import Controllers.Controller;
import GeneralClass.Cart;
import GeneralClass.Product;
import Pages.Cashier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pongp
 */
public class CashierController implements Controller, ActionListener {

    private Cashier cashier;
    private Cart cart;

    public CashierController() {
        this.cashier = new Cashier();
        this.cart = new Cart();
        this.cashier.getAddBtn().addActionListener(this);
        this.cashier.getClearBtn().addActionListener(this);
        this.cashier.getPayment1().addActionListener(this);
        this.cashier.getPayment2().addActionListener(this);
        this.cashier.getPayment3().addActionListener(this);
        this.cashier.getPayment4().addActionListener(this);

        setQueueTable(this.cart.getProducts(), this.cashier.getTable());
    }

    @Override
    public Cashier getLayout() {
        return this.cashier;
    }

    public void setQueueTable(java.util.ArrayList<GeneralClass.Product> products, javax.swing.JTable table) {
        for (int i = 0; i < products.size(); i++) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{i + 1, products.get(i).getName(), products.get(i).getQuantity(), products.get(i).getPrice()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ADD")) {
            int index = this.cart.getProductIndexByName(this.cashier.getServiceName().getText(), Double.parseDouble(this.cashier.getNumber().getText()));
            DefaultTableModel model = (DefaultTableModel) this.cashier.getTable().getModel();
            if (index != -1) {
                this.cart.getProducts().get(index).increaseQuantity();
                model.setValueAt(this.cart.getProducts().get(index).getQuantity(), index, 2);
            } else {
                Product pd = new Product(this.cashier.getServiceName().getText(), Float.parseFloat(this.cashier.getNumber().getText()));
                this.cart.addProduct(pd);
                model.addRow(new Object[]{this.cart.size(), pd.getName(), pd.getQuantity(), pd.getPrice()});
            }
            this.cashier.resetNumPad();
            this.cashier.setTotal(this.cart.totalQuantity(), this.cart.totalPrice());
        } else if (e.getActionCommand().equals("Clear")) {
            reset();
        } else if (e.getActionCommand().equals("")) {
            if (this.cart.size() > 0) {
                JOptionPane.showMessageDialog(null, "Payment Success");
                reset();
            } else {
                JOptionPane.showMessageDialog(null, "No product in cart", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void reset() {
        this.cart.clear();
        DefaultTableModel model = (DefaultTableModel) this.cashier.getTable().getModel();
        model.setRowCount(0);
        this.cashier.resetNumPad();
        this.cashier.setTotal(this.cart.totalQuantity(), this.cart.totalPrice());

    }

}
