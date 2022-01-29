package com.dungeonboy.state;

import com.dungeonboy.Arena;
import com.dungeonboy.Game;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SurvivalGameStateTest {

    Game game;
    SurvivalGameState surv;
    TextGraphics tg;
    Screen screen;

    @BeforeEach
    void setUp(){
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        game = Mockito.mock(Game.class);
        game.survArena = new Arena(80, 24);

        surv = new SurvivalGameState(game);
        surv.screen = screen;
        surv.tg = tg;
    }

    @Test
    void display() throws IOException {
        surv.display();

        Mockito.verify(tg, Mockito.atLeast(1)).setBackgroundColor(TextColor.ANSI.BLACK);
        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.DEFAULT);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(3, 1, "Survival");
    }

    @Test
    void goForward() {}

    @Test
    void goBack() throws IOException{
        surv.goBack();

        Mockito.verify(game, Mockito.atLeast(1)).changeState(new MenuGameState(game));
    }

    @Test
    void lose() throws IOException{
        surv.lose();

        Mockito.verify(game, Mockito.atLeast(1)).changeState(new ShopGameState(game));

        game.survArena.getPlayer().lostlife();
        game.survArena.getPlayer().lostlife();

        Mockito.verify(game, Mockito.atLeast(1)).changeState(new MenuGameState(game));
    }

    @Test
    void win() throws IOException{
        game.lvl = 2;
        surv.win();

        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.GREEN);
        Mockito.verify(tg, Mockito.atLeast(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(37,12, "LEVEL " + game.lvl);

        game.lvl = 3;
        surv.win();
        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.GREEN);
        Mockito.verify(tg, Mockito.atLeast(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(37,12, "LEVEL " + game.lvl);

    }

    @Test
    void levelUp() throws IOException{
        game.lvl = 2;
        surv.levelUp();

        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.GREEN);
        Mockito.verify(tg, Mockito.atLeast(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(37,12, "LEVEL " + game.lvl);
    }

    @Test
    void finalLevel() throws IOException{
        game.lvl = 3;
        surv.finalLevel();

        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.GREEN);
        Mockito.verify(tg, Mockito.atLeast(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(37,12, "LEVEL " + game.lvl);
    }
}