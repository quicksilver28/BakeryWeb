/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryjava.bean;

/**
 *
 * @author Sana
 */
public class Customer {
    
    private int cid;
    private String fname, lname, email, phone;

    public Customer(){
        
    }
    
    public Customer(int cid, String fname, String lname, String email, String phone) {
        this.cid = cid;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
    }
    
    public Customer(String fname, String lname, String email, String phone) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
    }
    
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
