package com.example.cis183_homework02_donovangilliam;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    View view;

    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    TextView tv_j_hexrgb;

    Button btn_j_savecolor;

    ListView lv_j_storedcolors;

    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;

    StoredColorAdapter adapter;

    ArrayList<ColorInfo> stored_colors = new ArrayList<ColorInfo>();

    int red = 255;
    int green = 255;
    int blue = 255;
    String hex_rgb = String.format("%02X%02X%02X", red, green, blue);

    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        view = this.getWindow().getDecorView();

        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);
        tv_j_hexrgb = findViewById(R.id.tv_v_hexrgb);

        btn_j_savecolor = findViewById(R.id.btn_v_savecolor);

        lv_j_storedcolors = findViewById(R.id.lv_v_storedcolors);

        sb_j_red = findViewById(R.id.sb_v_red);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_blue = findViewById(R.id.sb_v_blue);


        //set textboxes initially
        tv_j_red.setText("Red: " + String.valueOf(red));
        tv_j_green.setText("Green: " + String.valueOf(green));
        tv_j_blue.setText("Blue: " + String.valueOf(blue));
        tv_j_hexrgb.setText("Hex:" + hex_rgb);

        //set initial background color
        updateBackgroundColor();

        fillListView();

        saveColorClickListener();
        seekBarListeners();
        colorListClickListener();
    }
    //LISTENERS

    //seekbar listening, updates rgb values, hex value, and background color when seekbar is being
    //slid
    private void seekBarListeners()
    {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                red = i;
                updateColorStrings();
                updateBackgroundColor();
                updateTextColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                green = i;
                updateColorStrings();
                updateBackgroundColor();
                updateTextColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                blue = i;
                updateColorStrings();
                updateBackgroundColor();
                updateTextColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    //save color button listening, saves the color with addColorToList() and then resets values
    //back to default
    private void saveColorClickListener()
    {
        btn_j_savecolor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addColorToList();
                adapter.notifyDataSetChanged();
                resetInfo();
                updateBackgroundColor();
                updateTextColor();
                updateColorStrings();
            }
        });
    }

    private void colorListClickListener()
    {
        lv_j_storedcolors.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                red = stored_colors.get(i).getRed();
                green = stored_colors.get(i).getGreen();
                blue = stored_colors.get(i).getBlue();
                hex_rgb = stored_colors.get(i).getHex_rgb();

                sb_j_red.setProgress(red);
                sb_j_green.setProgress(green);
                sb_j_blue.setProgress(blue);
                updateBackgroundColor();
                updateTextColor();
            }
        });
    }
    //DATA MANIPULATION

    //updates the strings with values of R, G, B, and the hex code
    private void updateColorStrings()
    {
        tv_j_red.setText("Red: " + String.valueOf(red));
        tv_j_green.setText("Green: " + String.valueOf(green));
        tv_j_blue.setText("Blue: " + String.valueOf(blue));
        hex_rgb = String.format("%02X%02X%02X", red, green, blue);
        tv_j_hexrgb.setText("Hex:" + hex_rgb);
    }

    //updates the background
    private void updateBackgroundColor()
    {
        color = Color.argb(255, red, green, blue);
        view.setBackgroundColor(color);
    }

    //updates text color if RGB values fall below stated values, for visibility
    private void updateTextColor()
    {
        //would like to use a foreach here but idk how to do that with the view
        if (red <= 170 && green <= 100 && blue <= 255)
        {
            tv_j_red.setTextColor(Color.WHITE);
            tv_j_green.setTextColor(Color.WHITE);
            tv_j_blue.setTextColor(Color.WHITE);
            tv_j_hexrgb.setTextColor(Color.WHITE);
        }
        else
        {
            tv_j_red.setTextColor(Color.BLACK);
            tv_j_green.setTextColor(Color.BLACK);
            tv_j_blue.setTextColor(Color.BLACK);
            tv_j_hexrgb.setTextColor(Color.BLACK);
        }
    }

    //resets the application to default
    private void resetInfo()
    {
        red = 255;
        green = 255;
        blue = 255;

        sb_j_red.setProgress(255);
        sb_j_green.setProgress(255);
        sb_j_blue.setProgress(255);
    }

    //adds color to array, which the list adapter grabs
    private void addColorToList()
    {
        ColorInfo color_info = new ColorInfo(red, green, blue, hex_rgb);
        stored_colors.add(color_info);
        adapter.notifyDataSetChanged();
    }

    //adapter handling
    private void fillListView()
    {
        adapter = new StoredColorAdapter(this, stored_colors);
        lv_j_storedcolors.setAdapter(adapter);
    }
}