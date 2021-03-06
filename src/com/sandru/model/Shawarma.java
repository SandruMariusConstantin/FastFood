package com.sandru.model;

import com.sandru.contracts.FastFood;

public class Shawarma implements FastFood {
    private String name;
    private String meat;
    private double price;
    private double finalPrice;
    private String breadRollType;

    private String addition1Name;
    private double addition1Price;

    private String addition2Name;
    private double addition2Price;

    private String addition3Name;
    private double addition3Price;

    private String addition4Name;
    private double addition4Price;

    public Shawarma() {
        this.name = "Normal shawarma";
        this.meat = "Pork";
        this.price = 5.12;
        this.breadRollType = "Pita";
    }

    public Shawarma(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
    }

    public void addShawarmaAddition1(String name, double price) {
        this.addition1Name = name;
        this.addition1Price = price;
    }
    public void addShawarmaAddition2(String name, double price) {
        this.addition2Name = name;
        this.addition2Price = price;
    }
    public void addShawarmaAddition3(String name, double price) {
        this.addition3Name = name;
        this.addition3Price = price;
    }
    public void addShawarmaAddition4(String name, double price) {
        this.addition4Name = name;
        this.addition4Price = price;
    }


    public String getName() {
        return name;
    }

    public String getMeat() {
        return meat;
    }

    public double getPrice() {
        return price;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public double itemize() {
        double ShawarmaPrice = this.price;
        System.out.println(this.name + " shawarma " + " on a " + this.breadRollType
                + ", price is " + this.price);

        if(this.addition1Name != null) {
            ShawarmaPrice += this.addition1Price;
            System.out.println("Added " + this.addition1Name + " for an extra " + this.addition1Price);
        }

        if(this.addition2Name != null) {
            ShawarmaPrice += this.addition2Price;
            System.out.println("Added " + this.addition2Name + " for an extra " + this.addition2Price);
        }

        if(this.addition3Name != null) {
            ShawarmaPrice += this.addition3Price;
            System.out.println("Added " + this.addition3Name + " for an extra " + this.addition3Price);
        }

        if(this.addition4Name != null) {
            ShawarmaPrice += this.addition4Price;
            System.out.println("Added " + this.addition4Name + " for an extra " + this.addition4Price);
        }

        finalPrice = ShawarmaPrice;

        return ShawarmaPrice;
    }

    public void printProduct() {
        System.out.println(this.name + " on a " + this.breadRollType + " roll "
                + ", price is " + this.finalPrice + "\n");
    }

}
