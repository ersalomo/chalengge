import Model.Beverage;
import Model.Food;
import Model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Item> map = new HashMap<>();
        List<Item> orderedMenu = new ArrayList<Item>();

        Item nasiGoreng = new Food("Nasi Goreng",    15.000,1);
        Item mieGoreng  = new Food("Mie Goreng",     15.000,1);
        Item nasiAyam   = new Food("Nasi + Ayam",    18.000,1);
        Item esTeh      = new Beverage("Es Teh Manis",3.000,1);
        Item esJeruk    = new Beverage("Es Jeruk",    5.000,1);

        map.put(1, nasiGoreng);
        map.put(2, mieGoreng);
        map.put(3, nasiAyam);
        map.put(4, esTeh);
        map.put(5, esJeruk);

        boolean isYes = true;
        printLine("Selamat datang di BinarFud");
        while (isYes) {
            clearConsole();
            int choice = getChoice();
            if(choice == 0) {
                System.out.println("Thank you :) ");
                break;
            }
            if (choice == 99) {
                confirmPayment(orderedMenu);
                break;


            }

            printLine("Berapa pesanan Anda");
//           Integer numberedChoice = getUserInput();
            Item item =  map.get(choice); // choice number harus di validasi
            System.out.printf("%s \t| %.3f \n" ,item.name(), item.price());
            Integer qty = getUserInput("qty => ");
            item.count(qty);
            orderedMenu.add(item);
            isYes = isYes("Lanjut (y/n) => ");
        }

    }

    static void printLine(String msg) {
        String header = String.format(
                        "==================================\n" +
                        "=== %s ===\n" +
                        "==================================\n"
        , msg);
        System.out.println(header);
    }
    static int getUserInput(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("%s", msg);
        return sc.nextInt();
    }
    static int getChoice() {
        System.out.println("Silahkan pilih menu yang tersedia");
        System.out.println(" 1. Nasi Goreng  \t| 15.000");
        System.out.println(" 2. Mie Goreng   \t| 13.000");
        System.out.println(" 3. Nasi + Ayam  \t| 18.000");
        System.out.println(" 4. Es Teh Manis \t| 3.000");
        System.out.println(" 5. Es Jeruk     \t| 5.000");
        System.out.println("99. Pesan dan Bayar");
        System.out.println(" 0. Keluar");
        Scanner sc = new Scanner(System.in);
        System.out.println("=> ");
        return sc.nextInt();
    }

    public static boolean isYes(String msg) {
        Scanner sc = new Scanner(System.in);
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
            System.err.println("Error" + e.getMessage());;
        }
    }

    static void confirmPayment(List<Item> orderedMenu) {
        printLine("Konfirmasi pembayaran Anda");
        int total= 0;
        double totalPrice = 0.00;

        for (Item orderedItem: orderedMenu) {
            String name = orderedItem.name();
            double price = orderedItem.price();
            int count = orderedItem.count();
            total += count;
            totalPrice += (count * price);
            System.out.printf("%s \t %d \t\t %.3f", name, count, price);
            System.out.println();
        }
        System.out.println("----------------------------------+");
        System.out.printf("Total \t %d \t%.3f \n", total, totalPrice);
        System.out.println();
        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");

        if(2 == 2) {return;}

    }

}