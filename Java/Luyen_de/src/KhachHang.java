import java.util.ArrayList;
import java.util.Scanner;

public class KhachHang {
    Scanner sc = new Scanner(System.in);
    private ArrayList<TaiKhoanNH> ArrTaiKhoanNHs = new ArrayList<>();
    private String MaKH;
    private String TenKH;
    private String DiaChi;

    public KhachHang(){}

    public KhachHang(String maKH, String tenKH, String diaChi){
        MaKH = maKH;
        TenKH = tenKH;
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

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public void ThemKH(){
        System.out.println("Nhap ma khach hang: ");
        MaKH = sc.nextLine();
        System.out.println("Nhap ten khach hang: ");
        TenKH = sc.nextLine();
        System.out.println("Nhap dia chi khach hang: ");
        DiaChi = sc.nextLine();
    }

    public void ThemTK(TaiKhoanNH taiKhoanNH){
        ArrTaiKhoanNHs.add(taiKhoanNH);
    }

    public void HienThiTTKH(){
        System.out.println("Ma KH: " + MaKH + ". Ho ten: " + TenKH
                + ". Dia chi: " + DiaChi);
    }

    public void HienThiTaiKhoanNH(){
        for (TaiKhoanNH taiKhoanNH : ArrTaiKhoanNHs){
            taiKhoanNH.HienThiTK();
        }
    }

    public void HienThiGD(){
        for (TaiKhoanNH taiKhoanNH : ArrTaiKhoanNHs){
            taiKhoanNH.HienThiGD();
        }
    }
}
