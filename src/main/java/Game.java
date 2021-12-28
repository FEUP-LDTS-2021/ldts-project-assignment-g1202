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
import java.io.IOException;
import java.util.Scanner;


public class Game {
    //Iniciar variaveis - Terminais e screen
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new TerminalScreen(terminal);
    TextGraphics tg = screen.newTextGraphics();
    private Object Character;

    public Game() throws IOException { // construtor de Game
        try {
            screen.startScreen(); // start


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Ciclo para manter terminal aberto ate receber alguma key que quebre

    public void run() throws IOException {

        boolean keepRunning = true;
        StringBuilder sb = new StringBuilder();

        screen.clear();
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(30, 15,"Press ENTER to START");

        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(35, 4,"CAVE BOYYYY");
        screen.refresh();

        while (keepRunning) {
            KeyStroke keyPressed = terminal.pollInput();

            if (keyPressed != null) {
                switch (keyPressed.getKeyType()) {
                    case Escape:
                        keepRunning = false;
                        System.out.println("Exiting...");
                        break;
                    case Enter:
                        System.out.println("Enter");
                        screen.clear();
                        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                        tg.putString(8,10, "Survival Mode");

                        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                        tg.putString(8,13, "Player VS Player Mode");

                        screen.refresh();
                        sb = new StringBuilder();
                        break;
                    case ArrowDown:
                        System.out.println("baixo");
                        break;
                    case ArrowLeft:
                        System.out.println("Esq");
                        break;
                    case ArrowRight:
                        System.out.println("Drt");
                        break;
                 /*  case Character:
                      if(Character == 'x'){
                          System.out.println("Carreguei no x");
                      }
                       // break;
                   */ //case (keyPressed.getKeyType() == KeyType.Character && keyPressed.getCharacter() == 'x')
                }

            }

        }
        //screen.refresh();
        //screen.readInput(); // read users input
        screen.stopScreen();
    }


}




