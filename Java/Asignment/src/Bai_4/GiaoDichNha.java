package Bai_4;

import java.util.Locale;

public class GiaoDichNha extends GiaoDich{
    private String LoaiNha, DiaChi;
    private char LuaChon;

    public GiaoDichNha(){
        super();
    }

    public GiaoDichNha(String LoaiNha, String DiaChi){
        super();
        this.LoaiNha = LoaiNha;
        this.DiaChi = DiaChi;
    }

    public String getLoaiNha() {
        return LoaiNha;
    }

    public void setLoaiNha(String loaiNha) {
        this.LoaiNha = loaiNha;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        this.DiaChi = diaChi;
    }

    @Override
    public void input(){
        super.input();
        System.out.println("Nhap dia chi: ");
        DiaChi = sc.nextLine();
        System.out.println("Nhap loai nha (cao cap : c/thuong: t)");
        LuaChon = sc.next().charAt(0);
        switch (LuaChon){
            case 'c':
                LoaiNha = "cao cap";
                break;
            case 't':
                LoaiNha = "thuong";
            default:
                System.out.println("Ky tu khong hop le!");
                break;
        }
    }

    @Override
    public String display(){
        return super.display() + ", loai nha: " + this.LoaiNha + ", dia chi: " + this.DiaChi;
    }

    @Override
    public float TinhTien(){
        switch (getLoaiNha().toUpperCase(Locale.ROOT)){
            case "C":
                return super.getDienTich()*super.getDonGia();
            case "T":
                return super.getDienTich()*super.getDonGia()*0.9f;
            default:
                System.out.println("Ky tu khong hop le!");
        }

        return 0;
    }
}
