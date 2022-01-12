import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    Wall teste = new Wall(20,30);

    @BeforeEach

    @Test
    void wall_width() {
        assertEquals(20, teste.position.getX());
    }

    @Test
    void wall_height() {
        assertEquals(30, teste.position.getY());

    }

    @Test
    void wallSet_width() {
        teste.position.setX(50);
        assertEquals(50, teste.position.getX());
    }

    @Test
    void wallSet_height() {
        teste.position.setY(50);
        assertEquals(50, teste.position.getY());
    }

    @Test
    void draw() {

    }
}