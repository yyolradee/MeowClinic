/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Editor;

import Controllers.PageController.QueueController;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

/**
 *
 * @author puttipongbunreangsri
 */
public class CancelEditor extends ButtonEditor implements ActionListener{
    private int queue_id;
    private QueueController controller;
    
    public CancelEditor(QueueController controller){
        super();
        button.addActionListener(this);
        this.controller = controller;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        queue_id = (int) value;
        button.setText("Cancel");
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.delQueue(queue_id);
        this.stopCellEditing();
        controller.setQueueTable();
    }
}
