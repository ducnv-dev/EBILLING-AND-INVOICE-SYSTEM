/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupplierManager;

import Connection.DataConnect;
import ProductType.ProductType;
import ProductType.ProductTypeManager;
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
public class SupplierManager {

    Connection con = null;
    protected PreparedStatement ps;

    public SupplierManager() {
        con = DataConnect.connectData();
    }

    public List<Supplier> loadSupplier() {

        List<Supplier> listSupplier = new LinkedList<>();
        try {
            listSupplier.clear();
            String query = "select * from SUPPLIER";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int code = rs.getInt("SUPPLIER_CODE");
                String name = rs.getString("SUPPLIER_NAME");
                listSupplier.add(new Supplier(code, name));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSupplier;
    }
}
