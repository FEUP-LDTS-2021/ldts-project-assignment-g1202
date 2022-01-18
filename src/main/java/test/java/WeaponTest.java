import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeaponTest {

    Weapon weapon1 = new Weapon(5, 5, "Sword");
    Weapon weapon2 = new Weapon(0, 0, "None");

    @Test
    void getCost() {
        assertEquals(5, weapon1.getCost());
        assertEquals(0, weapon2.getCost());
    }

    @Test
    void getRange() {
        assertEquals(5, weapon1.getRange());
        assertEquals(0, weapon2.getRange());
    }

    @Test
    void getType() {
        assertEquals("Sword", weapon1.getType());
        assertEquals("None", weapon2.getType());
    }

    @Test
    void setCost() {
        weapon1.setCost(10);
        weapon2.setCost(1);

        assertEquals(10, weapon1.getCost());
        assertEquals(1, weapon2.getCost());
    }

    @Test
    void setRange() {
        weapon1.setRange(0);
        weapon2.setRange(10);

        assertEquals(0, weapon1.getRange());
        assertEquals(10, weapon2.getRange());
    }

    @Test
    void setType() {
        weapon1.setType("Arrow");
        weapon2.setType("");

        assertEquals("Arrow", weapon1.getType());
        assertEquals("", weapon2.getType());
    }
}
