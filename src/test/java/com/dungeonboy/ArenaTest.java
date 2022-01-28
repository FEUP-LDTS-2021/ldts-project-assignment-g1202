package com.dungeonboy;

import com.dungeonboy.Arena;
import com.dungeonboy.BadGuy;
import com.dungeonboy.Coins;
import com.dungeonboy.Player;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {

    Arena arena = new Arena(40, 40);
    Player test = new Player (10,10,100,3 );
    BadGuy bad = new BadGuy(10,10,100);
    Coins coinTest = new Coins(10,10);

/*
    @Test
    void draw() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        TextGraphics tg = screen.newTextGraphics();

        arena.draw(tg,1);

        assertEquals(TextColor.Factory.fromString("#906846"), tg.getBackgroundColor());
    }

    @Test
    void draw2() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        TextGraphics tg = screen.newTextGraphics();

        arena.draw2(tg);

        assertEquals(TextColor.Factory.fromString("#465690"), tg.getBackgroundColor());
    }

*/

    @Test
    void retrieveCoins() {
        assertTrue(coinTest.position.getX() ==  test.position.getX() && coinTest.position.getY() == test.position.getY());
    }

    @Test
    void damagePos() {
        assertTrue(test.position.equals(bad.position));
    }
}