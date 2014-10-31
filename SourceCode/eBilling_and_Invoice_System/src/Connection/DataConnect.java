/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr_Duc
 */
public class DataConnect {

    //ket noi Database
    public static Connection connectData() {
        Connection conn = null;
        ServerConfig serverConfig = config();
        if (serverConfig == null) {
            return null;
        }
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            String url = "jdbc:sqlserver://" + serverConfig.getServerName() + ":" + serverConfig.getPort() + ";databaseName=" + serverConfig.getDatabaseName();
//            String userName = serverConfig.getUserName();
//            String passWord = serverConfig.getPassWord();
            conn = DriverManager.getConnection(url,serverConfig.getUserName(),serverConfig.getPassWord() );
        } catch (Exception e) {
            return null;
        }
        return conn;
    }

//Set thong tin config
    public static ServerConfig config() {
        File file = new File("config.properties");
        ServerConfig serverConfig = new ServerConfig();
        if (!file.exists()) {
            return null;
        }

        try  {
            FileInputStream fis = new FileInputStream(file);
            Properties pro = new Properties();
            pro.load(fis);
            serverConfig.setServerName(pro.getProperty("serverName"));
            serverConfig.setPort(pro.getProperty("port"));
            serverConfig.setDatabaseName(pro.getProperty("databaseName"));
            serverConfig.setUserName(pro.getProperty("userName"));
            serverConfig.setPassWord(pro.getProperty("passWord"));
            fis.close();
        } catch (Exception e) {
            return null;
        }
        return serverConfig;
    }

    public static void setServerConfig(ServerConfig conn) {
        FileOutputStream fos = null;
        try {
            File file = new File("config.properties");
            Properties pro = new Properties();
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            pro.setProperty("serverName", conn.getServerName());
            pro.setProperty("port", conn.getPort());
            pro.setProperty("databaseName", conn.getDatabaseName());
            pro.setProperty("userName", conn.getUserName());
            pro.setProperty("passWord", conn.getPassWord());
            pro.store(fos, null);
            fos.close();

        } catch (Exception ex) {
            Logger.getLogger(DataConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
