package vu.hong.phuc.at16b.bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<HSHocSinh> arrHS = new ArrayList<>();
        int n;
        int namSinh;
        String queQuan;
        int soLuong = 0;
        HSHocSinh hsHocSinh;
        Scanner sc = new Scanner(System.in);

        int choose;
        do {
            System.out.println("\n1.Nhap them danh sach hoc sinh.");
            System.out.println("2.Hien thi hoc sinh theo nam sinh.");
            System.out.println("3.Dem so luong hoc sinh theo nam sinh va que quan");
            System.out.println("4.Thoat");

            System.out.print("Nhap lua chon tu 1 den 4: ");
            choose = sc.nextInt();
            switch (choose){
                case 1:
                    System.out.print("Nhap so sinh vien muon them: ");
                    n = sc.nextInt();

                    for (int i = 1; i <=  n; i++) {
                        System.out.println("Nhap thong tin hoc sinh thu " + i + ": ");
                        hsHocSinh = new HSHocSinh();
                        hsHocSinh.input();
                        arrHS.add(hsHocSinh);
                    }
                    break;
                case 2:
                    System.out.print("Nhap nam sinh muon cua hoc sinh muon hien thi: ");
                    namSinh = sc.nextInt();
                    for (int i = 0; i < arrHS.size(); i ++){
                        if (arrHS.get(i).getNamSinh() == namSinh){
                            System.out.println(arrHS.get(i).display());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhap nam sinh cua hoc sinh muon dem: ");
                    namSinh = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap que quan cua hoc sinh muon dem: ");
                    queQuan = sc.nextLine();
                    for (int i = 0; i < arrHS.size(); i ++){
                        if (arrHS.get(i).getNamSinh() == namSinh && arrHS.get(i).getQueQuan().equalsIgnoreCase(queQuan)){
                            soLuong += 1;
                        }
                    }

                    System.out.println("Co " + soLuong + " hoc sinh sinh nam " + namSinh + " que tai "+ queQuan);
                    break;
                default:
                    System.out.println("Loi ky tu khong hop le!");
                    break;
            }
        } while (choose != 4);



    }


}
