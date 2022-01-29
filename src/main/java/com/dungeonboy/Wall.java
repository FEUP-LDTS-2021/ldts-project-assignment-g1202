package com.dungeonboy;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element{
    private int w,h;

    //construtor

    public Wall(int x, int y){
        super(x,y,0);
    }

    /*public Position getPosition(){
        return position;
    }*/

    public void draw(TextGraphics tg) {
        tg.setForegroundColor(TextColor.Factory.fromString("#000000"));
        tg.enableModifiers(SGR.BOLD);
        tg.putString(new TerminalPosition(position.getX(), position.getY()), "@");

    }


}