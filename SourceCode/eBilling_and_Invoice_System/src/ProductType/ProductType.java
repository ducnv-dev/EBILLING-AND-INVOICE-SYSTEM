/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProductType;


/**
 *
 * @author MrDuc
 */
public class ProductType {
    int Type_Code;
    String Type_Name;
    public ProductType(){}

    public ProductType(int Type_Code, String Type_Name) {
        this.Type_Code = Type_Code;
        this.Type_Name = Type_Name;
    }

    public int getType_Code() {
        return Type_Code;
    }

    public void setType_Code(int Type_Code) {
        this.Type_Code = Type_Code;
    }

    public String getType_Name() {
        return Type_Name;
    }

    public void setType_Name(String Type_Name) {
        this.Type_Name = Type_Name;
    }
    
}
