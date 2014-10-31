/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CustomerManager;

/**
 *
 * @author vivapc99
 */
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mr_Duc
 */
public class CustomerTableModel extends AbstractTableModel{

 private static List<Customer> CustomerList;

    public static List<Customer> getEmplList() {
        return CustomerList;
    }

    public CustomerTableModel() {
        CustomerList = new LinkedList<>();
        
    }

    public void addListToTheTable(List<Customer> dSach){
       CustomerList.clear();
        for (Customer cc : dSach) {
            CustomerList.add(cc);
        }
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return CustomerList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer em = (Customer) CustomerList.get(rowIndex);
        if (columnIndex == 0) {
            return em.getCustomerCode();
        }
        if (columnIndex == 1) {
            return em.getName();
        }
        if (columnIndex == 2) {
            return em.getTel();
        }
        if (columnIndex == 3) {
            return em.getAddr();
        }
      
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Code";
        }
        if (column == 1) {
            return "Name";
        }
        if (column == 2) {
            return "Tel";
        }
        if (column == 3) {
            return "Address";
        }
     
        return "";
    }
    
}

