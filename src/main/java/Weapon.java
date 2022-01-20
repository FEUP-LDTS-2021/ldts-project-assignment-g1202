package com.dungeonboy;

import java.util.Objects;

public class Weapon {

    int cost;
    int range;
    String type;

    public Weapon(){
        cost = 0;
        range = 0;
        type = "None";
    }
    public Weapon(int cost, int range, String type){
        this.cost = cost;
        this.range = range;
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public int getRange(){
        return range;
    }

    public String getType(){
        return type;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public void setRange(int range){
        this.range = range;
    }

    public void setType(String type){
        this.type = type;
    }
}
