package com.sandru.model;

public class DeluxeHamburger extends Hamburger {
    public DeluxeHamburger() {
        super("Deluxe hamburger", "Pork & Bacon", 6.23, "White");
        super.addHamburgerAddition1("Chips", 2.75);
        super.addHamburgerAddition2("Drink", 3.13);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Cannot additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Cannot additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Cannot additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Cannot additional items to a deluxe burger");
    }
}
