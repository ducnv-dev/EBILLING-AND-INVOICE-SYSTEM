/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillManager;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vivapc99
 */
public class BillDetailTableModel_BillManagerPanel extends AbstractTableModel {

    private static List<EbillDetail> ProductList;
    private EbillDetailsManager ebillDetailsManager = new EbillDetailsManager();

    public static List<EbillDetail> getEmplList() {
        return ProductList;
    }

    public BillDetailTableModel_BillManagerPanel() {
        ProductList = new LinkedList<>();

    }

    public void addListToTheTable(List<EbillDetail> dSach) {
        ProductList.clear();
        for (EbillDetail cc : dSach) {
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            EbillDetail em = (EbillDetail) ProductList.get(rowIndex);
            if (columnIndex == 0) {
                return em.getEbillCode();
            }
            if (columnIndex == 1) {
                return ebillDetailsManager.returnProductByCode(ProductManager.ProductTableModel.getEmplList(), em.getProductCode()).getProduct_Name();
            }
            if (columnIndex == 2) {
                return ebillDetailsManager.returnProductByCode(ProductManager.ProductTableModel.getEmplList(), em.getProductCode()).getProduct_Price();
            }
            if (columnIndex == 3) {
                return em.getQuantity();
            }
        } catch (NullPointerException ex) {

        }

        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Bill Code";
        }
        if (column == 1) {
            return "Product Name";
        }
        if (column == 2) {
            return "Price";
        }
        if (column == 3) {
            return "Quantity";
        }

        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
    }
}
