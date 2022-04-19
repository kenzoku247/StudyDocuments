package De1;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class KhachHang {
    private String MaKH;
    private String TenKH;
    private int NamSinh;
    private String DiaChi;
//    HoaDon hoaDon;
//    ArrayList<HoaDon> arrHD = new ArrayList<>();

    Scanner sc = new Scanner(System.in);


    
    public  KhachHang(){}
    
    public KhachHang(String maKH, String tenKH, int namSinh, String diaChi) {
        MaKH = maKH;
        TenKH = tenKH;
        NamSinh = namSinh;
        DiaChi = diaChi;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int namSinh) {
        NamSinh = namSinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public void Nhap(){
        System.out.println("Nhap ma khach hang: ");
        MaKH = sc.nextLine();
        System.out.println("Nhap ten khach hang: ");
        TenKH = sc.nextLine();
        System.out.println("Nhap nam sinh cua khach hang: ");
        NamSinh = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap dia chi cua khach hang: ");
        DiaChi = sc.nextLine();
    }

    public void Nhap(String maKH){
        MaKH = maKH;
        System.out.println("Nhap ten khach hang: ");
        TenKH = sc.nextLine();
        System.out.println("Nhap nam sinh cua khach hang: ");
        NamSinh = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap dia chi cua khach hang: ");
        DiaChi = sc.nextLine();
    }


    public String HienThi(){
        return "khach hang: " + TenKH + ", co ma KH: " + MaKH + ", nam sinh: " + NamSinh + ", dia chi: " + DiaChi;
    }
    
}
