/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validate;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author NHATTHANH
 */
public class SystemManagement {
    
    public static String convertStringIdCardNo(String idCardNo, boolean b) {
        return b
                ?   idCardNo.substring(0, 3)
                        + "-"
                        + idCardNo.substring(3, 6)
                        + "-"
                        + idCardNo.substring(6, 9)
                :   idCardNo.substring(0, 3)
                        + idCardNo.substring(4, 7)
                        + idCardNo.substring(8, 11);
    }

    public static String convertStringAccNo(String accNo, boolean b) {
        return b
                ?   accNo.substring(0, 4)
                        + "-"
                        + accNo.substring(4, 8)
                        + "-"
                        + accNo.substring(8, 12)
                        + "-"
                        + accNo.substring(12, 16)
                :   accNo.substring(0, 4)
                        + accNo.substring(5, 9)
                        + accNo.substring(10, 14)
                        + accNo.substring(15, 19);
    }
    
    
    
    public static String convertMoney(String money) {
        String strFormat = "";
        int len = money.length();

        if (len > 9) {
            for (int i = 0; i < len - 9; i++) {
                strFormat += "0";
            }
            strFormat += ",000,000,000";
        } else if (len > 6) {
            for (int i = 0; i < len - 6; i++) {
                strFormat += "0";
            }
            strFormat += ",000,000";
        } else if (len > 3) {
            for (int i = 0; i < len - 3; i++) {
                strFormat += "0";
            }
            strFormat += ",000";
        } else {
            return money;
        }
        NumberFormat format = new DecimalFormat(strFormat);
        try {
            return format.format(Integer.parseInt(money));
        } catch (Exception e) {
            return "";
        }
    }
    
    public static String convertMoney(float money) {
        String strFormat = "";
        int nMoney = (int) money;
        String sMoney = Integer.toString(nMoney);
        int len = sMoney.length();

        if (len > 9) {
            for (int i = 0; i < len - 9; i++) {
                strFormat += "0";
            }
            strFormat += ",000,000,000";
        } else if (len > 6) {
            for (int i = 0; i < len - 6; i++) {
                strFormat += "0";
            }
            strFormat += ",000,000";
        } else if (len > 3) {
            for (int i = 0; i < len - 3; i++) {
                strFormat += "0";
            }
            strFormat += ",000";
        } else {
            return sMoney;
        }
        NumberFormat format = new DecimalFormat(strFormat);
        try {
            return format.format(Integer.parseInt(sMoney));
        } catch (Exception e) {
            return "";
        }
    }
    
    public static float convertStringMoneyToFloat(String sMoney) {
        return Float.parseFloat(sMoney.replaceAll(",", ""));
    }

    public static String convertMoneyToString(float fMoney) {
        String sMoney = Float.toString(fMoney);
        sMoney = sMoney.substring(0, sMoney.lastIndexOf("."));
        return sMoney.trim();
    }
    
    
}
