/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.PageController;

import Controllers.Controller;
import Pages.Queue;

/**
 *
 * @author pongp
 */
public class QueueController implements Controller {

    private Queue queue;

    public QueueController() {
        queue = new Queue();
    }

    @Override
    public Queue getLayout() {
        return this.queue;
    }

}
