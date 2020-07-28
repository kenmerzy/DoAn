package ngoclong.example.phanmemthibanglai.ui.tracuuluat;

public class Luat {
    private String noiDung;
    private String mucPhat;
    private String hinh;

    public Luat(String noiDung, String mucPhat, String hinh) {
        this.noiDung = noiDung;
        this.mucPhat = mucPhat;
        this.hinh = hinh;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getMucPhat() {
        return mucPhat;
    }

    public void setMucPhat(String mucPhat) {
        this.mucPhat = mucPhat;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
