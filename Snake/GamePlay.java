package mygames.game.Snake;

public enum GamePlay {
    RUN,
    STOPPED,
    START;

    public boolean isRun(){return this == RUN;}
    public boolean isStopped(){return this == STOPPED;}

}

