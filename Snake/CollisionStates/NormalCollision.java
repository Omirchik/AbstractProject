package mygames.game.Snake.CollisionStates;

import mygames.game.Snake.*;

import java.util.ArrayList;

public class NormalCollision extends CollisionState{

    private Snake snake;
    public NormalCollision(Snake snake){
        this.snake=snake;
    }
    @Override
    public void collision() {

        ArrayList<Obstacle> obstacles=snake.getObstacles();
        for (Obstacle obstacle:obstacles){
            if (obstacle.overLaps(snake.getHead())){
                GameConfig.setGMstate(GamePlay.STOPPED);
            }
        }
    }
    public void selfCollision(){
        for (BodyPart bodyPart : snake.getBody()){
            if (bodyPart.overLaps(snake.getHead())){
                GameConfig.setGMstate(GamePlay.STOPPED);
                break;
            }
        }
    }

}
