import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {

    Player test = new Player (10,10,100,3 );
    BadGuy bad = new BadGuy(10,10,100);
    Coins coinTest = new Coins(10,10);


    @Test
    void draw() {
    }

    @Test
    void draw2() {
    }

    @Test
    void retrieveCoins() {
        assertTrue(coinTest.position.getX() ==  test.position.getX() && coinTest.position.getY() == test.position.getY());
    }

    @Test
    void damagePos() {
        assertTrue(test.position.equals(bad.position));
    }
}