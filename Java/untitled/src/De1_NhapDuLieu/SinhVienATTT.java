package De1_NhapDuLieu;

public class SinhVienATTT extends SinhVien{
    public int HocPhi;

    public SinhVienATTT(){}
    public SinhVienATTT(String maSV, String hoTen, String ngaySinh,
                    String gioiTinh, float diemTB, int hocPhi){
        super(maSV,hoTen,ngaySinh,gioiTinh,diemTB);
        HocPhi = hocPhi;
    }

    public int getHocPhi() {
        return HocPhi;
    }

    public void setHocPhi(int hocPhi) {
        HocPhi = hocPhi;
    }

    public void HienTHiTT(){
        super.HienThiTT();
        System.out.println("Hoc phi: " + HocPhi);
    }
}
