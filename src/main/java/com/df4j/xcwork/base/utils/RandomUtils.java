package com.df4j.xcwork.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class RandomUtils {

    private static Logger logger = LoggerFactory.getLogger(RandomUtils.class);

    public final static String NUMBER = "0123456789";
    public final static String CHAR = "ABCDEFGHIJKLMOPQRSTUVWXYZ";
    public final static String NUM_CHAR = NUMBER + CHAR;

    public static String getRandomString(String from, int length) {
        Random random = new Random();
        int index = random.nextInt(length);
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = from.charAt(index);
            index = random.nextInt(from.length());
        }
        return new String(chars);
    }

    public static String getNumberRandomString(int length) {
        return getRandomString(NUMBER, length);
    }

    public static String getCharRandomString(int length) {
        return getRandomString(CHAR, length);
    }

    public static String getRandomString(int length) {
        return getRandomString(NUM_CHAR, length);
    }
}
