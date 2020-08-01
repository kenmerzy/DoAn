package ngoclong.example.phanmemthibanglai.ui.thisathach;

public class DapAn {
    private int maDapAn;
    private String noiDung;
    private int dungSai;
    private int maCauHoi;
    private int viTriDung;

    public DapAn(int maDapAn, String noiDung, int dungSai, int maCauHoi, int viTriDung) {
        this.maDapAn = maDapAn;
        this.noiDung = noiDung;
        this.dungSai = dungSai;
        this.maCauHoi = maCauHoi;
        this.viTriDung = viTriDung;
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

    public int getViTriDung() {
        return viTriDung;
    }

    public void setViTriDung(int viTriDung) {
        this.viTriDung = viTriDung;
    }
}
