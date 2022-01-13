import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class Player {


    Position position;
    Hp hitpoints;
    private int life;
    int credit = 0; // coins = 0

    public int getCredit(){
        return credit;
    }

    public void setCredit(int credit){
        this.credit = credit;
    }

    public void changeCredit(){
        //Aumentar 1 coin cada vez que apanha uma
        setCredit(credit+1); // coins ++
    }

    //construtor
    public Player(int x, int y,int health, int life){
        position = new Position(x,y);
        hitpoints = new Hp(health);
        this.life = life;
    }

    public void setHitpoints(Hp hitpoints) {
        this.hitpoints = hitpoints;
    }

    public Hp getHitpoints() {
        return hitpoints;
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

    public Position getPosition(){
        return position;
    }
    public void setPosition(Position position){
        this.position = this.position;
    }

    //Movimento
    public void moving(KeyStroke keyPressed, Arena arena){
        switch(keyPressed.getKeyType()){
            case ArrowUp:
                if(this.position.canMoveUp(arena))
                    position.setY(position.getY()-1);

                break;
            case ArrowDown:
                if(this.position.canMoveDown(arena))
                    position.setY(position.getY()+1);

                break;
            case ArrowLeft:
                if(this.position.canMoveLeft())
                    position.setX(position.getX()-1);

                break;
            case ArrowRight:
                if(this.position.canMoveRight(arena))
                    position.setX(position.getX()+1);

                break;
        }
    }

    public void movingp2(KeyStroke keyPressed,Arena arena){

        if (keyPressed.getKeyType() == KeyType.Character  && keyPressed.getCharacter() == ('w')) {
            if(this.position.canMoveUp(arena)) {
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