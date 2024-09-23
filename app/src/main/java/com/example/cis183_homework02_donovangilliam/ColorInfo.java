package com.example.cis183_homework02_donovangilliam;

public class ColorInfo
{
    private int red;
    private int green;
    private int blue;

    private String hex_rgb;

    public ColorInfo(int r, int g, int b)
    {
        this.red = r;
        this.green = g;
        this.blue = b;
        hex_rgb = String.format("%02X%02X%02X", red, green, blue);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public String getHex_rgb() {
        return hex_rgb;
    }

    public void setHex_rgb(String hex_rgb) {
        this.hex_rgb = hex_rgb;
    }
}
