package com.utilities;

public class ThreadSleep {


    public static void sleep(int second)  {

        second *=1000 ;

            try {
                Thread.sleep(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Something is not working with sleep method");
            }

    }








}
