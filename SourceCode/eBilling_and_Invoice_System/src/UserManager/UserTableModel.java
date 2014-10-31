/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserManager;

/**
 *
 * @author vivapc99
 */
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mr_Duc
 */
public class UserTableModel extends AbstractTableModel{

 private static List<User> UserList;

    public static List<User> getEmplList() {
        return UserList;
    }

    public UserTableModel() {
        UserList = new LinkedList<>();
        
    }

    public void addListToTheTable(List<User> dSach){
       UserList.clear();
        for (User cc : dSach) {
            UserList.add(cc);
        }
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return UserList.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User em = (User) UserList.get(rowIndex);
        if (columnIndex == 0) {
            return em.getUserCode();
        }
        if (columnIndex == 1) {
            return em.getUserLogin();
        }
        if (columnIndex == 2) {
            return em.getUserPassword();
        }
        if (columnIndex == 3) {
            return em.getFullName();
        }
        if (columnIndex == 4) {
            return em.getUserTypeCode();
        }
        if (columnIndex == 5) {
            return em.getUserAddress();
        }
        if (columnIndex == 6) {
            return em.getUserPhone();
        }
        if (columnIndex == 7) {
            return em.getEmail();
        }
        if (columnIndex == 8) {
            return em.getActive();
        }
      
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Code";
        }
        if (column == 1) {
            return "UserLogin";
        }
        if (column == 2) {
            return "UserPassword";
        }
        if (column == 3) {
            return "UserFullName";
        }
        if (column == 4) {
            return "UserTypeCode";
        }
        if (column == 5) {
            return "UserAddress";
        }
        if (column == 6) {
            return "UserPhone";
        }
        if (column == 7) {
            return "UserEmail";
        }
        if (column == 8) {
            return "UserActive";
        }
     
        return "";
    }
    
}

