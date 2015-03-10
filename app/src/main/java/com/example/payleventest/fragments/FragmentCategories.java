package com.example.payleventest.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.payleventest.R;
import com.example.payleventest.adapters.CatalogAdapter;
import com.example.payleventest.model.Category;
import com.example.payleventest.model.Product;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:iBersh20@gmail.com">Iliya Bershadskiy</a>
 * @since 09.03.2015
 */
public class FragmentCategories extends BaseBasketFragment {
    private CatalogAdapter catalogAdapter;
    private ExpandableListView listView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frgament_catalog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ExpandableListView) view.findViewById(R.id.list);
    }

    public void setCatalogInfo(Map<Category, List<Product>> catalog) {
        catalogAdapter = (new CatalogAdapter(getActivity(), catalog, basketDataHolder));
        listView.setAdapter(catalogAdapter);
    }

    public void bucketDataRefreshed() {
        catalogAdapter.notifyDataSetChanged();
    }
}
