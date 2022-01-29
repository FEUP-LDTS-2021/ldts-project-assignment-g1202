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
import java.util.ArrayList;
import java.util.List;

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

    @Test
    void setCoins() {
        List<Coins> c = new ArrayList<>();
        c.add(new Coins(4,15));
        arena.setCoins(c);

        assertEquals(c, arena.getCoins());
    }

    @Test
    void setBaddies() {
        List<BadGuy> bg = new ArrayList<>();
        bg.add(new BadGuy(20, 4, 100));
        arena.setBaddies(bg);

        assertEquals(bg, arena.getBaddies());
    }

    @Test
    void getBaddies() {
        List<BadGuy> bg = new ArrayList<>();
        bg.add(new BadGuy(20, 4, 100));
        arena.setBaddies(bg);

        assertEquals(bg, arena.getBaddies());
    }

    @Test
    void getWidth() {
        assertEquals(40, arena.getWidth());
    }

    @Test
    void getHeight() {
        assertEquals(40, arena.getHeight());
    }

    @Test
    void getWall_height() {
        assertEquals(arena.wall_height, arena.getWall_height());
    }

    @Test
    void getWall_width() {
        assertEquals(arena.wall_width, arena.getWall_width());
    }

    @Test
    void getPlayer() {
        assertEquals(arena.player, arena.getPlayer());
    }

    @Test
    void getPlayer2() {
        assertEquals(arena.player2, arena.getPlayer2());
    }

    @Test
    void damageEnemy() {
        BadGuy bg1 = new BadGuy(12, 10, 100);
        List<BadGuy> bg = new ArrayList<>();
        bg.add(bg1);

        arena.setBaddies(bg);
        arena.player.setWeapon(new Weapon());
        arena.damageEnemy();
        assertEquals(90, bg1.hitpoints.getHp());

        arena.player.setWeapon(new Weapon(0, 5, "Sword"));
        arena.damageEnemy();
        assertEquals(70, bg1.hitpoints.getHp());

        arena.player.setWeapon(new Weapon(0, 10, "Bow"));
        arena.damageEnemy();
        assertEquals(55, bg1.hitpoints.getHp());
    }

    @Test
    void damagePlayer2() {
        arena.player2.setPosition(new Position(12, 10));

        arena.player.setWeapon(new Weapon());
        arena.damagePlayer2();
        assertEquals(90, arena.player2.getHitpoints().getHp());

        arena.player.setWeapon(new Weapon(0, 5, "Sword"));
        arena.damagePlayer2();
        assertEquals(70, arena.player2.getHitpoints().getHp());

        arena.player.setWeapon(new Weapon(0, 10, "Bow"));
        arena.damagePlayer2();
        assertEquals(55, arena.player2.getHitpoints().getHp());
    }

    @Test
    void damagePlayer1() {
        arena.player.setPosition(new Position(58, 10));

        arena.player2.setWeapon(new Weapon());
        arena.damagePlayer1();
        assertEquals(90, arena.player.getHitpoints().getHp());

        arena.player2.setWeapon(new Weapon(0, 5, "Sword"));
        arena.damagePlayer1();
        assertEquals(70, arena.player.getHitpoints().getHp());

        arena.player2.setWeapon(new Weapon(0, 10, "Bow"));
        arena.damagePlayer1();
        assertEquals(55, arena.player.getHitpoints().getHp());
    }

    @Test
    void createCoins() {
        assertEquals(2, arena.createCoins().size());
    }

    @Test
    void createBaddies() {
        assertEquals(4, arena.createBaddies().size());
    }

    @Test
    void getCoins() {
        List<Coins> c = new ArrayList<>();
        c.add(new Coins(4,15));
        arena.setCoins(c);

        assertEquals(c, arena.getCoins());
    }
}