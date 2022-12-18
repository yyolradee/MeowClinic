/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Editor;

import Controllers.PageController.RecordsController;
import GeneralClass.Customer;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;

/**
 *
 * @author puttipongbunreangsri
 */
public class PetsTableEditor extends ButtonEditor implements ActionListener{
    private Customer customer;
    private boolean isOpened;
    private RecordsController controller;
    
    public PetsTableEditor(RecordsController controller){
        super();
        this.controller = controller;
        button.addActionListener(this);
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        customer = (Customer) value;
        button.setText("View Pets");
        isPushed = true;
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!isOpened){
            isOpened = true;
            Popup.PetsTable window = new Popup.PetsTable(customer, controller);
            window.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent event){
                    isOpened = false;
                    window.disposeAddPet();
                }
            });
        }
    }
}
