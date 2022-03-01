package De1;

import java.util.ArrayList;
import java.util.Scanner;

public class HoaDon {
    private String sanPham;
    private int soLuong;
    private float thanhTien;
    private String maHD;
    private String maKH;
    private String ngayVietHD;

    private ArrayList<SanPham> arrSp = new ArrayList<>();
    private ArrayList<Integer> arrSl = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public HoaDon(int soLuong, float thanhTien, String maHD, String maKH, String ngayVietHD) {
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.maHD = maHD;
        this.maKH = maKH;
        this.ngayVietHD = ngayVietHD;
    }

    public HoaDon(){}

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

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

    public String getNgayVietHD() {
        return ngayVietHD;
    }

    public void setNgayVietHD(String ngayVietHD) {
        this.ngayVietHD = ngayVietHD;
    }

//    public void Nhap(){
//        int lc;
//
//    }
}
