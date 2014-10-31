/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BillManager;

/**
 *
 * @author vivapc99
 */
public class EbillDetail {
    int productCode;
    int ebillCode;
    int quantity;

    public EbillDetail(int productCode, int ebillCode, int quantity) {
        this.productCode = productCode;
        this.ebillCode = ebillCode;
        this.quantity = quantity;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getEbillCode() {
        return ebillCode;
    }

    public void setEbillCode(int ebillCode) {
        this.ebillCode = ebillCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
