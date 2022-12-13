/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.PageController;

import Controllers.Controller;
import Model.QueueModel;
import Pages.Queue;
import java.util.LinkedList;
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
            dtm.addRow(new Object[]{queueList.get(i).getTime(), queueList.get(i).getCustomer().getFirstName() + " " + queueList.get(i).getCustomer().getLastName(), queueList.get(i).getPet().getName(), queueList.get(i).getCustomer().getPhone(), queueList.get(i), "Accept", "Cancel"});
        }
    }
    
    public void addQueue(){
        
    }

    @Override
    public Queue getLayout() {
        return this.queue;
    }

}
