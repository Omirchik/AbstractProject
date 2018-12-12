package mygames.game.Snake.Foods;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import mygames.game.Snake.BaseActor;
import mygames.game.Snake.GameBeta;

public class MainFood extends BaseActor {
    private int count=8;
    private float timer=0f;
    private Label label;

    public MainFood(float x, float y, Stage s) {
        super(x, y, s);
        label=new Label("", GameBeta.labelStyle);
        label.setColor(Color.CYAN);
        label.setPosition(this.getX()-10,this.getY()+10);
        s.addActor(label);
    }
    public void act(float dt){
        timer+=dt;
        if (timer<1){
            setScale(1);
        }else if (timer >= 1 && timer < 2){
            setScale(1.1f);
        }else if (timer >= 2 && timer < 3){
            setScale(1);
            count=8;
        }else if (timer >= 3 && timer < 4) {
            setScale(1.1f);
            count=6;
        }else if (timer >= 4 && timer < 5){
            setScale(1);
            count=4;
        }else {
            setScale(1.1f);
            count=2;
        }
        if (timer>6f){
            this.remove();
            label.remove();
        }
        label.setText(""+count);
    }
    public int getCount() {
        return count;
    }

    public Label getLabel() {
        return label;
    }

}
