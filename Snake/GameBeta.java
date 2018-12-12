package mygames.game.Snake;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;



public abstract class GameBeta extends Game implements Screen {

    protected Stage mainStage;
    protected Stage uiStage;

    public static Label.LabelStyle labelStyle;
    public static Label.LabelStyle labelStyle2;
    public static FreeTypeFontGenerator fontGenerator;

    @Override
    public void create() {
        mainStage=new Stage();
        uiStage = new Stage();
        labelStyle=new Label.LabelStyle();
        labelStyle.font=new BitmapFont();

        labelStyle2=new Label.LabelStyle();
        fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("snake/BlueSilky.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters.size=30;
        fontParameters.color= Color.WHITE;
        fontParameters.borderWidth = 2;
        fontParameters.borderColor = Color.BLACK;
        fontParameters.borderStraight = true;
        fontParameters.minFilter = Texture.TextureFilter.Linear;
        fontParameters.magFilter = Texture.TextureFilter.Linear;
        BitmapFont customFont = fontGenerator.generateFont(fontParameters);
        labelStyle2.font = customFont;

        initialize();
    }
    public abstract void initialize();
    public void render(){
        float dt= Gdx.graphics.getDeltaTime();
        mainStage.act(dt);
        uiStage.act(dt);

        update(dt);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mainStage.draw();
        uiStage.draw();
    }
    public abstract void update(float dt);

}
