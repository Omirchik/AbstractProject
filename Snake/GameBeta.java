package mygames.game.Snake;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;



public abstract class GameBeta extends Game {

    Stage mainStage;

    public static Label.LabelStyle labelStyle;

    @Override
    public void create() {
        mainStage=new Stage();

        labelStyle=new Label.LabelStyle();
        labelStyle.font=new BitmapFont();

        initialize();
    }
    public abstract void initialize();
    public void render(){
        float dt= Gdx.graphics.getDeltaTime();
        mainStage.act(dt);
        update(dt);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mainStage.draw();
    }
    public abstract void update(float dt);

}
