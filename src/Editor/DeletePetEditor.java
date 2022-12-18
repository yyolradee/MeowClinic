/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Editor;

import Controllers.PageController.RecordsController;
import GeneralClass.Customer;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

/**
 *
 * @author puttipongbunreangsri
 */
public class DeletePetEditor extends ButtonEditor implements ActionListener{
    private int record_id;
    private RecordsController controller;
    private JTable petsTable;
    private Customer customer;
    
    public DeletePetEditor(Customer customer, RecordsController controller){
        super();
        button.addActionListener(this);
        this.controller = controller;
        this.customer = customer;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        record_id = (int) value;
        petsTable = table;
        button.setText("Delete");
        isPushed = true;
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.delPet(record_id);
        controller.setPetsTable(controller.getModel().getCustomer(customer.getID()), petsTable);
        controller.setRecordTable(controller.getModel().getCustomers(), controller.getRecord().getJTable1());
    }
}
