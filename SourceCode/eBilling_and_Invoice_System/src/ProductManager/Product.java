/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductManager;

/**
 *
 * @author MrDuc
 */
public class Product {

    int Product_Code;
    String Product_Name;
    String Product_Type;
    String Supplier_Code;
    int Product_Price;
    int Product_AvailableAmount;
    String Product_infor;

    public Product() {
    }

    public Product(int Product_Code, String Product_Name, String Product_Type, String Supplier_Code, int Product_Price, int Product_AvailableAmount, String Product_infor) {
        this.Product_Code = Product_Code;
        this.Product_Name = Product_Name;
        this.Product_Type = Product_Type;
        this.Supplier_Code = Supplier_Code;
        this.Product_Price = Product_Price;
        this.Product_AvailableAmount = Product_AvailableAmount;
        this.Product_infor = Product_infor;
    }

    public int getProduct_Code() {
        return Product_Code;
    }

    public void setProduct_Code(int Product_Code) {
        this.Product_Code = Product_Code;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String Product_Name) {
        this.Product_Name = Product_Name;
    }

    public String getProduct_Type() {
        return Product_Type;
    }

    public void setProduct_Type(String Product_Type) {
        this.Product_Type = Product_Type;
    }

    public String getSupplier_Code() {
        return Supplier_Code;
    }

    public void setSupplier_Code(String Supplier_Code) {
        this.Supplier_Code = Supplier_Code;
    }

    public int getProduct_Price() {
        return Product_Price;
    }

    public void setProduct_Price(int Product_Price) {
        this.Product_Price = Product_Price;
    }

    public int getProduct_AvailableAmount() {
        return Product_AvailableAmount;
    }

    public void setProduct_AvailableAmount(int Product_AvailableAmount) {
        this.Product_AvailableAmount = Product_AvailableAmount;
    }

    public String getProduct_infor() {
        return Product_infor;
    }

    public void setProduct_infor(String Product_infor) {
        this.Product_infor = Product_infor;
    }

    

}
