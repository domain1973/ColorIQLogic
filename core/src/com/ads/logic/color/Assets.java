/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.ads.logic.color;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

public class Assets {
    public static AssetManager assetManager;

    public static Music musicbg;
    public static Sound btnSound;
    public static Sound starSound;
    public static TextureRegion gameBg;
    public static TextureRegion theme;
    public static TextureRegion winBg;
    public static TextureRegion layerBg;
    public static TextureRegion areaBg;
    public static TextureRegion dlgBg;
    public static TextureRegion resultBg;
    public static TextureRegion star;
    public static TextureRegion star_null;
    public static TextureRegion readme;
    public static TextureRegion help;
    public static TextureRegion share;
    public static TextureRegion recommend;
    public static TextureRegion refresh;
    public static TextureRegion returnTr;
    public static TextureRegion light;
    public static TextureRegion gate;
    public static TextureRegion next;
    public static TextureRegion suspend;
    public static TextureRegion setting;
    public static TextureRegion continueTr;
    public static TextureRegion music;
    public static TextureRegion sound;
    public static TextureRegion about;
    public static TextureRegion buy;
    public static TextureRegion forbid;
    public static TextureRegion exit;
    public static TextureRegion playBtn;
    public static TextureRegion playBtnDown;
    public static TextureRegion resetGameBtn;
    public static TextureRegion levelPreBtn;
    public static TextureRegion levelNextBtn;
    public static TextureRegion gate_0star;
    public static TextureRegion gate_1star;
    public static TextureRegion gate_2star;
    public static TextureRegion gate_3star;
    public static TextureRegion gate_lock;
    public static TextureRegion lock;
    public static TextureRegion cannot;
    public static TextureRegion yy;
    public static TextureRegion[] cubes;
    public static float TOPBAR_HEIGHT;//顶部按钮条的高度
    public static float WIDTH;
    public static float HEIGHT;
    public static float GAME_HEIGHT;
    public static float GAME_WIDTH;
    public static float PIECE_SIZE;
    public static float CHANGLL_SIZE;
    public static float CHANGLL_SIZE_SPRITE;
    public static float GAME_README_H;
    public static float CHANGLL_AREA_H;
    public static float CHANGLL_AREA_W;
    public static float CHANGLL_AREA_H_SPACE;
    public static float CHANGLL_AREA_V_SPACE;
    public static float AREA_SIZE;
    public static float LEVEL_IMAGE_SIZE;
    public static float LEVEL_IMAGE_OFF_SIZE;
    public static int LEVEL_MAX = 5;

    public static List<Sprite> levels;
    public static Sprite[] pieces;
    public static BitmapFont gameFont;
    public static BitmapFont otherFont;
    public static BitmapFont readmeFont;
    public static BitmapFont quizFont;

    public static void load() {
        assetManager = new AssetManager();
        assetManager.load("p.atlas", TextureAtlas.class);
        assetManager.load("puzzle.fnt", BitmapFont.class);
        assetManager.load("game.fnt", BitmapFont.class);
        assetManager.load("readme.fnt", BitmapFont.class);
        assetManager.load("quiz.fnt", BitmapFont.class);
        assetManager.load("data/musicbg.mp3", Music.class); //加载背景音乐
        assetManager.load("data/btn.wav", Sound.class);
        assetManager.load("data/star.mp3", Sound.class);
        assetManager.finishLoading();
        gameFont = assetManager.get("puzzle.fnt", BitmapFont.class);
        otherFont = assetManager.get("game.fnt", BitmapFont.class);
        readmeFont = assetManager.get("readme.fnt", BitmapFont.class);
        quizFont = assetManager.get("quiz.fnt", BitmapFont.class);
        btnSound = assetManager.get("data/btn.wav", Sound.class);
        starSound = assetManager.get("data/star.mp3", Sound.class);
        musicbg = assetManager.get("data/musicbg.mp3", Music.class);    //加载背景音乐
        initConstants();
        TextureAtlas atlas = assetManager.get("p.atlas", TextureAtlas.class);
        loadBmps(atlas);
        createLevels(atlas);
        creteMagicCubes(atlas);
        loadMusic();
    }

