package vu.hong.phuc.at16b.bai1;

import java.util.Scanner;

public class HSHocSinh extends Nguoi{
    private String Lop;
    private Nguoi Nguoi;
    Scanner sc = new Scanner(System.in);

    public HSHocSinh(String Lop, Nguoi Nguoi){
        super();
        this.Lop = Lop;
        this.Nguoi = Nguoi;
    }

    public HSHocSinh(){
        super();
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }

    public vu.hong.phuc.at16b.bai1.Nguoi getNguoi() {
        return Nguoi;
    }

    public void setNguoi(vu.hong.phuc.at16b.bai1.Nguoi nguoi) {
        Nguoi = nguoi;
    }

    public void inputHS(){
        Nguoi = new Nguoi();
        Nguoi.input();

        System.out.print("Nhap lop: ");
        Lop = sc.nextLine();
    }

    public void displayHS(){
        Nguoi.display();
        System.out.println("Lop: " + Lop);
    }
}
