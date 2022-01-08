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
        coins = createCoins();
        eggman = new BadGuy(Math.random() * generator(1,wall_width-1), Math.random() * generator(wall_height - (wall_height - 2) + 1, wall_height-1) , 100);
        eggman2 = new BadGuy(Math.random() * generator(1,wall_width-1), Math.random() * generator(wall_height - (wall_height - 2) + 1, wall_height-1) , 100);
        eggman3 = new BadGuy(Math.random() * generator(1,wall_width-1), Math.random() * generator(wall_height - (wall_height - 2) + 1, wall_height-1), 100);
        eggman4 = new BadGuy(Math.random() * generator(1,wall_width-1), Math.random() * generator(wall_height - (wall_height - 2) + 1, wall_height-1), 100);
        //finalBoss = new BadGuy( wall_width - 1, wall_height, 400);

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


    //Ecrã modo Survival
    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString("#906846"));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player.draw(screen);
        eggman.draw(screen);
        eggman2.draw(screen);
        eggman3.draw(screen);
        eggman4.draw(screen);
        //finalBoss.drawBoss(screen);

        //implementação das walls
        for (Wall wall : walls)
            wall.draw(screen); //screen é o nosso textgraphics

        //Draw das coins
        for (Coins coin : coins)
            coin.draw(screen);
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
        for (int c = 0; c < wall_width; c++) {
            walls.add(new Wall(c, 2));         // coloca walls abaixo da informação de Survival + Inventory
            walls.add(new Wall(c, wall_height)); // coloca walls acima da informação de HP etc
        }
        for (int r = 2; r < wall_height; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(wall_width, r));
        }
        return walls;
    }


    //Se passar por cima duma moeda, ela desaparece - Still not working fully
    public void retrieveCoins(){
        for(Coins coin : coins){
            if(player.position.getX() == (coin.position.getX()) && player.position.getY() == coin.position.getY()) {
                coins.remove(coin);
                player.changeCredit();
                break;
            }
        }
    }

    //Creating coins on terminal -  They are still being drawn out of wall bounds
    private List<Coins> createCoins() {

        Random random = new Random();
        ArrayList<Coins> coins = new ArrayList<>();
        for (int i = 0; i < 2; i++) { //max 2 moedas no ecrã
            Coins newcoin = new Coins(generator(1,wall_width-1) , generator(wall_height - (wall_height - 2) + 1, wall_height-1));
                    coins.add(newcoin);
            }
        return coins;
    }

}
