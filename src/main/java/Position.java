public class Position {
    //Player 1
    private int x;
    private int y;

    //construtor
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    // getters
    public int getX(){  return x;}
    public int getY(){  return y; }

    //setters
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

}