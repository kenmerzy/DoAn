package ngoclong.example.phanmemthibanglai.ui.bienbao;

public class BienBao {

    private String maBB;
    private String tenBB;
    private String hinh;
    private String noiDung;
    private String loadBB;

    public BienBao(String maBB, String tenBB, String hinh, String noiDung, String loadBB) {
        this.maBB = maBB;
        this.tenBB = tenBB;
        this.hinh = hinh;
        this.noiDung = noiDung;
        this.loadBB = loadBB;
    }

    public String getMaBB() {
        return maBB;
    }

    public void setMaBB(String maBB) {
        this.maBB = maBB;
    }

    public String getTenBB() {
        return tenBB;
    }

    public void setTenBB(String tenBB) {
        this.tenBB = tenBB;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getLoadBB() {
        return loadBB;
    }

    public void setLoadBB(String loadBB) {
        this.loadBB = loadBB;
    }
}
