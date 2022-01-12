import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinsTest {

    Position test = new Position(50, 100);
    Position testeFinal = new Position(60, 90);

    @BeforeEach

    @Test
    void setPosition() {
        test.setX(60);
        test.setY(90);
        assertEquals(test.getX(), testeFinal.getX());
        assertEquals(test.getY(), testeFinal.getY());
    }

    @Test
    void draw() {

    }
}