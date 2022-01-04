import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public class Player {


    Position position;
    Hp hitpoints;
    private int life;

    //construtor
    public Player(int x, int y,int health){
        position = new Position(x,y);
        hitpoints = new Hp(health);
    }

    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        screen.putString(new TerminalPosition(position.getX(), position.getY()),"X");
    }

    public void changeHp(){
        //perder 10 pontos de vida
        hitpoints.setHp(hitpoints.getHp()-10);
    }

    public int lostlife(){
        return life--;
    }

    public int oneup(){
        return life++;
    }

    public int getLife(){
        return life;
    }

    //Movimento
    public void moving(KeyStroke keyPressed){
        switch(keyPressed.getKeyType()){
            case ArrowUp:
                position.setY(position.getY()-1);
                break;
            case ArrowDown:
                position.setY(position.getY()+1);
                break;
            case ArrowLeft:
                position.setX(position.getX()-1);
                break;
            case ArrowRight:
                position.setX(position.getX()+1);
                break;
        }
    }

    public int hitsword(){
        // dar um hit vai ter um range de 5
        // se pos de inimigo <= ao que e retornado pela func change hp para ele
        return position.getY() + 5;
    }


}