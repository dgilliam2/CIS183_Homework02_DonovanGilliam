package com.example.cis183_homework02_donovangilliam;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    Button btn_j_savecolor;
    ListView lv_j_storedcolors;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;

    ArrayList<ColorInfo> stored_colors;

    StoredColorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_j_savecolor = findViewById(R.id.btn_v_savecolor);
        lv_j_storedcolors = findViewById(R.id.lv_v_storedcolors);
        sb_j_red = findViewById(R.id.sb_v_red);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_blue = findViewById(R.id.sb_v_blue);
    }



}