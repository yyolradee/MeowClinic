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
        queue.setQueueTable(model.getQueues());
    }

    @Override
    public Queue getLayout() {
        return this.queue;
    }

}
