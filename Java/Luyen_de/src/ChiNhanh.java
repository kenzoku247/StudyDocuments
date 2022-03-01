import java.util.ArrayList;
import java.util.Scanner;

public class ChiNhanh {
    Scanner sc = new Scanner(System.in);
    public String MaChiNhanh;
    public String TenChiNhanh;
    public String DiaChi;
    private ArrayList<KhachHang> arrKhachHangs = new ArrayList<>();

    public ChiNhanh(){}

    public ChiNhanh(String maChiNhanh, String tenChiNhanh, String diaChi){
        MaChiNhanh = maChiNhanh;
        TenChiNhanh = tenChiNhanh;
        DiaChi = diaChi;
    }

    public String getMaChiNhanh() {
        return MaChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        MaChiNhanh = maChiNhanh;
    }

    public String getTenChiNhanh() {
        return TenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        TenChiNhanh = tenChiNhanh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public void ThemChiNhanh(){
        System.out.println("Nhap ma chi nhanh: ");
        MaChiNhanh = sc.nextLine();
        System.out.println("Nhap ten chi nhanh: ");
        TenChiNhanh = sc.nextLine();
        System.out.println("Nhap dia chi chi nhanh: ");
        DiaChi = sc.nextLine();
    }

    public void ThemKH(KhachHang khachHang){
        arrKhachHangs.add(khachHang);
    }

    public void HienThiTT(){
        System.out.println("Ma chi nhanh: " + MaChiNhanh +
                ". Ten chi nhanh: " + TenChiNhanh + ". Dia chi: " + DiaChi);
    }

    public void HienThiKH(){
        for (KhachHang khachHang: arrKhachHangs){
            khachHang.HienThiTTKH();
        }
    }

    public void HienThiTaiKhoanNH(){
        for (KhachHang khachHang: arrKhachHangs){
            khachHang.HienThiTaiKhoanNH();
        }
    }

    public void HienThiGD(){
        for (KhachHang khachHang: arrKhachHangs){
            khachHang.HienThiGD();
        }
    }

}
