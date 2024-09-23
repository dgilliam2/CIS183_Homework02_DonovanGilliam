package com.example.cis183_homework02_donovangilliam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StoredColorAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> stored_colors;

    public StoredColorAdapter(Context c, ArrayList<ColorInfo> ci)
    {
        context = c;
        stored_colors = ci;
    }

    @Override
    public int getCount() {
        return stored_colors.size();
    }

    @Override
    public Object getItem(int i) {
        return stored_colors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if (view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.stored_color_cell, null);
        }

        TextView red = view.findViewById(R.id.tv_v_cc_red);
        TextView green = view.findViewById(R.id.tv_v_cc_green);
        TextView blue = view.findViewById(R.id.tv_v_cc_blue);
        TextView hexrgb = view.findViewById(R.id.tv_v_cc_hexrgb);

        ColorInfo color = stored_colors.get(i);

        //Set textboxes to values of specific stored color
        red.setText(String.valueOf(color.getRed()));
        green.setText(String.valueOf(color.getGreen()));
        blue.setText(String.valueOf(color.getBlue()));
        hexrgb.setText(color.getHex_rgb());

        return view;
    }
}
