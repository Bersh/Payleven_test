package com.example.payleventest.activities;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.payleventest.Constants;
import com.example.payleventest.R;
import com.example.payleventest.fragments.FragmentBasket;
import com.example.payleventest.fragments.FragmentCategories;
import com.example.payleventest.loaders.CatalogLoader;
import com.example.payleventest.model.Category;
import com.example.payleventest.model.Product;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This activity will store catalog and basket data in memory and notify fragments when data is updated
 *
 * @author <a href="mailto:iBersh20@gmail.com">Iliya Bershadskiy</a>
 * @since 09.03.2015
 */
public class MainActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks<Map<Category, List<Product>>>, BasketDataHolder {
    private ProgressBar progressBar;
    private LinearLayout content;
    private Map<Category, List<Product>> catalog;
    //This probably should be stored in local database but there are no requirements about data persistence.
    // Used memory storage as the simplest way
    private Map<Product, Integer> basket = new TreeMap<>(); //product - quantity
    private static final int CATALOG_LOADER_ID = 12345;
    private FragmentCategories fragmentCategories;
    private FragmentBasket fragmentBasket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        content = (LinearLayout) findViewById(R.id.content);
        //fragments are added in layout
        fragmentCategories = (FragmentCategories) getFragmentManager().findFragmentById(R.id.fragment_categories);
        fragmentBasket = (FragmentBasket) getFragmentManager().findFragmentById(R.id.fragment_basket);
        getLoaderManager().initLoader(CATALOG_LOADER_ID, null, this).forceLoad();
    }

    /**
     * Here mock data loader will be created. Change this method if you need another loader.
     * <b>Assumed that all data sorting will be done in loader</b>
     *
     * @param id   loader id
     * @param args loader arguments
     * @return created {@link com.example.payleventest.loaders.CatalogLoader}
     */
    @Override
    public Loader<Map<Category, List<Product>>> onCreateLoader(int id, Bundle args) {
        Loader<Map<Category, List<Product>>> loader = null;
        if (id == CATALOG_LOADER_ID) {
            loader = new CatalogLoader(this);
            Log.d(Constants.LOG_TAG, "onCreateLoader: " + loader.hashCode());
        }
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Map<Category, List<Product>>> loader, Map<Category, List<Product>> data) {
        catalog = data;
        fragmentCategories.setCatalogInfo(catalog);
        progressBar.setVisibility(View.GONE);
        content.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoaderReset(Loader<Map<Category, List<Product>>> loader) {
        Log.d(Constants.LOG_TAG, "onLoaderReset for loader " + loader.hashCode());
    }

    @Override
    public void addToBasket(@NonNull Product product) {
        if (basket.containsKey(product)) {
            int itemsCount = basket.get(product);
            basket.put(product, ++itemsCount);
        } else {
            basket.put(product, 1);
        }
        fragmentBasket.setBasket(basket);
        fragmentCategories.bucketDataRefreshed();
    }

    @Override
    public void removeFromBasket(@NonNull Product product) {
        if (basket.containsKey(product)) {
            int itemsCount = basket.get(product);
            if (itemsCount > 1) {
                basket.put(product, --itemsCount);
            } else {
                basket.remove(product);
            }
            fragmentBasket.setBasket(basket);
            fragmentCategories.bucketDataRefreshed();
        }
    }

    @Override
    @NonNull
    public Map<Product, Integer> getBasket() {
        return basket;
    }
}