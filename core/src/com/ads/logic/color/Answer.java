package com.ads.logic.color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/6/24.
 */
public class Answer {
    public static final int GATE_MAX = 12;
    public final static int GRADE_1 = 1;
    public final static int GRADE_2 = 3;
    public final static int GRADE_3 = 5;
    public final static List<Integer[]> VALUES = new ArrayList<Integer[]>();
    public final static List<Integer[][]> CHALLENGES = new ArrayList<Integer[][]>();
    public final static String[] TITLES = new String[]{
            "时间已到!", "恭喜您过关了!", "您真牛!", "您真棒!"};

    private final static Integer[] VALUE1 =
            {1, 2, 3, 4, 5, 6, 7, 8, 9};

    static {
        VALUES.add(VALUE1);
    }

    private final static Integer[][] CHALLENGE1 = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 4, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 5, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 6, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 7, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 8, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 9}
    };

    static {
        CHALLENGES.add(CHALLENGE1);
    }

    public static List<Integer> gateStars = new ArrayList<Integer>();

    public static boolean isLasterSmallGate(int nextGateNum) {
        return nextGateNum == 12 || nextGateNum == 24 || nextGateNum == 36 || nextGateNum == 48 || nextGateNum == 60 || nextGateNum == 72;
    }
}
