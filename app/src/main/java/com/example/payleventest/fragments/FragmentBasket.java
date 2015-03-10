package com.example.payleventest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.payleventest.R;
import com.example.payleventest.adapters.BasketAdapter;
import com.example.payleventest.model.Product;

import java.util.Map;

/**
 * @author <a href="mailto:iBersh20@gmail.com">Iliya Bershadskiy</a>
 * @since 09.03.2015
 */
public class FragmentBasket extends BaseBasketFragment {
    private ListView list;
    private BasketAdapter basketAdapter;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_basket, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = (ListView) view.findViewById(R.id.list);
        basketAdapter = new BasketAdapter(getActivity(), basketDataHolder.getBasket(), basketDataHolder);
        list.setAdapter(basketAdapter);
    }

    public void setBasket(Map<Product, Integer> basket) {
        basketAdapter.setBasket(basket);
    }
}
