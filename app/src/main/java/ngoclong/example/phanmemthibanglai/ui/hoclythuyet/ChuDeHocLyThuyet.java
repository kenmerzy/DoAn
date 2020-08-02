package ngoclong.example.phanmemthibanglai.ui.hoclythuyet;

public class ChuDeHocLyThuyet {
    private int maChuDe;
    private String tenChuDe;
    private String hinhAnh;

    public ChuDeHocLyThuyet(int maChuDe, String tenChuDe, String hinhAnh) {
        this.maChuDe = maChuDe;
        this.tenChuDe = tenChuDe;
        this.hinhAnh = hinhAnh;
    }

    public int getMaChuDe() {
        return maChuDe;
    }

    public void setMaChuDe(int maChuDe) {
        this.maChuDe = maChuDe;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
