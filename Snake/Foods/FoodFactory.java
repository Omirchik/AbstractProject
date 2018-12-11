package mygames.game.Snake.Foods;

import com.badlogic.gdx.scenes.scene2d.Stage;
import mygames.game.Snake.BaseActor;
import mygames.game.Snake.GameConfig;
import mygames.game.Snake.Obstacle;

import java.util.ArrayList;
public class FoodFactory {
    private ArrayList<Obstacle> obstacles;
    public FoodFactory(ArrayList<Obstacle> obstacles){
        this.obstacles=obstacles;
    }
    public MainFood giveFood(Stage stage){
        boolean bool=false;
        float x,y;
        BeerFood bd;
        do {
            x=GameConfig.getX();
            y=GameConfig.getY();
            bd=new BeerFood(x,y,stage);
            for(Obstacle o:obstacles){
                if ((o.overLaps(bd))){
                    bd.remove();
                    bool=true;
                    break;
                }
            }if (bool==false){
                break;
            }
        }while (true);
        return bd;
    }
    public MainFood giveBasicFood(Stage stage){
        boolean bool=false;
        float x,y;
        BasicFood bf;
        do {
            x=GameConfig.getX();
            y=GameConfig.getY();
            bf=new BasicFood(x,y,stage);
            for(Obstacle o:obstacles){
                if ((o.overLaps(bf))){
                    bf.remove();
                    bool=true;
                    break;
                }
            }if (bool==false){
                break;
            }
        }while (true);
        return bf;
    }


}
