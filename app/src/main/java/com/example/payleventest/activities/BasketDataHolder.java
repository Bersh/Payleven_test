package com.example.payleventest.activities;

import android.support.annotation.NonNull;

import com.example.payleventest.model.Product;

import java.util.Map;

/**
 * @author <a href="mailto:iBersh20@gmail.com">Iliya Bershadskiy</a>
 * @since 10.03.2015
 */
public interface BasketDataHolder {
    public void addToBasket(@NonNull Product product);

    public void removeFromBasket(@NonNull Product product);

    @NonNull
    public Map<Product, Integer> getBasket();
}
