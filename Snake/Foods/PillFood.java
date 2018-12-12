package mygames.game.Snake.Foods;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PillFood extends MainFood {
    public PillFood(float x, float y, Stage s) {
        super(x, y, s);
        this.setTexture(new Texture(Gdx.files.internal("snake/pill.png")));
    }
    public void act(float dt){
        super.act(dt);
    }
}
