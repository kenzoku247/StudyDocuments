package De1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class SieuThi{

    static ArrayList<SanPham> arrSPSTHC = new ArrayList<>();
    static ArrayList<KhachHang> arrKH = new ArrayList<>();
    ArrayList<HoaDon> arrHD = new ArrayList<>();
    static ArrayList<SanPham> arrSPKHM = new ArrayList<>();
    static ArrayList<Integer> arrSLSPKHM = new ArrayList<>();

    static SanPham sanPham;
    static KhachHang khachHang;
    //        HoaDon hoaDon;
    static Scanner sc = new Scanner(System.in);
    static String Masp;
    static String Makh = null;
    static int soLuong;

    public static void NhapTTKH(){
        System.out.println("Nhap ma khach hang: ");
        Makh = sc.nextLine();
        boolean kt = true;
        for (KhachHang hang : arrKH) {
            if (Objects.equals(hang.getMaKH(), Makh)) {
                System.out.println("Da co khach hang voi ma so: " + Makh + " trong danh sach khach hang.");
                kt = false;

            }
        }
        if (kt){
            khachHang = new KhachHang();
            khachHang.Nhap(Makh);
            arrKH.add(khachHang);
        }
    }

    public static void NhapTTSP(ArrayList<SanPham> arrSP){
        String MaSp;
        int SoLuong;
        if(arrSP.size() == 0){
            sanPham = new SanPham();
            sanPham.Nhap();
            arrSP.add(sanPham);
        }
        else{
            System.out.println("Nhap ma san pham: ");
            MaSp = sc.nextLine();
            boolean kt =true;
            for (SanPham sp : arrSP){
                kt = Objects.equals(sp.getMaSP(), MaSp);
            }
            if (kt){
                for (SanPham sp : arrSP) {
                    if (Objects.equals(sp.getMaSP(), MaSp)) {
                        System.out.println("Nhap so luong: ");
                        SoLuong = Integer.parseInt(sc.nextLine());
                        sp.setSoLuong(sp.getSoLuong() + SoLuong);
                    }
                }
            } else {
                System.out.println("Ma san pham nay chua co trong danh sach SP!");
                System.out.println("Nhap moi san pham:");
                sanPham = new SanPham();
                sanPham.Nhap(MaSp);
                arrSP.add(sanPham);
            }
        }
    }

    public static void ChuyenSP(ArrayList<SanPham> arrSPST, ArrayList<SanPham> arrSPKH, String MaSP, int Soluong){
        boolean checkSPST = false;
        boolean checkSPKH = false;

        for (SanPham sp: arrSPST){// Kiem tra co san pham nao trung ma san pham nhap vao ko
            checkSPST = Objects.equals(sp.getMaSP(),MaSP);
            if (checkSPST) break;

        }
        if(checkSPST){                                                  // Neu co
            for (SanPham sp: arrSPKH){                                  // Kiem tra trong gio khach hang co SP nao trung ma nhap vao ko
                checkSPKH = Objects.equals(sp.getMaSP(),MaSP);
            }
            if (checkSPKH){                                             // Neu co
                for (SanPham sp: arrSPKH){                              // Set so luong moi cho SP
                    if (Objects.equals(sp.getMaSP(), MaSP)){
                        if (Soluong < sp.getSoLuong()) Soluong = sp.getSoLuong();
                        sp.setSoLuong(sp.getSoLuong() + Soluong);
                    }
                    break;
                }

            } else{                                                     // Neu khong
                for (int i = 0; i<arrSPST.size();i++){                              // Them san pham
                    if (Objects.equals(arrSPST.get(i).getMaSP(), MaSP)){
                        if (Soluong > arrSPST.get(i).getSoLuong()) Soluong = arrSPST.get(i).getSoLuong();
                        arrSPKH.add(arrSPST.get(i));
                        System.out.println(arrSPST.get(i));
                    }
                    for (SanPham SP: arrSPKH){
                        System.out.println(SP);
                    }
                    break;
                }
                for (SanPham sp: arrSPKH){                              // Set lai so luong cho SP
                    if (Objects.equals(sp.getMaSP(), MaSP)) {
                        sp.setSoLuong(Soluong);
                    }
                }

            }
            for (SanPham sp: arrSPST){                                  // Giam so luong SP cua ST
                if (Objects.equals(sp.getMaSP(), MaSP)){
                    if (Soluong > sp.getSoLuong()) Soluong = sp.getSoLuong();
                    sp.setSoLuong(sp.getSoLuong() - Soluong);
                }
                break;
            }
        } else {
            System.out.println("Sieu thi khong co san pham nao co ma SP: " + MaSP);
        }
    }

    public static void HienThiSP(ArrayList<SanPham> arrSP){
        for (SanPham pham : arrSP) {
            System.out.println(pham.HienThi());
        }
    }

    public static void HienThiKH(){
        for (KhachHang kh : arrKH) {
            System.out.println(kh.HienThi());
        }
    }

    public static void main(String args[]){
        int choose;
        do {
            System.out.println("\n1.Nhap them san pham.");
            System.out.println("2.Hien thi danh sach san pham.");
            System.out.println("3.Nhap them khach hang moi");
            System.out.println("4.Hien thi danh sach khach hang.");
            System.out.println("5.Sua thong tin khach hang theo ma khach hang.");
            System.out.println("6.Nhap danh sach san pham tu file.");
            System.out.println("7.Khach hang mua hang.");
            System.out.println("9. Test Chuyen SP.");
            System.out.println("8.Thoat");

            System.out.print("Nhap lua chon tu 1 den 8: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    NhapTTSP(arrSPSTHC);
                    break;
                case 2:
                    HienThiSP(arrSPSTHC);
                    break;
                case 3:
                    NhapTTKH();
                    break;
                case 4:
                    HienThiKH();
                    break;
                case 5:
                    System.out.println("Nhap ma khach hang muon thay doi: ");
                    Makh = sc.nextLine();
                    boolean kt = true;
                    for (KhachHang kh : arrKH) {
                        kt = Objects.equals(kh.getMaKH(), Makh);
                    }
                    if (kt){
                        for (KhachHang kh : arrKH) {
                            if(Objects.equals(kh.getMaKH(), Makh)){
                                kh.Nhap(Makh);
                            }
                        }
                    } else {
                        System.out.println("Khong co khach hang nao co ma: " + Makh);
                    }
                case 6:
                    String[] data;
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\vuphu\\OneDrive\\Máy tính\\Java\\src\\De1\\data.txt"))) {
                        String line = bufferedReader.readLine();
                        while (line != null) {
                            data = line.split(";");
                            sanPham = new SanPham();
                            sanPham.Nhap(data[0],data[1], Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]));
                            arrSPSTHC.add(sanPham);

                            line = bufferedReader.readLine();
                        }
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
                    break;
                case 7:
                    String ten;
                    System.out.println("Nhap ten khach hang: ");
                    ten = sc.nextLine();
                    int lc6;
                    System.out.println("Khach hang co muon luu thong tin cho lan sau khong? (1:yes)");
                    lc6 = Integer.parseInt(sc.nextLine());
                    if (lc6 == 1){
                        NhapTTKH();
                    } else {
                        System.out.println("Danh sach san pham hien co: ");
                        HienThiSP(arrSPSTHC);
                        String lc;
                        do {
                            System.out.println("\n1. Nhap them san pham. Bam (+)");
                            System.out.println("2. Bo bot san pham. Bam (-)");
                            System.out.println("3. Xuat hoa don");
                            System.out.println("3.1 In danh sach hang trong gio. (p)");
                            System.out.println("4. Thoat. Bam(t)");
                            lc = sc.nextLine();

                            switch(lc) {
                                case "+":
                                    String maSP;
                                    int sl;
                                    System.out.println("Nhap ma san pham ban muon them vao gio hang:");
                                    maSP = sc.nextLine();
                                    System.out.println("Nhap so luong san pham:");
                                    sl = Integer.parseInt(sc.nextLine());
                                    ChuyenSP(arrSPSTHC,arrSPKHM,maSP,sl);
//                                    boolean checkSPST = true;
//                                    boolean checkSPKH;
//                                    for (SanPham sp : arrSPSTHC) {
//                                        checkSPST = Objects.equals(sp.getMaSP(), maSP);
//                                        if (checkSPST) break;
//                                    }
//                                    if (checkSPST) {
//                                        for (SanPham sp : arrSPSTHC) {
//                                            if (Objects.equals(sp.getMaSP(), maSP)) {
//                                                checkSPKH = arrSPKHM.contains(sp.getTenSP());
//                                                System.out.println("Nhap so luong ma ban muon mua: ");
//                                                sl = Integer.parseInt(sc.nextLine());
//                                                if (sl > sp.getSoLuong()) sl = sp.getSoLuong();
//                                                if (checkSPKH) {
//                                                    arrSLSPKHM.set(arrSPKHM.indexOf(sp.getTenSP()), arrSLSPKHM.get(arrSPKHM.indexOf(sp.getTenSP()))+sl);
//                                                } else {
//                                                    arrSPKHM.add(sp.getTenSP());
//                                                    arrSLSPKHM.add(sl);
//                                                }
//                                                System.out.println("San pham da duoc them vao gio hang.");
//                                                sp.setSoLuong(sp.getSoLuong() - sl);
//                                                break;
//                                            }
//                                        }
//                                    } else {
//                                        System.out.println("Sieu thi hien khong co san pham nao co ma SP la: " + maSP);
//                                    }
                                    break;
                                case "-":
                                    System.out.println("Cac san pham hien co trong gio hang cua ban:");
                                    System.out.println("San pham" + "\t"+"So luong");
                                    for (int i = 0; i < arrSPKHM.size(); i++){
                                        System.out.println(arrSPKHM.get(i) + "\t"+ arrSLSPKHM.get(i));
                                    }
                                    System.out.println("Nhap ma san pham ban muon bo bot:");
                                    maSP = sc.nextLine();
                                    break;
                                case "p":
                                    System.out.println("Cac san pham hien co trong gio hang cua ban:");
                                    System.out.println("San pham" + "\t"+"So luong");
                                    for (int i = 0; i < arrSPKHM.size(); i++){
                                        System.out.println(arrSPKHM.get(i).getTenSP() + "\t"+ arrSPKHM.get(i).getSoLuong());
                                    }
                                    break;
                            }
                        } while (!lc.equals("t"));
                    }



            }
        } while (choose != 8);

    }
}
