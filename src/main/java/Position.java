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

    //movement functions
    public void moveUp(){
        this.setY(this.getY() - 1);
    }

    public void moveDown(){
        this.setY(this.getY() + 1);
    }

    public void moveLeft(){
        this.setX(this.getX()-1);
    }

    public void moveRight(){
        this.setX(this.getX()+1);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || o.getClass() != this.getClass()) return false;

        return (this == o) ||
                (this.x == ((Position) o).x && this.y == ((Position) o).y);
    }

}