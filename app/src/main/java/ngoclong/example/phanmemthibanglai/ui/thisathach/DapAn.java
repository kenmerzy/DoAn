package ngoclong.example.phanmemthibanglai.ui.thisathach;

public class DapAn {
    private int maDapAn;
    private String noiDung;
    private int dungSai;
    private int maCauHoi;


    public DapAn() {

    }

    public DapAn(int maDapAn, String noiDung, int dungSai, int maCauHoi) {
        this.maDapAn = maDapAn;
        this.noiDung = noiDung;
        this.dungSai = dungSai;
        this.maCauHoi = maCauHoi;
    }

    public int getMaDapAn() {
        return maDapAn;
    }

    public void setMaDapAn(int maDapAn) {
        this.maDapAn = maDapAn;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getDungSai() {
        return dungSai;
    }

    public void setDungSai(int dungSai) {
        this.dungSai = dungSai;
    }

    public int getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(int maCauHoi) {
        this.maCauHoi = maCauHoi;
    }
}
