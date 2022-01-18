import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    Game test = new Game();
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen testeScreen = new TerminalScreen(terminal);

    public MainTest() throws IOException {
    }

    @BeforeEach
    @Test
    void run() throws IOException {
       // assertTrue(test.run());
        // testeScreen.stopScreen();
    }
}
