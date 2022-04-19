package Bai_4;

import java.util.Locale;
import java.util.Scanner;

public class GiaoDichDat extends GiaoDich{
    private  String LoaiDat;
    Scanner sc = new Scanner(System.in);


    public GiaoDichDat(){
        super();
    }

    public GiaoDichDat(String LoaiDat){
        super();
        this.LoaiDat = LoaiDat;
    }

    public String getLoaiDat() {
        return LoaiDat;
    }

    public void setLoaiDat(String loaiDat) {
        this.LoaiDat = loaiDat;
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Nhap loai dat (A/B/C): ");
        this.LoaiDat = sc.nextLine();
    }

    @Override
    public String display(){
        return super.display() + ", loai dat: " + this.LoaiDat;
    }

    @Override
    public float TinhTien(){
        switch (getLoaiDat().toUpperCase(Locale.ROOT)){
            case "A":
                return super.getDienTich()*super.getDonGia()*1.5f;
            case "B":
            case "C":
                return super.getDienTich()*super.getDonGia();
            default:
                System.out.println("Ky tu khong hop le!");
        }

        return 0;
    }

}
