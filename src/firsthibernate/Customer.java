/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firsthibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

  

/**
 *
 * @author BENJIRO
 */
    @Entity
    @Table(name= "public.customer")  
public class Customer {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "customer_id")    
    private String customerID;
    
    @Column(name = "title")   
    private String title;
    
    @Column(name = "fname")   
    private String fname;
    
    @Column(name = "lname")   
    private String lname;
    
    @Column(name = "addressline")   
    private String addressLine;
          
    @Column(name = "town")        
    private String town;
    
    @Column(name = "zipcode")   
    private String zipCode;
    
    @Column(name = "phone")   
    private String phone;

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    

    public Customer(String customerID, String title, String fname, String lname, String addressLine, String town, String zipCode, String phone) {
        
        this.customerID = customerID;
        this.title = title;
        this.fname = fname;
        this.lname = lname;
        this.addressLine = addressLine;
        this.town = town;
        this.zipCode = zipCode;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", customerID=" + customerID + ", title=" + title + ", fname=" + fname + ", lname=" + lname + ", addressLine=" + addressLine + ", town=" + town + ", zipCode=" + zipCode + ", phone=" + phone + '}';
    }
    
   
   
    

  
    
}
