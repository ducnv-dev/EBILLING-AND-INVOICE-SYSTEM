/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPanel;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author vivapc99
 */
public class Listeners {

    private static void filterTableProcess(JTextField jtextfield, TableRowSorter<AbstractTableModel> sorter) {
        RowFilter<AbstractTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(jtextfield.getText().trim());
        } catch (java.util.regex.PatternSyntaxException ex) {
            return;
        }
        sorter.setRowFilter(rf);
    }

    public static void addDocumentListenerToTextField(final JTextField jtextfield, final JTable table, final AbstractTableModel tableEmp) {
        final TableRowSorter<AbstractTableModel> sorter = new TableRowSorter<>(tableEmp);
        table.setRowSorter(sorter);
        jtextfield.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTableProcess(jtextfield, sorter);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTableProcess(jtextfield, sorter);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

}
