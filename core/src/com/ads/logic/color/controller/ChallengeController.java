package com.ads.logic.color.controller;

import com.ads.logic.color.Answer;
import com.ads.logic.color.Assets;
import com.ads.logic.color.actors.Challenge;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Administrator on 2014/7/5.
 */
public class ChallengeController extends IController {
    private Challenge challenge;
    private int level;
    private int gateNum;
    private float top;

    public ChallengeController(int lv, int num, String name, float t) {
        setName(name);
        level = lv;
        gateNum = num;
        challenge = new Challenge(num, t);
        addActor(challenge);
        top = t;
    }

    @Override
    public void handler() {
        challenge.remove();
        gateNum++;
        if (Answer.isLasterSmallGate(gateNum)) {
            level++;
        }
        if (level < Assets.LEVEL_MAX) {
            challenge = new Challenge(gateNum, top);
            addActor(challenge);
        }
    }

    public void buildChallenge(int lv, int num) {
        level = lv;
        gateNum = num;
        challenge.remove();
        challenge = new Challenge(gateNum, top);
        addActor(challenge);
    }

    public int getGateNum() {
        return gateNum;
    }
}
