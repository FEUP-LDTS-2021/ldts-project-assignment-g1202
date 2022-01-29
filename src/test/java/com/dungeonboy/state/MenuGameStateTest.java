package com.dungeonboy.state;

import com.dungeonboy.Game;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InvalidObjectException;

import static org.junit.jupiter.api.Assertions.*;

class MenuGameStateTest {

    Game game;
    MenuGameState menu;
    TextGraphics tg;
    Screen screen;

    @BeforeEach
    void setUp(){
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        game = Mockito.mock(Game.class);

        menu = new MenuGameState(game);
        menu.screen = screen;
        menu.tg = tg;
    }

    @Test
    void display() throws IOException {
        menu.display();

        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.DEFAULT);
        Mockito.verify(tg, Mockito.atLeast(1)).setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(8, 10, "Survival Mode");
    }

    @Test
    void goForward() throws IOException {
    }

    @Test
    void goBack() throws IOException{
        menu.goBack();

        Mockito.verify(game, Mockito.atLeast(1)).changeState(new InitialGameState(game));
    }

    @Test
    void lose() {}

    @Test
    void win() {}
}