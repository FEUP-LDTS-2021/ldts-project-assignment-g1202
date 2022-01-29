package com.dungeonboy.state;

import com.dungeonboy.Arena;
import com.dungeonboy.Game;
import com.dungeonboy.Hp;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PvpGameStateTest {

    Game game;
    PvpGameState pvp;
    Screen screen;
    TextGraphics tg;

    @BeforeEach
    void setUp(){
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        game = Mockito.mock(Game.class);
        game.pvpArena = new Arena(80, 24);

        pvp = new PvpGameState(game);
        pvp.screen = screen;
        pvp.tg = tg;
    }

    @Test
    void display() throws IOException {
        pvp.display();

        Mockito.verify(tg, Mockito.atLeast(1)).setBackgroundColor(TextColor.ANSI.BLACK);
        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.DEFAULT);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(3, 1, "Player VS Player");
    }

    @Test
    void goForward() {}

    @Test
    void goBack() throws IOException{
        pvp.goBack();

        Mockito.verify(game, Mockito.atLeast(1)).changeState(new MenuGameState(game));
    }

    @Test
    void lose() throws IOException{
        game.pvpArena.getPlayer().setHitpoints(new Hp(0));
        pvp.lose();
        assertEquals(1, game.p2kills);
    }

    @Test
    void win() throws IOException{
        game.round = 5;
        game.p1kills = 3;
        game.p2kills = 2;
        pvp.win();

        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.RED);
        Mockito.verify(tg, Mockito.atLeast(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(30, 12, "Player 1 Wins!");
    }
}