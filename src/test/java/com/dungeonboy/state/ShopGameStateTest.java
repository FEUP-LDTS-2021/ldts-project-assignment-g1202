package com.dungeonboy.state;

import com.dungeonboy.Arena;
import com.dungeonboy.Game;
import com.dungeonboy.Shop;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ShopGameStateTest {

    Game game;
    ShopGameState shop;
    TextGraphics tg;
    Screen screen;

    @BeforeEach
    void setUp() throws IOException{
        Terminal terminal = Mockito.mock(Terminal.class);
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        game = Mockito.mock(Game.class);
        game.survArena = new Arena(80, 24);
        game.shop = new Shop(screen, terminal);
        game.shop.tg = tg;

        shop = new ShopGameState(game);
        shop.screen = screen;
        shop.tg = tg;
    }

    @Test
    void display() throws IOException {
    }

    @Test
    void goForward() {}

    @Test
    void goBack() throws IOException{
        shop.goBack();

        Mockito.verify(game, Mockito.atLeast(1)).changeState(new SurvivalGameState(game));
    }

    @Test
    void lose() {}

    @Test
    void win() {}
}