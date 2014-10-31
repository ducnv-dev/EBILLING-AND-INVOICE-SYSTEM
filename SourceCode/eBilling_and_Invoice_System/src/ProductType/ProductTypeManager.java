/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductType;

import Connection.DataConnect;
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
 * @author MrDuc
 */
public class ProductTypeManager {

    Connection con = null;
    protected PreparedStatement ps;

    public ProductTypeManager() {
        con = DataConnect.connectData();
    }

    public List<ProductType> loadProductType() {

        List<ProductType> listProductType = new LinkedList<>();
        try {
            listProductType.clear();
            String query = "select * from PRODUCT_TYPE";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int code = rs.getInt("TYPE_CODE");
                String name = rs.getString("TYPE_NAME");
                listProductType.add(new ProductType(code, name));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductTypeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProductType;

    }

    

}
