package com.dungeonboy.state;

import com.dungeonboy.*;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.List;

public class SurvivalGameState implements GameState {
    Game game;
    Screen screen;
    TextGraphics tg;

    public SurvivalGameState(Game game) {
        this.game = game;
        screen = game.getScreen();
        tg = screen.newTextGraphics();
    }

    public void display() throws IOException {

        List<Weapon> w = game.getPvpArena().getPlayer().getWeapons();
        w.add(new Weapon(0, 5, "Sword"));
        w.add(new Weapon(0, 10, "Arrow"));
        game.getPvpArena().getPlayer().setWeapons(w);

        screen.clear();
        game.getSurvArena().draw(tg, game.getLvl());
        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(3, 1, "Survival");

        //String Inventory
        tg.putString(65, 1, "Inventory (U)");

        //String HP
        tg.putString(2, 22, "HP: " + game.getSurvArena().getPlayer().getHitpoints().getHp());

        //String Live
        tg.putString(15, 22, "Lives: " + game.getSurvArena().getPlayer().getLife());

        //Strings WEAPON
        tg.putString(30, 22, "Weapon:  " + game.getSurvArena().getPlayer().getWeapon());

        //String com numero coins:
        tg.putString(53, 22, "Coins: " + game.getSurvArena().getPlayer().getCredit());

        //Strings com LVL
        tg.putString(70, 22, "Lvl: " + game.getLvl());

        screen.refresh();
    }


    public void goForward() throws IOException {
    }

    public void goBack() throws IOException {
        game.changeState(new MenuGameState(game));
        game.menu();
    }

    public void lose() throws IOException {
        if (game.getSurvArena().getPlayer().getLife() > 0) {
            switch (game.getSurvArena().getPlayer().getLife()) {  //restaura o hp conforme o nr de vidas
                case 3:
                    game.getSurvArena().getPlayer().setHitpoints(new Hp(90));
                    break;
                case 2:
                    game.getSurvArena().getPlayer().setHitpoints(new Hp(75));
                    break;
                case 1:
                    game.getSurvArena().getPlayer().setHitpoints(new Hp(50));
                    break;
            }
            game.getSurvArena().getPlayer().lostlife();
            game.getSurvArena().getPlayer().getPosition().setX(10);   // restaura posicao inicial
            game.getSurvArena().getPlayer().getPosition().setY(10);

            game.changeState(new ShopGameState(game));
        } else {
            screen.clear();
            tg.setForegroundColor(TextColor.ANSI.RED);
            tg.enableModifiers(SGR.BOLD);
            tg.putString(35, 12, "GAME OVER");
            screen.refresh();

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            goBack();
        }
    }

    public void win() throws IOException {
        if (game.getLvl() < 3) {
            levelUp();
        } else if (game.getLvl() == 3) {
            finalLevel();
        }
    }

    public void levelUp() throws IOException {
        game.setLvl(game.getLvl() + 1);

        screen.clear();
        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.enableModifiers(SGR.BOLD);
        tg.putString(37, 12, "LEVEL " + game.getLvl());
        screen.refresh();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<BadGuy> baddies = game.getSurvArena().createBaddies();
        List<Coins> coins = game.getSurvArena().createCoins();

        game.getSurvArena().setBaddies(baddies);
        game.getSurvArena().setCoins(coins);

        display();
        game.survival();
    }

    public void finalLevel() throws IOException {
        game.setLvl(game.getLvl() + 1);

        screen.clear();
        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.enableModifiers(SGR.BOLD);
        tg.putString(37, 12, "LEVEL " + game.getLvl());
        screen.refresh();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        display();
        game.survival();
    }

}



