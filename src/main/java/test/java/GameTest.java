import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class GameTest {

    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new TerminalScreen(terminal);
    TextGraphics tg = screen.newTextGraphics();
    Arena survArena = new Arena(80, 24);

    GameTest() throws IOException {
    }

    @BeforeEach

    @Test
    void survival() {

    }

    @Test
    void pvp() {

    }

    @Test
    void menu() {

    }

    @Test
    void run() {

    }
}