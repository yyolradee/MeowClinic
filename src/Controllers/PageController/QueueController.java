/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.PageController;

import Controllers.Controller;
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
    
    public void addQueue(String time, String customerName, String pet_id, int user_id, String description){
        //model.addQueue(time, customer_id, pet_id, user_id, description);
    }
    
    public void setAddQueueComboBox(JComboBox box1, JComboBox box2, JComboBox box3){
        LinkedList<GeneralClass.Queue> queueList = model.getQueues();
        for(int i = 0; i < queueList.size(); i++){
            box1.addItem(queueList.get(i).getCustomer().getFirstName() + " " + queueList.get(i).getCustomer().getLastName());
            if(i == 0){
                for(int j = 0; j < queueList.get(i).getCustomer().getPets().size(); j++){
                    box2.addItem(queueList.get(i).getCustomer().getPets().get(j));
                }
            }
        }
    }
    
    public void setAddQueueComboBox(JComboBox petBox, String customer_name){
        LinkedList<GeneralClass.Queue> queueList = model.getQueues();
        customer_name = customer_name.split(" ")[0];
        for(int i = 0; i < queueList.size(); i++){
            if(queueList.get(i).getCustomer().getFirstName().equals(customer_name)){
                
            }
        }
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
