package ngoclong.example.phanmemthibanglai.ui.caccauhaysai;

public class CacCauHaySai {
    private int maCauHoi;
    private String giaiThich;
    private String hinhAnh;
    public CacCauHaySai(int maCauHoi, String giaiThich, String hinhAnh) {
        this.maCauHoi = maCauHoi;
        this.giaiThich = giaiThich;
        this.hinhAnh = hinhAnh;
    }

    public int getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(int maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public String getGiaiThich() {
        return giaiThich;
    }

    public void setGiaiThich(String giaiThich) {
        this.giaiThich = giaiThich;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
