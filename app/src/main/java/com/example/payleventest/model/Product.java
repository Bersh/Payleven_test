package com.example.payleventest.model;

import android.support.annotation.NonNull;

/**
 * @author <a href="mailto:iBersh20@gmail.com">Iliya Bershadskiy</a>
 * @since 09.03.2015
 */
public class Product extends BaseObject implements Comparable<Product> {
    private int price;

    public Product(String id, String name, int price) {
        super(id, name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(@NonNull Product another) {
        return this.getId().compareTo(another.getId());
    }
}
