package com.example.kiemtrafirebase_351;

public class CayThuoc {
    private String tenKH,tenTG,boPhanDung;

    public CayThuoc(String tenKH, String tenTG, String boPhanDung) {
        this.tenKH = tenKH;
        this.tenTG = tenTG;
        this.boPhanDung = boPhanDung;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public String getBoPhanDung() {
        return boPhanDung;
    }

    public void setBoPhanDung(String boPhanDung) {
        this.boPhanDung = boPhanDung;
    }
}
