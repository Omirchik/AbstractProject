package mygames.game.Snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BaseActor extends Actor {
    private TextureRegion tr;
    private Rectangle rect;
    
    public BaseActor(float x, float y, Stage s){
        super();
        setPosition(x,y);
        s.addActor(this);
        tr=new TextureRegion();
        rect=new Rectangle();
    }
    public void setTexture(Texture t){
        tr.setRegion(t);
        setSize(t.getWidth(),t.getHeight());
        rect.setSize(t.getWidth(),t.getHeight());
    }
    public Rectangle getRect(){
        rect.setPosition(getX(),getY());
        return rect;
    }
    public void setRect(float w,float h){
        rect.setSize(w,h);
    }
    public boolean overLaps(BaseActor other){
        return this.getRect().overlaps(other.getRect());
    }
    public void act(float dt){
        super.act(dt);
    }
    public void draw(Batch batch,float parentAlpha){

        super.draw(batch,parentAlpha);
        Color c=getColor();
        batch.setColor(c.r,c.g,c.b,c.a);
        if (isVisible()){
            batch.draw(tr,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
        }
    }
}


