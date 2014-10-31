/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerManager;

/**
 *
 * @author vivapc99
 */
public class Customer {

    int customerCode;
    String name;
    String tel;
    String addr;

    public Customer() {
    }

    public Customer(int customerCode, String name, String tel, String addr) {
        this.customerCode = customerCode;
        this.name = name;
        this.tel = tel;
        this.addr = addr;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

}
