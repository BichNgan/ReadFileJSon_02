package vlu.android.readfilejson_02;

public class NV {
    String msnv, idAnh, hten, ngaySinh, cvu;

    public NV(String msnv, String idAnh, String hten, String ngaySinh, String cvu) {
        this.msnv = msnv;
        this.idAnh = idAnh;
        this.hten = hten;
        this.ngaySinh = ngaySinh;
        this.cvu = cvu;
    }

    public NV() {
    }

    public String getMsnv() {
        return msnv;
    }

    public void setMsnv(String msnv) {
        this.msnv = msnv;
    }

    public String getIdAnh() {
        return idAnh;
    }

    public void setIdAnh(String idAnh) {
        this.idAnh = idAnh;
    }

    public String getHten() {
        return hten;
    }

    public void setHten(String hten) {
        this.hten = hten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCvu() {
        return cvu;
    }

    public void setCvu(String cvu) {
        this.cvu = cvu;
    }
}
