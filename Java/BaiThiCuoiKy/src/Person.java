public class Person {
    private String HoTen;
    private String NgaySinh;
    private String GioiTinh;
    private String DiaChi;

    public Person(){}

    public Person(String hoTen, String ngaySinh, String gioiTinh, String diaChi) {
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        DiaChi = diaChi;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public void HienThi(){
        System.out.println("Ho ten: " +HoTen + ". Ngay sinh: " + NgaySinh +
                ". Gioi tinh: " + GioiTinh + " . Dia chi: " + DiaChi);
    }
}
