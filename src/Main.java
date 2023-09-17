import Model.Beverage;
import Model.Food;
import Model.Item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    private static List<Item> orderedMenu = new ArrayList<>();

    public static void main(String[] args) {
        mainMenu();
    }

     static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Item> map = mappingOrderMenu();
        boolean isYes = true;

        System.out.println(printLine("Welcome to Binarfud"));

        while (isYes) {
            clearConsole();
            int choice = getChoice(sc);
            if(choice == 0) {
                System.out.println("Thank you :) ");
                return;
            }
            if (choice == 99) {
                if(orderedMenu.isEmpty()){
                    System.out.println("Belum ada item yang ditambahkan");
                    continue;
                } else {
                    confirmPayment(sc);
                    return;
                }
            }
            printLine("How many you want to buy : ");
            Item item =  map.get(choice);
            System.out.printf("%s \t| %.3f" ,item.name(), item.price());
            System.out.println("\ninput 0 untuk kembali");
            Integer qty = getUserInput("qty => ", sc);
            if (qty == 0) continue;
            item.count(qty);
            orderedMenu.add(item);
            isYes = isYes("Lanjut (y/n) => ", sc);
        }
        sc.close();

    }
    static Map<Integer,Item> mappingOrderMenu() {
        Map<Integer, Item> map = new HashMap<>();

        map.put(1, new Food("Nasi Goreng",    15.000));
        map.put(2, new Food("Mie Goreng",     15.000));
        map.put(3, new Food("Nasi + Ayam",    18.000));
        map.put(4, new Beverage("Es Teh Manis",3.000));
        map.put(5, new Beverage("Es Jeruk",    5.000));
        return map;
    }

    static String printLine(String msg) {
        return String.format(
                        "==================================\n" +
                        "\t%8s \n" +
                        "=================================="
        , msg);
    }
    static int getUserInput(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextInt();
    }
    static int getChoice(Scanner sc) {
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
        int choice;
        System.out.print("=> ");
        while (true) {
            if(sc.hasNextInt()){
                choice = sc.nextInt();
                break;
            }else{
                System.out.printf("Masukkan pilihan yang valid (%s)! : ", Arrays.toString(validNumber));
                sc.next();
            }
        }

        while (!validChosenNumber(validNumber, choice)) {
            System.out.print("Masukkan pilihan yang tersedia : ");
            choice = sc.nextInt();
        }

        return choice;
    }
    static Integer[] serializeValidChoices(Set<Integer> keys) {
        Integer[] itemKeyArray = keys.toArray(new Integer[keys.size()]);
        List<Integer> validNumberList = new ArrayList<>(Arrays.asList(itemKeyArray));
        validNumberList.addAll(Arrays.asList(0, 99));
        return  validNumberList.toArray(new Integer[validNumberList.size()]);

    }

    public static boolean isYes(String msg, Scanner sc) {
        System.out.printf("%s", msg);
        String input = sc.next();
        while (!input.equalsIgnoreCase("y") &&
               !input.equalsIgnoreCase("n")) {
            input = sc.next();
        }
        return input.equalsIgnoreCase("y");
    }

    static void clearConsole(){
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder().command("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                System.out.print("\033\004");
            }
        }catch (Exception e){
            System.err.println("Error" + e.getMessage());
        }
    }

    static void confirmPayment(Scanner sc) {
        String header = printLine("Confirm Your Payment");
        System.out.println(header);
        printDetailOrder(orderedMenu);
        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");
        System.out.println();
        Integer[] validNumber = {0,1,2};
        int input = getUserInput("=> ", sc);
        while (!validChosenNumber(validNumber, input)){
            System.out.println("Pilih menu yang tersedia");
            input = getUserInput("=> ", sc);
        }

        if(input == 0) {
            System.exit(0);
            System.out.println("Thank you :)");
        }
        if (input == 1) {
            printPaymentStruct(orderedMenu);
        }else {
            mainMenu();
        }

    }

    static boolean validChosenNumber(Integer[] validNumber, int chosenNumber) {
        for (int num : validNumber) {
            if (num == chosenNumber ) return true;
        }
        return false;
    }

    static void printPaymentStruct(List<Item> ordered) {
        List<String> template = new ArrayList<>();
        String header         = printLine("BinarFud");
        String msg            = "Terima kasih sudah memesan\ndi BinarFud\n\n" +
                                "Di bawahi ini adalah pesanan Anda";
        String desc           = "Pembayaran: BinarCash";
        String footer         = printLine("Simpan struk ini sebagai\n\tbukti pembayaran");

        System.out.println(header);
        System.out.println(msg);
        String detailOrderStr = printDetailOrder(ordered);
        System.out.println(desc);
        System.out.println(footer);

        template.add(header);
        template.add(msg);
        template.add(detailOrderStr);
        template.add(desc);
        template.add(footer);
        saveStruct(template);

    }

    static String printDetailOrder(List<Item> orderedMenu) {
        StringBuilder sb = new StringBuilder();
        int total           = 0;
        double totalPrice   = 0.00;

        System.out.println();
        for (Item orderedItem: orderedMenu) {
            String name     = orderedItem.name();
            double price    = orderedItem.price();
            int count       = orderedItem.count();
            total           += count;
            totalPrice      += (count * price);
            String pesanan = String.format("%s  \t %d \t %.3f", name, count, price);
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

    static void saveStruct(List<String> desc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("struck.txt"))){
            for (String line : desc) {
                writer.write(line);
                writer.newLine();
            }
        }catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}