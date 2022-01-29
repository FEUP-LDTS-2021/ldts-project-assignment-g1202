package com.dungeonboy;

import com.dungeonboy.Wall;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    Wall teste = new Wall(20,23);

    @BeforeEach

    @Test
    void wall_width() {
        assertEquals(20, teste.getPosition().getX());
    }

    @Test
    void wall_height() {
        assertEquals(23, teste.getPosition().getY());

    }

    @Test
    void wallSet_width() {
        teste.getPosition().setX(50);
        assertEquals(50, teste.getPosition().getX());
    }

    @Test
    void wallSet_height() {
        teste.getPosition().setY(50);
        assertEquals(50, teste.getPosition().getY());
    }

    @Test
    void draw() throws IOException {
        TextGraphics tg = Mockito.mock(TextGraphics.class);

        teste.draw(tg);

        Mockito.verify(tg, Mockito.atLeast(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(teste.getPosition().getX(), teste.getPosition().getY()), "@");
    }
}