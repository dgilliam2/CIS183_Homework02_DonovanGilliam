package com.example.cis183_homework02_donovangilliam;

public class ColorInfo
{
    private int red;
    private int green;
    private int blue;

    private String hex_rgb;

    public ColorInfo(int r, int g, int b, String h)
    {
        red = r;
        green = g;
        blue = b;
        hex_rgb = h;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public String getHex_rgb() {
        return hex_rgb;
    }
}