    private static void initConstants() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        TOPBAR_HEIGHT = HEIGHT / 16;
        GAME_HEIGHT = 13*HEIGHT/16;
        GAME_WIDTH = WIDTH;

        AREA_SIZE = WIDTH / 2;
        PIECE_SIZE = AREA_SIZE / 3;

        CHANGLL_SIZE = WIDTH / 12 * 3.5f;
        CHANGLL_SIZE_SPRITE = CHANGLL_SIZE / 3;
        CHANGLL_AREA_H = HEIGHT * 3 / 16;
        CHANGLL_AREA_W = CHANGLL_SIZE;
        CHANGLL_AREA_H_SPACE = (WIDTH - WIDTH / 4 * 3.5f) / 2;
        CHANGLL_AREA_V_SPACE = WIDTH * 5 / 854;

        GAME_README_H = HEIGHT / 8;

        LEVEL_IMAGE_SIZE = WIDTH;
        LEVEL_IMAGE_OFF_SIZE = WIDTH / 7;
    }

    private static void loadBmps(TextureAtlas atlas) {
        gameBg = atlas.findRegion("gamebg");
        theme = atlas.findRegion("theme");
        layerBg = atlas.findRegion("layerbg");//图层背景,对话框使用
        winBg = atlas.findRegion("winbg");
        dlgBg = atlas.findRegion("dlgbg");
        areaBg = atlas.findRegion("area");
        resultBg = atlas.findRegion("resultbg");
        readme = atlas.findRegion("readme");

        suspend = atlas.findRegion("suspend");
        share = atlas.findRegion("share");
        recommend = atlas.findRegion("recommend");
        light = atlas.findRegion("light");
        next = atlas.findRegion("next");
        returnTr = atlas.findRegion("return");
        help = atlas.findRegion("help");
        refresh = atlas.findRegion("refresh");
        gate = atlas.findRegion("gate");
        setting = atlas.findRegion("setting");
        music = atlas.findRegion("muisc");
        sound = atlas.findRegion("sound");
        continueTr = atlas.findRegion("continue");
        about = atlas.findRegion("about");
        buy = atlas.findRegion("buy");
        star = atlas.findRegion("star");
        star_null = atlas.findRegion("star_null");
        forbid = atlas.findRegion("forbid");
        lock = atlas.findRegion("lock");
        exit = atlas.findRegion("exit");
        playBtn = atlas.findRegion("playbtn");
        playBtnDown = atlas.findRegion("playbtndown");
        resetGameBtn = atlas.findRegion("resetgamebtn");
        levelPreBtn = atlas.findRegion("levelpre");
        levelNextBtn = atlas.findRegion("levelnext");
        cannot = atlas.findRegion("cannot");
        yy = atlas.findRegion("yy");

        gate_0star = atlas.findRegion("gate_0star");
        gate_1star = atlas.findRegion("gate_1star");
        gate_2star = atlas.findRegion("gate_2star");
        gate_3star = atlas.findRegion("gate_3star");
        gate_lock = atlas.findRegion("gate_lock");
    }

    private static void creteMagicCubes(TextureAtlas atlas) {
        cubes = new TextureRegion[9];
        pieces = new Sprite[9];
        for (int i = 0; i < 9; i++) {
            String name = "piece" + i;
            pieces[i] = atlas.createSprite(name);
            cubes[i] = atlas.findRegion(name);
        }
    }

    private static void createLevels(TextureAtlas atlas) {
        levels = new ArrayList<Sprite>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Sprite s = atlas.createSprite("s" + i);
            if (s == null) {
                break;
            }
            levels.add(s);
        }
    }

    public static void playSound(Sound sound) {
        if (Settings.soundEnabled) sound.play(1);
    }

    private static void loadMusic() {
        musicbg.setLooping(true);  //设置背景音乐循环播放
        musicbg.setVolume(0.5f);   //设置音量
        if (Settings.musicEnabled) {
            musicbg.play();        //播放背景音乐
        }
    }
}
