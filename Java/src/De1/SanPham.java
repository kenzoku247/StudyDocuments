package De1;

import java.util.Scanner;

public class SanPham {
    private String MaSP;
    private String TenSP;
    private float DonGia;
    private String NgayXS;
    private int SoLuongTonKho;

    Scanner sc = new Scanner(System.in);

    public SanPham(){}

    public SanPham(String maSP, String tenSP, float donGia, String ngayXS) {
        this.MaSP = maSP;
        this.TenSP = tenSP;
        this.DonGia = donGia;
        this.NgayXS = ngayXS;
    }

    public String getMaSP() {
        return this.MaSP;
    }

    public void setMaSP(String maSP) {
        this.MaSP = maSP;
    }

    public String getTenSP() {
        return this.TenSP;
    }

    public void setTenSP(String tenSP) {
        this.TenSP = tenSP;
    }

    public float getDonGia() {
        return this.DonGia;
    }

    public void setDonGia(float donGia) {
        this.DonGia = donGia;
    }

    public String getNgayXS() {
        return this.NgayXS;
    }

    public void setNgayXS(String ngayXS) {
        this.NgayXS = ngayXS;
    }

    public int getSoLuong() {
        return SoLuongTonKho;
    }

    public void setSoLuong(int soLuong) {
        SoLuongTonKho = soLuong;
    }

    public void Nhap(){
        System.out.println("Nhap ma san pham: ");
        MaSP = sc.nextLine();
        System.out.println("Nhap ten san pham: ");
        TenSP = sc.nextLine();
        System.out.println("Nhap don gia cua san pham: ");
        DonGia = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ngay sx cua san pham: ");
        NgayXS = sc.nextLine();
        System.out.println("Nhap so luong cua san pham: ");
        SoLuongTonKho = Integer.parseInt(sc.nextLine());
    }

    public void Nhap(String maSP){
        this.MaSP = maSP;
        System.out.println("Nhap ten san pham: ");
        TenSP = sc.nextLine();
        System.out.println("Nhap don gia cua san pham: ");
        DonGia = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ngay sx cua san pham: ");
        NgayXS = sc.nextLine();
        System.out.println("Nhap so luong cua san pham: ");
        SoLuongTonKho = Integer.parseInt(sc.nextLine());
    }

    public void Nhap(String maSP,int soLuong){
        SoLuongTonKho = getSoLuong() + soLuong;
    }

    public void Nhap(String maSP, String tenSP, int donGia, String ngayXS, int soLuongTonKho){
        MaSP = maSP;
        TenSP = tenSP;
        NgayXS = ngayXS;
        DonGia = donGia;
        SoLuongTonKho = soLuongTonKho;
    }

    public String HienThi(){
        return "Ma san pham: " + MaSP + ". Ten SP: " + TenSP  + ", don gia: " + DonGia + ", ngay SX: " + NgayXS + ", so luong hien co: " + SoLuongTonKho;
    }
}
