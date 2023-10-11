package com;

import com.Model.Beverage;
import com.Model.Food;
import com.Model.Item;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static List<Item> orderedMenu = new ArrayList<>();

    public static void main(String[] args) {
        mainMenu();
    }

     public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Item> map = mappingOrderMenu();
        boolean isYes = true;

        System.out.println(printLine("Welcome to Binarfud"));

        while (isYes) {
            clearConsole();
            int choice = getChoice();
            if(choice == 0) {
                System.out.println("Thank you :) ");
                return;
            }
            if (choice == 99) {
                if(orderedMenu.isEmpty()){
                    System.out.println("Belum ada item yang ditambahkan");
                    continue;
                } else {
                    confirmPayment();
                    return;
                }
            }
            printLine("How many you want to buy : ");
            Item selectedItem =  map.get(choice);

            System.out.printf("%s \t| %.3f" ,selectedItem.name(), selectedItem.price());
            System.out.println("\nInput 0 untuk kembali");

            Integer qty = getUserInput("qty => ");
            if (qty == 0) continue;
            addOrder(selectedItem, qty);
            isYes = isYes("Lanjut (y/n) => ", sc);
        }
        sc.close();

    }
    public static void addOrder(Item selectedItem, Integer qty) {
        boolean isSameItem = false;
        for (Item item : orderedMenu) {
            if (item.name().equals(selectedItem.name())) {
                item.count(item.count() + qty);
                isSameItem = true;
                break;
            }
        }
        if (!isSameItem) {
            selectedItem.count(qty);
            orderedMenu.add(selectedItem);
        }

    }
    public static Map<Integer,Item> mappingOrderMenu() {
        Map<Integer, Item> map = new HashMap<>();
        map.put(1, new Food("Nasi Goreng",    15.000));
        map.put(2, new Food("Mie Goreng",     15.000));
        map.put(3, new Food("Nasi + Ayam",    18.000));
        map.put(4, new Beverage("Es Teh Manis",3.000));
        map.put(5, new Beverage("Es Jeruk",    5.000));
        return map;
    }

    public static String printLine(String msg) {
        return String.format(
                        "==================================\n" +
                        "%s \n" +
                        "=================================="
        , msg);
    }
    public static int getUserInput(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);

        while (true) {
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Pilihan tidak tersedia");
                String errMsg = getErrorInputMsg("Mohon masukkan input\npilihan Anda");
                if (isYes(errMsg, sc)) {
                    System.out.print(msg);
                } else {
                    System.exit(0);
                }
            }
        }
    }

    public static int getChoice() {
        System.out.println("Silahkan pilih menu yang tersedia");
        Map<Integer, Item> items = mappingOrderMenu();
        for (Map.Entry<Integer, Item> itemMap : items.entrySet()){
            Item item = itemMap.getValue();
            System.out.println(
                    String.format("%d. %s\t \t| %.3f", itemMap.getKey(), item.name(), item.price())
            );
        }
        System.out.println("99. Pesan dan Bayar");
        System.out.println(" 0. Keluar");
        Integer[] validNumber = serializeValidChoices(items.keySet());
        int choice = getUserInput("=> ");
        while (!validChosenNumber(validNumber, choice)) {
            choice = getUserInput("\nPilihan Anda tidak tersedia :( ");
        }

        return choice;
    }
    public static Integer[] serializeValidChoices(Set<Integer> keys) {
        Integer[] itemKeyArray = keys.toArray(new Integer[0]);
        List<Integer> validNumberList = new ArrayList<>(Arrays.asList(itemKeyArray));
        validNumberList.addAll(Arrays.asList(0, 99));
        return  validNumberList.toArray(new Integer[0]);

    }

    public static boolean isYes(String msg, Scanner sc) {
        System.out.printf("%s", msg);
        String input = sc.next();
        while (!input.equalsIgnoreCase("y") &&
               !input.equalsIgnoreCase("n")) {
            System.out.println("Pilih y/n ");
            input = sc.next();
        }
        return input.equalsIgnoreCase("y");
    }

    public static void clearConsole(){
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                new ProcessBuilder("clear").inheritIO().start().waitFor();
                System.out.print("\033\004");
            }
        }catch (Exception e){
            System.err.println("Error" + e.getMessage());
        }
    }

    public static void confirmPayment() {
        String header = printLine("Confirm Your Payment");
        System.out.println(header);
        printDetailOrder();
        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");
        System.out.println();
        Integer[] validNumber = {0,1,2};
        int input = getUserInput("=> ");

        while (!validChosenNumber(validNumber, input)){
            System.out.println("Pilih menu yang tersedia");
            input = getUserInput("=> ");
        }

        if(input == 0) {
            System.out.println("Thank you :)");
            System.exit(0);
        }

        if (input == 1) printPaymentStruct();
        if (input == 2) mainMenu();



    }

    public static boolean validChosenNumber(Integer[] validNumber, int chosenNumber) {
        for (int num : validNumber) {
            if (num == chosenNumber ) return true;
        }
        return false;
    }

    public static void printPaymentStruct() {
        List<String> template = new ArrayList<>();
        String header         = printLine("BinarFud");
        String msg            = "Terima kasih sudah memesan\ndi BinarFud\n\n" +
                                "Di bawah ini adalah pesanan Anda";
        String desc           = "Pembayaran: BinarCash";
        String footer         = printLine("Simpan struk ini sebagai\n\tbukti pembayaran");

        System.out.println(header);
        System.out.println(msg);
        String detailOrderStr = printDetailOrder();
        System.out.println(desc);
        System.out.println(footer);

        template.add(header);
        template.add(msg);
        template.add(detailOrderStr);
        template.add(desc);
        template.add(footer);
        saveStruct(template);

    }

    public static String printDetailOrder() {
        StringBuilder sb    = new StringBuilder();
        int total           = 0;
        double totalPrice   = 0.00;

        System.out.println();
        for (Item orderedItem: orderedMenu) {
            String name     = orderedItem.name();
            double price    = orderedItem.price();
            int count       = orderedItem.count();
            total           += count;
            totalPrice      += (count * price);
            String pesanan  = String.format("%s  \t %d \t %.3f", name, count, price);
            sb.append(pesanan + "\n");
            System.out.print(pesanan + "\n");
        }

        String linePlus = "--------------------------------- +";
        String totalStr = String.format("Total %12d \t %.3f", total, totalPrice);
        System.out.println(linePlus+"\n");
        System.out.println(totalStr+ "\n");
        sb.append(linePlus).append("\n");
        sb.append(totalStr);
        return sb.toString();
    }

    public static void saveStruct(List<String> desc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("struck.txt"))){
            for (String line : desc) {
                writer.write(line);
                writer.newLine();
            }
        }catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    public static String getErrorInputMsg(String msg) {
        String footer = "\n" + "(Y) untuk lanjut" + "\n" +
                        "(n) untuk keluar" + "\n";
        return printLine(msg) + footer;
    }
}