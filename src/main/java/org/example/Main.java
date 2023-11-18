package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(KUniqueCharacters("2aabbcbbbadef"));
        System.out.println(KUniqueCharacters("2aabbacbaa"));
    }

    public static String KUniqueCharacters(String str) {
        Map<String, Integer> map = new HashMap<>();
        int differentCharCount = Integer.parseInt(String.valueOf(str.charAt(0)));
        String maxSubStr = "";
        int mapCharCount = 0;

        int resultBeginIndex = 0;
        int resultEndIndex = 0;

        int j = 0;

        for (int i = 1; i < str.length(); i++) {
            maxSubStr = str.substring(j+1, i);
            String charToAdd = String.valueOf(str.charAt(i));
            map.put(charToAdd, map.getOrDefault(charToAdd, 0) + 1);
            mapCharCount++;

            if (map.size() > differentCharCount) {
                j++;
                String charForReduce = String.valueOf(str.charAt(j));
                if (map.get(charForReduce) == 1) {
                    map.remove(charForReduce);
                } else {
                    map.computeIfPresent(charForReduce, (key, val) -> val - 1);
                }
                mapCharCount--;
            }

            if (maxSubStr.length() < mapCharCount) {
                resultBeginIndex = j+1;
                resultEndIndex = i+1;
            }
        }

        return str.substring(resultBeginIndex, resultEndIndex);
    }
}