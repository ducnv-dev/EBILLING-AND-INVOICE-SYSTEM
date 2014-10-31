/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import Connection.ConfigServer;
import Connection.DataConnect;
import Login.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author Mr_Duc
 */
public class Run {

    public static void main(String[] args) {
        if (DataConnect.connectData() == null) {
            JOptionPane.showMessageDialog(null, "You need config server to connect to database.", "Server is not connect", 2);
            new ConfigServer();
        } else {
            new Login();
        }
    }
}
