package com.dungeonboy.state;

import com.dungeonboy.*;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.List;

public class PvpGameState implements GameState{
    Game game;
    Screen screen;
    TextGraphics tg;

    public PvpGameState(Game game){
        this.game = game;
        screen = game.getScreen();
        tg = screen.newTextGraphics();

    }


    public void display() throws IOException{

        List<Weapon> w = game.getPvpArena().getPlayer().getWeapons();
        w.add(new Weapon(0, 5, "Sword"));
        w.add(new Weapon(0, 10, "Arrow"));
        game.getPvpArena().getPlayer().setWeapons(w);

        List<Weapon> w1 = game.getPvpArena().getPlayer2().getWeapons();
        w1.add(new Weapon(0, 5, "Sword"));
        w1.add(new Weapon(0, 10, "Arrow"));
        game.getPvpArena().getPlayer2().setWeapons(w1);

        screen.clear();

        game.getPvpArena().draw2(tg);
        tg.setBackgroundColor(TextColor.ANSI.BLACK); //texto do canto superior esq que indica o modo selecionado
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(3, 1, "Player VS Player");

        //String Round
        tg.putString(37, 1, "Round:  " + game.getRound());

        //Strings com HP
        tg.putString(2, 22, "P1 HP: " + game.getPvpArena().getPlayer().getHitpoints().getHp());
        tg.putString(2, 23, "P2 HP: " + game.getPvpArena().getPlayer2().getHitpoints().getHp());

        //Strings WEAPON
        tg.putString(30, 22, "P1 Weapon:  " + game.getPvpArena().getPlayer().getWeapon());
        tg.putString(30, 23, "P2 Weapon:  " + game.getPvpArena().getPlayer2().getWeapon());

        //Strings com Kills
        tg.putString(65, 22, "P1 Kills:  " + game.getP1kills());
        tg.putString(65, 23, "P2 Kills:  " + game.getP2kills());

        screen.refresh();
    }

    public void goForward(){}

    public void goBack() throws IOException {
        game.changeState(new MenuGameState(game));
        game.menu();
    }

    public void lose() throws IOException {
        if (game.getPvpArena().getPlayer2().getHitpoints().getHp() <= 0){
            game.setP1kills(game.getP1kills() + 1);
        }

        if (game.getPvpArena().getPlayer().getHitpoints().getHp() <= 0){
            game.setP2kills(game.getP2kills() + 1);
        }

        if (game.getRound() == 5){
            win();
        }
        else {
            game.setRound(game.getRound() + 1);
            game.getPvpArena().getPlayer().setHitpoints(new Hp(100));
            game.getPvpArena().getPlayer().setPosition(new Position(10, 10));
            game.getPvpArena().getPlayer2().setHitpoints(new Hp(100));
            game.getPvpArena().getPlayer2().setPosition(new Position(60, 10));

            screen.clear();
            tg.setForegroundColor(TextColor.ANSI.GREEN);
            tg.enableModifiers(SGR.BOLD);
            tg.putString(37,12, "ROUND " + game.getRound());
            screen.refresh();

            try{
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            display();
        }
    }


    public void win() throws IOException {
        if (game.getRound() == 5 && game.getP1kills() > game.getP2kills()) {
            screen.clear();
            tg.setForegroundColor(TextColor.ANSI.RED);
            tg.enableModifiers(SGR.BOLD);
            tg.putString(35, 12, "Player 1 Wins!");
            screen.refresh();
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            screen.clear();
            tg.setForegroundColor(TextColor.ANSI.RED);
            tg.enableModifiers(SGR.BOLD);
            tg.putString(35,12, "Player 2 Wins!");
            screen.refresh();
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        goBack();
    }

}





