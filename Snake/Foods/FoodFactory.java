package mygames.game.Snake.Foods;

import com.badlogic.gdx.scenes.scene2d.Stage;
import mygames.game.Snake.BaseActor;
import mygames.game.Snake.GameConfig;
import mygames.game.Snake.Obstacle;

import java.util.ArrayList;
public class FoodFactory {
    private ArrayList<Obstacle> obstacles;
    private Stage mainStage;

    public FoodFactory(ArrayList<Obstacle> obstacles, Stage s) {
        this.obstacles = obstacles;
        mainStage = s;
    }
    public MainFood giveFood() {
        float[] xy = getXY();
        int f=(int)(Math.random()*3);
        if (f==0){
            return new PillFood(xy[0],xy[1],mainStage);
        }else if (f==1){
            return new TimeFood(xy[0],xy[1],mainStage);
        }else {
            return new BeerFood(xy[0], xy[1], mainStage);
        }
    }
    public MainFood giveBasicFood() {
        float[] xy = getXY();
        return new BasicFood(xy[0], xy[1], mainStage);
    }
    public float[] getXY() {
        int randomPos=(int)(Math.random()*6);
        float x=0,y=0;
        if (randomPos==0){
            x=(float)(Math.random()*80+10);
            y=(float)(Math.random()*430+30);
        }else if (randomPos==1){
            x=(float)(Math.random()*600+15);
            y=(float)(Math.random()*60+390);
        }else if (randomPos==2){
            x=(float)(Math.random()*80+536);
            y=(float)(Math.random()*430+30);
        }else if (randomPos==3){
            x=(float)(Math.random()*600+15);
            y=(float)(Math.random()*50+15);
        }else if (randomPos==4){
            x=(float)(Math.random()*600+15);
            y=(float)(Math.random()*180+150);
        }else if (randomPos==5){
            x=(float)(Math.random()*250+178);
            y=(float)(Math.random()*430+30);
        }
        float[] xy={x,y};
        return xy;
    }
}

