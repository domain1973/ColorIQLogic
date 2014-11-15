package com.ads.logic.color.actors;

import com.ads.logic.color.Assets;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Administrator on 2014/7/4.
 */
public class Piece extends Image {
    private int area = -1;
    private int id;

    public Piece(int pieceId) {
        super(Assets.pieces[pieceId]);
        id = pieceId;
        return2BeginArea();
    }

    public void return2BeginArea() {
        float x = 0;
        float y = 0;
        float spriteSize = Assets.PIECE_SIZE;
        float top = Assets.HEIGHT - Assets.PIECE_SIZE - Assets.TOPBAR_HEIGHT;
        float left = 0;
        switch (id) {
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
                y = top - Assets.PIECE_SIZE;
                break;
            case 4:
                x = left + spriteSize;
                y = top - Assets.PIECE_SIZE;
                break;
            case 5:
                x = left + 2 * spriteSize;
                y = top -  spriteSize;
                break;
            case 6:
                x = left;
                y = top - 2 * spriteSize;
                break;
            case 7:
                x = left + Assets.PIECE_SIZE;
                y = top - 2 * spriteSize;
                break;
            case 8:
                x = left + 2 * Assets.PIECE_SIZE;
                y = top - 2 * spriteSize;
                break;
        }
        setBounds(x, y, Assets.PIECE_SIZE, Assets.PIECE_SIZE);
        setArea(-1);
    }



    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getId() {
        return id;
    }
}
