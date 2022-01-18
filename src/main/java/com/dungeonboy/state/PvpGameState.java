package com.dungeonboy.state;

import com.dungeonboy.Game;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

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
        screen.clear();

        game.getPvpArena().draw2(tg);
        tg.setBackgroundColor(TextColor.ANSI.BLACK); //texto do canto superior esq que indica o modo selecionado
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(3, 1, "Player VS Player");

        //String Round
        tg.putString(37, 1, "Round:  " + game.getRound());

        //Strings com HP
        tg.putString(2, 22, "P1 HP: " + game.getPvpArena().getPlayer().getHitpoints().getHp());  // falta concatenar com a variavel que recebe os valores corretos
        tg.putString(2, 23, "P2 HP: " + game.getPvpArena().getPlayer2().getHitpoints().getHp());  // falta concatenar com a variavel que recebe os valores corretos

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

    }

    public void win(){

    }
}
