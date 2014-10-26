package com.ads.logic.color.actors;

import com.ads.logic.color.Answer;
import com.ads.logic.color.Assets;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Administrator on 2014/7/5.
 */
public class Challenge extends Group {

    public Challenge(int gateNum, float t) {
        Integer[][] bmpIds = Answer.CHALLENGES.get(gateNum);
        for (int i = 0; i < 9; i++) {
            float top = 0;
            float left = 0;
            float y1 = t - Assets.CHANGLL_SIZE_SPRITE;
            float y2 = y1 - Assets.CHANGLL_SIZE - Assets.CHANGLL_AREA_V_SPACE;
            float y3 = y2 - Assets.CHANGLL_SIZE - Assets.CHANGLL_AREA_V_SPACE;
            switch (i) {
                case 0:
                    left = 0;
                    top = y1;
                    break;
                case 1:
                    left = Assets.CHANGLL_AREA_W + Assets.CHANGLL_AREA_H_SPACE;
                    top = y1;
                    break;
                case 2:
                    left = 2 * Assets.CHANGLL_AREA_W + 2 * Assets.CHANGLL_AREA_H_SPACE;
                    top = y1;
                    break;
                case 3:
                    left = 0;
                    top = y2;
                    break;
                case 4:
                    left = Assets.CHANGLL_AREA_W + Assets.CHANGLL_AREA_H_SPACE;
                    top = y2;
                    break;
                case 5:
                    left = 2 * Assets.CHANGLL_AREA_W + 2 * Assets.CHANGLL_AREA_H_SPACE;
                    top = y2;
                    break;
                case 6:
                    left = 0;
                    top = y3;
                    break;
                case 7:
                    left = Assets.CHANGLL_AREA_W + Assets.CHANGLL_AREA_H_SPACE;
                    top = y3;
                    break;
                case 8:
                    left = 2 * Assets.CHANGLL_AREA_W + 2 * Assets.CHANGLL_AREA_H_SPACE;
                    top = y3;
                    break;
            }
            buildCube(top, left);
            Integer[] qs = bmpIds[i];
            for (int m = 0; m < qs.length; m++) {
                int p = qs[m] - 1;
                if (p != -1) {
                    buildImage(new Image(Assets.pieces[p]), top, left, m);
                }
            }
        }
    }

    private void buildCube(float top, float left) {
        for (int i = 0; i < 9; i++) {
            Image image = new Image(Assets.areaBg);
            buildImage(image, top, left, i);
        }
    }

    private void buildImage(Image image, float top, float left, int i) {
        float spriteSize = Assets.CHANGLL_SIZE_SPRITE;
        float x = 0;
        float y = 0;
        switch (i) {
            case 0:
                x = left;
                y = top;
                break;
            case 1:
                x = left + spriteSize;
                y = top;
                break;
            case 2:
                x = left + 2 * spriteSize;
                y = top;
                break;
            case 3:
                x = left;
                y = top - spriteSize;
                break;
            case 4:
                x = left + spriteSize;
                y = top - spriteSize;
                break;
            case 5:
                x = left + 2 * spriteSize;
                y = top - spriteSize;
                break;
            case 6:
                x = left;
                y = top - 2 * spriteSize;
                break;
            case 7:
                x = left + spriteSize;
                y = top - 2 * spriteSize;
                break;
            case 8:
                x = left + 2 * spriteSize;
                y = top - 2 * spriteSize;
                break;
        }
        image.setBounds(x, y, Assets.CHANGLL_SIZE_SPRITE, Assets.CHANGLL_SIZE_SPRITE);
        addActor(image);
    }
}
