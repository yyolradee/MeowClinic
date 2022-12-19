/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Editor;

import Controllers.PageController.QueueController;
import GeneralClass.Queue;
import Popup.PetDetail;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author puttipongbunreangsri
 */
public class PetDetailEditor extends ButtonEditor implements ActionListener{
    private Queue queue;
    private QueueController controller;
    private boolean isOpened;
    
    public PetDetailEditor(QueueController controller){
        super();
        this.controller = controller;
        button.addActionListener(this);
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        queue = (Queue) value;
        button.setText("View");
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!isOpened){
            isOpened = true;
            JFrame window = new PetDetail(queue);
            window.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent event){
                    isOpened = false;
                }
            });
        }
        this.stopCellEditing();
        this.controller.setQueueTable();
    }
}
