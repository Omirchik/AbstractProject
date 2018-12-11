package mygames.game.Snake;

public class GameConfig {


    public static float getX(){
        float x=(float) Math.random()*400+50;
        return x;
    }
    public static float getY() {
        float y = (float) Math.random() * 400 + 50;
        return y;
    }

}
