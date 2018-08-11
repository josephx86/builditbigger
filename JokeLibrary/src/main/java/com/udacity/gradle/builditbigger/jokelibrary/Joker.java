package com.udacity.gradle.builditbigger.jokelibrary;

import java.util.Random;

public class Joker {
    // Jokes obtained from https://www.rd.com/jokes/corny/
    private static String[] jokesArray = new String[]{
            "I can't stand Russian nesting dolls. They're so full of themselves.",
            "Q. What happened when one cannibal arrived late to the dinner party? \n\nA. The others gave him the cold shoulder.",
            "A burglar stole all the lamps in my house. I know I should be more upset, but I'm absolutely delighted.",
            "Q. Why was the belt sent to jail?\n\nA. For holding up a pair of pants!",
            "Q. Why did the invisible man turn down the job offer?\n\nA. Because he just couldn't see himself doing it.",
            "Two fish are in a tank. One says to the other, 'Do you know how to drive this thing?'"
    };

    private static Random prng;

    static {
        prng = new Random(System.currentTimeMillis());
    }

    public static String getJoke() {
        int index = prng.nextInt(jokesArray.length);
        return jokesArray[index];
    }
}
