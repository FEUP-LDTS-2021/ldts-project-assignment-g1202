import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BadGuyTest {


    BadGuy badGuy1 = new BadGuy(10, 11, 100);
    BadGuy badGuy2 = new BadGuy(10, 9, 100);
    BadGuy badGuy3 = new BadGuy(11, 10, 100);
    BadGuy badGuy4 = new BadGuy(9, 10, 100);

    @Test
    void draw() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        TextGraphics tg = screen.newTextGraphics();

        badGuy1.draw(tg);
        badGuy2.draw(tg);

        assertEquals("E", tg.getCharacter(10, 11).getCharacterString());
        assertEquals("E", tg.getCharacter(10,9).getCharacterString());
    }

    @Test
    void damagePlayer(){
        Player player = new Player(10, 10, 100, 3);

        badGuy1.damagePlayer(player);
        assertEquals(90, player.getHitpoints().getHp());

        badGuy2.damagePlayer(player);
        assertEquals(80, player.getHitpoints().getHp());

        badGuy3.damagePlayer(player);
        assertEquals(70, player.getHitpoints().getHp());

        badGuy4.damagePlayer(player);
        assertEquals(60, player.getHitpoints().getHp());
    }

}
