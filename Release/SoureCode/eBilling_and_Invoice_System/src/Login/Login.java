/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Connection.DataConnect;
import UserProfile.UserProfile;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mr_Duc
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    Connection conn;
    PreparedStatement prst;
    ResultSet rs;

    public static String userTypeCode = "";
    public static String userLogin = "";
    public static int active;

    public Login() {
        initComponents();
        conn = DataConnect.connectData();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/ebilling_logo_icon.png")));
        setTitle("Ebilling System - Login");
        setLocationRelativeTo(null); 
        conn = DataConnect.connectData();
        setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtpassWord = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ebilling_logo.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

        jLabel4.setText("UserName :");

        jLabel5.setText("Password :");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit))
                    .addComponent(txtUserName)
                    .addComponent(txtpassWord))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtpassWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnExit))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
//        UserProfile user = new UserProfile();
//        user.setVisible(false);
//        this.LoginAdmin();
        boolean check = false;
        String userName = txtUserName.getText();
        String passWord = new String(txtpassWord.getPassword());
        if (userName.isEmpty() || userName == "") {
            JOptionPane.showMessageDialog(this, "Card number is not empty!", "Warning!", 2);
            txtUserName.requestFocus();
            return;
        }
        if (passWord.isEmpty() || passWord == "") {
            JOptionPane.showMessageDialog(this, "PIN number is not empty!", "Warning!", 2);
            txtpassWord.requestFocus();
            return;
        } else {
            try {
                String sql = "select * from Users where userLogin = ? and [password] = ?";
                prst = conn.prepareStatement(sql);
                prst.setString(1, userName);
                prst.setString(2, passWord);
                rs = prst.executeQuery();
                if (rs.next()) {
//                    System.out.println("hihi");
                    String type = rs.getString("userTypeCode");
//                    UserProfile user = new UserProfile();
//                    user.setVisible(true);
                    if ("M".equals(type)) {
                        this.setVisible(false);
                        UserProfile.setUserName(userName);
                        UserProfile user = new UserProfile();                 
                        user.setVisible(true);
                    }
                    if ("A".equals(type)) {
                        this.setVisible(false);
                        UserProfile.setUserName(userName);
                        UserProfile user = new UserProfile();                 
                        user.setVisible(true);
                    }
                    if ("S".equals(type)) {
                        this.setVisible(false);
                        UserProfile.setUserName(userName);
                        UserProfile user = new UserProfile();                 
                        user.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid card number or PIN!", "Login failed", 0);
                }

                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JPasswordField txtpassWord;
    // End of variables declaration//GEN-END:variables

//    public void LoginAdmin() {
//        boolean flag = false;
//        Vector v = new Vector();
//        try {
//            String userName = txtUserName.getText();
//            String passWord = new String(txtpassWord.getPassword());
//            prst = conn.prepareCall("{call spGetAllUser)}");
//            rs = prst.executeQuery();
//            while (rs.next()) {
//                User objUser = new User();
//                objUser.userCode = rs.getInt(1);
//                objUser.userLogin = rs.getString(2);
//                objUser.password = rs.getString(3);
//                objUser.fullName = rs.getString(4);
//                objUser.userTypeCode = rs.getString(5);
//                objUser.userAddress = rs.getString(6);
//                objUser.userPhone = rs.getString(7);
//                objUser.userEmail = rs.getString(8);
//                objUser.userActive = rs.getInt(9);
//                v.add(objUser);
//            }
//            User u = new User();
//            for (int i = 0; i < v.size(); i++) {
//                u = (User) v.get(i);
//                if (u.getUserLogin().equals(userName) && u.getPassword().equals(passWord)) {
//                    userTypeCode = u.getUserTypeCode();
//                    userLogin = u.getUserLogin();
//                    active = u.getUserActive();
//                    if (active == 1) {
//                        flag = true;
//                    } else {
//                        flag = false;
//                    }
//                }
//                if (flag == true) {
//                    UserProfile use = new UserProfile();
//                    use.setVisible(true);
//                    dispose();
//                } else {
//                    JOptionPane.showMessageDialog(this, "User name or password is invalid \nUser not active .Please try agian", "Login Fails", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}