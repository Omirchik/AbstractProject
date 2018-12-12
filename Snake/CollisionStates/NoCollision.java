package mygames.game.Snake.CollisionStates;

import mygames.game.Snake.BodyPart;
import mygames.game.Snake.Snake;

public class NoCollision extends CollisionState {

    private Snake snake;
    boolean bool;
    public NoCollision(Snake snake) {
        this.snake = snake;
        bool = true;
    }
    @Override
    public void collision() {
        if (bool) {
            for (BodyPart b : snake.getBody()) {
                b.getColor().a = 0.5f;
            }
            snake.getHead().getColor().a = 0.5f;
        }
        bool = false;
    }
    public boolean isBool() {
        return bool;
    }
    public void setBool(boolean bool) {
        this.bool = bool;
    }
    public void selfCollision(){

    }
}
