/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserType;

/**
 *
 * @author MrDuc
 */
public class UserType {

    String UserTypeCode;
    String UserTypeName;

    public UserType() {
    }

    ;

    public UserType(String UserTypeCode, String UserTypeName) {
        this.UserTypeCode = UserTypeCode;
        this.UserTypeName = UserTypeName;
    }

    public String getUserTypeCode() {
        return UserTypeCode;
    }

    public void setUserTypeCode(String UserTypeCode) {
        this.UserTypeCode = UserTypeCode;
    }

    public String getUserTypeName() {
        return UserTypeName;
    }

    public void setUserTypeName(String UserTypeName) {
        this.UserTypeName = UserTypeName;
    }

}
