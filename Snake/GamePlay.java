package mygames.game.Snake;

public enum GamePlay {
    RUN,
    STOPPED;

    public boolean isRun(){return this == RUN;}
    public boolean isStopped(){return this == STOPPED;}

}

