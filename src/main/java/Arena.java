import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    Player player;
    Player player2;
    BadGuy eggman;
    BadGuy eggman2;
    BadGuy eggman3;
    BadGuy eggman4;
    int wall_height;
    int wall_width;
    private int height;
    private int width;
    private List<Wall> walls;


    public Arena(int width, int height) {
        player = new Player(10, 10,100);
        player2 = new Player(10,15,100);
        this.height = height;
        this.width = width;
        this.walls = createWalls();
        eggman = new BadGuy(Math.random() * wall_width ,Math.random() * wall_height  ,100);
        eggman2 = new BadGuy(Math.random() * wall_width ,Math.random() * wall_height  ,100);
        eggman3 = new BadGuy(Math.random() * wall_width ,Math.random() * wall_height  ,100);
        eggman4 = new BadGuy(Math.random() * wall_width ,Math.random() * wall_height ,100);
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public int getWall_height(){return  wall_height;}
    public int getWall_width(){return wall_width;}


    //Ecrã modo Survival
    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString("#906846"));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player.draw(screen);
        eggman.draw(screen);
        eggman2.draw(screen);
        eggman3.draw(screen);
        eggman4.draw(screen);

        //implementação das walls
        for(Wall wall : walls)
            wall.draw(screen); //screen é o nosso textgraphics
    }

    // Ecrã para o modo PVP
    public void draw2(TextGraphics screen2) {
        screen2.setBackgroundColor(TextColor.Factory.fromString("#465690"));
        screen2.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player.draw(screen2);
        player2.draw(screen2);

        //implementação das walls
        for(Wall wall : walls)
            wall.draw(screen2); //screen é o nosso textgraphics

    }

//Existem 4 @ que estão fora das walls e deveriam ser apagados
    private List<Wall> createWalls() {

        wall_height = height-3;
        wall_width = width - 1;

        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < wall_width; c++) {
            walls.add(new Wall(c, 2));           // coloca walls abaixo da informação de Survival + Inventory
            walls.add(new Wall(c, wall_height)); // coloca walls acima da informação de HP etc
        }
        for (int r = 2; r < wall_height; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(wall_width, r));
        }
        return walls;
    }


}


