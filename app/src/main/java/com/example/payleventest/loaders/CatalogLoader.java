package com.example.payleventest.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.payleventest.model.Category;
import com.example.payleventest.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Here we should load all catalog data.
 * This loaded loads simple mock data.
 * If you need to load data from other data source change this loader or replace it in {@link com.example.payleventest.activities.MainActivity}
 *
 * @author <a href="mailto:iBersh20@gmail.com">Iliya Bershadskiy</a>
 * @since 09.03.2015
 */
public class CatalogLoader extends AsyncTaskLoader<Map<Category, List<Product>>> {

    public CatalogLoader(Context context) {
        super(context);
    }

    @Override
    public Map<Category, List<Product>> loadInBackground() {
        Map<Category, List<Product>> result = new TreeMap<>();//will be sorted alphabetically
        //First of all assume that categories and products were loaded as described
        //"loading" categories
        List<Category> categoriesList = new ArrayList<>();
        Set<String> productIds = new TreeSet<String>() {{ //will be sorted alphabetically
            add("productA");
            add("productC");
            add("productE");
            add("productF");
        }};
        categoriesList.add(new Category("categoryA", "Coffees", productIds));
        productIds = new TreeSet<String>() {{
            add("productB");
            add("productG");
            add("productA");
        }};
        categoriesList.add(new Category("categoryB", "Extra Coffees", productIds));
        productIds = new TreeSet<String>() {{
            add("productA");
            add("productG");
            add("productE");
        }};
        categoriesList.add(new Category("categoryC", "Small Coffees", productIds));

        //"loading" products
        List<Product> products = new ArrayList<>();
        products.add(new Product("productA", "Coffe A", 350));
        products.add(new Product("productB", "Coffe B", 450));
        products.add(new Product("productC", "Coffe C", 150));
        products.add(new Product("productD", "Coffe D", 250));
        products.add(new Product("productE", "Coffe E", 500));
        products.add(new Product("productF", "Coffe F", 325));
        products.add(new Product("productG", "Coffe G", 315));
        products.add(new Product("productH", "Coffe H", 350));


        //now map products to their ids
        Map<String, Product> productsMap = new HashMap<>();
        for (Product product : products) {
            productsMap.put(product.getId(), product);
        }

        //Construct catalog map
        for (Category category : categoriesList) {
            List<Product> productSet = new ArrayList<>();
            for (String productId : category.getProducts()) {
                productSet.add(productsMap.get(productId));
            }
            result.put(category, productSet);
        }

        return result;
    }
}
