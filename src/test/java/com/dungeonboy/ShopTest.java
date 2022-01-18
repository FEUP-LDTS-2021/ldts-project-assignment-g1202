package com.dungeonboy;

import com.dungeonboy.*;
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

class ShopTest {
    Terminal terminal;
    Screen screen;
    TextGraphics tg;

    @Test
    void goDown() throws IOException{
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        Shop shop = new Shop(screen, terminal);
        shop.goDown(0,shop.tg);
        assertEquals(TextColor.ANSI.BLACK_BRIGHT, shop.tg.getCharacter(9,11).getBackgroundColor());

        shop.goDown(1,shop.tg);
        assertEquals(TextColor.ANSI.BLACK_BRIGHT, shop.tg.getCharacter(9, 13).getBackgroundColor());

        shop.goDown(4, shop.tg);
        assertEquals(TextColor.ANSI.BLACK_BRIGHT, shop.tg.getCharacter(45, 15).getBackgroundColor());
    }

    @Test
    void goUp() throws IOException{
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        Shop shop = new Shop(screen, terminal);

        shop.goUp(0, shop.tg);
        assertEquals(TextColor.ANSI.BLACK_BRIGHT, shop.tg.getCharacter(9,11).getBackgroundColor());

        shop.goUp(1, shop.tg);
        assertEquals(TextColor.ANSI.BLACK_BRIGHT, shop.tg.getCharacter(9, 13).getBackgroundColor());

        shop.goUp(2, shop.tg);
        assertEquals(TextColor.ANSI.BLACK_BRIGHT, shop.tg.getCharacter(45,11).getBackgroundColor());
    }

    @Test
    void canBuy() throws IOException {
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        Shop shop = new Shop(screen, terminal);

        Weapon w1= new Weapon(2, 5, "Sword");
        Weapon w2= new Weapon(4, 10, "Arrow");
        Potion p1 = new Potion(3, new Hp(10), "10 HP");
        shop.weapons.set(0, w1);
        shop.weapons.set(1, w2);
        shop.potions.set(0, p1);

        Player p = new Player(10,10,100,3);
        p.setCredit(3);

        assertEquals(true, shop.canBuy(0, p));
        assertEquals(false, shop.canBuy(1, p));
        assertEquals(true, shop.canBuy(2, p));
    }

    @Test
    void select() throws IOException{
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        Shop shop = new Shop(screen, terminal);

        Player player = new Player(10,10,100, 3);
        player.setCredit(4);

        shop.select(0, shop.tg, player);
        assertEquals("A", shop.tg.getCharacter(9,4).getCharacterString());

        shop.select(6, shop.tg, player);
        assertEquals("N", shop.tg.getCharacter(9,4).getCharacterString());
    }

    @Test
    void show() throws IOException {
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        tg = screen.newTextGraphics();

        Shop shop = Mockito.mock(Shop.class);
        shop.screen = screen;
        shop.terminal = terminal;
        shop.tg = tg;

        Game game = new Game();
        game.shop = shop;
        game.survArena = new Arena(0,0);
        game.survArena.player = new Player(10,10, 0, 3);

        game.shop.show(game.survArena.player);

        Mockito.verify(shop, Mockito.times(1)).show(game.survArena.player);
    }
}