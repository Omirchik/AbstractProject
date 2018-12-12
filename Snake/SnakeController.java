package mygames.game.Snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import mygames.game.Snake.Foods.BeerFood;
import mygames.game.Snake.Foods.FoodFactory;
import mygames.game.Snake.Foods.MainFood;
import mygames.game.Snake.Foods.TimeFood;
import mygames.game.Snake.StatesOfSnake.HardState;

import java.util.ArrayList;
public class SnakeController extends GameBeta {
    private Snake snake;
    private BaseActor food;
    private BaseActor field;
    private BaseActor gameOver;

    private static final float MOVE_TIME=0.06f;
    private float timer=0.0f;

    private Label label;
    private Label labelTimerForState;

    private float timerForBeer=0f;

    private int count=0;
    private GamePlay GMstate;

    private MainFood mainFood;
    private FoodFactory foodFactory;

    private float timerForFood=0f;

    private ArrayList<Obstacle> obstacles;
    @Override
    public void initialize() {
        obstacles=new ArrayList<Obstacle>();
        foodFactory=new FoodFactory(obstacles,mainStage);

        GMstate=GamePlay.RUN;
        field = new BaseActor(0,0,mainStage);
        field.setTexture(new Texture(Gdx.files.internal("snake/field.jpg")));
        field.setSize(640,480);
        field.addActor();
        snake=new Snake(100,100,mainStage);
        snake.getHead().addActor();

        food=foodFactory.giveBasicFood();
        food.addActor();

        label=new Label("Score:",GameBeta.labelStyle);
        label.setColor(Color.CYAN);
        label.setPosition(20,450);


        labelTimerForState = new Label("Time:",GameBeta.labelStyle);
        labelTimerForState.setColor(Color.ROYAL);
        labelTimerForState.setPosition(580,450);

        mainStage.addActor(label);

        //left side bottom
        obstacles.add(new Obstacle(148,80,mainStage));
        obstacles.add(new Obstacle(100,120,mainStage));

        //left up side
        obstacles.add(new Obstacle(100,380,mainStage));
        obstacles.add(new Obstacle(100,352,mainStage));

        //right side
        obstacles.add(new Obstacle(450,380,mainStage));
        obstacles.add(new Obstacle(506,352,mainStage));

        //right side down
        obstacles.add(new Obstacle(450,80,mainStage));
        obstacles.add(new Obstacle(506,120,mainStage));
    }
    @Override
    public void update(float dt) {
        switch (GMstate){
            case RUN:
                if (snake.getState() instanceof HardState){
                    int temp=(int)(timerForBeer);
                    labelTimerForState.setText("Time: "+temp);
                    timerForBeer-=dt;

                    if (timerForBeer<0){
                        snake.setState(snake.getNormalState());
                        labelTimerForState.remove();
                    }
                }
                timerForFood+=dt;
                if (timerForFood>=6f){
                    mainFood = foodFactory.giveFood();
                    mainFood.addActor();
                    timerForFood=0f;
                }
                timer+=dt;
                if (timer>=MOVE_TIME){
                    timer=0;
                    snake.act();
                    for (BodyPart bodyPart : snake.getBody()){
                        if (bodyPart.overLaps(snake.getHead())){
                            GMstate=GamePlay.STOPPED;
                            break;
                        }
                    }
                }
                if (snake.getHead().overLaps(food)){
                    count++;
                    label.setText("Score: "+count);
                    snake.addBodyPart();
                    float[] xy=foodFactory.getXY();
                    food.setPosition(xy[0],xy[1]);
                }if (mainStage.getActors().contains(mainFood,true) && snake.getHead().overLaps(mainFood)){
                    if (mainFood instanceof BeerFood){
                        snake.setState(snake.getHardState());
                        timerForBeer+=10f;
                        mainStage.addActor(labelTimerForState);
                    }else if (mainFood instanceof TimeFood){
                        count+=((TimeFood) mainFood).getCount();
                        ((TimeFood) mainFood).getLabel().remove();
                        label.setText("Score: "+count);
                    }
                    mainFood.remove();
                }
                break;
            case STOPPED:
                gameOver=new BaseActor(120,100,mainStage);
                gameOver.setTexture(new Texture(Gdx.files.internal("snake/over.png")));
                gameOver.addActor();
                gameOver.setVisible(true);break;
        }
    }
}
