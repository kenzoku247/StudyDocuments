package vu.hong.phuc.at16b.bai2;

import java.util.Locale;
import java.util.Scanner;

public class GiaoDichTienTe extends GiaoDich{
    private float TiGia;
    private String LoaiTien;
    Scanner sc = new Scanner(System.in);

    public GiaoDichTienTe(){
        super();
    }

    public GiaoDichTienTe(String LoaiTien, float TiGia){
        super();
        this.LoaiTien = LoaiTien;
        this.TiGia = TiGia;
    }

    public float getTiGia() {
        return TiGia;
    }

    public void setTiGia(float tiGia) {
        TiGia = tiGia;
    }

    public String getLoaiTien() {
        return LoaiTien;
    }

    public void setLoaiTien(String loaiTien) {
        LoaiTien = loaiTien;
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Nhap loai tien: ");
        this.LoaiTien = sc.nextLine();
        System.out.println("Nhap ti gia");
        this.TiGia = Integer.parseInt(sc.nextLine());

    }

    @Override
    public String display(){
        return super.display() + ", loai tien: " + this.LoaiTien + ", ti gia: "+ TiGia;
    }

    @Override
    public float ThanhTien(){
        switch (getLoaiTien().toUpperCase(Locale.ROOT)){
            case "VN":
            case "VIET NAM":
                return super.getDonGia()*super.getSoLuong();
            case "USD":
            case "EURO":
                return super.getDonGia()*super.getSoLuong()*this.getTiGia();
            default:
                System.out.println("Khong co loai tien nay!");
        }

        return 0;
    }

}
