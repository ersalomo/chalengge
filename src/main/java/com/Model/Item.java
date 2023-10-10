package com.Model;

import com.Util.Util;


public abstract class Item {
    private String name;
    private double price;
    private Integer count = 0;
    public Item(String name, double price) {
        if (Util.isNull(name, price)) throw new NullPointerException();
        if(Util.isEmpty(name)) throw new IllegalArgumentException();
        if (price < 0 ) throw new IllegalArgumentException();
        this.name = name;
        this.price = price;
        this.count++;
    }

    public double price() {
        return price;
    }
    public void price(double price) {
        if (Util.isNegative(price)) throw  new IllegalArgumentException();
        this.price = price;
    }

    public String name() {
        return name;
    }
    public void name(String name) {
        if (Util.isEmpty(name)) throw  new IllegalArgumentException();
        this.name = name;
    }

    public int count() {
        return count;
    }

    public void count(Integer count) {
        if(Util.isNull(count)) throw new NullPointerException();
        if(Util.isNegative(count) || Util.isNull(count)) throw new IllegalArgumentException();
        this.count = count;
    }

}
