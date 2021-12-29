package ru.vsu.cs.factory;

import java.util.Random;

public class RndUtils {
    private static final Random rnd = new Random();

    public static int randInt(int min, int max) {
        return rnd.nextInt(max - min) + min;
    }

    public static Random getRnd() {
        return rnd;
    }
}
