import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    Weapon testCost  = new Weapon ( 10, 5, "Sword");

    @BeforeEach


    @Test
    void getCost() {
        assertEquals(10, testCost.getCost());
    }

    @Test
    void getRange() {
        assertEquals(5, testCost.getRange());
    }

    @Test
    void getType() {
        assertEquals("Sword", testCost.getType());
    }

    @Test
    void setCost() {
        testCost.setCost(20);
        assertEquals(20, testCost.getCost());
    }

    @Test
    void setRange() {
        testCost.setRange(50);
        assertEquals(50, testCost.getRange());
    }

    @Test
    void setType() {
        testCost.setType("Bow");
        assertEquals("Bow", testCost.getType());
    }
}
