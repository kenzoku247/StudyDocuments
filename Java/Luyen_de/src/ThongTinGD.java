import java.util.Scanner;

public class ThongTinGD {
    private String MaGD;
    private String NgayGD;
    private int SoTienGD;
    private char LoaiGD;

    public ThongTinGD(){}

    public ThongTinGD(String ngayGD, int soTienGD, char loaiGD){
        NgayGD = ngayGD;
        SoTienGD = soTienGD;
        LoaiGD = loaiGD;
    }

    public String getMaGD() {
        return MaGD;
    }

    public void setMaGD(String maGD) {
        MaGD = maGD;
    }

    public String getNgayGD() {
        return NgayGD;
    }

    public void setNgayGD(String ngayGD) {
        NgayGD = ngayGD;
    }

    public float getSoTienGD() {
        return SoTienGD;
    }

    public void setSoTienGD(int soTienGD) {
        SoTienGD = soTienGD;
    }

    public char getLoaiGD() {
        return LoaiGD;
    }

    public void setLoaiGD(char loaiGD) {
        LoaiGD = loaiGD;
    }


    public void HienThiGD() {
        System.out.println("Ma GD: " + MaGD + ". Ngay GD: "
                + NgayGD + ". So tien: " + SoTienGD + ". Loai GD: " + LoaiGD);
    }
}
