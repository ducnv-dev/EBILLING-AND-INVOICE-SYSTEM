/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BillManager;

import CustomerManager.*;

/**
 *
 * @author vivapc99
 */
public class EBill {
    int ebillCode;
    int userCode;
    int customerCode;
    String date;
    int totalPrice;

    public EBill(int ebillCode, int userCode, int customerCode, String date, int totalPrice) {
        this.ebillCode = ebillCode;
        this.userCode = userCode;
        this.customerCode = customerCode;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    EBill() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getEbillCode() {
        return ebillCode;
    }

    public void setEbillCode(int ebillCode) {
        this.ebillCode = ebillCode;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    
    
}
