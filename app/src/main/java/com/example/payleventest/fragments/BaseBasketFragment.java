package com.example.payleventest.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;

import com.example.payleventest.Constants;
import com.example.payleventest.activities.BasketDataHolder;

/**
 * Base fragment with basket info
 *
 * @author <a href="mailto:iBersh20@gmail.com">Iliya Bershadskiy</a>
 * @since 10.03.2015
 */
public abstract class BaseBasketFragment extends Fragment {
    protected BasketDataHolder basketDataHolder;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            basketDataHolder = (BasketDataHolder) activity;
        } catch (ClassCastException e) {
            Log.e(Constants.LOG_TAG, this.getClass().getName() + " should be attached only to activity implementing BasketDataHolder interface");
            throw e;
        }
    }
}
