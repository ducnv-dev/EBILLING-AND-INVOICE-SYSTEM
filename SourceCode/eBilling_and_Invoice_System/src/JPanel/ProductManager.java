/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPanel;

import java.sql.Connection;
import Connection.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mr_Duc
 */
public class ProductManager {
    
    Connection con = null;
     protected PreparedStatement ps;
    public ProductManager(){
        con = DataConnect.connectData();
    }
    
    public List<Product> loadProducts(){
        
        List<Product> listProduct = new LinkedList<>();
        try {
            listProduct.clear();
            String query = "select * from PRODUCT";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("SP_MA");
                String NAME = rs.getString("SP_TEN");
                int PRICE = rs.getInt("SP_GIA");
                String INFO = rs.getString("SP_INFO");
                listProduct.add(new Product(ID, NAME, PRICE, INFO));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct;
    
    }
}
