package com.ads.logic.color.listener;

import com.ads.logic.color.Answer;
import com.ads.logic.color.Assets;
import com.ads.logic.color.actors.Area;
import com.ads.logic.color.actors.Piece;
import com.ads.logic.color.controller.AreaController;
import com.ads.logic.color.controller.IController;
import com.ads.logic.color.controller.PieceController;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.SnapshotArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/7/4.
 */
public class PieceDetector extends GestureDetector {
    private Stage stage;

    /**
     * Creates a new GestureDetector with default values: halfTapSquareSize=20, tapCountInterval=0.4f, longPressDuration=1.1f,
     * maxFlingDelay=0.15f.
     *
     * @param listener
     */
    public PieceDetector(Stage stage, GestureListener listener) {
        super(listener);
        this.stage = stage;
    }

    public boolean isPass(int gateNum) {
        AreaController areaCtrl = (AreaController) stage.getRoot().findActor(IController.AREA_CTRL);
        SnapshotArray<Actor> children = areaCtrl.getChildren();
        for (Actor actor : children) {
            Area area = (Area) actor;
            if (area.getPieceId() == -1) {
                return false;
            }
        }
        PieceController pieceController = (PieceController) stage.getRoot().findActor(IController.PIECE_CTRL);
        SnapshotArray<Actor> actors = pieceController.getChildren();
        Integer[] answer = Answer.VALUES.get(gateNum);
        for (Actor actor : actors) {
            Piece piece = (Piece) actor;
            int areaId = piece.getArea();
            if (areaId == -1) {
                return false;
            }
            int pieceId = piece.getId();
            if (answer[areaId] == pieceId + 1) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
