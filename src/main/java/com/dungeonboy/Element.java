package com.dungeonboy;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    public Position position;
    public Hp hitpoints;

    public Element(int x, int y,int health){
        position = new Position(x,y);
        hitpoints = new Hp(health);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void draw(TextGraphics tg,String color,String shape){
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.enableModifiers(SGR.BOLD);
        tg.putString(new TerminalPosition(position.getX(), position.getY()), shape);
    }

}