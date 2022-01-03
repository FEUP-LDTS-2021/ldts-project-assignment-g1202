import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class Arena {
    Player player;
    Player player2;
    BadGuy eggman;
    private int height;
    private int width;


    public Arena(int width, int height) {
        player = new Player(10, 10,100);
        player2 = new Player(20,20,100);
        eggman = new BadGuy(Math.random() * width,Math.random() * height ,100);
        this.height = height;
        this.width = width;
    }

    /*public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
     */

    //Ecrã modo Survival
    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString("#906846"));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player.draw(screen);
        eggman.draw(screen);
    }

    // Ecrã para o modo PVP
    public void draw2(TextGraphics screen2) {
        screen2.setBackgroundColor(TextColor.Factory.fromString("#465690"));
        screen2.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player.draw(screen2);
        player2.draw(screen2);
    }





}


