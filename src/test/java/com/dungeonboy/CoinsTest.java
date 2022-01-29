package com.dungeonboy;

import com.dungeonboy.Coins;
import com.dungeonboy.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        TextGraphics tg = Mockito.mock(TextGraphics.class);

        coin.draw(tg);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#999933"));
        Mockito.verify(tg, Mockito.atLeast(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(coin.getPosition().getX(), coin.getPosition().getY()), "$");
    }
}