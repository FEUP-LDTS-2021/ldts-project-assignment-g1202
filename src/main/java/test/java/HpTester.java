import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class HpTester {



    @Test
    void getHp() {
        Player test = new Player(20,20, 30,3 );
        test.getHitpoints();
        assertEquals(30, test.getHitpoints().getHp());
    }

    @Test
    void setHp() {
        Player test = new Player(20,20, 30,3 );
        test.setHitpoints(new Hp (70));
        assertEquals(70, test.getHitpoints().getHp());
    }

    @Test
    void changeHp() {
        Player test = new Player (10,10,100,3);
        test.changeHp();
        assertEquals(90, test.getHitpoints().getHp());
    }
}