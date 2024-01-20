package com.google.ar.core.examples.java.requestRide;

public class Ride {

    private int time;
    private double rating;
    private String name;

    private double price;
    private int avatar;

    public Ride(String name, int time, double rating, double price, int avatar) {
        this.time = time;
        this.rating = rating;
        this.name = name;
        this.price = price;
        this.avatar = avatar;
    }

    public int getTime() {return time;}
    public double getRating() {
        return rating;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getAvatar() {
        return avatar;
    }

}
