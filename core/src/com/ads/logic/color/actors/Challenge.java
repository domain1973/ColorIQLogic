package com.ads.logic.color.actors;

import com.ads.logic.color.Answer;
import com.ads.logic.color.Assets;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by Administrator on 2014/7/5.
 */
public class Challenge extends Group {

    public Challenge(int gateNum, float t) {
        Integer[][] quizs = Answer.CHALLENGES.get(gateNum);
        if (quizs.length > 9) {//包含阴影
            buildQuiz0(t, quizs);
        } else if (quizs.length == 1) {
            buildQuiz1(t, quizs[0][0]);
        } else {
            buildQuiz2(t, quizs);
        }
    }

    private void buildQuiz0(float t, Integer[][] quizs) {
        for (int i = 0; i < 12; i++) {
            float top = 0;
            float left = 0;
            float y1 = t - Assets.CHANGLL_SIZE_SPRITE;
            float y2 = y1 - 2*Assets.CHANGLL_SIZE_SPRITE ;
            float y3 = y2 - 3*Assets.CHANGLL_SIZE_SPRITE;
            float y4 = y3 - 2*Assets.CHANGLL_SIZE_SPRITE;
            Integer[] quiz = quizs[i];
            switch (i) {
                case 0:
                    left = 0;
                    top = y1;
                    buildLabel(top, left, quiz[0]);
                    break;
                case 1:
                    left = Assets.CHANGLL_AREA_W + Assets.CHANGLL_AREA_H_SPACE;
                    top = y1;
                    buildLabel(top, left, quiz[0]);
                    break;
                case 2:
                    left = 2 * Assets.CHANGLL_AREA_W + 2 * Assets.CHANGLL_AREA_H_SPACE;
                    top = y1;
                    buildLabel(top, left, quiz[0]);
                    break;
                case 3:
                    left = 0;
                    top = y2;
                    buildCube(top, left);
                    buildImages(quiz, top, left);
                    break;
                case 4:
                    left = Assets.CHANGLL_AREA_W + Assets.CHANGLL_AREA_H_SPACE;
                    top = y2;
                    buildCube(top, left);
                    buildImages(quiz, top, left);
                    break;
                case 5:
                    left = 2 * Assets.CHANGLL_AREA_W + 2 * Assets.CHANGLL_AREA_H_SPACE;
                    top = y2;
                    buildCube(top, left);
                    buildImages(quiz, top, left);
                    break;
                case 6:
                    left = 0;
                    top = y3;
                    buildLabel(top, left, quiz[0]);
                    break;
                case 7:
                    left = Assets.CHANGLL_AREA_W + Assets.CHANGLL_AREA_H_SPACE;
                    top = y3;
                    buildLabel(top, left, quiz[0]);
                    break;
                case 8:
                    left = 2 * Assets.CHANGLL_AREA_W + 2 * Assets.CHANGLL_AREA_H_SPACE;
                    top = y3;
                    buildLabel(top, left, quiz[0]);
                    break;
                case 9:
                    left = 0;
                    top = y4;
                    buildQuiz(top, left, quiz);
                    break;
                case 10:
                    left = Assets.CHANGLL_AREA_W + Assets.CHANGLL_AREA_H_SPACE;
                    top = y4;
                    buildQuiz(top, left, quiz);
                    break;
                case 11:
                    left = 2 * Assets.CHANGLL_AREA_W + 2 * Assets.CHANGLL_AREA_H_SPACE;
                    top = y4;
                    buildQuiz(top, left, quiz);
                    break;
            }
        }
    }

    private void buildQuiz(float top, float left, Integer[] quiz) {
        for (int m = 0; m < quiz.length; m++) {
            if (quiz[m] != 0) {
                buildCube(top, left);
                buildImages(quiz, top, left);
                break;
            }
        }
    }

    private void buildQuiz1(float t, Integer key) {
        String str = Answer.quiz.get(key);
        Label c = new Label(str, new Label.LabelStyle(Assets.readmeFont, Color.YELLOW));
        c.setPosition(0,  t - 2*Assets.CHANGLL_SIZE);
        addActor(c);
    }

    private void buildQuiz2(float t, Integer[][] quizs) {
        for (int i = 0; i < quizs.length; i++) {
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
            buildImages(quizs[i], top, left);
        }
    }

    private void buildImages(Integer[] quiz, float top, float left) {
        Integer[] qs = quiz;
        for (int m = 0; m < qs.length; m++) {
            if (qs[m] == 10) {
                buildImage(new Image(Assets.yy), top, left, m);
            } else if (qs[m] < 0) {//禁止放置的颜色
                int p = Math.abs(qs[m]) - 1;
                buildImage(new Image(Assets.pieces[p]), top, left, m);
                buildImage(new Image(Assets.cannot), top, left, m);
            } else {
                if (Answer.quiz.containsKey(qs[m])) {
                    buildLabel(top, left, qs[m]);
                } else {
                    int p = qs[m] - 1;
                    if (p != -1) {
                        buildImage(new Image(Assets.pieces[p]), top, left, m);
                    }
                }
            }
        }
    }

    private void buildLabel(float top, float left, Integer q) {
        String str = Answer.quiz.get(q);
        if (str != null) {
            Label c = new Label(str, new Label.LabelStyle(Assets.readmeFont, Color.YELLOW));
            c.setPosition(left, top - Assets.CHANGLL_SIZE_SPRITE);
            addActor(c);
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
