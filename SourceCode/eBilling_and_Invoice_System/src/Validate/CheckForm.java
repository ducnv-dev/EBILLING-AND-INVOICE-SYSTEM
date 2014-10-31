/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author NHATTHANH
 */
public class CheckForm {

    public static boolean checkPrice(String value) {
        Pattern pattern = Pattern.compile("^[0-9]{4,10}$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean checkAmount(String value) {
        Pattern pattern = Pattern.compile("^[0-9]{1,4}$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean checkCardNumber(String value) {
        Pattern pattern = Pattern.compile("^[0-9]{16}$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean checkIDCard(String value) {
        Pattern pattern = Pattern.compile("^[0-9]{9}$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean checkBalance(String value) {
        Pattern pattern = Pattern.compile("^[-+]?[0-9]*\\.?[0-9]*$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean checkPIN(String value) {
        Pattern pattern = Pattern.compile("^[0-9]{4}$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean checkUsername(String value) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{4,10}$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean checkPassword(String value) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9][ \\w\\W]{3,11}$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean checkName(String value) {
        Pattern pattern = Pattern.compile("^[a-zA-Z ]{6,20}$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean checkAddress(String value) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9][ \\w\\W]{5,50}$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean checkPhone(String value) {
        Pattern pattern = Pattern.compile("^[0][0-9]{9,10}$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean checkEmail(String value) {
        Pattern pattern = Pattern.compile("^[a-zA-Z][\\w]+(@)[\\w]+((.)[\\w]+)+$$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}
