/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package real.estate;

/**
 *
 * @author LENOVO
 */
public class Property {
    public double address;//post code
    public double price;
    public double landsize;

    public void setAddress(double address) {
        this.address = address;
    }
    

    public double getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public double getLandsize() {
        return landsize;
    }

   
    public void setPrice(double price) {
        this.price = price;
    }

    public void setLandsize(double landsize) {
        this.landsize = landsize;
    }
  
    
}
