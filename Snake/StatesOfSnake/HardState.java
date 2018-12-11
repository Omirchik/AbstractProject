package mygames.game.Snake.StatesOfSnake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import mygames.game.Snake.Snake;

public class HardState extends State {
    private Snake snake;
    public HardState(Snake snake){
        this.snake=snake;
    }
    @Override
    public void moving() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && !(snake.getMovement().equals("left"))){
            snake.setMovement("right");
        }if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !(snake.getMovement().equals("right"))){
            snake.setMovement("left");
        }if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && !(snake.getMovement().equals("down"))){
            snake.setMovement("up");
        }if (Gdx.input.isKeyPressed(Input.Keys.UP) && !(snake.getMovement().equals("up"))){
            snake.setMovement("down");
        }
    }
}
