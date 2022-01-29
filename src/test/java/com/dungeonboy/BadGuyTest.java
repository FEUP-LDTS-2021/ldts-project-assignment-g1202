package com.dungeonboy;

import com.dungeonboy.BadGuy;
import com.dungeonboy.Player;
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

class BadGuyTest {

    BadGuy badGuy1 = new BadGuy(10, 11, 100);
    BadGuy badGuy2 = new BadGuy(10, 9, 100);
    BadGuy badGuy3 = new BadGuy(11, 10, 100);
    BadGuy badGuy4 = new BadGuy(9, 10, 100);

    @Test
    void draw() throws IOException {
        TextGraphics tg = Mockito.mock(TextGraphics.class);

        badGuy1.draw(tg);
        badGuy2.draw(tg);

        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        Mockito.verify(tg, Mockito.atLeast(1)).putString(new TerminalPosition(badGuy1.getPosition().getX(), badGuy1.getPosition().getY()),"E");
    }

    @Test
    void damagePlayer(){
        Player player = new Player(10, 10, 100);

        badGuy1.damagePlayer(player);
        assertEquals(90, player.getHitpoints().getHp());

        badGuy2.damagePlayer(player);
        assertEquals(80, player.getHitpoints().getHp());

        badGuy3.damagePlayer(player);
        assertEquals(70, player.getHitpoints().getHp());

        badGuy4.damagePlayer(player);
        assertEquals(60, player.getHitpoints().getHp());
    }

    @Test
    void getPosition() {
        assertEquals(badGuy1.position, badGuy1.getPosition());
        assertEquals(badGuy2.position, badGuy2.getPosition());
    }

    @Test
    void changeHp() {
        badGuy1.changeHp(10);
        assertEquals(90, badGuy1.hitpoints.getHp());

        badGuy2.changeHp(20);
        assertEquals(80, badGuy2.hitpoints.getHp());
    }

    @Test
    void drawBoss() {
    }
}