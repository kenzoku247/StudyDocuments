package Bai_4;

import java.util.Scanner;

public class GiaoDich {
    private String MaGiaoDich;
    private String NgayGiaoDich;
    private Float DonGia;
    private Float DienTich;
    Scanner sc = new Scanner(System.in);

    public GiaoDich(){
        super();
    }

    public GiaoDich(String maGiaoDich, String ngayGiaoDich, Float donGia, Float dienTich) {
        super();
        this.MaGiaoDich = maGiaoDich;
        this.NgayGiaoDich = ngayGiaoDich;
        this.DonGia = donGia;
        this.DienTich = dienTich;
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

    public Float getDienTich() {
        return DienTich;
    }

    public void setDienTich(Float DienTich) {
        this.DienTich = DienTich;
    }

    public void input(){
        System.out.print("Nhap ma giao dich: ");
        MaGiaoDich = sc.nextLine();
        System.out.print("Nhap ngay giao dich (ngay/thang/nam)");
        NgayGiaoDich = sc.nextLine();
        System.out.print("Nhap don gia: ");
        DonGia = sc.nextFloat();
        System.out.print("Nhap dien tich");
        DienTich = sc.nextFloat();
    }

    public String display(){
        return "Ma giao dich: " + this.MaGiaoDich + ", ngay giao dich: " + this.NgayGiaoDich +
                ", don gia: " + this.DonGia + ", dien tich: " + this.DienTich;
    }

    public float TinhTien(){
        return this.DienTich*this.DonGia;
    }

}

