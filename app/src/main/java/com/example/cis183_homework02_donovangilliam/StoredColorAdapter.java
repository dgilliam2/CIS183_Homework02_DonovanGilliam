package com.example.cis183_homework02_donovangilliam;

import android.content.Context;
import android.graphics.Color;
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
    int color;

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

        ColorInfo color_info = stored_colors.get(i);

        color = Color.argb(255,
                                color_info.getRed(),
                                color_info.getGreen(),
                                color_info.getBlue());

        //Set textboxes to values of specific stored color
        red.setText("Red: " + String.valueOf(color_info.getRed()));
        green.setText("Green: " + String.valueOf(color_info.getGreen()));
        blue.setText("Blue: " + String.valueOf(color_info.getBlue()));
        hexrgb.setText("Hex: " + color_info.getHex_rgb());

        //Make sure text is visible on the saved color, similar to in Main Activity
        if (color_info.getRed() <= 170 && color_info.getGreen() <= 100 && color_info.getBlue() <= 255)
        {
            red.setTextColor(Color.WHITE);
            green.setTextColor(Color.WHITE);
            blue.setTextColor(Color.WHITE);
            hexrgb.setTextColor(Color.WHITE);
        }
        else
        {
            red.setTextColor(Color.BLACK);
            green.setTextColor(Color.BLACK);
            blue.setTextColor(Color.BLACK);
            hexrgb.setTextColor(Color.BLACK);
        }
        view.setBackgroundColor(color);

        return view;
    }
}
