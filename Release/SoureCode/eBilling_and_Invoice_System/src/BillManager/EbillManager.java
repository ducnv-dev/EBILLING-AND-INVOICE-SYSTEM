/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillManager;

import CustomerManager.*;
import Connection.DataConnect;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author vivapc99
 */
public class EbillManager {

    Connection con = null;
    protected PreparedStatement ps;

    public EbillManager() {
        con = DataConnect.connectData();
    }

    public List<Customer> loadCustomers() {

        List<Customer> listCustomer = new LinkedList<>();
        try {
            listCustomer.clear();
            String query = "select * from CUSTOMER";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int code = rs.getInt("CUSTOMER_CODE");
                String name = rs.getString("CUSTOMER_NAME");
                String tel = rs.getString("CUSTOMER_PHONE");
                String addr = rs.getString("CUSTOMER_ADDRESS");
                listCustomer.add(new Customer(code, name, tel, addr));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCustomer;

    }

    public List<EBill> loadEbill() {

        List<EBill> listCustomer = new LinkedList<>();
        try {
            listCustomer.clear();
            String query = "select * from EBILL";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int code = rs.getInt("EBILL_CODE");
                int custcode = rs.getInt("CUSTOMER_CODE");
                int usercode = rs.getInt("USER_CODE");
                String date = rs.getString("EBILL_DATE");
                int totalprice = rs.getInt("EBILL_TOTALPRICE");
                listCustomer.add(new EBill(code, usercode, custcode, date, totalprice));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCustomer;

    }

    public void addEbill(EBill bill) {
        try {
            String query = "insert into EBILL values(?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, bill.getCustomerCode());
            ps.setInt(2, bill.getUserCode());
            ps.setString(3, bill.getDate());
            ps.setInt(4, bill.getTotalPrice());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateEbill(EBill bill) {
        try {
            String query = " update EBILL\n"
                    + "	set CUSTOMER_CODE =?,USER_CODE=?,EBILL_DATE=?,EBILL_TOTALPICE=?\n"
                    + "	where EBILL_CODE =?";
            ps = con.prepareStatement(query);
            ps.setInt(1, bill.getCustomerCode());
            ps.setInt(2, bill.getUserCode());
            ps.setString(3, bill.getDate());
            ps.setInt(4, bill.getTotalPrice());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateEbillTotalPrice(int price, int code) {
        try {
            String query = " update EBILL\n"
                    + "	set EBILL_TOTALPRICE=?\n"
                    + "	where EBILL_CODE =?";
            ps = con.prepareStatement(query);
            ps.setInt(1, price);
            ps.setInt(2, code);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeleteCustomer(int customerCode) {
        try {
            String query = "delete from CUSTOMER WHERE CUSTOMER_CODE =?";
            ps = con.prepareStatement(query);
            ps.setInt(1, customerCode);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int returnUserCode(String userName) {
        int userCode = 0;
        try {
            String query = "select * from Users WHERE userLogin =?";
            ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                userCode = rs.getInt("userCode");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EbillManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userCode;

    }

    public Customer returnCustomerByCode(int code) {
        Customer c = null;
        try {
            String query = "select * from CUSTOMER WHERE CUSTOMER_CODE =?";
            ps = con.prepareStatement(query);
            ps.setInt(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("CUSTOMER_NAME");
                String phone = rs.getString("CUSTOMER_PHONE");
                String addr = rs.getString("CUSTOMER_ADDRESS");
                c = new Customer(code, name, phone, addr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EbillManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;

    }

    public List<Integer> loadUserCode() {

        List<Integer> listUserCode = new LinkedList<>();
        try {
            listUserCode.clear();
            String query = "select userCode from Users";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listUserCode.add(rs.getInt("userCode"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUserCode;
    }

    public String returnUserNameByuserCode(int code) {
        String customerName = null;
        try {
            String query = "select userLogin from Users WHERE userCode =?";
            ps = con.prepareStatement(query);
            ps.setInt(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customerName = rs.getString("userLogin");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EbillManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerName;
    }

    public void searchEbillbyColumn(int columnIndex, String stringToSearch, JTable table, AbstractTableModel tableEmp) {
        TableRowSorter<AbstractTableModel> sorter = new TableRowSorter<>(tableEmp);
        table.setRowSorter(sorter);
        RowFilter<AbstractTableModel, Object> rf = null;
        try {
            if (stringToSearch.equals("Please Choose!")) {
                throw new Exception();
            }
            rf = RowFilter.regexFilter("^" + stringToSearch + "$", columnIndex);
        } catch (java.util.regex.PatternSyntaxException ex) {
            return;
        }catch (Exception ex) {
            rf = null;
        }
        sorter.setRowFilter(rf);
    }

 public void searchEbillbyPrice(final String stringToSearch, JTable table, AbstractTableModel tableEmp) {
        TableRowSorter<AbstractTableModel> sorter = new TableRowSorter<>(tableEmp);
        table.setRowSorter(sorter);
        RowFilter<AbstractTableModel, Object> rf = null;
        try {
            rf = new RowFilter<AbstractTableModel, Object>() {

                @Override
                public boolean include(RowFilter.Entry<? extends AbstractTableModel, ? extends Object> entry) {
                    if (stringToSearch.equals("Please Choose!")) {
                        return true;
                    }
                    if (stringToSearch.split("-")[1].equals(" ")) {
                        return Integer.parseInt(entry.getStringValue(4)) >= Integer.parseInt(stringToSearch.split("-")[0]);
                    }

                    return Integer.parseInt(entry.getStringValue(4)) >= Integer.parseInt(stringToSearch.split("-")[0])
                            && Integer.parseInt(entry.getStringValue(4)) <= Integer.parseInt(stringToSearch.split("-")[1]);
                }
            };
        } catch (java.util.regex.PatternSyntaxException ex) {
            return;
        }

        sorter.setRowFilter(rf);
    }
 public void searchEbillbyDate(final Date date1,final Date date2, JTable table, AbstractTableModel tableEmp) {
        TableRowSorter<AbstractTableModel> sorter = new TableRowSorter<>(tableEmp);
        table.setRowSorter(sorter);
        RowFilter<AbstractTableModel, Object> rf = null;
        try {
            rf = new RowFilter<AbstractTableModel, Object>() {

                @Override
                public boolean include(RowFilter.Entry<? extends AbstractTableModel, ? extends Object> entry) {
                    
                    return java.sql.Date.valueOf(entry.getStringValue(3)).after(date1)&&java.sql.Date.valueOf(entry.getStringValue(3)).before(date2);
                }
            };
        } catch (java.util.regex.PatternSyntaxException ex) {
            return;
        }

        sorter.setRowFilter(rf);
    }
}
