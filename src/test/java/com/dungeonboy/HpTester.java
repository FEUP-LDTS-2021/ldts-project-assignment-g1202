package com.dungeonboy;

import com.dungeonboy.Hp;
import com.dungeonboy.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HpTester {

    @Test
    void getHp() {
        Player test = new Player(20,20, 30);
        test.hitpoints.getHp();
        assertEquals(30, test.hitpoints.getHp());
    }

    @Test
    void setHp() {
        Player test = new Player(20,20, 30 );
        test.hitpoints.setHp((new Hp(70).getHp()));
        assertEquals(70, test.hitpoints.getHp());
    }

    @Test
    void changeHp() {
        Player test = new Player (10,10,100);
        test.changeHp();
        assertEquals(90, test.hitpoints.getHp());
    }
}