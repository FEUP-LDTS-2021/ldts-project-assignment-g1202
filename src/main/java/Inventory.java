package com.dungeonboy;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

        Terminal terminal;
        Screen screen;
        TextGraphics tg;

        // construtor
        public Inventory(Screen screen, Terminal terminal) throws IOException {
            this.screen = screen;
            this.terminal = terminal;
            this.tg = screen.newTextGraphics();


        }


        public void openInv() throws IOException {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);

            tg.putString(9, 11, "TESTE");

        }
}




