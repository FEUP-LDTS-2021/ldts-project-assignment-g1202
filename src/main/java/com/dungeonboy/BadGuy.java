package com.dungeonboy;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class BadGuy extends Element {

    public BadGuy(double x, double y,int health){
        super((int)Math.round(x),(int) Math.round(y),health);
    }

    /*public Position getPosition(){
        return position;
    }*/

    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#FF0000")); // vermelho
        screen.putString(new TerminalPosition(position.getX(), position.getY()),"E");
    }

    public void drawBoss(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#000000")); // vermelho
        screen.putString(new TerminalPosition(position.getX(), position.getY()),"(0.o)");
    }


    public void damagePlayer(Player player){
        if(player.position.getY()+1 == this.position.getY() || player.position.getY()-1 == this.position.getY()){
            player.hitpoints.changeHp();
        }
        if(player.position.getX()+1 == this.position.getX() || player.position.getX()-1 == this.position.getX()){
            player.hitpoints.changeHp();
        }
    }

    //padroes de movimento inimigo

    public void rangeToPlayerT1(Player player,Arena arena){
        if(player.position.getX() <= this.position.getX() && player.position.getY() == this.position.getY()){
            if(this.position.canMoveLeft()) {
                this.position.moveLeft();
            }
        }
        else if(player.position.getX() >= this.position.getX() && player.position.getY() == this.position.getY()){
            if(this.position.canMoveRight(arena)) {
                this.position.moveRight();
            }
        }
    }

    public void rangeToPlayerT2(Player player,Arena arena){
        if(player.position.getY() <= this.position.getY() && player.position.getX() == this.position.getX()){
            if(this.position.canMoveUp(arena)) {
                this.position.moveUp();
            }
        }
        else if(player.position.getY() >= this.position.getY() && player.position.getX() == this.position.getX()){
            if(this.position.canMoveDown(arena)) {
                this.position.moveDown();
            }
        }
    }

    public void changeHp(int damage){
        hitpoints.setHp(hitpoints.getHp() - damage);
    }
}