package com.dungeonboy.state;

import com.dungeonboy.Game;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InitialGameStateTest {

    Game game;
    InitialGameState initial;
    TextGraphics tg;
    Screen screen;

    @BeforeEach
    void setUp(){
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        game = Mockito.mock(Game.class);

        initial = new InitialGameState(game);
        initial.screen = screen;
        initial.tg = tg;
    }

    @Test
    void display() throws IOException {
        initial.display();

        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.RED);
        Mockito.verify(tg, Mockito.atLeast(1)).setBackgroundColor(TextColor.ANSI.DEFAULT);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(30, 20, "Press ENTER to START");
    }

    @Test
    void goForward() throws IOException{
        initial.goForward();

        Mockito.verify(game, Mockito.atLeast(1)).changeState(new MenuGameState(game));
    }

    @Test
    void goBack() throws IOException{
        initial.goBack();

        Mockito.verify(screen, Mockito.times(1)).stopScreen();
    }

    @Test
    void lose() {}

    @Test
    void win() {}
}