package mygames.game.Snake.Foods;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import mygames.game.Snake.BaseActor;

public class BeerFood extends MainFood {

    private float timer=0f;
    public BeerFood(float x, float y, Stage s) {
        super(x, y, s);
        setTexture(new Texture(Gdx.files.internal("snake/beer.png")));
    }
    public void act(float dt){
        timer+=dt;

        if (timer>3f){
            this.remove();
        }
    }
}
