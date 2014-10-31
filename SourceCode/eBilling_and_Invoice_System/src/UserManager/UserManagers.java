/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserManager;

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
public class UserManagers {
    Connection con = null;
    protected PreparedStatement ps;

    public UserManagers() {
        con = DataConnect.connectData();
    }

    public List<User> loadUser() {

        List<User> listUser = new LinkedList<>();
        try {
            listUser.clear();
            String query = "select * from Users";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int code = rs.getInt("userCode");
                String name = rs.getString("userLogin");
                String pass = rs.getString("password");
                String fullname = rs.getString("fullName");
                String typecode = rs.getString("userTypeCode");
                String address = rs.getString("userAddress");
                String phone = rs.getString("userphone");
                String email = rs.getString("userEmail");
                int active = rs.getInt("userActive");
                listUser.add(new User(code, name, pass, fullname, typecode, address, phone, email, active));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManagers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;

    }

    public void addUser(User user) {
        try {
            String query = "insert into Users values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            //ps.setInt(1, user.getUserCode());
            ps.setString(1, user.getUserLogin());
            ps.setString(2, user.getUserPassword());
            ps.setString(3, user.getFullName());
            ps.setString(4, user.getUserTypeCode());
            
            ps.setString(5, user.getUserAddress());
            ps.setString(6, user.getUserPhone());
            ps.setString(7, user.getEmail());
            ps.setInt(8, user.getActive());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserManagers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUser(User user) {
        try {
            String query = " update Users\n"
                    + "	set userLogin =?,password=?,fullName=?,userTypeCode=?,userAddress=?,userphone=?,userEmail=?,userActive=?\n"
                    + "	where userCode =?";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getUserLogin());
            ps.setString(2, user.getUserPassword());
            ps.setString(3, user.getFullName());
            ps.setString(4, user.getUserTypeCode());
            ps.setString(5, user.getUserAddress());
            ps.setString(6, user.getUserPhone());
            ps.setString(7, user.getEmail());
            ps.setInt(8,user.getActive());
            ps.setInt(9,user.getUserCode());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserManagers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DeleteUser(int usercode) {
        try {
            String query = "delete from Users WHERE userCode =?";
            ps = con.prepareStatement(query);
            ps.setInt(1, usercode);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
