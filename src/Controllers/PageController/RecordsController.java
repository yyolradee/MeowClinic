/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.PageController;

import Controllers.Controller;
import GeneralClass.Customer;
import GeneralClass.Pet;
import Model.RecordModel;
import Pages.Records;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pongp
 */
public class RecordsController implements Controller {

    private Records record;
    private RecordModel model;

    public RecordsController() {
        record = new Records(this);
        model = new RecordModel();
        this.setRecordTable(model.getCustomers(), record.getJTable1());
    }
    
    public void setRecordTable(java.util.LinkedList<GeneralClass.Customer> customers, javax.swing.JTable table){
        for(int i = 0; i < customers.size(); i++){
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table.getModel();
            model.addRow(new Object[]{i+1, customers.get(i).getFirstName() + customers.get(i).getLastName(), customers.get(i).getPhone(), customers.get(i).getPets().size(), customers.get(i)});
        }
    }
    
    public void delCustomer(int id){
        model.delCustomer(id);
    }

    public void setPetsTable(Customer customer,JTable table){
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        LinkedList<Pet> pets = customer.getPets();
        for(int i = 0; i < pets.size(); i++){
            dtm.addRow(new Object[]{pets.get(i).getId(), pets.get(i).getName(), pets.get(i).getWeight(), pets.get(i).getColor(), pets.get(i).getType(), pets.get(i).getSpecies(), pets.get(i).getId()});
        }
    }
    
    @Override
    public Records getLayout() {
        return this.record;
    }
}
