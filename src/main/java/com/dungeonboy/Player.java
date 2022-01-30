package com.dungeonboy;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;

public class Player extends Element{

    private int life = 3;
    private int credit = 0; // coins = 0
    List<Weapon> weapons; //Todas as weapons do player
    Weapon weapon; //A weapon que o player está a usar no momento

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
    public Player(int x, int y,int health){
        super(x,y,health);
        List<Weapon> weapons = new ArrayList<>();
        Weapon weapon = new Weapon();
        weapons.add(weapon);
        this.weapons = weapons;
        this.weapon = weapon;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public String getWeapon(){
        return weapon.getType();
    }

    public void setWeapons(List<Weapon> weapons){
        this.weapons = weapons;
    }

    public List<Weapon> getWeapons(){
        return weapons;
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

    public void noneAttack(BadGuy badGuy){  //Ataque quando o player não tem arma nenhuma
        if (weapon.getType().equals("Fists")){
            badGuy.changeHp(10);
        }
    }

    public void swordAttack(BadGuy badGuy){  //Ataque quando o player tem uma sword
        if (weapon.getType().equals("Sword")){
            badGuy.changeHp(20);
        }
    }

    public void bowAttack(BadGuy badGuy){ //Ataque quando o player tem um arrow
        if (weapon.getType().equals("Bow")){
            badGuy.changeHp(15);
        }
    }

    public void noneAttackPvP(Player player){
        if (weapon.getType().equals("Fists")){
            player.hitpoints.setHp(player.hitpoints.getHp() - 10);
        }
    }

    public void swordAttackPvP(Player player){
        if (weapon.getType().equals("Sword")){
            player.hitpoints.setHp(player.hitpoints.getHp() - 20);
        }
    }

    public void bowAttackPvP(Player player){
        if (weapon.getType().equals("Bow")){
            player.hitpoints.setHp(player.hitpoints.getHp() - 15);
        }
    }
}