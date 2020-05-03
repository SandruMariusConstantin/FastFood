package com.sandru;

import com.sandru.helpers.FoodManager;
import com.sandru.model.Order;

import java.awt.print.Book;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FoodManager foodGuy = new FoodManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("Hello! Select one of following options:");

        System.out.println("1 - Food menu\n" +
                           "2 - Order\n" +
                           "3 - Generate report by ascending price\n" +
                           "4 - Generate report by descending price\n" +
                           "5 - Generate normal report\n" +
                           "6 - Displays the report in the console\n" +
                           "7 - Exit\n");


        while (true) {
            String option = scanner.next();
            switch (option) {
                case "1":
                    foodGuy.showMenu();
                    break;
                case "2":
                    foodGuy.takeOrder();
                    break;
                case "3":
                    Collections.sort(foodGuy.orders, Comparator.comparing(Order::getOrderPrice));
                    foodGuy.initReportHeader();
                    foodGuy.orders.forEach(order -> foodGuy.writeDataToReport(order));
                    System.out.println("Report was generated with success!!!");
                    break;
                case "4":
                    Collections.sort(foodGuy.orders, Comparator.comparing(Order::getOrderPrice).reversed());
                    foodGuy.initReportHeader();
                    foodGuy.orders.forEach(order -> foodGuy.writeDataToReport(order));
                    System.out.println("Report was generated with success!!!");
                    break;
                case "5":
                    foodGuy.initReportHeader();
                    foodGuy.orders.forEach(order -> foodGuy.writeDataToReport(order));
                    System.out.println("Report was generated with success!!!");
                    break;
                case "6":
                    foodGuy.showOrders();
                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n");
                    System.out.println("You chose wrong. Choose one of the options above!");
            }

            System.out.println("\n");
            System.out.println("1 - Food menu\n" +
                    "2 - Order\n" +
                    "3 - Generate report by ascending price\n" +
                    "4 - Generate report by descending price\n" +
                    "5 - Generate normal report\n" +
                    "6 - Displays the report in the console\n" +
                    "7 - Exit\n");
        }

    }
}
