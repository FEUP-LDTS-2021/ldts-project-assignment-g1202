package com.dungeonboy;

import com.dungeonboy.*;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    Terminal terminal;
    Screen screen;
    TextGraphics tg;
    Shop shop;

    @BeforeEach
    void setup() throws IOException{
        terminal = Mockito.mock(Terminal.class);
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        shop = new Shop(screen, terminal);
        shop.tg = tg;
    }

    @Test
    void goDown() throws IOException{
        shop.goDown(0,shop.tg);
        Mockito.verify(tg, Mockito.atLeast(1)).setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.DEFAULT);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(9, 11, shop.getWeapons().get(0).getType() + "(" + String.valueOf(shop.getWeapons().get(0).getRange()) + ")");

        shop.goDown(1,shop.tg);
        Mockito.verify(tg, Mockito.atLeast(1)).setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.DEFAULT);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(9, 11 + 2, shop.getWeapons().get(1).getType() + "(" + String.valueOf(shop.getWeapons().get(1).getRange()) + ")");

        shop.goDown(4, shop.tg);
        Mockito.verify(tg, Mockito.atLeast(1)).setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.DEFAULT);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(45, 11 + (2*(4-2)), shop.getPotions().get(4-2).getName());
    }

    @Test
    void goUp() throws IOException{
        shop.goUp(0, shop.tg);
        Mockito.verify(tg, Mockito.atLeast(1)).setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.DEFAULT);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(9, 11, shop.getWeapons().get(0).getType() + "(" + String.valueOf(shop.getWeapons().get(0).getRange()) + ")");

        shop.goUp(1, shop.tg);
        Mockito.verify(tg, Mockito.atLeast(1)).setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.DEFAULT);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(9, 11 + 2, shop.getWeapons().get(1).getType() + "(" + String.valueOf(shop.getWeapons().get(1).getRange()) + ")");

        shop.goUp(2, shop.tg);
        Mockito.verify(tg, Mockito.atLeast(1)).setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        Mockito.verify(tg, Mockito.atLeast(1)).setForegroundColor(TextColor.ANSI.DEFAULT);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(45, 11, shop.getPotions().get(0).getName());
    }

    @Test
    void canBuy() throws IOException {
        Weapon w1= new Weapon(2, 5, "Sword");
        Weapon w2= new Weapon(4, 10, "Arrow");
        Potion p1 = new Potion(3, new Hp(10), "10 HP");
        shop.weapons.set(0, w1);
        shop.weapons.set(1, w2);
        shop.potions.set(0, p1);

        Player p = new Player(10,10,100,3);
        p.setCredit(3);

        assertTrue(shop.canBuy(0, p));
        assertFalse(shop.canBuy(1, p));
        assertTrue(shop.canBuy(2, p));
    }

    @Test
    void select() throws IOException{
        Player player = new Player(10,10,100, 3);
        player.setCredit(4);

        shop.select(0, shop.tg, player);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(9, 4, "Adquired: " + shop.getWeapons().get(0).getType());

        shop.select(6, shop.tg, player);
        Mockito.verify(tg, Mockito.atLeast(1)).putString(9, 4, "Not enough coins!");
    }

    @Test
    void show() {

    }

    @Test
    void getWeapons() {
        assertEquals(shop.weapons, shop.getWeapons());
    }

    @Test
    void getPotions() {
        assertEquals(shop.potions, shop.getPotions());
    }
}