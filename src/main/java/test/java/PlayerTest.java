import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player test = new Player(15,40, 100, 3);
    Position testePos = new Position(10,50);
    Hp testHitPoints  = new Hp(50);


    @BeforeEach

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
    void draw() {
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
        testePos.getX();
        testePos.getY();
        assertEquals(10, testePos.getX());
        assertEquals(50, testePos.getY());
    }

    @Test
    void setPosition() {
        testePos.setX(20);
        testePos.setY(60);
        assertEquals(20, testePos.getX());
        assertEquals(60, testePos.getY());
    }

    @Test
    void moving() {
        //ArrowUp
        testePos.setY(testePos.getY() -1);
        assertEquals(49, testePos.getY());

        //ArrowDown
        testePos.setY(testePos.getY() +1);
        assertEquals(50, testePos.getY());

        //ArrowLeft
        testePos.setX(testePos.getX() -1);
        assertEquals(9, testePos.getX());

        //ArrowRight
        testePos.setX(testePos.getX() +1);
        assertEquals(10, testePos.getX());

    }

    @Test
    void movingp2() {

    }

    @Test
    void hitsword() {
        testePos.setY(testePos.getY()+5);
        assertEquals(55, testePos.getY());
    }
}
