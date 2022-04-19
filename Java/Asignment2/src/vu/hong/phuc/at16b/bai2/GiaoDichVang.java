package vu.hong.phuc.at16b.bai2;

import java.util.Scanner;

public class GiaoDichVang extends GiaoDich{
    private String LoaiVang;
    Scanner sc = new Scanner(System.in);

    public GiaoDichVang(){
        super();
    }

    public GiaoDichVang(String LoaiVang){
        super();
        this.LoaiVang = LoaiVang;
    }

    public String getLoaiVang() {
        return LoaiVang;
    }

    public void setLoaiVang(String loaiVang) {
        LoaiVang = loaiVang;
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Nhap loai vang: ");
        this.LoaiVang = sc.nextLine();
    }

    @Override
    public String display(){
        return super.display() + ", loai vang: " + this.LoaiVang;
    }

    @Override
    public float ThanhTien(){
        return super.getSoLuong()*super.getDonGia();
    }

}
