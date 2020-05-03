package com.sandru.model;

import com.sandru.model.Shawarma;

public class PlateShawarma extends Shawarma {

    public PlateShawarma() {
        super("Plate shawarma", "Pork & Chicken", 8.15, "Plate");
        super.addShawarmaAddition1("Drink", 2.13);
    }

    @Override
    public void addShawarmaAddition1(String name, double price) {
        System.out.println("Cannot additional items to a deluxe burger");
    }

    @Override
    public void addShawarmaAddition2(String name, double price) {
        System.out.println("Cannot additional items to a deluxe burger");
    }

    @Override
    public void addShawarmaAddition3(String name, double price) {
        System.out.println("Cannot additional items to a deluxe burger");
    }

    @Override
    public void addShawarmaAddition4(String name, double price) {
        System.out.println("Cannot additional items to a deluxe burger");
    }
}
