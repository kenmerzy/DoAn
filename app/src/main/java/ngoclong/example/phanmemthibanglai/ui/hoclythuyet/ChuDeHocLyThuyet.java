package ngoclong.example.phanmemthibanglai.ui.hoclythuyet;

public class ChuDeHocLyThuyet {
    private int maChuDe;
    private String TenChuDe;

    public ChuDeHocLyThuyet(int maChuDe, String tenChuDe) {
        this.maChuDe = maChuDe;
        TenChuDe = tenChuDe;
    }

    public int getMaChuDe() {
        return maChuDe;
    }

    public void setMaChuDe(int maChuDe) {
        this.maChuDe = maChuDe;
    }

    public String getTenChuDe() {
        return TenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        TenChuDe = tenChuDe;
    }
}
