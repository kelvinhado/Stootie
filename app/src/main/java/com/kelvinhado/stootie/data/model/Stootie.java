package com.kelvinhado.stootie.data.model;

/**
 * Created by kelvin on 12/10/2017.
 */

public class Stootie {

    private String id; //id

    private String title; // title

    private String userFirstName; //user->firstname

    private String userLastName;    //user->lastname

    private double price; //unit_price

    private String address; //address

    private String creationDate; // created_at

    public Stootie() {
    }

    public Stootie(String id, String title, String userFirstName, String userLastName, double price, String address, String creationDate) {
        this.id = id;
        this.title = title;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.price = price;
        this.address = address;
        this.creationDate = creationDate;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stootie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}

