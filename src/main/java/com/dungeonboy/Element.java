package com.dungeonboy;
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

    public abstract void draw(TextGraphics screen);
}