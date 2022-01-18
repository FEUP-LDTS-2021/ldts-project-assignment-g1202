package com.dungeonboy;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {

    private Position position;
    int x,y;
    private int w,h;

    //construtor

    public Wall(int x, int y){
        position = new Position(x,y);
    }

    public Position getPosition(){
        return position;
    }

    //setters
    public void wallSet_width(int width){
        this.w = width;
    }

    public void wallSet_height(int height){
        this.h = height;
    }
    //getters
    public int wall_width(){
        return w;
    }

    public int wall_height(){
        return h;
    }

    public void draw(TextGraphics tg) {
        tg.setForegroundColor(TextColor.Factory.fromString("#000000"));
        tg.enableModifiers(SGR.BOLD);
        tg.putString(new TerminalPosition(position.getX(), position.getY()), "@");

    }


}