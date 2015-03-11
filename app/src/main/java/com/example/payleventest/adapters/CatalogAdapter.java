package com.example.payleventest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.payleventest.activities.BasketDataHolder;
import com.example.payleventest.model.Category;
import com.example.payleventest.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:iBersh20@gmail.com">Iliya Bershadskiy</a>
 * @since 10.03.2015
 */
public class CatalogAdapter extends BaseExpandableListAdapter {
    private Map<Category, List<Product>> catalog;
    private List<Category> groups;
    private LayoutInflater inflater;
    private Context context;
    private BasketDataHolder basketDataHolder;

    public CatalogAdapter(Context context, Map<Category, List<Product>> catalog, BasketDataHolder basketDataHolder) {
        this.context = context;
        this.catalog = catalog;
        this.basketDataHolder = basketDataHolder;
        inflater = LayoutInflater.from(context);
        groups = new ArrayList<>(catalog.keySet());
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return catalog.get(getGroup(groupPosition)).size();
    }

    @Override
    public Category getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Product getChild(int groupPosition, int childPosition) {
        return catalog.get(getGroup(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition + childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);
            viewHolder.txtName = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Category category = getGroup(groupPosition);
        viewHolder.txtName.setPadding(getPixelFromDips(30), 0, 0, 0); //need some space for expand icon
        viewHolder.txtName.setText(category.getName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(android.R.layout.simple_list_item_2, null);
            viewHolder.txtName = (TextView) convertView.findViewById(android.R.id.text1);
            viewHolder.txtPrice = (TextView) convertView.findViewById(android.R.id.text2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Product product = getChild(groupPosition, childPosition);
        Map<Product, Integer> basket = basketDataHolder.getBasket();
        int quantity = basket.containsKey(product) ? basketDataHolder.getBasket().get(product) : 0;
        String productNameWithQty = quantity > 0 ? product.getName() + "  " + quantity : product.getName();
        viewHolder.txtName.setText(productNameWithQty);
        viewHolder.txtPrice.setText(Integer.toString(product.getPrice()));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basketDataHolder.addToBasket(product);
            }
        });
        return convertView;
    }

    public int getPixelFromDips(float dpis) {
        // Get the screen's density scale
        final float scale = context.getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (dpis * scale + 0.5f);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private static final class ViewHolder {
        TextView txtName;
        TextView txtPrice;
    }
}
