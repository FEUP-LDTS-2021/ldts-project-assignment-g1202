package com.dungeonboy;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena{
    Player player;
    Player player2;
    //BadGuy finalBoss;
    private int height;
    private int width;
    private List<Wall> walls;
    private List<Coins> coins;
    private List<BadGuy> baddies;
    int wall_height;
    int wall_width;
    int level = 1;
    BadGuy finalBoss;

    private int generator(int min,int max){
        return min + (int) (Math.random() * ((max-min)) + 1);
    }

    public Arena(int width, int height) {
        player = new Player(10, 10, 100);
        player2 = new Player(60, 10, 100);
        this.height = height;
        this.width = width;
        this.walls = createWalls();
        this.baddies = createBaddies(level);
        coins = createCoins();
    }

    public void setCoins(List<Coins> coins){
        this.coins = coins;
    }

    public List<Coins> getCoins(){
        return coins;
    }

    public void setBaddies(List<BadGuy> baddies){
        this.baddies = baddies;
    }

    public List<BadGuy> getBaddies(){
        return baddies;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getWall_height() {
        return wall_height;
    }

    public int getWall_width() {
        return wall_width;
    }

    public Player getPlayer(){
        return player;
    }

    public Player getPlayer2(){
        return player2;
    }


    public boolean checkDamage(int i, BadGuy bad){
        if (player.position.getX() + i >= bad.position.getX() && player.position.getX() < bad.position.getX() && player.position.getY() == bad.position.getY() ||
                player.position.getX() - i <= bad.position.getX() && player.position.getX() > bad.position.getX() && player.position.getY() == bad.position.getY() ||
                player.position.getY() + i >= bad.position.getY() && player.position.getY() < bad.position.getY() && player.position.getX() == bad.position.getX() ||
                player.position.getY() - i <= bad.position.getY() && player.position.getY() > bad.position.getY() && player.position.getX() == bad.position.getX()) {
            return true;
        }
        return false;
    }


    public void damageEnemy() {
        for (BadGuy bad : baddies) {
            if (checkDamage(3,bad) && player.getWeapon() == "Fists"){
                player.noneAttack(bad);
                //System.out.println(bad.hitpoints.getHp());
                if(bad.hitpoints.getHp() == 0) {
                    baddies.remove(bad);
                    Coins newcoin = new Coins(bad.getPosition().getX() , bad.getPosition().getY()); // moeda nova apos matar inimigo
                    coins.add(newcoin);
                }
                break;
            }
            else if (checkDamage(5,bad)  && player.getWeapon() == "Sword"){
                player.swordAttack(bad);
                //System.out.println(bad.hitpoints.getHp());
                if(bad.hitpoints.getHp() == 0) {
                    baddies.remove(bad);
                    Coins newcoin = new Coins(bad.getPosition().getX() , bad.getPosition().getY()); // moeda nova apos matar inimigo
                    coins.add(newcoin);
                }
                break;
            }
            else if (checkDamage(10,bad) && player.getWeapon() == "Bow"){
                player.bowAttack(bad);
                //System.out.println(bad.hitpoints.getHp());
                if(bad.hitpoints.getHp() == 0) {
                    baddies.remove(bad);
                    Coins newcoin = new Coins(bad.getPosition().getX() , bad.getPosition().getY()); // moeda nova apos matar inimigo
                    coins.add(newcoin);
                }
                break;
            }
        }
    }

    public void moveEnemy(){
        int count = 0;
        for(BadGuy bad: baddies){
            if(count % 2 == 0) bad.rangeToPlayerT1(player,this);
            else bad.rangeToPlayerT2(player,this);
            count++;
        }
    }

    //verificar posicoes dos jogadores
    public boolean checkDamagePvp(int i, Player player ,Player bad){
        if (player.position.getX() + i >= bad.position.getX() && player.position.getX() < bad.position.getX() && player.position.getY() == bad.position.getY() ||
                player.position.getX() - i <= bad.position.getX() && player.position.getX() > bad.position.getX() && player.position.getY() == bad.position.getY() ||
                player.position.getY() + i >= bad.position.getY() && player.position.getY() < bad.position.getY() && player.position.getX() == bad.position.getX() ||
                player.position.getY() - i <= bad.position.getY() && player.position.getY() > bad.position.getY() && player.position.getX() == bad.position.getX()) {
            return true;
        }
        return false;
    }

    public void damagePlayer(Player player,Player hitten) {  // player1 ataca player2
        if (checkDamagePvp(3, player,hitten) && player.getWeapon() == "Fists"){
            player.noneAttackPvP(hitten);
        }
        else if (checkDamagePvp(5, player,hitten) && player.getWeapon() == "Sword"){
            player.swordAttackPvP(hitten);
        }
        else if (checkDamagePvp(10, player,hitten) && player.getWeapon() == "Bow"){
            player.bowAttackPvP(hitten);
        }
    }

    public void damagePlayer1() {  //Player2 ataca player1
        if (checkDamagePvp(3, player2,player) && player2.getWeapon() == "Fists"){
            player2.noneAttackPvP(player);
        }
        else if (checkDamagePvp(5, player2,player) && player2.getWeapon() == "Sword"){
            player2.swordAttackPvP(player);
        }
        else if (checkDamagePvp(10, player2,player) && player2.getWeapon() == "Bow"){
            player2.bowAttackPvP(player);
        }
    }

    //Ecrã modo Survival
    public void draw(TextGraphics screen, int level) {
        if (level == 1){
            screen.setBackgroundColor(TextColor.Factory.fromString("#906846"));
            screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

            //Draw das coins
            for (Coins coin : coins)
                coin.draw(screen,"#999933","$");
            //Draw inimigos
            for(BadGuy bad : baddies){
                bad.draw(screen,"#FF0000","E");
            }
        }
        else if (level == 2){
            screen.setBackgroundColor(TextColor.Factory.fromString("#6495ED"));
            screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

            //Draw das coins
            for (Coins coin : coins)
                coin.draw(screen,"#999933","$");
            //Draw inimigos
            for(BadGuy bad : baddies){
                bad.draw(screen,"#FF0000","E");
            }
        }
        else if (level == 3){
            screen.setBackgroundColor(TextColor.Factory.fromString("#FF7F50"));
            screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

            finalBoss.draw(screen,"#000000","(0.o)");
        }

        player.draw(screen,"#FFFF33","X");
        //finalBoss.drawBoss(screen);

        //implementação das walls
        for (Wall wall : walls)
            wall.draw(screen,"#000000","@"); //screen é o nosso textgraphics
    }

    // Ecrã para o modo PVP
    public void draw2(TextGraphics screen2) {
        screen2.setBackgroundColor(TextColor.Factory.fromString("#465690"));
        screen2.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player.draw(screen2,"#FFFF33","X");
        player2.draw(screen2,"#FF0000","X");

        //implementação das walls
        for (Wall wall : walls)
            wall.draw(screen2,"#000000","@");

    }


    private List<Wall> createWalls() {

        wall_height = height - 3;
        wall_width = width - 1;

        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c <= wall_width; c++) {
            walls.add(new Wall(c, 2));         // coloca walls abaixo da informação de Survival + Inventory
            walls.add(new Wall(c, wall_height)); // coloca walls acima da informação de HP etc
        }
        for (int r = 2; r <= wall_height; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(wall_width, r));
        }
        return walls;
    }


    //Se passar por cima duma moeda, ela desaparece
    public void retrieveCoins(){
        for(Coins coin : coins){
            if(player.position.equals(coin.position)) {
                coins.remove(coin);
                player.changeCredit();
                break;
            }
        }
    }

    public boolean damagePos(){
        for(BadGuy bad : baddies){
            if(player.position.equals(bad.position)) {
                return true;
            }
        }
        return false;
    }

    //Creating coins on terminal
    public List<Coins> createCoins() {

        ArrayList<Coins> coins = new ArrayList<>();
        for (int i = 0; i < 2; i++) { //max 2 moedas no ecrã
            Coins newcoin = new Coins(generator(1,wall_width-1) , generator(wall_height - (wall_height - 2) + 1, wall_height-1));
            coins.add(newcoin);
        }
        return coins;
    }

    public List<BadGuy> createBaddies(int level) {
        ArrayList<BadGuy> baddies = new ArrayList<>();
        if(level == 3){
            finalBoss = new BadGuy( 60, 10, 400);
            baddies.add(finalBoss);
        }else {
            for (int i = 0; i < 4; i++) { //max 2 moedas no ecrã
                BadGuy bad = new BadGuy(generator(1, wall_width - 1), generator(wall_height - (wall_height - 2) + 1, wall_height - 1), 100);
                baddies.add(bad);
            }
        }
        return baddies;
    }

}


