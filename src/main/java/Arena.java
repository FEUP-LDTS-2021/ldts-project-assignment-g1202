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
    BadGuy eggman;
    BadGuy eggman2;
    BadGuy eggman3;
    BadGuy eggman4;
    //BadGuy finalBoss;
    private int height;
    private int width;
    private List<Wall> walls;
    private List<Coins> coins;
    private List<BadGuy> baddies;
    int wall_height;
    int wall_width;

    private int generator(int min,int max){
        return min + (int) (Math.random() * ((max-min)) + 1);
    }

    public Arena(int width, int height) {
        player = new Player(10, 10, 100, 3);
        player2 = new Player(10, 15, 100, 3);
        this.height = height;
        this.width = width;
        this.walls = createWalls();
        this.baddies = createBaddies();
        coins = createCoins();
        //finalBoss = new BadGuy( wall_width - 1, wall_height, 400);

    }

    /*public int getWidth() {
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
     */


    //Ecrã modo Survival
    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString("#906846"));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player.draw(screen);
        //finalBoss.drawBoss(screen);

        //implementação das walls
        for (Wall wall : walls)
            wall.draw(screen); //screen é o nosso textgraphics

        //Draw das coins
        for (Coins coin : coins)
            coin.draw(screen);
        //Draw inimigos
        for(BadGuy bad : baddies){
            bad.draw(screen);
        }
    }

    // Ecrã para o modo PVP
    public void draw2(TextGraphics screen2) {
        screen2.setBackgroundColor(TextColor.Factory.fromString("#465690"));
        screen2.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player.draw(screen2);
        player2.draw(screen2);

        //implementação das walls
        for (Wall wall : walls)
            wall.draw(screen2);

    }


    private List<Wall> createWalls() {

        wall_height = height - 3;
        wall_width = width - 1;

        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < wall_width + 1; c++) {
            walls.add(new Wall(c, 2));         // coloca walls abaixo da informação de Survival + Inventory
            walls.add(new Wall(c, wall_height)); // coloca walls acima da informação de HP etc
        }
        for (int r = 2; r < wall_height; r++) {
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
    private List<Coins> createCoins() {

        ArrayList<Coins> coins = new ArrayList<>();
        for (int i = 0; i < 2; i++) { //max 2 moedas no ecrã
            Coins newcoin = new Coins(generator(1,wall_width-1) , generator(wall_height - (wall_height - 2) + 1, wall_height-1));
            coins.add(newcoin);
        }
        return coins;
    }

    private List<BadGuy> createBaddies() {

        ArrayList<BadGuy> baddies = new ArrayList<>();
        for (int i = 0; i < 4; i++) { //max 2 moedas no ecrã
            BadGuy bad = new BadGuy(generator(1,wall_width-1) , generator(wall_height - (wall_height - 2) + 1, wall_height-1),100);
            baddies.add(bad);
        }
        return baddies;
    }

}


