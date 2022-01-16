import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    Wall teste = new Wall(20,23);

    @BeforeEach

    @Test
    void wall_width() {
        assertEquals(20, teste.position.getX());
    }

    @Test
    void wall_height() {
        assertEquals(23, teste.position.getY());

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
    void draw() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        TextGraphics tg = screen.newTextGraphics();

        teste.draw(tg);

        assertTrue(tg.getCharacter(20, 23).isBold());
        assertEquals(TextColor.Factory.fromString("#000000"), tg.getForegroundColor());
        assertEquals("@", tg.getCharacter(20,23).getCharacterString());

    }
}