/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Renderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author puttipongbunreangsri
 */
public class MeowTableHeaderRenderer extends JLabel implements TableCellRenderer{

    public MeowTableHeaderRenderer() {
        setForeground(Color.white);
        setBackground(new Color(108, 118, 234));
        setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
    
}
