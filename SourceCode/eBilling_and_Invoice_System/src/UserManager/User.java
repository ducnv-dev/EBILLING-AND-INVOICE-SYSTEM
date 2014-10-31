/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManager;

/**
 *
 * @author MrDuc
 */
public class User {

    int userCode;
    String userLogin;
    String userPassword;
    String fullName;
    String userTypeCode;
    String userAddress;
    String userPhone;
    String Email;
    int Active;

    public User() {
    }

    public User(int userCode, String userLogin, String userPassword, String fullName, String userTypeCode, String userAddress, String userPhone, String Email, int Active) {
        this.userCode = userCode;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.fullName = fullName;
        this.userTypeCode = userTypeCode;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.Email = Email;
        this.Active = Active;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(String userTypeCode) {
        this.userTypeCode = userTypeCode;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int Active) {
        this.Active = Active;
    }

    

}
