import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;
import java.io.IOException;




public class Game {
    //Iniciar variaveis - Terminais e screen
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new TerminalScreen(terminal);
    TextGraphics tg = screen.newTextGraphics();


    public Game() throws IOException { // construtor de Game
        try {
            screen.startScreen(); // Iniciar o terminal

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Opção do modo survival
    public void survival() throws IOException{
        screen.clear();

        Arena arena = new Arena(80, 24);
        arena.draw(tg);
        tg.setBackgroundColor(TextColor.ANSI.BLACK); //texto do canto superior esq que indica o modo selecionado
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(3, 1, "Survival");

        screen.refresh();

        boolean keepRunning = true;

        while (keepRunning){
            KeyStroke keyPressed = terminal.readInput();
            if (keyPressed.getKeyType() == KeyType.Escape) {
                keepRunning = false;
                menu();
            }
        }
    }
  // Opção do modo PVP
    public void pvp() throws IOException{
        screen.clear();

        Arena arena = new Arena(80, 24);
        arena.draw(tg);
        tg.setBackgroundColor(TextColor.ANSI.BLACK); //texto do canto superior esq que indica o modo selecionado
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(3,1,"Player VS Player");

        screen.refresh();

        boolean keepRunning = true;

        while (keepRunning){
            KeyStroke keyPressed = terminal.readInput();
            if (keyPressed.getKeyType() == KeyType.Escape) {
                keepRunning = false;
                menu();
            }
        }
    }

    //Layout do menu principal

    public void menu() throws IOException{
        screen.clear();
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.putString(8,10, "Survival Mode");

        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(8,13, "Player VS Player Mode");

        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(53,5, "ArrowUp (Go UP)");

        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(53,7, "ArrowDown (Go Down)");

        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(53,3, "Press ESC to go back");

        screen.refresh();

        boolean keepRunning = true;
        boolean surv = true;

        while (keepRunning){
            KeyStroke keyPressed = terminal.readInput();

            switch (keyPressed.getKeyType()){
                case ArrowDown:
                    tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                    tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                    tg.putString(8,10, "Survival Mode");

                    tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);  // cor da selecao do tipo de jogo
                    tg.putString(8,13, "Player VS Player Mode");

                    screen.refresh();

                    surv = false;
                    break;

                case ArrowUp:
                    tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT); // cor da selecao do tipo de jogo
                    tg.putString(8,10, "Survival Mode");

                    tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                    tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                    tg.putString(8,13, "Player VS Player Mode");

                    screen.refresh();

                    surv = true;
                    break;
                case Enter:
                    keepRunning = false;
                    if (surv){
                        survival();
                    }
                    else{
                        pvp();
                    }
                    break;
                case Escape:
                    keepRunning = false;
                    run();


            }
        }
    }

    //Ciclo para manter terminal aberto ate receber alguma key que quebre

    public void run() throws IOException {

        boolean keepRunning = true;

        screen.clear();
        screen.setCursorPosition(null);
        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(30, 15,"Press ENTER to START");

        tg.setForegroundColor(TextColor.ANSI.WHITE);
        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.putString(35, 4,"DUNGEON BOY");


        screen.refresh();

        while (keepRunning) {
            KeyStroke keyPressed = terminal.pollInput();

            if (keyPressed != null) {
                switch (keyPressed.getKeyType()) {
                    case Escape:
                        keepRunning = false;
                        screen.stopScreen(); // se tiver no ecrã principal e carregar ESC, fecha o jogo
                        break;
                    case Enter:
                        menu();
                        break;
                }
            }
        }
        screen.stopScreen();

    }


}




