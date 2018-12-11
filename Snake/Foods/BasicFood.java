package mygames.game.Snake.Foods;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BasicFood extends MainFood {
    public BasicFood(float x, float y, Stage s) {
        super(x, y, s);
        setTexture(new Texture(Gdx.files.internal("snake/apple.png")));
    }
}
