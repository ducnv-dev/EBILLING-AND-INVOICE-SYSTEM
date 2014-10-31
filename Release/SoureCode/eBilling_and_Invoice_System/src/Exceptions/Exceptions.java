/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import ProductManager.Product;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vivapc99
 */
public class Exceptions extends Exception {

    public Exceptions() {

    }

    public Exceptions(String message) throws Exceptions {
        super(message);

    }

    public static void NoRowSelectedInTable(boolean isSlected, String msg) throws Exceptions {
        if (isSlected == false) {
            throw new Exceptions(msg);
        }
    }

    public static void ProductExistent(int productCodeTocheck, List<Product> choosenProducts) throws Exceptions {
        for (Product p : choosenProducts) {
            if (p.getProduct_Code()== productCodeTocheck) {
                throw new Exceptions("The product was added already");
            }
        }
    }

    public static void DateRangeException(Date date1, Date date2) throws Exceptions {
        if (date1.after(date2)) {
            throw new Exceptions("Invalid Date Range");
        }
    }

    public static void PreceedQuantityException(Object productCodeTocheck, String inputQuantity, List<Product> choosenProducts) throws Exceptions {
        for (Product p : choosenProducts) {
            if (p.getProduct_Code()== Integer.parseInt(productCodeTocheck.toString()) && Integer.parseInt(inputQuantity) > p.getProduct_AvailableAmount()) {
                throw new Exceptions("Not enough quantity in storage");
            }
        }
    }
}
