package org.jjianga.voter.enums;

public enum PLAYER_STATE {
    /**
     *
     */
    DEFAULT_STAGE(0),PLAYER_ON_STAGE(1);
    public int state;
    PLAYER_STATE(int state){
        this.state = state;
    }
}
