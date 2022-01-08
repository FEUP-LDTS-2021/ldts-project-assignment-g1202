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
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class Game {
    //Iniciar variaveis - Terminais e screen
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new TerminalScreen(terminal);
    TextGraphics tg = screen.newTextGraphics();
    Arena survArena = new Arena(80, 24);
    Shop shop;
    int lvl = 0;
    String arma = "Sword";
    int p1kills, p2kills, round = 0;


    public Game() throws IOException { // construtor de Game
        try {
            shop = new Shop();
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
            survArena.draw(tg);
            survArena.eggman.running();
            survArena.eggman2.running();
            survArena.eggman3.running();
            survArena.eggman4.running();
            survArena.retrieveCoins();
            tg.setBackgroundColor(TextColor.ANSI.BLACK); //texto do canto superior esq que indica o modo selecionado
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(3, 1, "Survival");

            //String Inventory
            tg.putString(65, 1, "Inventory (U)");

            //String HP
            tg.putString(2, 22, "HP: " + survArena.player.hitpoints.getHp());  // falta concatenar com a variavel que recebe os valores corretos

            //Strings WEAPON
           tg.putString(30, 22, "Weapon:  " + arma);
            tg.setBackgroundColor(TextColor.ANSI.BLACK); //texto do canto superior esq que indica o modo selecionado
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);

            //String HP
            tg.putString(2, 22, "HP: " + survArena.player.hitpoints.getHp());

            //String Live
            tg.putString(15, 22, "Lives: " + survArena.player.getLife());


            //Strings WEAPON
            tg.putString(30, 22, "Weapon:  " + arma);

            //String com numero coins:
            tg.putString(53, 22, "Coins: " + survArena.player.getCredit());

            //Strings com LVL
            tg.putString(70, 22, "Lvl: " + lvl);

            screen.refresh();


            KeyStroke keyPressed = terminal.readInput();
            if (keyPressed.getKeyType() == KeyType.Escape) {
                keepRunning = false;
                menu();
            } else { // caso nao fechemos o jogo vamos tentar mover
                survArena.player.moving(keyPressed,arena);
                if ((survArena.player.position.equals(survArena.eggman.position) ||
                        survArena.player.position.equals(survArena.eggman2.position)  ||
                        survArena.player.position.equals(survArena.eggman3.position) ||
                        survArena.player.position.equals(survArena.eggman4.position))) {

                    survArena.player.changeHp(); // perde-se 10 de vida quando embate no inimigo
                    if (survArena.player.hitpoints.getHp() == 0) {
                        //jogador morreu
                        survArena.player.lostlife();
                        keepRunning = false;
                        if (survArena.player.getLife() > 0){// abre a shop se ainda tiver vidas
                            survArena.player.setHitpoints(new Hp(100)); // restaura hp
                            survArena.player.position.setX(10);   // restaura posicao inicial
                            survArena.player.position.setY(10);
                            shop.show(screen, terminal, survArena.player);
                            survival();  // quando fecha a shop volta ao jogo
                        }
                        else{
                            menu();  // se não tiver mais vidas vai direto ao menu
                        }
                    }
                }
                //desenho da nova posicao
                survArena.draw(tg);
                //screen.refresh();
            }
        }
    }

    // Opção do modo PVP
    public void pvp() throws IOException {
        screen.clear();
        boolean keepRunning = true;
        Arena arena = new Arena(80, 24);

        while(keepRunning){
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

            KeyStroke keyPressed = terminal.readInput();
            if (keyPressed.getKeyType() == KeyType.Escape) {
                keepRunning = false;
                menu();
            } else { // caso nao fechemos o jogo vamos tentar mover
                arena.player.moving(keyPressed,arena);
                arena.player2.movingp2(keyPressed,arena);
                //desenho da nova posicao
                arena.draw(tg);
                //screen.refresh();
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
