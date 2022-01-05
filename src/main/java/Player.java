import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

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
    public void moving(KeyStroke keyPressed,Arena arena){
        switch(keyPressed.getKeyType()){
            case ArrowUp:
                if(this.position.canMoveUp()) {
                    this.position.moveUp();
                }
                break;
            case ArrowDown:
                if(this.position.canMoveDown(arena)) {
                    this.position.moveDown();
                }
                break;
            case ArrowLeft:
                if(this.position.canMoveLeft()) {
                    this.position.moveLeft();
                }
                break;
            case ArrowRight:
                if(this.position.canMoveRight(arena)) {
                    this.position.moveRight();
                }
                break;
        }
    }

    public void movingp2(KeyStroke keyPressed,Arena arena){

        if (keyPressed.getKeyType() == KeyType.Character  && keyPressed.getCharacter() == ('w')) {
            if(this.position.canMoveUp()) {
                this.position.moveUp();
            }
        } else if (keyPressed.getKeyType() == KeyType.Character  && keyPressed.getCharacter() == ('s')) {
            if(this.position.canMoveDown(arena)) {
                this.position.moveDown();
            }
        } else if (keyPressed.getKeyType() == KeyType.Character  && keyPressed.getCharacter() == ('a')) {
            if(this.position.canMoveLeft()) {
                this.position.moveLeft();
            }
        } else if (keyPressed.getKeyType() == KeyType.Character  && keyPressed.getCharacter() == ('d')) {
            if(this.position.canMoveRight(arena)) {
                this.position.moveRight();
            }
        }
    }

    public int hitsword(){
        // dar um hit vai ter um range de 5
        // se pos de inimigo <= ao que e retornado pela func change hp para ele
        return position.getY() + 5;
    }


}