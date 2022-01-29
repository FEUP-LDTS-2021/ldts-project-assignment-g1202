package com.dungeonboy.state;

import com.dungeonboy.Arena;
import com.dungeonboy.Game;
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
    void lose() {
    }

    @Test
    void win() {
    }

    @Test
    void levelUp() {
    }

    @Test
    void finalLevel() {
    }
}