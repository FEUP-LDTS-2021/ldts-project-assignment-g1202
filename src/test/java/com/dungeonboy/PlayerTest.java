package com.dungeonboy;

import com.dungeonboy.Arena;
import com.dungeonboy.Hp;
import com.dungeonboy.Player;
import com.dungeonboy.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.beans.PropertyChangeListenerProxy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player test = new Player(15,20, 100);
    Player test2 = new Player(35,20, 100);
    Position testePos = new Position(10,50);
    Hp testHitPoints  = new Hp(50);

    @Test
    void getCredit() {
        assertEquals(0, test.getCredit());
    }

    @Test
    void setCredit() {
        test.setCredit(50);
        assertEquals(50, test.getCredit());
    }

    @Test
    void changeCredit() {
        int change = test.getCredit()+1;
        assertEquals(1, change);
    }

    @Test
    void setHitpoints() {
        testHitPoints.setHp(100);
        assertEquals(100, testHitPoints.getHp());
    }

    @Test
    void getHitpoints() {
        assertEquals(50,testHitPoints.getHp());
    }

    @Test
    void draw() throws IOException {
        TextGraphics tg = Mockito.mock(TextGraphics.class);
        String color = "#FFFF33";
        String shape = "X";

        test.draw(tg,color,shape);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(color));
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(15, 20), shape);
    }

    @Test
    void drawPlayer2() throws IOException {
        TextGraphics tg = Mockito.mock(TextGraphics.class);
        String color = "#FF0000";
        String shape = "X";

        test2.draw(tg,color,shape);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(color));
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(35, 20), shape);
    }

    @Test
    void changeHp() {
        testHitPoints.setHp(testHitPoints.getHp()-10);
        assertEquals(40, testHitPoints.getHp());
    }

    @Test
    void lostlife() {
        int lifeTest = test.getLife()-1;
        assertEquals(2, lifeTest);
    }

    @Test
    void oneup() {
        int lifeTest = test.getLife()+1;
        assertEquals(4, lifeTest);
    }

    @Test
    void getLife() {
        assertEquals(3, test.getLife());
    }

    @Test
    void getPosition() {
        assertEquals(15, test.getPosition().getX());
        assertEquals(20, test.getPosition().getY());
    }

    @Test
    void setPosition() {
        test.setPosition(new Position(20, 11));

        assertEquals(20, test.getPosition().getX());
        assertEquals(11, test.getPosition().getY());
    }

    @Test
    void moving() {
        Arena arena = new Arena(20,20);

        //ArrowUp
        KeyStroke up = new KeyStroke(KeyType.ArrowUp);

        test.moving(up, arena);
        assertEquals(19, test.getPosition().getY());

        //ArrowDown
        KeyStroke down = new KeyStroke(KeyType.ArrowDown);

        test.moving(down, arena);
        assertEquals(20, test.getPosition().getY());

        //ArrowRight
        KeyStroke right = new KeyStroke(KeyType.ArrowRight);

        test.moving(right, arena);
        assertEquals(16, test.getPosition().getX());

        //ArrowLeft
        KeyStroke left = new KeyStroke(KeyType.ArrowLeft);

        test.moving(left, arena);
        assertEquals(15, test.getPosition().getX());
    }

    @Test
    void movingp2() {
        Arena arena = new Arena(20,20);

        //W
        Character w = 'w';
        KeyStroke wKey = new KeyStroke(w, false, false);

        test.movingp2(wKey, arena);
        assertEquals(19, test.getPosition().getY());

        //S
        Character s = 's';
        KeyStroke sKey = new KeyStroke(s, false, false);

        test.movingp2(sKey, arena);
        assertEquals(20, test.getPosition().getY());

        //D
        Character d = 'd';
        KeyStroke dKey = new KeyStroke(d, false, false);

        test.movingp2(dKey, arena);
        assertEquals(16, test.getPosition().getX());

        //A
        Character a = 'a';
        KeyStroke akey = new KeyStroke(a, false, false);

        test.movingp2(akey, arena);
        assertEquals(15, test.getPosition().getX());
    }


    @Test
    void noneAttack() {
        BadGuy bg = new BadGuy(5, 5, 100);
        test.setWeapon(new Weapon());

        test.noneAttack(bg);

        assertEquals(90, bg.hitpoints.getHp());
    }

    @Test
    void swordAttack() {
        BadGuy bg = new BadGuy(5, 5, 100);
        test.setWeapon(new Weapon(0, 5, "Sword"));

        test.swordAttack(bg);

        assertEquals(80, bg.hitpoints.getHp());
    }

    @Test
    void bowAttack() {
        BadGuy bg = new BadGuy(5, 5, 100);
        test.setWeapon(new Weapon(0, 10, "Bow"));

        test.bowAttack(bg);

        assertEquals(85, bg.hitpoints.getHp());
    }

    @Test
    void noneAttackPvP() {
        test.setWeapon(new Weapon());

        test.noneAttackPvP(test2);

        assertEquals(90, test2.hitpoints.getHp());
    }

    @Test
    void swordAttackPvP() {
        test.setWeapon(new Weapon(0, 5, "Sword"));

        test.swordAttackPvP(test2);

        assertEquals(80, test2.hitpoints.getHp());
    }

    @Test
    void bowAttackPvP() {
        test.setWeapon(new Weapon(0, 10, "Bow"));

        test.bowAttackPvP(test2);

        assertEquals(85, test2.hitpoints.getHp());
    }

    @Test
    void setWeapon() {
        test.setWeapon(new Weapon());
        assertEquals("Fists", test.getWeapon());
    }

    @Test
    void getWeapon() {
        assertEquals("Fists", test.getWeapon());

        test.setWeapon(new Weapon(0, 5, "Sword"));
        assertEquals("Sword", test.getWeapon());
    }

    @Test
    void setWeapons() {
        List<Weapon> w = new ArrayList<>();
        w.add(new Weapon());
        test.setWeapons(w);

        assertEquals(w, test.getWeapons());
    }

    @Test
    void getWeapons() {
        assertEquals(test.weapons, test.getWeapons());
    }
}