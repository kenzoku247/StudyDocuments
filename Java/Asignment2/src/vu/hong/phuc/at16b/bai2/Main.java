package vu.hong.phuc.at16b.bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<GiaoDichVang> arrGiaoDichVang = new ArrayList<>();
        ArrayList<GiaoDichTienTe> arrGiaoDichTienTe = new ArrayList<>();
        int SoGiaoDichVang = 0;
        int SoGiaoDichTien = 0;
        float TongTienGiaoDichVang = 0;
        float TongTienGiaoDichTienTe = 0;
        float TrungBinhThanhTienGDV;
        float TrungBinhThanhTienGDTT;

        float DonGia;
        Scanner sc = new Scanner(System.in);


        int choose;
        do {
            System.out.println("1.Nhap them thong tin giao dich vang.");
            System.out.println("2.Nhap them thong tin giao dich tien.");
            System.out.println("3.Tinh tong so luong cua tung loai giao dich.");
            System.out.println("4.Tinh trung binh thanh tien giao dich.");
            System.out.println("5.Xuat thong tin giao dich don gia lon hon 1 ty.");
            System.out.println("6.Thoat");

            System.out.print("Nhap lua chon tu 1 den 6: ");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    System.out.print("Nhap them so giao dich vang: ");
                    SoGiaoDichVang = sc.nextInt();

                    System.out.println("Nhap thong tin giao dich vang: ");
                    for (int i = 1; i <= SoGiaoDichVang; i++) {
                        System.out.println("Nhap thong tin giao dich vang STT: " + i);
                        GiaoDichVang giaoDichVang = new GiaoDichVang();
                        giaoDichVang.input();
                        arrGiaoDichVang.add(giaoDichVang);
                    }
                    System.out.println("\n\n");
                    break;
                case 2:
                    System.out.print("Nhap them so giao dich tien te: ");
                    SoGiaoDichTien = sc.nextInt();
                    System.out.println("Nhap thong tin giao dich tien te:");
                    for (int i = 1; i <= SoGiaoDichTien; i++) {
                        System.out.println("Nhap thong tin giao dich tien STT: " + (i + 1));
                        GiaoDichTienTe giaoDichTienTe = new GiaoDichTienTe();
                        giaoDichTienTe.input();
                        arrGiaoDichTienTe.add(giaoDichTienTe);
                    }
                    System.out.println("\n\n");
                    break;
                case 3:
                    System.out.println("Ban muon tinh so luong giao dich nao (vang:1/tien te:2)");
                    int luachon3;
                    luachon3 = sc.nextInt();
                    switch (luachon3) {
                        case 1:
                            System.out.println("So luong giao dich vang la: " + arrGiaoDichVang.size());
                        case 2:
                            System.out.println("So luong giao dich tien te la: " + arrGiaoDichTienTe.size());
                        default:
                            System.out.println("Loi ky tu khong hop le!");
                            break;
                    }
                    System.out.println("\n\n");
                    break;
                case 4:
                    System.out.println("Ban muon tinh trung binh thanh tien giao dich nao (vang:1/tien te:2)");
                    int luachon4;
                    luachon4 = sc.nextInt();
                    switch (luachon4) {
                        case 2:
                            for (int i = 0; i < arrGiaoDichTienTe.size(); i++) {
                                if (arrGiaoDichTienTe.get(i).getLoaiTien().equalsIgnoreCase("US") || arrGiaoDichTienTe.get(i).getLoaiTien().equalsIgnoreCase("EURO")) {
                                    TongTienGiaoDichTienTe += arrGiaoDichTienTe.get(i).ThanhTien();
                                } else if (arrGiaoDichTienTe.get(i).getLoaiTien().equalsIgnoreCase("VN") || arrGiaoDichTienTe.get(i).getLoaiTien().equalsIgnoreCase("VIET NAM")) {
                                    TongTienGiaoDichTienTe += arrGiaoDichTienTe.get(i).ThanhTien();
                                }
                            }
                            TrungBinhThanhTienGDTT = TongTienGiaoDichTienTe / (arrGiaoDichTienTe.size());
                            System.out.println("Trung bình thành tiền của giao dịch đất = " + TrungBinhThanhTienGDTT);

                            break;
                        case 1:
                            for (int i = 0; i < arrGiaoDichVang.size(); i++) {
                                TongTienGiaoDichVang += arrGiaoDichVang.get(i).ThanhTien();

                            }
                            TrungBinhThanhTienGDV = TongTienGiaoDichVang / (arrGiaoDichVang.size());
                            System.out.println("Trung bình thành tiền của giao dịch nhà = " + TrungBinhThanhTienGDV);
                            System.out.println("\n\n");
                            break;
                        default:
                            System.out.println("Loi!");
                            break;
                    }
                case 5:
                    System.out.println("Ban muon hien thi giao dich nao (vang:1/tien te:2)");
                    int luachon5;
                    luachon5 = sc.nextInt();
                    switch (luachon5) {
                        case 1:
                            for (int i = 0; i < arrGiaoDichVang.size(); i ++){
                                if (arrGiaoDichVang.get(i).getDonGia() > 1000000000f) {
                                    System.out.println(arrGiaoDichVang.get(i).display());
                                }
                            }
                            break;
                        case 2:
                            for (int i = 0; i < arrGiaoDichTienTe.size(); i ++){
                                if (arrGiaoDichTienTe.get(i).getDonGia() > 1000000000f) {
                                    System.out.println(arrGiaoDichTienTe.get(i).display());
                                }
                            }
                            break;
                        default:
                            System.out.println("Ky tu loi!");
                            break;
                    }

                default:
                    System.out.println("Ky tu loi!");
                    
                    break;
            }

        }while (choose != 6) ;
    }
}
