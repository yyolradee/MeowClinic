/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.PageController;

import Controllers.Controller;
import Model.RecordModel;
import Pages.Records;

/**
 *
 * @author pongp
 */
public class RecordsController implements Controller {

    private Records record;
    private RecordModel model;

    public RecordsController() {
        record = new Records();
        model = new RecordModel();
        this.setRecordTable(model.getCustomers(), record.getJTable1());
    }
    
    public void setRecordTable(java.util.LinkedList<GeneralClass.Customer> customers, javax.swing.JTable table){
        for(int i = 0; i < customers.size(); i++){
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table.getModel();
            model.addRow(new Object[]{i+1, customers.get(i).getFirstName() + customers.get(i).getLastName(), customers.get(i).getPhone(), customers.get(i).getPets().size()});
        }
    }

    @Override
    public Records getLayout() {
        return this.record;
    }
}
