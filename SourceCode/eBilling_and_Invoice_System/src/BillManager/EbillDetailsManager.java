/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillManager;

import Connection.DataConnect;
import CustomerManager.CustomerManager;
import ProductManager.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vivapc99
 */
public class EbillDetailsManager {

    Connection con = null;
    protected PreparedStatement ps;

    public EbillDetailsManager() {
        con = DataConnect.connectData();
    }

    public void addEbillDetails(EbillDetail billdetail) {
        try {
            String query = "insert into EBILL_DETAILS values(?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, billdetail.getProductCode());
            ps.setInt(2, billdetail.getEbillCode());
            ps.setInt(3, billdetail.getQuantity());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<EBill> loadEbill() {

        List<EBill> listCustomer = new LinkedList<>();
        try {
            listCustomer.clear();
            String query = "select * from EBILL where EBILL_TOTALPRICE =0";
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

    public List<EbillDetail> loadEbillDetails() {

        List<EbillDetail> listCustomer = new LinkedList<>();
        try {
            listCustomer.clear();
            String query = "select * from EBILL_DETAILS";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productcode = rs.getInt("PRODUCT_CODE");
                int ebillcode = rs.getInt("EBILL_CODE");
                int quantity = rs.getInt("PRODUCT_QUANTITY");
                listCustomer.add(new EbillDetail(productcode, ebillcode, quantity));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCustomer;

    }

    public Product returnProductByCode(List<Product> products, int code) {
        for (Product product : products) {
            if (product.getProduct_Code()== code) {
                return product;
            }
        }
        return null;

    }

}
