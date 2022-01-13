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

    public boolean canMoveLeft(){
        if(this.getX()-1 == 0) return false;
        //if(player.position.getY()+1 == wall_height || player.position.getY()-1 == 2 ) return false;
        return true;
    }

    public boolean canMoveRight(Arena arena){
        if(this.getX()+1 == arena.wall_width) return false;
        return true;
    }

    public boolean canMoveUp(Arena arena){
        if(this.getY()-1 == arena.wall_height - (arena.wall_height - 2)) return false;
        return true;
    }

    public boolean canMoveDown(Arena arena){
        if(this.getY()+1 == arena.wall_height) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || o.getClass() != this.getClass()) return false;

        return (this == o) ||
                (this.x == ((Position) o).x && this.y == ((Position) o).y);
    }

}