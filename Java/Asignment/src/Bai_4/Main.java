package Bai_4;

import java.util.ArrayList;
import java.util.Scanner;
import Bai_4.Input.*;

public class Main {


    public static void main(String[] args) {
        ArrayList<GiaoDichNha> arrGiaoDichNha = new ArrayList<>();
        ArrayList<GiaoDichDat> arrGiaoDichDat = new ArrayList<>();
        int SoGiaoDichNha = 0;
        int SoGiaoDichDat = 0;
        float TongTienGiaoDichDat = 0; float TongTienGiaoDichNha = 0;
        float TrungBinhThanhTienGDD;
        float TrungBinhThanhTienGDN;
        String nam;
        String thang;

        Scanner sc = new Scanner(System.in);


        int choose;
        do {
            System.out.println("1.Nhap them thong tin giao dich dat");
            System.out.println("2.Nhap them thong tin giao dich nha");
            System.out.println("3.Tinh so luong giao dich");
            System.out.println("4.Tinh trung binh thanh tien giao dich");
            System.out.println("5.Xuat thong tin giao dich theo thang/nam");
            System.out.println("6.Thoat");

            System.out.print("Nhap lua chon tu 1 den 6: ");
            choose = sc.nextInt();

            Input input = new Input();
            input.input("int");


            switch (choose){
                case 1:
                    System.out.print("Nhap them so giao dich dat: ");
                    SoGiaoDichDat = sc.nextInt();

                    System.out.println("Nhap thong tin giao dich dat: ");
                    for (int i = 0; i < SoGiaoDichDat; i++){
                        System.out.println("Nhap thong tin giao dich dat STT: " + (i+1));
                        GiaoDichDat giaoDichDat = new GiaoDichDat();
                        giaoDichDat.input();
                        arrGiaoDichDat.add(giaoDichDat);
                    }
                    System.out.println("\n\n");
                    break;
                case 2:
                    System.out.println("Nhap them so giao dich nha: ");
                    SoGiaoDichNha = sc.nextInt();
                    System.out.println("Nhap thong tin giao dich nha:");
                    for (int i = 0; i < SoGiaoDichNha; i++) {
                        System.out.println("Nhap thong tin giao dich nha STT: " + (i + 1));
                        GiaoDichNha giaoDichNha = new GiaoDichNha();
                        giaoDichNha.input();
                        arrGiaoDichNha.add(giaoDichNha);
                    }
                    System.out.println("\n\n");
                    break;
                case 3:
                    System.out.println("Ban muon tinh so luong giao dich nao (nha:1/dat:2)");
                    int luachon3;
                    luachon3 = sc.nextInt();
                    switch (luachon3){
                        case 1:
                            System.out.println("So luong giao dich nha la: " + arrGiaoDichNha.size());
                        case 2:
                            System.out.println("So luong giao dich dat la: " + arrGiaoDichDat.size());
                        default:
                            System.out.println("Loi ky tu khong hop le!");
                            break;
                    }
                    System.out.println("\n\n");
                    break;
                case 4:
                    System.out.println("Ban muon tinh trung binh thanh tien giao dich nao (nha:1/dat:2)");
                    int luachon4;
                    luachon4 = sc.nextInt();
                    switch (luachon4) {
                        case 2:
                            for (int i = 0; i < arrGiaoDichDat.size(); i++) {
                                if (arrGiaoDichDat.get(i).getLoaiDat().equalsIgnoreCase("A")) {
                                    TongTienGiaoDichDat += arrGiaoDichDat.get(i).TinhTien();
                                } else if (arrGiaoDichDat.get(i).getLoaiDat().equalsIgnoreCase("B") ||
                                        arrGiaoDichDat.get(i).getLoaiDat().equalsIgnoreCase("C")) {
                                    TongTienGiaoDichDat += arrGiaoDichDat.get(i).TinhTien();
                                }
                            }
                            TrungBinhThanhTienGDD = TongTienGiaoDichDat / (arrGiaoDichDat.size());
                            System.out.println("Trung bình thành tiền của giao dịch đất = " + TrungBinhThanhTienGDD);

                            break;
                        case 1:
                            for (int i = 0; i < arrGiaoDichNha.size(); i++) {
                                if (arrGiaoDichNha.get(i).getLoaiNha().equalsIgnoreCase("C")) {
                                    TongTienGiaoDichNha += arrGiaoDichNha.get(i).TinhTien();
                                } else if (arrGiaoDichNha.get(i).getLoaiNha().equalsIgnoreCase("T")){
                                    TongTienGiaoDichNha += arrGiaoDichNha.get(i).TinhTien();
                                }
                            }
                            TrungBinhThanhTienGDN = TongTienGiaoDichNha / (arrGiaoDichNha.size());
                            System.out.println("Trung bình thành tiền của giao dịch nhà = " + TrungBinhThanhTienGDN);
                            System.out.println("\n\n");
                            break;
                        default:
                            System.out.println("Loi!");
                            break;
                    }
                    System.out.println("\n\n");
                    break;
                case 5:
                    System.out.print("Ban muon xuat thong tin giao dich nao (nha:1/dat:2): ");
                    int luachon5;
                    luachon5 = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap nam: ");
                    nam = sc.nextLine();
                    System.out.print("Nhap thang: ");
                    thang = sc.nextLine();
                    switch (luachon5){
                        case 2:
                            if (arrGiaoDichDat.size() == 0){
                                System.out.println("Khong co thong tin giao dich nao hien co trong thang "+ thang + ", nam " + nam);
                            } else {
                                System.out.println("Các giao dịch đất của tháng "+ thang + ", nam " + nam);
                                for (int i = 0; i < arrGiaoDichDat.size(); i++) {
                                    String[] dateGiaoDichDat = arrGiaoDichDat.get(i).getNgayGiaoDich().split("/");
                                    if (dateGiaoDichDat[1].equals(thang) && dateGiaoDichDat[2].equals(nam)) {
                                        System.out.println(arrGiaoDichDat.get(i).display());

                                    }
                                }
                            }
                            break;
                        case 1:
                            System.out.println("Các giao dịch nhà của tháng 9 năm 2013: ");
                            for (int i = 0; i < arrGiaoDichNha.size(); i++) {
                                String[] dateGiaoDichNha = arrGiaoDichNha.get(i).getNgayGiaoDich().split("/");
                                if (dateGiaoDichNha[1].equals(thang) && dateGiaoDichNha[2].equals(nam)) {
                                    System.out.println(arrGiaoDichNha.get(i).display());
                                }
                            }
                            System.out.println("\n\n");
                            break;
                        default:
                            System.out.println("Loi ky tu khong hop le!");
                            break;
                    }
                    System.out.println("\n\n");
                    break;
                default:
                    System.out.println("Loi ky tu khong hop le!");
                    break;
            }
        } while (choose != 6);






    }
}
