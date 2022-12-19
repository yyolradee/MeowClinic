/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.PageController;

import Controllers.Controller;
import GeneralClass.Customer;
import GeneralClass.Pet;
import Model.QueueModel;
import Pages.Queue;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pongp
 */
public class QueueController implements Controller {

    private Queue queue;
    private QueueModel model;

    public QueueController() {
        queue = new Queue(this);
        model = new QueueModel();
        setQueueTable();
    }
    
    public void setQueueTable(){
        DefaultTableModel dtm = (DefaultTableModel) queue.getJTable1().getModel();
        dtm.setRowCount(0);
        LinkedList<GeneralClass.Queue> queueList = model.getQueues();
        
        for(int i = 0; i < queueList.size(); i++){
            dtm.addRow(new Object[]{queueList.get(i).getTime(), queueList.get(i).getCustomer().getFirstName() + " " + queueList.get(i).getCustomer().getLastName(), queueList.get(i).getPet().getName(), queueList.get(i).getCustomer().getPhone(), queueList.get(i), "Accept", queueList.get(i).getID()});
        }
    }
    
    public void addQueue(String time, int customer_id, int pet_id, int user_id, String description){
        model.addQueue(time, customer_id, pet_id, user_id, description);
    }
    
    public void setAddQueueComboBox(JComboBox box1, JComboBox box2, JComboBox box3){
        LinkedList<GeneralClass.Customer> customerList = new Model.RecordModel().getCustomers();
        for(int i = 0; i < customerList.size(); i++){
            box1.addItem(customerList.get(i).getFirstName() + " " + customerList.get(i).getLastName() + " " + customerList.get(i).getID());
            if(i == 0){
                for(int j = 0; j < customerList.get(i).getPets().size(); j++){
                    Pet currentPet = (Pet) customerList.get(i).getPets().get(j);
                    box2.addItem(currentPet.getName() + " " + currentPet.getId());
                }
            }
        }
    }
    
    public void setAddQueueComboBox(JComboBox petBox, String customer_name){
        petBox.removeAllItems();
        int customer_id = Integer.valueOf(customer_name.split(" ")[2]);
        LinkedList<GeneralClass.Pet> petList = new Model.RecordModel().getCustomer(customer_id).getPets();
        for(int i = 0; i < petList.size(); i++){
            petBox.addItem(String.format("%s %d", petList.get(i).getName(), petList.get(i).getId()));
        }
    }
    
    public LinkedList<String> getCustomerNames(){
        LinkedList<String> names = new LinkedList();
        LinkedList<Customer> customers = new Model.RecordModel().getCustomers();
        for(int i = 0; i < customers.size(); i++){
            names.add(String.format("%s %s %d", customers.get(i).getFirstName(), customers.get(i).getLastName(), customers.get(i).getID()));
        }
        return names;
    }
    
    public void delQueue(int id){
        model.delQueue(id);
    }
    
    public QueueModel getModel(){
        return this.model;
    }

    @Override
    public Queue getLayout() {
        return this.queue;
    }

}
