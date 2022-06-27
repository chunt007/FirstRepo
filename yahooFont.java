package com.example.project;

import java.awt.*;

public class yahooFont extends Font {
    private double fontColor;

    public yahooFont(String name, int style, int size, double color) {
        super(name, style, size);
        fontColor = color;
    }

    public String getName(){
        return name;
    }

    public int getStyle(){
        return style;
    }

    public int getSize(){
        return size;
    }

    public double getColor(){
        return fontColor;
    }

    public String setFontName(String setFontName){
        return name = setFontName;
    }

    public int setStyle(int setStyle){
        return style = setStyle;
    }

    public double setFontColor(double setFontColor){
        return fontColor = setFontColor;
    }

}
