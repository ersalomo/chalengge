package Model;

import com.sun.istack.internal.Nullable;

public class Item {
    private String name;
    private double price;
    private Integer count;
    Item(String name, double price, Integer count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public double
    price() {
        return price;
    }
    public void price(int price) {
        this.price = price;
    }

    public String name() {
        return name;
    }
    public void name(String name) {
        this. name = name;
    }

    public int count() {
        return count;
    }

    public void count(Integer count) {
        if (count != null){
            this.count = count;
        }else{
            this.count++;
        }
    }
}
