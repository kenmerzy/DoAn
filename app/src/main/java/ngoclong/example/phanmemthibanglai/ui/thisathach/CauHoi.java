package ngoclong.example.phanmemthibanglai.ui.thisathach;

import java.sql.Blob;

public class CauHoi {
    private int maCauHoi;
    private String noiDung;
    private String hinhAnh;
    private String nhomCauHoi;
    private String giaiThich;

    public CauHoi(int maCauHoi, String noiDung, String giaiThich, String nhomCauHoi, String hinhAnh) {
        this.maCauHoi = maCauHoi;
        this.noiDung = noiDung;
        this.hinhAnh = hinhAnh;
        this.nhomCauHoi = nhomCauHoi;
        this.giaiThich = giaiThich;
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

    public String getNhomCauHoi() {
        return nhomCauHoi;
    }

    public void setNhomCauHoi(String nhomCauHoi) {
        this.nhomCauHoi = nhomCauHoi;
    }

    public String getGiaiThich() {
        return giaiThich;
    }

    public void setGiaiThich(String giaiThich) {
        this.giaiThich = giaiThich;
    }
}
