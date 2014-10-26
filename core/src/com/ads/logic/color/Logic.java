package com.ads.logic.color;

import com.ads.logic.color.screen.MainScreen;
import com.badlogic.gdx.Game;

public class Logic extends Game {
    private MainScreen mainScreen;
    private PEvent pEvent;

    public Logic() {
    }

    public Logic(PEvent pe) {
        pEvent = pe;
    }

    @Override
    public void create() {
        Assets.load();
        mainScreen = new MainScreen(this);
        setScreen(mainScreen);
    }

    public MainScreen getMainScreen() {
        return mainScreen;
    }

    public PEvent getPEvent() {
        return pEvent;
    }
}
