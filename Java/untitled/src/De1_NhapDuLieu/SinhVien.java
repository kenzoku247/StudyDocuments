package De1_NhapDuLieu;

public class SinhVien{
    public String MaSV;
    public String HoTen;
    public String NgaySinh;
    public String GioiTinh;
    public float DiemTB;

    //Hàm khởi tạo đối tượng
    public SinhVien(){}
    public SinhVien(String maSV, String hoTen, String ngaySinh, String gioiTinh, float diemTB)
    {
        MaSV = maSV;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        DiemTB = diemTB;
    }

    // Các hàm get để lấy giá trị thuộc tính của đối tượng
    public String getMaSV() {
        return MaSV;
    }
    public String getHoTen() {
        return HoTen;
    }
    public String getNgaySinh() {
        return NgaySinh;
    }
    public String getGioiTinh() {
        return GioiTinh;
    }
    public float getDiemTB() {
        return DiemTB;
    }

    // Các hàm set để thiết lập giá trị thuộc tính của đối tượng
    public void setMaSV(String maSV) {
        MaSV = maSV;
    }
    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }
    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }
    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }
    public void setDiemTB(float diemTB) {
        DiemTB = diemTB;
    }

    // Hàm hiển thị thông tin
    public void HienThiTT(){
        System.out.println("Ma SV: " + MaSV + ". Ten SV: " + HoTen + ". Ngay sinh: " + NgaySinh +
                ". Gioi tinh: " + GioiTinh + ". Diem TB: " + DiemTB);
    }
}