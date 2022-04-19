public class Student extends Person{
    private String MaSV;
    private String Email;
    private float DiemTK;

    public Student(){}

    public Student(String hoTen, String ngaySinh, String gioiTinh, String diaChi) {
        super(hoTen, ngaySinh, gioiTinh, diaChi);
    }

    public Student(String hoTen, String ngaySinh, String gioiTinh, String diaChi, String maSV, String email, float diemTK) {
        super(hoTen, ngaySinh, gioiTinh, diaChi);
        MaSV = maSV;
        Email = email;
        DiemTK = diemTK;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String maSV) {
        MaSV = maSV;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public float getDiemTK() {
        return DiemTK;
    }

    public void setDiemTK(float diemTK) {
        DiemTK = diemTK;
    }

    public void HienThi(){
        super.HienThi();
        System.out.println("Ma SV: "+ MaSV + " . Email: " + Email + ". Diem TK: "  +DiemTK);
    }
}
