import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player test = new Player(15,20, 100, 3);
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
    void draw() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        TextGraphics tg = screen.newTextGraphics();

        test.draw(tg);

        assertEquals("X", tg.getCharacter(15, 20).getCharacterString());
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
        /* //ArrowUp
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

        */
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
    void hitsword() {
        testePos.setY(testePos.getY()+5);
        assertEquals(55, testePos.getY());
    }
}
