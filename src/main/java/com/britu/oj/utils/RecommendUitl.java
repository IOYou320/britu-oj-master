package com.britu.oj.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: britu-oj
 * @description: 推荐题目工具类
 * @author: Gauss
 * @date: 2020-08-11 20:47
 **/
public class RecommendUitl {
    public static String Recommend(double ability){
        Map<Double,String> recommendMap = new HashMap<>();
        recommendMap.put(0.4,"P1000");
        recommendMap.put(0.5,"P1006");
        recommendMap.put(0.6,"P1004");
        recommendMap.put(0.7,"P1003");
        if(ability <= 0.5){
            return recommendMap.get(0.4);
        }
        else if(ability > 0.5 && ability <= 0.6){
            return recommendMap.get(0.5);
        }
        else if(ability > 0.6 && ability <= 0.7){
            return recommendMap.get(0.6);
        }
        else{
            return recommendMap.get(0.7);
        }


    }

}

