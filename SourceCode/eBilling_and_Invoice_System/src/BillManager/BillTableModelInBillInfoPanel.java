/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BillManager;

import Connection.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vivapc99
 */
public class BillTableModelInBillInfoPanel extends AbstractTableModel{
    
    Connection con = null;
    protected PreparedStatement ps;
    private static List<EBill> EBillList;

    public static List<EBill> getEmplList() {
        return EBillList;
    }

    public BillTableModelInBillInfoPanel() {
        EBillList = new LinkedList<>();
        con = DataConnect.connectData();

    }

    private String getNameByCode(int code,String who,String whoseName,String whoseCode) {
        String name = null;
        try {
            String query = "select "+whoseName+" from "+who+" WHERE +"+whoseCode +"=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, code);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                name = rs.getString(whoseName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }

    public void addListToTheTable(List<EBill> dSach) {
        EBillList.clear();
        for (EBill cc : dSach) {
            EBillList.add(cc);
        }
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return EBillList.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EBill em = (EBill) EBillList.get(rowIndex);
        if (columnIndex == 0) {
            return em.getEbillCode();
        }
        if (columnIndex == 1) {
            return getNameByCode(em.getCustomerCode(),"CUSTOMER","CUSTOMER_NAME","CUSTOMER_CODE");
        }
        if (columnIndex == 2) {
            return getNameByCode(em.getUserCode(),"Users","fullName","userCode");
        }
        if (columnIndex == 3) {
            return em.getDate();
        }
        if (columnIndex == 4) {
            return em.getTotalPrice();
        }

        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Bill Code";
        }
        if (column == 1) {
            return "Customer Name";
        }
        if (column == 2) {
            return "Creator";
        }
        if (column == 3) {
            return "Date";
        }
        if (column == 4) {
            return "Total Price";
        }

        return "";
    }

}
