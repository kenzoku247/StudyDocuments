package De1_NhapDuLieu;

public class SinhVienMatMa extends SinhVien{
    public String DonVi;
    public int Luong;

    public SinhVienMatMa(){}
    public SinhVienMatMa(String maSV, String hoTen, String ngaySinh,
                        String gioiTinh, float diemTB, String donVi, int luong){
        super(maSV,hoTen,ngaySinh,gioiTinh,diemTB);
        DonVi = donVi;
        Luong = luong;
    }

    public String getDonVi() {
        return DonVi;
    }

    public void setDonVi(String donVi) {
        DonVi = donVi;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int luong) {
        Luong = luong;
    }

    public void HienTHiTT(){
        super.HienThiTT();
        System.out.println("Don vi: " + DonVi + " . Luong: " + Luong);
    }
}
