package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

public class CartGetSet {
     private String pName, price, quantity;

    public CartGetSet() {
    }

    public CartGetSet(String pName, String price, String quantity) {
        this.pName = pName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
