package com.sandru.model;

import com.sandru.contracts.FastFood;
import com.sandru.contracts.OrderContract;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order implements OrderContract {
    static Scanner scanner = new Scanner(System.in);
    static int numberOfOrders;

    private int orderNumber;
    private double orderPrice;
    private double payment;
    private double balance;

    private List<FastFood> products = new ArrayList<>();

    public void addProducts() {

        System.out.println("\n");
        System.out.println("Choose one of the products below, or 'Go bak' if you don't want to choose:");

        System.out.println("1 - Simple hamburger\n" +
                "2 - Healthy hamburger\n" +
                "3 - Deluxe hamburger\n" +
                "4 - Normal shawarma\n" +
                "5 - Vegetarian shawarma\n" +
                "6 - Plate shawarma\n" +
                "7 - Go back\n");

        boolean ok = true;

        while(ok) {
            String option = scanner.next();
            switch (option) {
                case "1":
                    FastFood hamburger = new Hamburger();
                    orderPrice += hamburger.itemize();
                    products.add(hamburger);
                    System.out.println("Product added\n");
                    break;
                case "2":
                    FastFood hburger = new HealthyBurger();
                    orderPrice += hburger.itemize();
                    products.add(hburger);
                    System.out.println("Product added\n");
                    break;
                case "3":
                    FastFood dburger = new DeluxeHamburger();
                    orderPrice += dburger.itemize();
                    products.add(dburger);
                    System.out.println("Product added\n");
                    break;
                case "4":
                    FastFood sh = new Shawarma();
                    orderPrice += sh.itemize();
                    products.add(sh);
                    System.out.println("Product added\n");
                    break;
                case "5":
                    FastFood vegSh = new VegetarianShawarma();
                    orderPrice += vegSh.itemize();
                    products.add(vegSh);
                    System.out.println("Product added\n");
                    break;
                case "6":
                    FastFood plateSh = new PlateShawarma();
                    orderPrice += plateSh.itemize();
                    products.add(plateSh);
                    System.out.println("Product added\n");
                    break;
                case "7":
                    break;
                default:
                    System.out.println("\n");
                    System.out.println("You chose wrong. Choose one of the options above!");
            }

            String k;
            System.out.println("If you want to continue adding products, press 1, anything else to go back\n");
            k = scanner.next();
            if(!k.equals("1")) {
                ok = false;
            } else {
                System.out.println("1 - Simple hamburger\n" +
                        "2 - Healthy hamburger\n" +
                        "3 - Deluxe hamburger\n" +
                        "4 - Normal shawarma\n" +
                        "5 - Vegetarian shawarma\n" +
                        "6 - Plate shawarma\n" +
                        "7 - Go back\n");
            }
        }

    }

    public void deleteProduct() {
        if(products.size() == 0) {
            System.out.println("You don't have any product\n");
            return;
        }

        System.out.println("What is th product you don't want anymore?\n");

        seeExistingProducts();

        boolean hasNextInt = scanner.hasNextInt();

        if(hasNextInt) {
            int option = scanner.nextInt();
            scanner.nextLine();
            if(option > 0 && option <= products.size()) {
                products.remove(option-1);
                System.out.println("Successful removal of the product\n");
            }
        } else {
            System.out.println("Write the number of your choice next time\n");
        }

    }

    public void seeExistingProducts() {
        int index = 1;

        System.out.println("\n");
        for (FastFood product: products) {
            System.out.println(index + " - " + product.getName() + " on a " + product.getBreadRollType() + ", at the price of " + product.getFinalPrice());
            index += 1;
        }

        System.out.println("\nPrice --- " + orderPrice);

        System.out.println("\n");
    }

    public boolean addOrder() {
        while(true) {
                System.out.println("Press:\n"
                        + "1 - If you want to place the order\n"
                        + "2 - If you want to add a product\n"
                        + "3 - If you want to delete one of the products\n"
                        + "4 - See the existing products\n"
                        + "5 - Cancel order\n");

                String option = scanner.next();
                switch (option) {
                    case "1":
                        if (products.size() != 0) {
                            numberOfOrders += 1;
                            orderNumber = numberOfOrders;
                            return true;
                        } else {
                            System.out.println("You don't have any product\n");
                        }
                        break;
                    case "2":
                        addProducts();
                        break;
                    case "3":
                        if (products.size() != 0) {
                            deleteProduct();
                        } else {
                            System.out.println("You don't have any product\n");
                        }
                        break;
                    case "4":
                        if (products.size() != 0) {
                            seeExistingProducts();
                        } else {
                            System.out.println("You don't have any product\n");
                        }
                        break;
                    case "5":
                        return false;
                    default:
                        System.out.println("Not a valid option\n");
                }
        }
    }

    public void getOrder() {
        System.out.println("Order number " + orderNumber + " with the following products: ");

        seeExistingProducts();
    };

    public String getPayment() {
        return Double.toString(payment);
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getBalance() {
        return Double.toString(balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOrderNumber() {
        return Integer.toString(orderNumber);
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderPrice() {
        return Double.toString(orderPrice);
    }

    public double getOrderPriceNumeric() {
        return orderPrice;
    }
}
