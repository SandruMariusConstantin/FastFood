package com.sandru.model;

import com.sandru.model.Shawarma;

public class VegetarianShawarma extends Shawarma {
    private String healthyExtra1Name;
    private double healthyExtra1Price;

    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public VegetarianShawarma() {
        super("Vegetarian shawarma", "Without", 4.75, "Pita");
    }

    public void addHealthyAddition1(String name, double price) {
        this.healthyExtra1Name = name;
        this.healthyExtra1Price = price;
    }
    public void addHealthyAddition2(String name, double price) {
        this.healthyExtra2Name = name;
        this.healthyExtra2Price = price;
    }

    @Override
    public double itemize() {
        double shawarmaPrice = super.itemize();
        if(this.healthyExtra1Name != null) {
            shawarmaPrice += this.healthyExtra1Price;
            System.out.println("Added " + this.healthyExtra1Name + " for an extra " + this.healthyExtra1Price);
        }

        if(this.healthyExtra2Name != null) {
            shawarmaPrice += this.healthyExtra2Price;
            System.out.println("Added " + this.healthyExtra2Name + " for an extra " + this.healthyExtra2Price);
        }

        return shawarmaPrice;
    }
}
