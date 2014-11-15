package com.ads.logic.color.actors;

import com.ads.logic.color.Assets;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Administrator on 2014/7/6.
 */
public class Area extends Image {
    private int id;
    private int pieceId;
    private float x;
    private float y;
    private float spriteSize;

    /**
     * 0,1,2
     * 3,4,5
     * 6,7,8
     *
     * @param areaId
     */
    public Area(int areaId) {
        super(Assets.areaBg);
        id = areaId;
        pieceId = -1;
        spriteSize = Assets.PIECE_SIZE;
        float top = Assets.HEIGHT - spriteSize - Assets.TOPBAR_HEIGHT;
        float left = Assets.AREA_SIZE;
        switch (areaId) {
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
                x = left  + 2 * spriteSize;
                y = top - 2 * spriteSize;
                break;
        }
        setBounds(x, y, spriteSize, spriteSize);
    }

    public int getId() {
        return id;
    }

    public int getPieceId() {
        return pieceId;
    }

    public void setPieceId(int pieceId) {
        this.pieceId = pieceId;
    }
}
