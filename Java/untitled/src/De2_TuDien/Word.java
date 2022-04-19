package De2_TuDien;

public class Word {
    public int ID;
    public String EN;
    public String VN;

    public Word(int ID, String EN, String VN){
        this.ID = ID;
        this.EN = EN;
        this.VN = VN;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEN() {
        return EN;
    }
    public void setEN(String EN) {
        this.EN = EN;
    }

    public String getVN() {
        return VN;
    }
    public void setVN(String VN) {
        this.VN = VN;
    }

    public void HienThi(){
        System.out.println("ID: " + ID + ". EN: " + EN + ". VN: " + VN);
    }
}
