package com.dungeonboy;

import com.dungeonboy.Arena;
import com.dungeonboy.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    Position test = new Position(20,10);         // heroi
    Arena testeArena = new Arena(25, 50); // arena criada

    @BeforeEach

    @Test
    void getX() {
        assertEquals(20, test.getX());
    }

    @Test
    void getY() {
        assertEquals(10, test.getY());
    }

    @Test
    void setX() {
        test.setX(70);
        assertTrue( test.getX() == 70);
    }

    @Test
    void setY() {
        test.setY(30);
        assertTrue( test.getY() == 30);

    }

    @Test
    void moveUp() {
        test.setY(test.getY() - 1);
        assertEquals(9, test.getY());
    }

    @Test
    void moveDown() {
        test.setY(test.getY() + 1);
        assertEquals(11, test.getY());
    }

    @Test
    void moveLeft() {
        test.setX(test.getX() - 1);
        assertEquals(19, test.getX());
    }

    @Test
    void moveRight() {
        test.setX(test.getX() + 1);
        assertEquals(21, test.getX());
    }

    @Test
    void canMoveLeft() {
        int width = testeArena.getWidth() -1;
        assertTrue(width != 0);
    }

    @Test
    void canMoveRight() {
        int width = testeArena.getWidth()+1;
        assertTrue(width != testeArena.getWall_width());
    }

    @Test
    void canMoveUp() {
        int height = testeArena.getHeight()-1;
        assertTrue(height != testeArena.getWall_height() - (testeArena.wall_height - 2 ));
    }

    @Test
    void canMoveDown() {
        int height = testeArena.getHeight() +1 ;
        assertTrue(height != testeArena.getWall_height());

    }

    @Test
    void testEquals() {
        assertTrue(test.equals(new Position(20,10)));
    }
}
