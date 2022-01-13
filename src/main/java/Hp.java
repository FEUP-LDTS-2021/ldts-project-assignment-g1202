public class Hp {
    private int Hp;

    public Hp(int Hp){
        this.Hp = Hp;
    }

    public int getHp(){
        return Hp;
    }

    public void setHp(int Hp){
        this.Hp = Hp;
    }

    public void changeHp(){
        //perder 10 pontos de vida
        setHp(getHp()-10);
    }
}
