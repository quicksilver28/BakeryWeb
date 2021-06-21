package bakeryjava.bean;

public class Address {
    private int aid, cid;
    private String line1, line2, zipcode;
    
    public Address(int aid, int cid, String line1, String line2, String zipcode) {
        this.aid = aid;
        this.cid = cid;
        this.line1 = line1;
        this.line2 = line2;
        this.zipcode = zipcode;
    }

    public Address(String line1, String line2, String zipcode, int cid) {
        this.aid = 0;
        this.cid = cid;
        this.line1 = line1;
        this.line2 = line2;
        this.zipcode = zipcode;
    }
    
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
