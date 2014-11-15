package com.ads.logic.color.controller;

import com.ads.logic.color.Assets;
import com.ads.logic.color.actors.Area;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.SnapshotArray;

/**
 * Created by Administrator on 2014/7/6.
 */
public class AreaController extends IController {
    private Area[] areas;
    private Rectangle bounds;

    public AreaController(String name) {
        setName(name);
        areas = new Area[9];
        buildArea();
    }

    public void buildArea() {
        for (Area area : areas) {
            if (area != null) {
                area.remove();
            }
        }
        for (int i = 0; i < 9; i++) {
            areas[i] = new Area(i);
            addActor(areas[i]);
        }
        //area有效区域
        bounds = new Rectangle(areas[5].getX(), areas[5].getY(), Assets.AREA_SIZE
                * 3, Assets.AREA_SIZE * 3);
    }


    public Rectangle getBounds() {
        return bounds;
    }

    public Area[] getAreas() {
        return areas;
    }

    @Override
    public void handler() {
        SnapshotArray<Actor> actors = getChildren();
        for (Actor actor : actors) {
            Area area = (Area) actor;
            area.setPieceId(-1);
        }
    }
}
