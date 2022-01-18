package com.dungeonboy;

import com.dungeonboy.Coins;
import com.dungeonboy.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CoinsTest {

    Coins coin = new Coins(19, 10);
    Position test = new Position(50, 100);
    Position testeFinal = new Position(60, 90);

    @Test
    void setPosition() {
        test.setX(60);
        test.setY(90);
        assertEquals(test.getX(), testeFinal.getX());
        assertEquals(test.getY(), testeFinal.getY());
    }

    @Test
    void draw() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        TextGraphics tg = screen.newTextGraphics();

        coin.draw(tg);
        assertEquals(TextColor.Factory.fromString("#999933"), tg.getForegroundColor());
        assertTrue(tg.getCharacter(19, 10).isBold());
        assertEquals("$", tg.getCharacter(19,10).getCharacterString());
    }
}