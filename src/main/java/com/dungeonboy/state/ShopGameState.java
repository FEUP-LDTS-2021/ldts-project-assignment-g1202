package com.dungeonboy.state;

import com.dungeonboy.Game;
import com.dungeonboy.Potion;
import com.dungeonboy.Weapon;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class ShopGameState implements GameState{

    Game game;
    Screen screen;
    TextGraphics tg;

    public ShopGameState(Game game){
        this.game = game;
        screen = game.getScreen();
        tg = game.getTg();
    }

    public void display() throws IOException {
        screen.clear();

        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(35, 2, "SHOP");

        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.putString(65, 4, "Coins: " + String.valueOf(game.survArena.getPlayer().getCredit()));

        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString(9, 8, "Weapons(Range)");

        int row = 11;
        for (Weapon weapon : game.shop.getWeapons()) {
            tg.setBackgroundColor(TextColor.ANSI.BLACK);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(9, row, weapon.getType() + "(" + String.valueOf(weapon.getRange()) + ")");
            tg.putString(19, row, String.valueOf(weapon.getCost()) + " coins");
            row += 2;
        }

        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString(45, 8, "Potions");

        row = 11;
        for (Potion potion : game.shop.getPotions()) {
            tg.setBackgroundColor(TextColor.ANSI.BLACK);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(45, row, potion.getName());
            tg.putString(52, row, String.valueOf(potion.getCost()) + " coins");
            row += 2;
        }

        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.putString(5, 20, "Buy (Enter)");
        tg.putString(5, 21, "Back to Game (ESC)");

        game.shop.show(game.survArena.getPlayer());
    }

    public void goForward(){}

    public void goBack() throws IOException{
        game.changeState(new SurvivalGameState(game));
        game.survival();
    }

    public void lose(){}

    public void win(){}
}
