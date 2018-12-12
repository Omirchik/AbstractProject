package mygames.game.Snake;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import mygames.game.Snake.StatesOfSnake.HardState;
import mygames.game.Snake.StatesOfSnake.NormalState;
import mygames.game.Snake.StatesOfSnake.State;

import java.util.ArrayList;
public class Snake {
    private ArrayList<BodyPart> body;
    public Head head;
    private Stage mainStage;
    private String movement;

    private State state;
    private HardState hardState;
    private NormalState normalState;

    

    private float moveRate=15.1f;

    public Snake(float x,float y,Stage stage){
        mainStage=stage;
        head=new Head(x,y,mainStage);
        head.setTexture(new Texture(Gdx.files.internal("snake/snake.png")));
        body=new ArrayList<BodyPart>();
        movement="up";

        hardState=new HardState(this);
        normalState=new NormalState(this);
        state=normalState;
    }
    public void act(){
        if (head.getX()<0){
            head.setPosition(640,head.getY());
        }else if (head.getX()>640){
            head.setPosition(0,head.getY());
        }else if (head.getY()>480){
            head.setPosition(head.getX(),0);
        }else if (head.getY()<0){
            head.setPosition(head.getX(),480);
        }
        state.moving();
        move(head.getX(),head.getY());
        if (movement.equals("right")){
            head.moveBy(moveRate,0);
        }if(movement.equals("left")){
            head.moveBy(-moveRate,0);
        }if(movement.equals("up")){
            head.moveBy(0,moveRate);
        }if (movement.equals("down")){
            head.moveBy(0,-moveRate);
        }
    }
    public void addBodyPart(){
        BodyPart bodyPart=new BodyPart(head.getX(),head.getY(),mainStage);
        bodyPart.setTexture(new Texture(Gdx.files.internal("snake/snake.png")));
        body.add(bodyPart);
    }
    public void move(float x,float y){
        if (body.size()==0){
            return;
        }
        for(int i=body.size()-1;i>0;i--){
            body.get(i).setPosition(body.get(i-1).getX(),body.get(i-1).getY());
        }
        body.get(0).setPosition(x,y);
    }
    public Head getHead(){
        return head;
    }
    public ArrayList<BodyPart> getBody(){
        return body;
    }
    public void setHead(Head head) {
        this.head = head;
    }
    public String getMovement() {
        return movement;
    }
    public void setMovement(String movement) {
        this.movement = movement;
    }
    public float getMoveRate() {
        return moveRate;
    }
    public void setMoveRate(float moveRate) {
        this.moveRate = moveRate;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public HardState getHardState() {
        return hardState;
    }
    public NormalState getNormalState() {
        return normalState;
    }
}
