package mygames.game.Snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Obstacle extends BaseActor {

    public Obstacle(float x, float y, Stage s) {
        super(x, y, s);
        setTexture(new Texture(Gdx.files.internal("chapter3/rock.png")));
        setSize(28f,28f);
        this.addActor();
    }
}
