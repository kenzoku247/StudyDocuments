import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.math.BigInteger;


public class app {
    static Scanner sc = new Scanner(System.in);

    private static int MaSoGD=0;

    static TaiKhoanNH taiKhoanNH;
    static ThongTinGD thongTinGD;
    static KhachHang khachHang;
    static ChiNhanh chiNhanh;
    private static ArrayList<ChiNhanh> arrChiNhanh = new ArrayList<>();

    public static TaiKhoanNH ThemTK(){
        Random random = new Random();
        BigInteger n = new BigInteger(53, random);
        taiKhoanNH = new TaiKhoanNH(String.valueOf(n), 0);
        return taiKhoanNH;
    }

    public static void GDThanhCong(ThongTinGD thongTinGD, String maChiNhanh){
        thongTinGD.setMaGD(maChiNhanh + String.format("%08d",MaSoGD));
        MaSoGD += 1;
    }

    public static void ThemKH(ArrayList<KhachHang> arrayKH){
        System.out.println("Nhap so luong khach hang muon them: ");
        int soLuong = Integer.parseInt(sc.nextLine());
        for (int i = 0; i<soLuong;i++){
            khachHang = new KhachHang();
            khachHang.ThemKH();
            arrayKH.add(khachHang);
        }
    }

    public static void ThemNhieuTK(ArrayList<TaiKhoanNH> arrayTK){
        System.out.println("Nhap so luong tai khaon ma khach hang muon them: ");
        int soLuong = Integer.parseInt(sc.nextLine());
        for (int i = 0; i<soLuong;i++){
            taiKhoanNH = new TaiKhoanNH();
            taiKhoanNH = ThemTK();
            arrayTK.add(taiKhoanNH);
        }
    }



    public static void main(String[] args){
        int choose;
        do {
            System.out.println("\n1.Them khach hang");
            System.out.println("2.Them tai khoan");
            System.out.println("3.In thong tin khach hang");
            System.out.println("4.Gui tien, rut tien");
            System.out.println("5.In tat ca giao dich");
            System.out.println("6.Liet ke cac tai khoan co so du lon nhat");
            System.out.println("7.Sap xep tang dan so du cua tat ca khach hang");
            System.out.println("8.Hien thi khach hang co so luong GD nhieu nhat");
            System.out.println("9.Thoat");

            System.out.print("Nhap lua chon tu 1 den 8: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Muon tao moi mot chi nhanh : 1:yes/0:no");
                    int lc1 = Integer.parseInt(sc.nextLine());
                    if (lc1 == 1) {
                        System.out.println("Nhap so luong chi nhanh muon them :");
                        int soLuongCN = Integer.parseInt(sc.nextLine());
                        for (int i = 0; i < soLuongCN; i++) {
                            chiNhanh = new ChiNhanh();
                            chiNhanh.ThemChiNhanh();
                            arrChiNhanh.add(chiNhanh);
                            System.out.println("Da them 1 chi nhanh!");
                        }
                    }
                    for (ChiNhanh chiNhanh : arrChiNhanh){
                        chiNhanh.HienThiTT();
                    }
                    System.out.println("Nhap ma chi nhanh muon them khach hang: ");
                    String maCN = sc.nextLine();
                    boolean kt = true;
                    for (ChiNhanh cn : arrChiNhanh) {
                        System.out.println(cn.getMaChiNhanh());
                        kt = Objects.equals(cn.getMaChiNhanh(), maCN);
                        if (kt) break;
                    }
                    if (kt){
                        for (ChiNhanh cn : arrChiNhanh) {
                            if(Objects.equals(cn.getMaChiNhanh(), maCN)){
                                System.out.println("Nhap so luong khach hang muon them: ");
                                int soLuongKH = Integer.parseInt(sc.nextLine());
                                for (int i=0; i<soLuongKH; i++){
                                    khachHang = new KhachHang();
                                    khachHang.ThemKH();
                                    cn.ThemKH(khachHang);
                                    System.out.println("Da them 1 khach hang!");
                                }
                            }
                        }
                    } else {
                        System.out.println("Khong co chi nhanh nao co ma: " + maCN);
                    }


                case 2:

                case 3:
                    for (ChiNhanh cn : arrChiNhanh){
                        cn.HienThiKH();
                    }
                case 4:

                case 5:

                case 6:

                case 7:

                case 8:

            }

        } while (choose != 9) ;
    }

}
