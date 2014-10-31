/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

/**
 *
 * @author Mr_Duc
 */
public class ServerConfig {

    private String serverName = "";
    private String databaseName = "";
    private String port = "";
    private String userName = "";
    private String passWord = "";

    public  ServerConfig() {
    }

    public ServerConfig(String serverName, String databaseName, String port, String userName, String passWord) {
        this.serverName = serverName;
        this.databaseName = databaseName;
        this.port = port;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    

}
