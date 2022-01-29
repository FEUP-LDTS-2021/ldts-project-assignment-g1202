package com.dungeonboy.state;

import com.dungeonboy.*;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.List;

public class SurvivalGameState implements GameState{
    Game game;
    Screen screen;
    TextGraphics tg;

    public SurvivalGameState(Game game){
        this.game = game;
        screen = game.getScreen();
        tg = game.getTg();
    }

    public void display() throws IOException {
        screen.clear();
        game.survArena.draw(tg, game.getLvl());
        tg.setBackgroundColor(TextColor.ANSI.BLACK); //texto do canto superior esq que indica o modo selecionado
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(3, 1, "Survival");

        //String Inventory
        tg.putString(65, 1, "Inventory (U)");

        //String HP
        tg.putString(2, 22, "HP: " + game.survArena.getPlayer().getHitpoints().getHp());

        //String Live
        tg.putString(15, 22, "Lives: " + game.survArena.getPlayer().getLife());


        //Strings WEAPON
        tg.putString(30, 22, "Weapon:  " + game.survArena.getPlayer().getWeapon());

        //String com numero coins:
        tg.putString(53, 22, "Coins: " + game.survArena.getPlayer().getCredit());

        //Strings com LVL
        tg.putString(70, 22, "Lvl: " + game.getLvl());

        screen.refresh();
    }

    public void goForward() {}

    public void goBack() throws IOException {
        game.changeState(new MenuGameState(game));
        game.menu();
    }

    public void lose() throws IOException{
        if (game.survArena.getPlayer().getLife() > 0){
            switch (game.survArena.getPlayer().getLife()) {  //restaura o hp conforme o nr de vidas
                case 3:
                    game.survArena.getPlayer().setHitpoints(new Hp(90));
                    break;
                case 2:
                    game.survArena.getPlayer().setHitpoints(new Hp(75));
                    break;
                case 1:
                    game.survArena.getPlayer().setHitpoints(new Hp(50));
                    break;
            }
            game.survArena.getPlayer().lostlife();
            game.survArena.getPlayer().getPosition().setX(10);   // restaura posicao inicial
            game.survArena.getPlayer().getPosition().setY(10);

            game.changeState(new ShopGameState(game));
        }
        else{
            screen.clear();
            tg.setForegroundColor(TextColor.ANSI.RED);
            tg.enableModifiers(SGR.BOLD);
            tg.putString(35,12, "GAME OVER");
            screen.refresh();

            try{
                Thread.sleep(2500);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            goBack();
        }
    }

    public void win() throws IOException{
        if (game.lvl < 3){
            levelUp();
        }
        else if (game.lvl == 3){
            finalLevel();
        }
    }

    public void levelUp() throws IOException{
        game.lvl = game.lvl + 1;

        screen.clear();
        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.enableModifiers(SGR.BOLD);
        tg.putString(37,12, "LEVEL " + game.lvl);
        screen.refresh();

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<BadGuy> baddies = game.survArena.createBaddies();
        List<Coins> coins = game.survArena.createCoins();

        game.survArena.setBaddies(baddies);
        game.survArena.setCoins(coins);

        display();
        game.survival();
    }

    public void finalLevel() throws IOException{
        game.lvl =  game.lvl + 1;

        screen.clear();
        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.enableModifiers(SGR.BOLD);
        tg.putString(37,12, "LEVEL " + game.lvl);
        screen.refresh();

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        display();
        game.survival();
    }
}
