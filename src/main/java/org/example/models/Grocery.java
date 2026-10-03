package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("0: Çıkış, 1: Eleman ekle, 2: Eleman çıkar");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "0":
                    running = false;
                    System.out.println("Uygulama durduruldu.");
                    break;
                case "1":
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    addItems(scanner.nextLine());
                    printSorted();
                    break;
                case "2":
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    removeItems(scanner.nextLine());
                    printSorted();
                    break;
                default:
                    System.out.println("Lütfen 0, 1 veya 2 giriniz.");
            }
        }
    }

    public static void addItems(String input) {
        if (input == null) return;
        for (String item : input.split(",")) {
            String product = item.trim();
            if (!product.isEmpty() && !checkItemIsInList(product)) {
                groceryList.add(product);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        if (input == null) return;
        for (String item : input.split(",")) {
            String product = item.trim();
            if (checkItemIsInList(product)) {
                groceryList.remove(product);
            }
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
}
