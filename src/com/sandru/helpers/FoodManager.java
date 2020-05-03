package com.sandru.helpers;

import com.sandru.contracts.ManagerContract;
import com.sandru.model.Order;

import java.awt.print.Book;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FoodManager implements ManagerContract {
    private String filePath = "/home/sandru/Desktop/Study/JavaProjects/FastFood/src/com/sandru/ReportData.csv";

    private Scanner scanner = new Scanner(System.in);

    public List<Order> orders = new LinkedList<>();


    public void showMenu() {
        List<String> menu = Arrays.asList("1. Hamburger with pork on a white bread roll --- price 3.56$\n",
                "2. Healthy hamburger with beef on a brown rye bread roll --- price 5.67$\n",
                "3. Deluxe hamburger with pork & bacon on a white bread roll. You'll also get a drink and chips. --- price 6.23$ + 2.75$ + 3.13$ = 12.11$\n",
                "4. Shawarma with pork on pita --- price 5.12$\n",
                "5. Vegetarian shawarma without meat on pita --- price 4.75$\n",
                "6. Plate shawarma with pork & chicken on a plate. You'll also get a drink. --- price 8.15$ + 2.13$ = 10.28\n");

        System.out.println("Menu:\n" + menu);
    }

    public void takeOrder() {
        Order order = new Order();

        boolean validation = order.addOrder();

        if(validation) {
            order.getOrder();

            boolean notPayed = true;
            while(notPayed) {
                System.out.println("Introduce the sum to pay\n");

                boolean hasNextDouble = scanner.hasNextDouble();
                if (hasNextDouble) {
                    double sum = scanner.nextDouble();
                    scanner.nextLine();
                    if (sum < 0) {
                        //O sa incerc sa folosesc exceptions and errors handlers, dar o sa mai dureze putin
                        System.out.println("Invalid sum\n");
                    } else if (sum < order.getOrderPriceNumeric()) {
                        System.out.println("Sorry, but it's not enough");
                    } else {
                        order.setPayment(sum);
                        order.setBalance(sum - order.getOrderPriceNumeric());
                        notPayed = false;
                    }
                } else {
                    System.out.println("Invalid input");
                }
            }

            orders.add(order);
            System.out.println("Take the rest: " + order.getBalance());
        }

    }

    public void writeDataToReport(Order order){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true))){
            bufferedWriter.append(order.getOrderNumber());
            bufferedWriter.append(",");
            bufferedWriter.append(order.getOrderPrice());
            bufferedWriter.append(",");
            bufferedWriter.append(order.getPayment());
            bufferedWriter.append(",");
            bufferedWriter.append(order.getBalance());
            bufferedWriter.append("\n");
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void initReportHeader() {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            bufferedWriter.append("ORDER_NUMBER");
            bufferedWriter.append(",");
            bufferedWriter.append("ORDER_PRICE");
            bufferedWriter.append(",");
            bufferedWriter.append("PAYMENT");
            bufferedWriter.append(",");
            bufferedWriter.append("BALANCE");
            bufferedWriter.append("\n");
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readDataFromCsv() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String record;
            while((record = bufferedReader.readLine()) != null) {
                String [] recordData = record.split(",");
                System.out.println(recordData[0] + " " + recordData[1] + " " + recordData[2] + " " + recordData[3]);
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void showOrders() {
        readDataFromCsv();
    }

}
