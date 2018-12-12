package mygames.game.Snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
public class Head extends BaseActor {

    public Head(float x, float y, Stage s) {
        super(x, y, s);
        this.addActor();
        setTexture(new Texture(Gdx.files.internal("snake/smiling1.png")));

    }

}
