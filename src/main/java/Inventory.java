package com.dungeonboy;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Inventory {

/*
    Terminal terminal;
    Screen screen;
    TextGraphics tg;
    Inventory inv;
    Game game;

    // construtor
    public Inventory() throws IOException { // construtor de Game
     this.terminal =  terminal;
     this.screen = screen;
     this.tg = tg;
    }
    public void openInv() throws IOException {
        screen.clear();
        KeyStroke keyPressed = terminal.readInput();
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);

    }
    public void closeInv() throws IOException {
        screen.close();
    }

    public void Invtest() throws IOException {
        screen.clear();
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(8, 2, "Inventory");

        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(53, 2, "Back to game: (U)");

        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(8, 10, "Current Items: ");

        screen.refresh();

        boolean keepRunning = true;

        while (keepRunning) {
            KeyStroke keyPressed = terminal.readInput();
            if (keyPressed.getKeyType() == KeyType.Character && keyPressed.getCharacter() == 'u') {
                game.survival();
            }

        }
    }
}

*/

}

