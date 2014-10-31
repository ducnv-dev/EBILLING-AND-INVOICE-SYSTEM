/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPanel;

/**
 *
 * @author Mr_Duc
 */
public class Bill {
    private Product product;
    private String maHD;
    private String maKH;
    private String maSP;
    private String ngay;
    private int slSP;

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getSlSP() {
        return slSP;
    }

    public void setSlSP(int slSP) {
        this.slSP = slSP;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public Bill(String maHD, String maKH, String maSP, String ngay, int slSP, int tongTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maSP = maSP;
        this.ngay = ngay;
        this.slSP = slSP;
        this.tongTien = tongTien;
    }
    private int tongTien;
    
}
