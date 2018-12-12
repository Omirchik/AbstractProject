package mygames.game.Snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import mygames.game.Snake.CollisionStates.NoCollision;
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
    private BaseActor startPage;

    private static final float MOVE_TIME=0.08f;
    private float timer=0.0f;

    private float timerForBeer=0f;

    private int count=0;
    private MainFood mainFood;
    private FoodFactory foodFactory;

    private float timerForFood=0f;
    private float timerForCollision=0f;

    private ArrayList<Obstacle> obstacles;

    private ScoreCreator score;
    private ScoreCreator timeHardControl;
    private ScoreCreator timeNoCollision;

    private Sound appleEating;
    private Sound drinking;
    private Sound crash;
    private float audioVolume=1.0f;

    private boolean stop = true;
    @Override
    public void initialize() {


        obstacles=new ArrayList<Obstacle>();
        foodFactory=new FoodFactory(obstacles,mainStage);

        field = new BaseActor(0,0,mainStage);
        field.setTexture(new Texture(Gdx.files.internal("snake/snakeStart.jpg")));
        field.addActor();

        snake=new Snake(200,200,mainStage,obstacles);
        snake.getHead().addActor();

        food=foodFactory.giveBasicFood();
        food.addActor();

        score=new ScoreCreator(20,483,mainStage,"snake/apple.png");
        timeHardControl=new ScoreCreator(200,483,mainStage,"snake/beer.png");
        timeNoCollision=new ScoreCreator(400,483,mainStage,"snake/pill.png");

        appleEating = Gdx.audio.newSound(Gdx.files.internal("snake/eating.wav"));
        drinking = Gdx.audio.newSound(Gdx.files.internal("snake/drink.mp3"));
        crash = Gdx.audio.newSound(Gdx.files.internal("snake/crash.wav"));
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
        switch (GameConfig.getGMstate()){
            case RUN:
                if (snake.getCollisionStatestate() instanceof NoCollision){
                    timerForCollision-=dt;
                    int time=(int)(timerForCollision);
                    timeNoCollision.getLabel().setText("Time:"+time);
                    if (timerForCollision<0f){
                        timeNoCollision.getLabel().setText("");
                        snake.setCollisionStatestate(snake.getNormalCollision());
                        snake.getNoCollision().setBool(true);
                        changeColor();
                    }
                }
                if (snake.getState() instanceof HardState){
                    int temp=(int)(timerForBeer);
                    timeHardControl.getLabel().setText("Time:"+temp);
                    timerForBeer-=dt;
                    if (timerForBeer<0){
                        snake.setState(snake.getNormalState());
                        timeHardControl.getLabel().setText("");
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
                    snake.getCollisionStatestate().selfCollision();
                }
                if (snake.getHead().overLaps(food)){
                    appleEating.play(audioVolume);
                    count++;
                    score.getLabel().setText("Score:"+count);
                    snake.addBodyPart();
                    float[] xy=foodFactory.getXY();
                    food.setPosition(xy[0],xy[1]);
                }if (mainStage.getActors().contains(mainFood,true) && snake.getHead().overLaps(mainFood)){
                    if (mainFood instanceof BeerFood){
                        drinking.play(audioVolume);
                        snake.setState(snake.getHardState());
                        timerForBeer+=10f;
                        mainStage.addActor(timeHardControl.getLabel());
                    }else if (mainFood instanceof TimeFood){
                        appleEating.play(audioVolume);
                        count+=((TimeFood) mainFood).getCount();
                        score.getLabel().setText("Score:"+count);
                    }else {
                        appleEating.play(audioVolume);
                        timerForCollision+=10;
                        snake.setCollisionStatestate(snake.getNoCollision());
                    }
                    mainFood.getLabel().remove();
                    mainFood.remove();
                }
                break;
            case STOPPED:
                if (stop) {
                    crash.play(audioVolume);
                }
                stop = false;
                gameOver=new BaseActor(120,100,mainStage);
                gameOver.setTexture(new Texture(Gdx.files.internal("snake/over.png")));
                gameOver.addActor();
                gameOver.setVisible(true);break;
        }
    }
    public void changeColor(){
        for (BodyPart bodyPart:snake.getBody()){
            bodyPart.getColor().a=1;
        }
        snake.getHead().getColor().a=1;
    }

    @Override
    public void show() {
    }
    @Override
    public void render(float delta) {
    }
    @Override
    public void hide() {
    }
}
