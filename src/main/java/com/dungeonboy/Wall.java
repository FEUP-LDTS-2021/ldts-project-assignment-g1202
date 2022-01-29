package com.dungeonboy;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element{
    //construtor
    public Wall(int x, int y){
        super(x,y,0);
    }

}