package ngoclong.example.phanmemthibanglai.ui.thisathach;

import java.sql.Blob;

public class CauHoi {
    private int maCauHoi;
    private String noiDung;
    private String hinhAnh;

    public CauHoi() {

    }

    public CauHoi(int maCauHoi, String noiDung, String hinhAnh) {
        this.maCauHoi = maCauHoi;
        this.noiDung = noiDung;
        this.hinhAnh = hinhAnh;
    }


    public int getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(int maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
