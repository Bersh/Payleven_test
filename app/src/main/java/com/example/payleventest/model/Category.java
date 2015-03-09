package com.example.payleventest.model;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:iBersh20@gmail.com">Iliya Bershadskiy</a>
 * @since 09.03.2015
 */
public class Category extends BaseObject implements Comparable<Category> {
    private Set<String> products;

    public Category(String id, String name, Set<String> products) {
        super(id, name);
        this.products = products;
    }

    public Set<String> getProducts() {
        return products;
    }

    public void setProducts(Set<String> products) {
        this.products = products;
    }

    @Override
    public int compareTo(@NonNull Category another) {
        return this.getId().compareTo(another.getId());
    }
}
