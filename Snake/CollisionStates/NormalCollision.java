package mygames.game.Snake.CollisionStates;

import mygames.game.Snake.Snake;

public class NormalCollision extends CollisionState{

    private Snake snake;
    public NormalCollision(Snake snake){
        this.snake=snake;
    }
    @Override
    public void collision() {

    }

}
