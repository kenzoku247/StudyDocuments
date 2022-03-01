import java.util.ArrayList;

public class TaiKhoanNH {
    private ArrayList<ThongTinGD> ArrThongTinGDs = new ArrayList<>();
    private String SoTK;
    private int SoDu;

    public TaiKhoanNH(){};

    public TaiKhoanNH(String soTK, int soDu){
        SoTK = soTK;
        SoDu = soDu;
    }

    public String getSoTK() {
        return SoTK;
    }

    public void setSoTK(String soTK) {
        SoTK = soTK;
    }

    public int getSoDu() {
        return SoDu;
    }

    public void setSoDu(int soDu) {
        SoDu = soDu;
    }

    public void HienThiTK(){
        System.out.println("So TK: " + SoTK + ". So du: " + SoDu);
    }

    public void ThemGD(ThongTinGD thongTinGD){
        ArrThongTinGDs.add(thongTinGD);
    }

    public void HienThiGD() {
        for (ThongTinGD thongTinGD : ArrThongTinGDs) {
            thongTinGD.HienThiGD();
        }
    }
}
