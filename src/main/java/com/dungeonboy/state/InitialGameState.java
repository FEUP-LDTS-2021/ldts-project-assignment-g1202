package com.dungeonboy.state;

import com.dungeonboy.Game;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class InitialGameState implements GameState{
    Game game;
    Screen screen;
    TextGraphics tg;

    public InitialGameState(Game game){
        this.game = game;
        screen = game.getScreen();
        tg = game.getTg();
    }

    public void display() throws IOException{
        screen.clear();
        screen.setCursorPosition(null);

        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(30, 20, "Press ENTER to START");


        tg.setForegroundColor(TextColor.ANSI.WHITE);
        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.putString(35, 4, "DUNGEON BOY");

        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.putString(68, 1, "EXIT (ESC)");

        screen.refresh();
    }

    public void goForward() throws IOException{
        game.changeState(new MenuGameState(game));
        game.menu();
    }

    public void goBack() throws IOException{
        screen.stopScreen();
    }

    public void lose(){}

    public void win(){}
}
