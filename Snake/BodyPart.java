package mygames.game.Snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BodyPart extends BaseActor {
    public BodyPart(float x, float y, Stage s) {
        super(x, y, s);
        this.addActor();
        this.setTexture(new Texture(Gdx.files.internal("snake/full-moon2.png")));

    }
}
