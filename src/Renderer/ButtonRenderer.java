
package Renderer;

import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;



public class ButtonRenderer extends JButton implements TableCellRenderer {
    
    public ButtonRenderer(String text) {
      setOpaque(true);
      setText(text);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      return this;
    }
}