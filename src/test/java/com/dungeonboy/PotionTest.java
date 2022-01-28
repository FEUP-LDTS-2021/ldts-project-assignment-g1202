package com.dungeonboy;

import com.dungeonboy.Hp;
import com.dungeonboy.Potion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {

    @Test
    void getCost() {
        Potion potion1 = new Potion(2, new Hp(10), "10 HP");
        Potion potion2 = new Potion(5, 1, "1 Life");

        assertEquals(2, potion1.getCost());
        assertEquals(5, potion2.getCost());
    }

    @Test
    void getHp() {
        Potion potion1 = new Potion(2, new Hp(10), "10 HP");
        Potion potion2 = new Potion(2, new Hp(20), "10 HP");

        assertEquals(10, potion1.getHp().getHp());
        assertEquals(20, potion2.getHp().getHp());
    }

    @Test
    void getLife() {
        Potion potion1 = new Potion(5, 1, "1 Life");
        Potion potion2 = new Potion(10, 2, "2 Life");

        assertEquals(1, potion1.getLife());
        assertEquals(2, potion2.getLife());
    }

    @Test
    void getName() {
        Potion potion1 = new Potion(2, new Hp(10), "10 HP");
        Potion potion2 = new Potion(5, 1, "1 Life");

        assertEquals("10 HP", potion1.getName());
        assertEquals("1 Life", potion2.getName());
    }

    @Test
    void setCost() {
        Potion potion1 = new Potion(2, new Hp(10), "10 HP");
        Potion potion2 = new Potion(5, 1, "1 Life");

        potion1.setCost(4);
        potion2.setCost(0);

        assertEquals(4, potion1.getCost());
        assertEquals(0, potion2.getCost());
    }

    @Test
    void setHp() {
        Potion potion1 = new Potion(2, new Hp(10), "10 HP");
        Potion potion2 = new Potion(2, new Hp(20), "10 HP");

        potion1.setHp(new Hp(20));
        potion2.setHp(new Hp(0));

        assertEquals(20, potion1.getHp().getHp());
        assertEquals(0, potion2.getHp().getHp());
    }

    @Test
    void setLife() {
        Potion potion1 = new Potion(5, 1, "1 Life");
        Potion potion2 = new Potion(10, 2, "2 Life");

        potion1.setLife(0);
        potion2.setLife(3);

        assertEquals(0, potion1.getLife());
        assertEquals(3, potion2.getLife());
    }

    @Test
    void setName() {
        Potion potion1 = new Potion(2, new Hp(10), "10 HP");
        Potion potion2 = new Potion(5, 1, "1 Life");

        potion1.setName("1 HP");
        potion2.setName("3 Life");

        assertEquals("1 HP", potion1.getName());
        assertEquals("3 Life", potion2.getName());
    }
}