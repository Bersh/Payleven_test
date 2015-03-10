package com.example.payleventest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.payleventest.activities.BasketDataHolder;
import com.example.payleventest.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:iBersh20@gmail.com">Iliya Bershadskiy</a>
 * @since 10.03.2015
 */
public class BasketAdapter extends BaseAdapter {
    private Map<Product, Integer> basket; //product - quantity
    private List<Product> products;
    private LayoutInflater inflater;
    private BasketDataHolder basketDataHolder;

    public BasketAdapter(Context context, Map<Product, Integer> basket, BasketDataHolder basketDataHolder) {
        inflater = LayoutInflater.from(context);
        this.basketDataHolder = basketDataHolder;
        setBasket(basket);
    }

    public void setBasket(Map<Product, Integer> basket) {
        this.basket = basket;
        products = new ArrayList<>(basket.keySet());
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return basketDataHolder.getBasket().size();
    }

    @Override
    public Product getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);
            viewHolder.txtProductInfo = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Product currentProduct = getItem(position);
        viewHolder.txtProductInfo.setText(currentProduct.getName() + "  " + basket.get(currentProduct));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basketDataHolder.removeFromBasket(currentProduct);
            }
        });
        return convertView;
    }

    private class ViewHolder {
        TextView txtProductInfo;
    }
}
