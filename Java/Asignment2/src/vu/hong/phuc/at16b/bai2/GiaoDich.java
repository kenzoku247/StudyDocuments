package vu.hong.phuc.at16b.bai2;

import java.util.Scanner;

public class GiaoDich {
    private String MaGiaoDich;
    private String NgayGiaoDich;
    private Float DonGia;
    private int SoLuong;
    Scanner sc = new Scanner(System.in);

    public GiaoDich(){
        super();
    }

    public GiaoDich(String maGiaoDich, String ngayGiaoDich, Float donGia, int soLuong) {
        super();
        this.MaGiaoDich = maGiaoDich;
        this.NgayGiaoDich = ngayGiaoDich;
        this.DonGia = donGia;
        this.SoLuong = soLuong;
    }



    public String getMaGiaoDich() {
        return MaGiaoDich;
    }

    public void setMaGiaoDich(String MaGiaoDich) {
        this.MaGiaoDich = MaGiaoDich;
    }

    public String getNgayGiaoDich() {
        return NgayGiaoDich;
    }

    public void setNgayGiaoDich(String NgayGiaoDich) {
        this.NgayGiaoDich = NgayGiaoDich;
    }

    public Float getDonGia() {
        return DonGia;
    }

    public void setDonGia(Float DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void input(){
        System.out.print("Nhap ma giao dich: ");
        MaGiaoDich = sc.nextLine();
        System.out.print("Nhap ngay giao dich (ngay/thang/nam)");
        NgayGiaoDich = sc.nextLine();
        System.out.print("Nhap don gia: ");
        DonGia = sc.nextFloat();
        System.out.print("Nhap so luong: ");
        SoLuong = sc.nextInt();
    }

    public String display(){
        return "Ma giao dich: " + this.MaGiaoDich + ", ngay giao dich: " + this.NgayGiaoDich +
                ", don gia: " + this.DonGia + ", so luong: " + this.SoLuong;
    }

    public float ThanhTien(){
        return this.SoLuong*this.DonGia;
    }

}