package com.itqf.commen;

import java.util.Random;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/811:22
 * description:
 */
public class RandomCode {
    private RandomCode(){}

    public static String getCode(){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }


}
