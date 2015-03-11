package com.example.payleventest;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.example.payleventest.activities.MainActivity;

/**
 * @author ilya
 * @since 11.03.15
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity activity;
    private ExpandableListView categoriesList;
    private ListView basketList;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);
        activity = getActivity();
        categoriesList = (ExpandableListView) activity.findViewById(R.id.catalog_list);
        basketList = (ListView) activity.findViewById(R.id.basket_list);
    }

    public void testEmptyLists() {
        assertEquals(categoriesList.getCount() == 0, activity.getCatalog().isEmpty());
        assertEquals(basketList.getCount() == 0, activity.getBasket().isEmpty());
    }

    @UiThreadTest
    public void testNotEmptyBasket() {
        categoriesList.expandGroup(0);
        View firstItem = categoriesList.getAdapter().getView(1, null, null);
        firstItem.performClick();
        assertEquals(basketList.getCount(), 1);
    }
}
