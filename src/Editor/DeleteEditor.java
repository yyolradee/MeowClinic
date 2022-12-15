/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Editor;

import Controllers.PageController.QueueController;
import Controllers.PageController.RecordsController;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

/**
 *
 * @author puttipongbunreangsri
 */
public class DeleteEditor extends ButtonEditor implements ActionListener{
    private int record_id;
    private RecordsController controller;
    
    public DeleteEditor(RecordsController controller){
        super();
        button.addActionListener(this);
        this.controller = controller;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        record_id = (int) value;
        button.setText("Cancel");
        isPushed = true;
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.delCustomer(record_id);
    }
}
