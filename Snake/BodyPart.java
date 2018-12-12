package mygames.game.Snake;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class BodyPart extends BaseActor {
    public BodyPart(float x, float y, Stage s) {
        super(x, y, s);
        this.addActor();
    }
}
