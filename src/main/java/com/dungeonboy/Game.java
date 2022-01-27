package com.dungeonboy;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.dungeonboy.state.GameState;
import com.dungeonboy.state.InitialGameState;

import java.io.IOException;


public class Game {
    //Iniciar variaveis - Terminais e screen
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new TerminalScreen(terminal);
    TextGraphics tg = screen.newTextGraphics();
    Arena survArena = new Arena(80, 24);
    Arena pvpArena = new Arena(80, 24);
    Shop shop;
    GameState gameState;
    int lvl = 1;
    int p1kills, p2kills, round = 1;


    public Game() throws IOException { // construtor de Game
        try {
            shop = new Shop(screen, terminal);
            screen.startScreen(); // Iniciar o terminal
            gameState = new InitialGameState(this); // O jogo começa no estado inicial

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Screen getScreen(){
        return screen;
    }

    public int getLvl(){
        return lvl;
    }

    public void setLvl(int lvl){
        this.lvl = lvl;
    }

    public Arena getSurvArena(){
        return survArena;
    }

    public Arena getPvpArena(){
        return pvpArena;
    }

    public Shop getShop(){
        return shop;
    }

    public int getRound(){
        return round;
    }

    public void setRound(int round){
        this.round = round;
    }

    public int getP1kills(){
        return p1kills;
    }

    public void setP1kills(int p1kills) {
        this.p1kills = p1kills;
    }

    public int getP2kills(){
        return p2kills;
    }

    public void setP2kills(int p2kills){
        this.p2kills = p2kills;
    }

    // Opção do modo survival
    public void survival() throws IOException{
        boolean keepRunning = true;

        while (keepRunning) {
            gameState.display();

            KeyStroke keyPressed = terminal.readInput();
            if (keyPressed.getKeyType() == KeyType.Escape) {
                keepRunning = false;
                gameState.goBack(); // Volta ao menu
            }else if (keyPressed.getKeyType() == KeyType.EOF){
                break;
            }
            else if (keyPressed.getKeyType() == KeyType.Character && keyPressed.getCharacter() == ' '){
                survArena.damageEnemy();

                if (survArena.getBaddies().size() == 0){
                    keepRunning = false;
                    try{
                        gameState.win();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            else { // caso nao fechemos o jogo vamos tentar mover
                survArena.player.moving(keyPressed,survArena);
                survArena.retrieveCoins();
                if (survArena.damagePos()) {

                    survArena.player.changeHp(); // perde-se 10 de vida quando embate no inimigo
                    if (survArena.player.hitpoints.getHp() <= 0) {
                        //jogador morreu
                        gameState.lose(); // Se ainda tiver vidas vai à shop, senão volta ao menu
                        keepRunning = false;
                        gameState.display(); //Mostra a shop
                        gameState.goBack();  //Volta ao survival
                    }
                }
            }
        }
    }


    // Opção do modo PVP
    public void pvp() throws IOException {
        boolean keepRunning = true;
        int c = 0;
        int q = 0;

        while(keepRunning){
            gameState.display();

            KeyStroke keyPressed = terminal.readInput();
            if (keyPressed.getKeyType() == KeyType.Escape) {
                keepRunning = false;
                gameState.goBack();  //Volta ao menu
            } else if (keyPressed.getKeyType() == KeyType.EOF){
                break;
            }
            else if (keyPressed.getKeyType() == KeyType.Character && keyPressed.getCharacter() == ' ') {
                pvpArena.damagePlayer2();

                if (pvpArena.player2.getHitpoints().getHp() == 0){
                    gameState.lose();
                }
            }else if (keyPressed.getKeyType() == KeyType.Tab){
                pvpArena.damagePlayer1();

                if (pvpArena.player.getHitpoints().getHp() == 0){
                    gameState.lose();
                }
            }else if (keyPressed.getKeyType() == KeyType.Character && keyPressed.getCharacter() == 'c'){
                if (c == 0) {
                    if (changeWeaponP1("Sword")) {
                        c++;
                    }
                }
                else if (c == 1){
                    if (changeWeaponP1("Arrow")) {
                        c++;
                    }
                    else {
                        changeWeaponP1("Fists");
                        c--;
                    }
                }
                else if (c == 2){
                    changeWeaponP1("Fists");
                    c = 0;
                }
            }else if (keyPressed.getKeyType() == KeyType.Character && keyPressed.getCharacter() == 'q'){
                if (q == 0) {
                    if (changeWeaponP2("Sword")) {
                        q++;
                    }
                }
                else if (q == 1){
                    if (changeWeaponP2("Arrow")) {
                        q++;
                    }
                    else {
                        changeWeaponP2("Fists");
                        q--;
                    }
                }
                else if (q == 2){
                    changeWeaponP2("Fists");
                    q = 0;
                }
            }
            else { // caso nao fechemos o jogo vamos tentar mover
                pvpArena.player.moving(keyPressed,pvpArena);
                pvpArena.player2.movingp2(keyPressed,pvpArena);
                //desenho da nova posicao
                pvpArena.draw2(tg);
                //screen.refresh();
            }
        }
    }

    //Layout do menu principal

    public void menu () throws IOException {
        gameState.display(); //Mostra o menu

        boolean keepRunning = true;

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
                    break;
                case ArrowUp:
                    tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT); // cor da selecao do tipo de jogo
                    tg.putString(8, 10, "Survival Mode");

                    tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                    tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                    tg.putString(8, 13, "Player VS Player Mode");

                    screen.refresh();
                    break;
                case Enter:
                    keepRunning = false;
                    gameState.goForward(); //Vai para o modo escolhido
                    break;
                case Escape:
                    gameState.goBack(); // volta ao ecrã inicial
                    break;
                case EOF:
                    keepRunning = false;
                    break;
            }
        }
    }


    //Ciclo para manter terminal aberto ate receber alguma key que quebre

    public void run() throws IOException {
        gameState.display(); //Mostra o ecrã inicial

        boolean keepRunning = true;

        while (keepRunning) {
            KeyStroke keyPressed = terminal.pollInput();

            if (keyPressed != null) {
                switch (keyPressed.getKeyType()) {
                    case Escape:
                        keepRunning = false;
                        gameState.goBack(); // se tiver no ecrã principal e carregar ESC, fecha o jogo
                        break;
                    case Enter:
                        gameState.goForward(); //Vai para o menu
                        break;
                    case EOF:
                        keepRunning = false;
                        break;
                }
            }
        }
        screen.stopScreen();
    }

    public void changeState (GameState state){
        this.gameState = state;
    }

    public boolean changeWeaponP1(String type){  //Mudança de arma do player1
        for (Weapon weapon : pvpArena.getPlayer().getWeapons()){
            if (weapon.getType() == type){
                pvpArena.getPlayer().setWeapon(weapon);
                return true;
            }
        }
        return false;
    }

    public boolean changeWeaponP2(String type){  //Mudança de arma do player2
        for (Weapon weapon : pvpArena.getPlayer2().getWeapons()){
            if (weapon.getType() == type){
                pvpArena.getPlayer2().setWeapon(weapon);
                return true;
            }
        }
        return false;
    }
}
