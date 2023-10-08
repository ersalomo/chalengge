package org.example.Model;

import java.util.Objects;
import java.util.stream.Stream;

public abstract class Item {
    private String name;
    private double price;
    private Integer count = 0;
    public Item(String name, double price) {
        if (isNull(name, price)) throw new NullPointerException();
        if(isEmpty(name)) throw new IllegalArgumentException();
        if (price < 0 ) throw new IllegalArgumentException();

        this.name = name;
        this.price = price;
        this.count++;
    }

    public double price() {
        return price;
    }
    public void price(double price) {
        if (isNegative(price)) throw  new IllegalArgumentException();
        this.price = price;
    }
    public String name() {
        return name;
    }
    public void name(String name) {
        if (isEmpty(name)) throw  new IllegalArgumentException();
        this.name = name;
    }

    public int count() {
        return count;
    }

    public void count(Integer count) {
        if(isNull(count)) throw new NullPointerException();
        if(isNegative(count) || isNull(count)) throw new IllegalArgumentException();
        this.count = count;
    }
    private boolean isEmpty(String name) {
        return  (name.isEmpty() || isNull(name));
    }

    private boolean isNull(Object... obj) {
        return Stream.of(obj).anyMatch(Objects::isNull);
    }
    private <T extends Number> boolean isNegative(T value) {
        double val = value.doubleValue();
        return val < 0;
    }
}
