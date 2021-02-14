package com.utilities;

public class ThreadSleep {

    public static void sleep(int seconds) {

        seconds *= 1000;

        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("If you are reading this message, this method is broken");
        }

    }
}
