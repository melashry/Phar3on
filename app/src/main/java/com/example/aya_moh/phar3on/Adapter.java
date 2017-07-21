package com.example.aya_moh.phar3on;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;

/**
 * Created by Aya_Moh on 7/2/2017.
 */

public class Adapter extends BaseAdapter {
    private Context mContext;
    public Adapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return SliderLayout.Transformer.values().length;
    }

    @Override
    public Object getItem(int position) {
        return SliderLayout.Transformer.values()[position].toString();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView t = (TextView) LayoutInflater.from(mContext).inflate(com.example.aya_moh.phar3on.R.layout.item,null);
        t.setText(getItem(position).toString());
        return t;
    }
}
