/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductManager;

import Connection.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vivapc99
 */
public class ProductManager {

    Connection con = null;
    protected PreparedStatement ps;

    public ProductManager() {
        con = DataConnect.connectData();
        loadProduct("PRODUCT_TYPE", listProductType);
        loadProduct("SUPPLIER", listProductSupplier);
    }
    public Map<Integer, String> listProductType = new LinkedHashMap<>();
    public Map<Integer, String> listProductSupplier = new LinkedHashMap<>();

    public List<Product> loadProducts() {

        List<Product> listProduct = new LinkedList<>();
        try {
            listProduct.clear();
            String query = "select * from PRODUCT";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int code = rs.getInt("PRODUCT_CODE");
                String name = rs.getString("PRODUCT_NAME");
                String type = listProductType.get(Integer.parseInt(rs.getString(3)));
                String supplier = listProductSupplier.get(Integer.parseInt(rs.getString(4)));
                int price = rs.getInt("PRODUCT_PRICE");
                int availableAmount = rs.getInt("PRODUCT_AVAILABLEAMOUNT");
                String infor = rs.getString("PRODUCT_INFO");
                listProduct.add(new Product(code, name, type, supplier, price, availableAmount, infor));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct;

    }

    public void addProduct(Product product) {
        try {
            String query = "insert into PRODUCT values(?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, product.getProduct_Name());
            ps.setInt(2, returnCodeByProduct(listProductType, product.getProduct_Type()));
            ps.setInt(3, returnCodeByProduct(listProductSupplier, product.getSupplier_Code()));
            ps.setInt(4, product.getProduct_Price());
            ps.setInt(5, product.getProduct_AvailableAmount());
            ps.setString(6, product.getProduct_infor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int returnCodeByProduct(Map<Integer, String> map, String p) {
        int code = 0;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(p)) {
                code = entry.getKey();
            }
        }
        return code;
    }

    private void loadProduct(String table, Map<Integer, String> listProduct) {
        try {
            listProduct.clear();

            String query = "select * from " + table;
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int code = rs.getInt(1);
                String name = rs.getString(2);
                listProduct.put(code, name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateProduct(Product product) {
        try {
            String query = " update PRODUCT\n"
                    + "	set PRODUCT_NAME =?,PRODUCT_TYPE = ?,SUPPLIER_CODE =?,PRODUCT_PRICE=?,PRODUCT_AVAILABLEAMOUNT=?,PRODUCT_INFO=?\n"
                    + "	where PRODUCT_CODE =?";
            ps = con.prepareStatement(query);
            ps.setString(1, product.getProduct_Name());
            ps.setInt(2, returnCodeByProduct(listProductType, product.getProduct_Type()));
            ps.setInt(3, returnCodeByProduct(listProductSupplier, product.getSupplier_Code()));
            ps.setInt(4, product.getProduct_Price());
            ps.setInt(5, product.getProduct_AvailableAmount());
            ps.setString(6, product.getProduct_infor());
            ps.setInt(7, product.getProduct_Code());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateProductAvailableAmount(int productAmt, int productCode) {
        try {
            String query = " update PRODUCT\n"
                    + "	set PRODUCT_AVAILABLEAMOUNT=?\n"
                    + "	where PRODUCT_CODE =?";
            ps = con.prepareStatement(query);
            ps.setInt(1, productAmt);
            ps.setInt(2, productCode);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeleteProduct(int productCode) {
        try {
            String query = "delete from PRODUCT WHERE PRODUCT_CODE =?";
            ps = con.prepareStatement(query);
            ps.setInt(1, productCode);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Product> searchProductsByProductTypeCode(String productypecode) {

        List<Product> listProCode = new LinkedList<>();
        try {
            listProCode.clear();
            String query = "select * from PRODUCT WHERE PRODUCT_TYPE = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, productypecode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int proCode = rs.getInt(1);
                String proName = rs.getString(2);
                String type = listProductType.get(Integer.parseInt(rs.getString(3)));
                String supplier = listProductSupplier.get(Integer.parseInt(rs.getString(4)));
                int proPrice = rs.getInt(5);
                int proAmount = rs.getInt(6);
                String proInfo = rs.getString(7);
                listProCode.add(new Product(proCode, proName, type, supplier, proPrice, proAmount, proInfo));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductManagers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProCode;
    }

    public List<Product> searchProductsBySupplierCode(String supCode) {

        List<Product> listSupCode = new LinkedList<>();
        try {
            listSupCode.clear();
            String query = "select * from PRODUCT WHERE SUPPLIER_CODE = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, supCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int proCode = rs.getInt(1);
                String proName = rs.getString(2);
                String type = listProductType.get(Integer.parseInt(rs.getString(3)));
                String supplier = listProductSupplier.get(Integer.parseInt(rs.getString(4)));
                int proPrice = rs.getInt(5);
                int proAmount = rs.getInt(6);
                String proInfo = rs.getString(7);
                listSupCode.add(new Product(proCode, proName, type, supplier, proPrice, proAmount, proInfo));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductManagers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSupCode;
    }

    public List<Product> searchProductsByName(String proName) {

        List<Product> listName = new LinkedList<>();
        try {
            listName.clear();
            String query = "select * from PRODUCT WHERE PRODUCT_NAME LIKE '%'+?+'%'";
            ps = con.prepareStatement(query);
            ps.setString(1, proName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int proCode = rs.getInt(1);
                String type = listProductType.get(Integer.parseInt(rs.getString(3)));
                String supplier = listProductSupplier.get(Integer.parseInt(rs.getString(4)));
                int proPrice = rs.getInt(5);
                int proAmount = rs.getInt(6);
                String proInfo = rs.getString(7);
                listName.add(new Product(proCode, proName, type, supplier, proPrice, proAmount, proInfo));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductManagers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listName;
    }

}
