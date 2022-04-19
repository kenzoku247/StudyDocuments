package vu.hong.phuc.at16b.bai1;

import java.util.Scanner;

public class Nguoi {
    private String HoTen;
    int Tuoi;
    int NamSinh;
    String QueQuan;
    Scanner sc = new Scanner(System.in);

    public Nguoi() {
        super();
    }

    public Nguoi(String HoTen, int Tuoi, int NamSinh, String QueQuan) {
        super();
        this.HoTen = HoTen;
        this.Tuoi = Tuoi;
        this.NamSinh = NamSinh;
        this.QueQuan = QueQuan;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int tuoi) {
        Tuoi = tuoi;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int namSinh) {
        NamSinh = namSinh;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String queQuan) {
        QueQuan = queQuan;
    }

    public void input() {
        System.out.print("Nhap ho va ten: ");
        HoTen = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        Tuoi = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap nam sinh: ");
        NamSinh = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap que quan: ");
        QueQuan = sc.nextLine();

    }

    public String display() {
        return "Ho ten " + this.HoTen + ", sinh nam " + this.HoTen + ", " + this.Tuoi + " tuoi, que tai " + this.QueQuan + ".";
    }
}


