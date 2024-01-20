package com.bank.utils;

import java.util.Random;

public class Utility {
    public static String getRandomAccountNumber() {
        Random rand = new Random();
        StringBuilder card = new StringBuilder();
        for (int i = 0; i < 14; i++)
        {
            int n = rand.nextInt(10);
            card .append(Integer.toString(n));
        }
        return card.toString();
    }
}
