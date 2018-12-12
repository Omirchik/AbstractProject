package mygames.game.Snake.Foods;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import mygames.game.Snake.GameBeta;


public class TimeFood extends MainFood {
    public TimeFood(float x, float y, Stage s) {
        super(x, y, s);
        setTexture(new Texture(Gdx.files.internal("snake/pineapple.png")));
    }
    public void act(float dt){
        super.act(dt);
    }
}
