package mygames.game.Snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class ScoreCreator extends BaseActor {

    private Label label;
    public ScoreCreator(float x, float y, Stage s,String path) {
        super(x, y, s);
        this.setTexture(new Texture(Gdx.files.internal(path)));
        s.addActor(this);
        label=new Label("",GameBeta.labelStyle2);
        label.setColor(Color.CYAN);
        label.setPosition(x+getWidth(),y+getHeight()/3);
        s.addActor(label);
    }
    public Label getLabel() {
        return label;
    }
}
