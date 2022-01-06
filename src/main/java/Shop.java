import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.w3c.dom.Text;

import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;


public class Shop {

    List<Weapon> weapons;
    List<Potion> potions;
    List<Boolean> bools;

    public Shop() throws IOException {
        potions = new ArrayList<>();
        weapons = new ArrayList<>();
        bools = new ArrayList<>();

        //diferentes armas disponiveis
        weapons.add(new Weapon(10, 5, "Sword"));
        weapons.add(new Weapon(20, 10, "Arrow"));

        //diferentes poções disponiveis
        potions.add(new Potion(5, new Hp(10), "10 HP"));
        potions.add(new Potion(10, new Hp(20), "20 HP"));
        potions.add(new Potion(15, new Hp(40), "40 HP"));
        potions.add(new Potion(15, 1, "1 Life"));
        potions.add(new Potion(25, 2, "2 Life"));

        //criar booleans para ser mais fácil a seleção na loja
        boolean w1 = false;
        boolean w2 = false;
        boolean p1 = false;
        boolean p2 = false;
        boolean p3 = false;
        boolean p4 = false;
        boolean p5 = false;
        bools.add(w1);
        bools.add(w2);
        bools.add(p1);
        bools.add(p2);
        bools.add(p3);
        bools.add(p4);
        bools.add(p5);
    }

    public void goDown(int i, TextGraphics tg){  // assinala o item da loja imediatamente depois do atualmente assinalado
        if (i == 0){
            tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(9, 11, weapons.get(i).getType() + "(" + String.valueOf(weapons.get(i).getRange()) + ")");
        }
        else if (i == 1){
            tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(9, 11 + 2, weapons.get(i).getType() + "(" + String.valueOf(weapons.get(i).getRange()) + ")");

            tg.setBackgroundColor(TextColor.ANSI.BLACK);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(9, 11, weapons.get(i-1).getType() + "(" + String.valueOf(weapons.get(i-1).getRange()) + ")");
        }
        else if (i == 2){
            tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(45, 11, potions.get(i-2).getName());

            tg.setBackgroundColor(TextColor.ANSI.BLACK);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(9, 11 + 2, weapons.get(i-1).getType() + "(" + String.valueOf(weapons.get(i-1).getRange()) + ")");
        }
        else if (i > 2){
            tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(45, 11 + (2*(i-2)), potions.get(i-2).getName());

            tg.setBackgroundColor(TextColor.ANSI.BLACK);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(45, 11 + (2*(i-3)), potions.get(i-3).getName());
        }

    }

    public void goUp(int i, TextGraphics tg){ // assinala o item da loja imediatamente antes do atualmente assinalado
        if (i > 1){
            tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(45, 11 + (2*(i-2)), potions.get(i-2).getName());

            tg.setBackgroundColor(TextColor.ANSI.BLACK);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(45, 11 + (2*(i-1)), potions.get(i-1).getName());
        }
        else if (i == 1){
            tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(9, 11 + 2, weapons.get(i).getType() + "(" + String.valueOf(weapons.get(i).getRange()) + ")");

            tg.setBackgroundColor(TextColor.ANSI.BLACK);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(45, 11, potions.get(0).getName());
        }
        else if (i == 0){
            tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(9, 11, weapons.get(i).getType() + "(" + String.valueOf(weapons.get(i).getRange()) + ")");

            tg.setBackgroundColor(TextColor.ANSI.BLACK);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(9, 11 + 2, weapons.get(i + 1).getType() + "(" + String.valueOf(weapons.get(i + 1).getRange()) + ")");
        }
    }

    public boolean canBuy(int i){
        if (i < 2){
            //if (coins >= weapons.get(i).getCost()){  // verificar se há coins suficientes
                return true;
            //}
            //return false;
        }
        else{
            //if (coins >= potions.get(i-2).getCost()){
                return true;
            //}
            //return false;
        }
    }

    public void select(int i, TextGraphics tg, Player player){
        if (i < 2){
            //if (canBuy(i)){  // falta implementar coins
                // falta atribuir arma ao player

                tg.setBackgroundColor(TextColor.ANSI.BLACK);
                tg.putString(9, 4, "                  ");  // maneira que eu arranjei para não haver sobreposição de texto
                tg.putString(9, 4, "Adquired: " + weapons.get(i).getType());
            //}

        }
        else{
            //if (canBuy(i)){
                if (i < 5){
                    Hp hp = new Hp(player.getHitpoints().getHp() + potions.get(i-2).getHp().getHp());
                    player.setHitpoints(hp);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK);
                    tg.putString(9, 4, "                  ");
                    tg.putString(9, 4, "Adquired: " + potions.get(i-2).getName());
                }
                else{
                    for (int j = 0; j < potions.get(i-2).getLife(); j++){
                        player.oneup();
                    }
                    tg.setBackgroundColor(TextColor.ANSI.BLACK);
                    tg.putString(9, 4, "                  ");
                    tg.putString(9, 4, "Adquired: " + potions.get(i-2).getName());
                }
            //}
        }
    }

    public void show(Screen screen, Terminal terminal, Player player) throws IOException{
        TextGraphics tg = screen.newTextGraphics();
        screen.clear();

        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(35, 2, "SHOP");

        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.putString(65, 4, "Coins: ");  // Concatenar com a variavel que guarda as coins do player

        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString(9, 8, "Weapons(Range)");

        int row = 11;
        for (Weapon weapon : weapons){
            tg.setBackgroundColor(TextColor.ANSI.BLACK);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(9, row, weapon.getType() + "(" + String.valueOf(weapon.getRange()) + ")");
            tg.putString(19, row, String.valueOf(weapon.getCost()) + " coins");
            row += 2;
        }

        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString(45, 8, "Potions");

        row = 11;
        for (Potion potion : potions){
            tg.setBackgroundColor(TextColor.ANSI.BLACK);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(45, row, potion.getName());
            tg.putString(52, row, String.valueOf(potion.getCost()) + " coins");
            row += 2;
        }

        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.putString(5, 20, "Buy (Enter)");
        tg.putString(5, 21, "Back to Game (ESC)");

        goDown(0, tg);
        bools.set(0, true);

        screen.refresh();

        while(true){
            KeyStroke keyPressed = terminal.readInput();
            switch (keyPressed.getKeyType()){
                case Escape:
                    return;
                case ArrowDown:
                    for (int i = 0; i < bools.size() - 1; i++ ){
                        if (bools.get(i)){
                            bools.set(i, false);
                            bools.set(i + 1, true);
                            goDown(i + 1, tg);
                            screen.refresh();
                            break;
                        }
                    }
                    break;
                case ArrowUp:
                    for (int i = 1; i < bools.size(); i++){
                        if (bools.get(i)){
                            bools.set(i, false);
                            bools.set(i - 1, true);
                            goUp(i - 1, tg);
                            screen.refresh();
                            break;
                        }
                    }
                    break;
                case Enter:
                    for (Boolean bool : bools){
                        if (bool){
                            select(bools.indexOf(bool), tg, player);
                            screen.refresh();
                            break;
                        }
                    }
                    break;
                case EOF:
                    break;
            }

        }
    }

}
