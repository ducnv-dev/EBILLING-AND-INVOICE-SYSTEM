/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerManager;

import Connection.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author vivapc99
 */
public class CustomerManager {

    Connection con = null;
    protected PreparedStatement ps;

    public CustomerManager() {
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

    public void addCustomer(Customer customer) {
        try {
            String query = "insert into CUSTOMER values(?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getTel());
            ps.setString(3, customer.getAddr());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCustomer(Customer customer) {
        try {
            String query = " update CUSTOMER\n"
                    + "	set CUSTOMER_NAME =?,CUSTOMER_PHONE=?,CUSTOMER_ADDRESS=?\n"
                    + "	where CUSTOMER_CODE =?";
            ps = con.prepareStatement(query);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getTel());
            ps.setString(3, customer.getAddr());
            ps.setInt(4, customer.getCustomerCode());
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
}
