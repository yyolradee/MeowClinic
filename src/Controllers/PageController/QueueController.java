/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.PageController;

import Controllers.Controller;
import Model.QueueModel;
import Pages.Queue;

/**
 *
 * @author pongp
 */
public class QueueController implements Controller {

    private Queue queue;
    private QueueModel model;

    public QueueController() {
        queue = new Queue();
        model = new QueueModel();
        this.setQueueTable(model.getQueues(), queue.getJTable1());
    }
    
    public void setQueueTable(java.util.LinkedList<GeneralClass.Queue> queue, javax.swing.JTable table){
        for(int i = 0; i < queue.size(); i++){
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table.getModel();
            model.addRow(new Object[]{queue.get(i).getTime(), queue.get(i).getCustomer().getFirstName() + " " + queue.get(i).getCustomer().getLastName(), queue.get(i).getPet().getName(), queue.get(i).getCustomer().getPhone(), queue.get(i), "Accept", "Cancel"});
        }
    }

    @Override
    public Queue getLayout() {
        return this.queue;
    }

}
