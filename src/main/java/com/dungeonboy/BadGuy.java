package com.dungeonboy;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class BadGuy {
    Position position;
    Hp hitpoints;

    public BadGuy(double x, double y,int health){
        //arredondar x e y porque usamos Math.random() que é double para gerar coordenadas mas position é em int
        int xi = (int)Math.round(x);
        int ye = (int)Math.round(y);
        position = new Position(xi,ye);
        hitpoints = new Hp(health);
    }

    public Position getPosition(){
        return position;
    }

    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#FF0000")); // vermelho
        screen.putString(new TerminalPosition(position.getX(), position.getY()),"E");
    }

    public void drawBoss(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#FF0000")); // vermelho
        screen.putString(new TerminalPosition(position.getX(), position.getY()),"O");
    }

    public void damagePlayer(Player player){
        if(player.position.getY()+1 == this.position.getY() || player.position.getY()-1 == this.position.getY()){
            player.hitpoints.changeHp();
        }
        if(player.position.getX()+1 == this.position.getX() || player.position.getX()-1 == this.position.getX()){
            player.hitpoints.changeHp();
        }
    }

    public void changeHp(int damage){
        hitpoints.setHp(hitpoints.getHp() - damage);
    }
}