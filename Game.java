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



public class Game {
    //Iniciar variaveis - Terminais e screen
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new TerminalScreen(terminal);
    TextGraphics tg = screen.newTextGraphics();
    int lvl = 0;
    String arma = "Riffle test";
    int p1kills, p2kills, round = 0;


    public Game() throws IOException { // construtor de Game
        try {
            screen.startScreen(); // Iniciar o terminal

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Opção do modo survival
    public void survival() throws IOException {
        screen.clear();
        Arena arena = new Arena(80, 24);
        boolean keepRunning = true;

            while (keepRunning) {
                arena.draw(tg);
                arena.eggman.running();
                arena.eggman2.running();
                arena.eggman3.running();
                arena.eggman4.running();
                tg.setBackgroundColor(TextColor.ANSI.BLACK); //texto do canto superior esq que indica o modo selecionado
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(3, 1, "Survival");

                //String Inventory
                tg.putString(65, 1, "Inventory (U)");

                //String HP
                tg.putString(2, 22, "HP: " + arena.player.hitpoints.getHp());  // falta concatenar com a variavel que recebe os valores corretos

                //Strings WEAPON
                tg.putString(30, 22, "Weapon:  " + arma);
                tg.setBackgroundColor(TextColor.ANSI.BLACK); //texto do canto superior esq que indica o modo selecionado
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);

                //String HP
                tg.putString(2, 22, "HP: " + arena.player.hitpoints.getHp());


                //Strings WEAPON
                tg.putString(30, 22, "Weapon:  " + arma);

                //Strings com LVL
                tg.putString(70, 22, "Lvl: " + lvl);

                screen.refresh();


                KeyStroke keyPressed = terminal.readInput();
                if (keyPressed.getKeyType() == KeyType.Escape) {
                    keepRunning = false;
                    menu();
                } else { // caso nao fechemos o jogo vamos tentar mover
                    arena.player.moving(keyPressed);
                    if ((arena.player.position.getX() == arena.eggman.position.getX() && arena.player.position.getY() == arena.eggman.position.getY() ||
                            arena.player.position.getX() == arena.eggman2.position.getX() && arena.player.position.getY() == arena.eggman2.position.getY() ||
                            arena.player.position.getX() == arena.eggman3.position.getX() && arena.player.position.getY() == arena.eggman3.position.getY() ||
                            arena.player.position.getX() == arena.eggman4.position.getX() && arena.player.position.getY() == arena.eggman4.position.getY())) {

                        arena.player.changeHp(); // perde-se 10 de vida quando embate no inimigo
                        if (arena.player.hitpoints.getHp() == 0) {
                            //jogador morreu
                            keepRunning = false;
                            menu();
                            //menu() placeholder vamos ter uma store()
                        }
                    }
                    //desenho da nova posicao
                    arena.draw(tg);
                    screen.refresh();
                }
            }
        }

        // Opção do modo PVP
        public void pvp() throws IOException {
            screen.clear();

            Arena arena = new Arena(80, 24);
            arena.draw2(tg);
            tg.setBackgroundColor(TextColor.ANSI.BLACK); //texto do canto superior esq que indica o modo selecionado
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(3, 1, "Player VS Player");

            //String Round
            tg.putString(37, 1, "Round:  " + round);

            //Strings com HP
            tg.putString(2, 22, "P1 HP: " + arena.player.hitpoints.getHp());  // falta concatenar com a variavel que recebe os valores corretos
            tg.putString(2, 23, "P2 HP: " + arena.player2.hitpoints.getHp());  // falta concatenar com a variavel que recebe os valores corretos

            //Strings WEAPON
            tg.putString(30, 22, "P1 Weapon:  " + arma);
            tg.putString(30, 23, "P2 Weapon:  " + arma);

            //Strings com Kills
            tg.putString(65, 22, "P1 Kills:  " + p1kills);
            tg.putString(65, 23, "P2 Kills:  " + p2kills);


            screen.refresh();

            boolean keepRunning = true;

            while (keepRunning) {
                KeyStroke keyPressed = terminal.readInput();
                if (keyPressed.getKeyType() == KeyType.Escape) {
                    keepRunning = false;
                    menu();
                } else if (keyPressed.getKeyType() == KeyType.EOF) {
                    keepRunning = false;
                }
            }
        }

        //Layout do menu principal

        public void menu () throws IOException {
            screen.clear();
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
            tg.putString(8, 10, "Survival Mode");

            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(8, 13, "Player VS Player Mode");

            tg.setForegroundColor(TextColor.ANSI.GREEN);
            tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(53, 5, "ArrowUp (Go UP)");

            tg.setForegroundColor(TextColor.ANSI.GREEN);
            tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(53, 7, "ArrowDown (Go Down)");

            tg.setForegroundColor(TextColor.ANSI.GREEN);
            tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(53, 3, "Press ESC to go back");

            screen.refresh();

            boolean keepRunning = true;
            boolean surv = true; //survival

            while (keepRunning) {
                KeyStroke keyPressed = terminal.readInput();

                switch (keyPressed.getKeyType()) {
                    case ArrowDown:
                        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                        tg.putString(8, 10, "Survival Mode");

                        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);  // cor da selecao do tipo de jogo
                        tg.putString(8, 13, "Player VS Player Mode");

                        screen.refresh();

                        surv = false;
                        break;

                    case ArrowUp:
                        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT); // cor da selecao do tipo de jogo
                        tg.putString(8, 10, "Survival Mode");

                        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                        tg.putString(8, 13, "Player VS Player Mode");

                        screen.refresh();

                        surv = true;
                        break;
                    case Enter:
                        keepRunning = false;
                        if (surv) {
                            survival();
                        } else {
                            pvp();
                        }
                        break;
                    case Escape:
                        run(); // volta ao ecrã inicial, ou seja anda para trás
                    case EOF:
                        keepRunning = false;
                        break;
                }
            }
        }


        //Ciclo para manter terminal aberto ate receber alguma key que quebre

        public void run() throws IOException {

            boolean keepRunning = true;

            screen.clear();
            screen.setCursorPosition(null);
            tg.setForegroundColor(TextColor.ANSI.RED);
            tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(30, 20, "Press ENTER to START");

            tg.setForegroundColor(TextColor.ANSI.WHITE);
            tg.setBackgroundColor(TextColor.ANSI.BLACK);
            tg.putString(35, 4, "DUNGEON BOY");

            tg.setForegroundColor(TextColor.ANSI.GREEN);
            tg.setBackgroundColor(TextColor.ANSI.BLACK);
            tg.putString(68, 1, "EXIT (ESC)");

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
                        case EOF:
                            keepRunning = false;
                            break;
                    }
                }
            }
            screen.stopScreen();

        }

    }

