import java.util.Scanner;

public class SanPham  {
    private String MaSp;
    private String TenSP;
    private float DonGia;
    private String NgaySX;
    private static int SoLuongTonKho=0;

    Scanner sc = new Scanner(System.in);

    public SanPham(){}

    public SanPham(String maSp, String tenSP, float donGia, String ngaySX) {
        MaSp = maSp;
        TenSP = tenSP;
        DonGia = donGia;
        NgaySX = ngaySX;
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String maSp) {
        MaSp = maSp;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float donGia) {
        DonGia = donGia;
    }

    public String getNgaySX() {
        return NgaySX;
    }

    public void setNgaySX(String ngaySX) {
        NgaySX = ngaySX;
    }

    public int getSoLuongTonKho() {
        return SoLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        SoLuongTonKho = soLuongTonKho;
    }

    public void Nhap(){
        System.out.println("Nhap ma san pham: ");
        MaSp = sc.nextLine();
        System.out.println("Nhap ten san pham: ");
        TenSP = sc.nextLine();
        System.out.println("Nhap don gia san pham: ");
        DonGia = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ngay sx cua san pham: ");
        NgaySX = sc.nextLine();
        System.out.println("Nhap so luong san pham: ");
        SoLuongTonKho = SoLuongTonKho + Integer.parseInt(sc.nextLine());
    }

    public void Nhap(String maSp){
        MaSp = maSp;
        System.out.println("Nhap ten san pham: ");
        TenSP = sc.nextLine();
        System.out.println("Nhap don gia san pham: ");
        DonGia = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ngay sx cua san pham: ");
        NgaySX = sc.nextLine();
        System.out.println("Nhap so luong san pham: ");
        SoLuongTonKho += Integer.parseInt(sc.nextLine());
    }

    public static void main(String args[]){
        System.out.println("Nhap them san pham");
        sanPham = new SanPham();
        sanPham.Nhap();
    }
}