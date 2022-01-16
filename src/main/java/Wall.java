import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {

    Position position;

    //construtor

    public Wall(int x, int y){
        position = new Position(x,y);
    }

    public void draw(TextGraphics tg) {
        tg.setForegroundColor(TextColor.Factory.fromString("#000000"));
        tg.enableModifiers(SGR.BOLD);
        tg.putString(new TerminalPosition(position.getX(), position.getY()), "@");

    }


}
