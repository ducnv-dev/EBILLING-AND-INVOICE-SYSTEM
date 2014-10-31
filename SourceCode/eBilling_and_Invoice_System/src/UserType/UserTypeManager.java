/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserType;

import ProductType.*;
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
public class UserTypeManager {

    Connection con = null;
    protected PreparedStatement ps;

    public UserTypeManager() {
        con = DataConnect.connectData();
    }

    public List<UserType> loadUserType() {

        List<UserType> listUserType = new LinkedList<>();
        try {
            listUserType.clear();
            String query = "select * from UserType";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String code = rs.getString("userTypeCode");
                String name = rs.getString("userTypeName");
                listUserType.add(new UserType(code, name));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserTypeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUserType;

    }

    

}
