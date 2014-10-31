/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProductManager;

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
public class ProductTableModel extends AbstractTableModel{

 private static List<Product> ProductList;

    public static List<Product> getEmplList() {
        return ProductList;
    }

    public ProductTableModel() {
        ProductList = new LinkedList<>();
        
    }

    public void addListToTheTable(List<Product> dSach){
       ProductList.clear();
        for (Product cc : dSach) {
            ProductList.add(cc);
        }
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return ProductList.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product em = (Product) ProductList.get(rowIndex);
        if (columnIndex == 0) {
            return em.getProduct_Code();
        }
        if (columnIndex == 1) {
            return em.getProduct_Name();
        }
        if (columnIndex == 2) {
            return em.getProduct_Type();
        }
        if (columnIndex == 3) {
            return em.getSupplier_Code();
        }
        if (columnIndex == 4) {
            return em.getProduct_Price();
        }
        if (columnIndex == 5) {
            return em.getProduct_AvailableAmount();
        }
        if (columnIndex == 6) {
            return em.getProduct_infor();
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
            return "Type";
        }
        if (column == 3) {
            return "Supplier Code";
        }
        if (column == 4) {
            return "Price";
        }
        if (column == 5) {
            return "Availible Amount";
        }
        if (column == 6) {
            return "Infor";
        }
     
        return "";
    }
    
}

