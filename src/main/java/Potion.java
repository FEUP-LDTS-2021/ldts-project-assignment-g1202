public class Potion {

    int cost;
    Hp hp;
    int life;
    String name;

    public Potion(int cost, Hp hp, String name){
        this.cost = cost;
        this.hp = hp;
        this.name = name;
    }

    public Potion(int cost, int life, String name){
        this.cost = cost;
        this.life = life;
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public Hp getHp() {
        return hp;
    }

    public int getLife() {
        return life;
    }

    public String getName() {
        return name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setHp(Hp hp) {
        this.hp = hp;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setName(String name) {
        this.name = name;
    }
}