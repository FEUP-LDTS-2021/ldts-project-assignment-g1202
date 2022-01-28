package com.dungeonboy.state;

import com.dungeonboy.Game;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class MenuGameState implements GameState{

    Game game;
    Screen screen;
    TextGraphics tg;

    public MenuGameState(Game game){
        this.game = game;
        screen = game.getScreen();
        tg = screen.newTextGraphics();
    }

    public void display() throws IOException{

        screen.clear();
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.putString(8, 10, "Survival Mode");

        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(8, 13, "Player VS Player Mode");

        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(53, 5, "ArrowUp (Go UP)");

        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(53, 7, "ArrowDown (Go Down)");

        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(53, 3, "Press ESC to go back");

        screen.refresh();
    }

    public void goForward() throws IOException{
        if (tg.getCharacter(8, 10).getBackgroundColor() == TextColor.ANSI.BLACK_BRIGHT){
            game.changeState(new SurvivalGameState(game));

            screen.clear();
            tg.setForegroundColor(TextColor.ANSI.GREEN);
            tg.enableModifiers(SGR.BOLD);
            tg.putString(37,12, "LEVEL " + game.getLvl());
            screen.refresh();

            try{
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            game.survival();
        }
        else if (tg.getCharacter(8, 13).getBackgroundColor() == TextColor.ANSI.BLACK_BRIGHT){
            game.changeState(new PvpGameState(game));

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
            game.pvp();
        }
    }

    public void goBack() throws IOException{
        game.changeState(new InitialGameState(game));
        game.run();
    }

    public void lose(){}

    public void win(){}
}
