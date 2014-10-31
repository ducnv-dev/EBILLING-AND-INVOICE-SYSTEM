/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPanel;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mr_Duc
 */
public class ProductTableModel extends AbstractTableModel{

 private static List<Product> productList;

    public static List<Product> getEmplList() {
        return productList;
    }

    public ProductTableModel() {
        productList = new LinkedList<>();
        
    }

    public void addListToTheTable(List<Product> dSach){
       productList.clear();
        for (Product cc : dSach) {
            productList.add(cc);
        }
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return productList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product em = (Product) productList.get(rowIndex);
        if (columnIndex == 0) {
            return em.getMaSP();
        }
        if (columnIndex == 1) {
            return em.getTenSP();
        }
        if (columnIndex == 2) {
            return em.getGiaSP();
        }
        if (columnIndex == 3) {
            return em.getInfo();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        }
        if (column == 1) {
            return "Name";
        }
        if (column == 2) {
            return "Price";
        }
        if (column == 3) {
            return "Information";
        }
     
        return "";
    }
    
}
