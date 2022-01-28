package com.dungeonboy;

import com.dungeonboy.Arena;
import com.dungeonboy.BadGuy;
import com.dungeonboy.Coins;
import com.dungeonboy.Player;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.Text;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {

    Arena arena = new Arena(40, 40);
    Player test = new Player (10,10,100,3 );
    BadGuy bad = new BadGuy(10,10,100);
    Coins coinTest = new Coins(10,10);

    @Test
    void draw() throws IOException {
        TextGraphics tg = Mockito.mock(TextGraphics.class);

        arena.draw(tg, 1);

        Mockito.verify(tg, Mockito.atLeast(1)).setBackgroundColor(TextColor.Factory.fromString("#906846"));
        Mockito.verify(tg, Mockito.atLeast(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(arena.getWidth(), arena.getHeight()), ' ');

        arena.draw(tg, 2);

        Mockito.verify(tg, Mockito.atLeast(1)).setBackgroundColor(TextColor.Factory.fromString("#6495ED"));
        Mockito.verify(tg, Mockito.atLeast(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(arena.getWidth(), arena.getHeight()), ' ');
    }

    @Test
    void draw2() throws IOException {
        TextGraphics tg = Mockito.mock(TextGraphics.class);

        arena.draw2(tg);

        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#465690"));
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(arena.getWidth(), arena.getHeight()), ' ');
    }

    @Test
    void retrieveCoins() {
        assertTrue(coinTest.position.getX() ==  test.position.getX() && coinTest.position.getY() == test.position.getY());
    }

    @Test
    void damagePos() {
        assertTrue(test.position.equals(bad.position));
    }
}