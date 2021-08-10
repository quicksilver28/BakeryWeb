package bakeryjava.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    
    private int oid, cid, status;
    private float total;
    private String createdate, shipdate;

    SimpleDateFormat sf;
    
    public Order(){
        oid = 0;
        cid = 0;
        status = 0;
        total = 0.0f;
        createdate = null;
        shipdate = null;
    }
    
    public Order(int oid, int cid, int status, float total, String createdate) {
        this.oid = oid;
        this.cid = cid;
        this.status = status;
        this.total = total;
        this.createdate = createdate;
        shipdate = null;
    }
    
    public Order(int oid, int cid, int status, float total) {
        this.oid = oid;
        this.cid = cid;
        this.status = status;
        this.total = total;
        createdate = null;
        shipdate = null;
    }
    
    public Order(int cid, int status, float total) {
        this.oid = 0;
        this.cid = cid;
        this.status = status;
        this.total = total;
        this.createdate = null;
        this.shipdate = null;
    }
    
    public Order(int cid, int status, float total, String createdate, String shipdate) {
        this.oid = 0;
        this.cid = cid;
        this.status = status;
        this.total = total;
        this.createdate = createdate;
        this.shipdate = shipdate;
    }
    
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getStrDate(Date date){
        sf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sf.format(date);
    }
    
    public String getStrDateSQL(Date date){
        sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(date);
    }
    
    public String getCreatedate() {
        return createdate;
    }

    public void setCreateDate(Date createDate){
        this.createdate = getStrDateSQL(createDate);
    }
    
    public String getShipdate() {
        return shipdate;
    }

    public void setShipDate(Date shipdate){
        this.shipdate = getStrDateSQL(shipdate);
    }
    
    @Override
    public String toString(){
        return oid+" "+createdate+""+shipdate+" "+status+" "+cid+" "+total+" ";
        //return this.getStrDateSQL(new Date());//+""+this.getShipdate();
    }
}
