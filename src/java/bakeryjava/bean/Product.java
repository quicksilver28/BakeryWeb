package bakeryjava.bean;

/**
 *
 * @author Sana
 */
public class Product {
    private String pname, descrp, img;
    private int category, type, pid;
    private float price;
    /*public Product(String pname, String descrp, String img, int category, int type, float price) {
        this.pname = pname;
        this.descrp = descrp;
        this.img = img;
        this.category = category;
        this.type = type;
        this.price = price;
    }*/   
    public int getPid() {
        return pid;
    }
    
    public String getPname() {
        return pname;
    }

    public String getDescrp() {
        return descrp;
    }

    public String getImg() {
        return img;
    }

    public int getCategory() {
        return category;
    }

    public int getType() {
        return type;
    }
    public float getPrice() {
        return price;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
