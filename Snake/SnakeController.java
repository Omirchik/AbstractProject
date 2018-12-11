package mygames.game.Snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import mygames.game.Snake.Foods.BeerFood;
import mygames.game.Snake.Foods.FoodFactory;
import mygames.game.Snake.Foods.MainFood;
import java.util.ArrayList;
public class SnakeController extends GameBeta {
    private Snake snake;
    private BaseActor food;
    private BaseActor field;
    private BaseActor gameOver;
    private static final float MOVE_TIME=0.08f;
    private float timer=0.0f;

    private Label label;
    private int count=0;
    private GamePlay GMstate;

    private MainFood mainFood;
    private FoodFactory foodFactory;

    private ArrayList<Obstacle> obstacles;
    @Override
    public void initialize() {
        obstacles=new ArrayList<Obstacle>();
        foodFactory=new FoodFactory(obstacles);

        GMstate=GamePlay.RUN;
        field = new BaseActor(0,0,mainStage);
        field.setTexture(new Texture(Gdx.files.internal("snake/field.jpg")));
        field.setSize(640,480);

        snake=new Snake(100,100,mainStage);


        mainFood = foodFactory.giveFood(mainStage);
        food=foodFactory.giveBasicFood(mainStage);

        label=new Label("Score:",GameBeta.labelStyle);
        label.setColor(Color.CYAN);
        label.setPosition(20,450);
        mainStage.addActor(label);

        obstacles.add(new Obstacle(100,80,mainStage));
        obstacles.add(new Obstacle(128,80,mainStage));
        obstacles.add(new Obstacle(156,80,mainStage));

        obstacles.add(new Obstacle(100,108,mainStage));
        obstacles.add(new Obstacle(100,136,mainStage));

        obstacles.add(new Obstacle(100,380,mainStage));
        obstacles.add(new Obstacle(128,380,mainStage));
        obstacles.add(new Obstacle(156,380,mainStage));

        obstacles.add(new Obstacle(100,352,mainStage));
        obstacles.add(new Obstacle(100,324,mainStage));

        obstacles.add(new Obstacle(480,380,mainStage));
        obstacles.add(new Obstacle(508,380,mainStage));
        obstacles.add(new Obstacle(536,380,mainStage));

        obstacles.add(new Obstacle(536,352,mainStage));
        obstacles.add(new Obstacle(536,324,mainStage));

        obstacles.add(new Obstacle(480,80,mainStage));
        obstacles.add(new Obstacle(508,80,mainStage));
        obstacles.add(new Obstacle(536,80,mainStage));

        obstacles.add(new Obstacle(536,108,mainStage));
        obstacles.add(new Obstacle(536,136,mainStage));

    }
    @Override
    public void update(float dt) {
        switch (GMstate){
            case RUN:
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
                    food.setPosition(GameConfig.getX(),GameConfig.getY());
                }if (mainStage.getActors().contains(mainFood,true) && snake.getHead().overLaps(mainFood)){
                    snake.setState(snake.getHardState());
                }
                break;
            case STOPPED:
                gameOver=new BaseActor(120,100,mainStage);
                gameOver.setTexture(new Texture(Gdx.files.internal("snake/over.png")));
                gameOver.setVisible(true);break;
        }
    }
}
