package mygames.game.Snake;

public class GameConfig {

    public static GamePlay GMstate=GamePlay.RUN;

    public static GamePlay getGMstate() {
        return GMstate;
    }

    public static void setGMstate(GamePlay GMstate) {
        GameConfig.GMstate = GMstate;
    }

}
