package com.codility;
import java.util.stream.IntStream;

class Solution {

    public static void main(String[] args) {

        int S[] = {8, 42, -3, -14, -5, 7, 8, 3};
        int W[] = {2, -3, 3, -1, 10, 8, 2, 5, 13, -5, 3, -18};

        System.out.println(solution(S));

    }

    public static String solution(int[] T) {

        final int tempsPerSeason = T.length / 4;
        int index = 0;
        int value = Integer.MIN_VALUE;

        System.out.println("count: " + tempsPerSeason + "\nlength: " + T.length);

        for (int i = 0; i < 4; ++i) {

            int max = IntStream.of(T)
                    .skip(tempsPerSeason * i)
                    .limit(tempsPerSeason)
                    .max()
                    .getAsInt();

            int min = IntStream.of(T)
                    .skip(tempsPerSeason * i)
                    .limit(tempsPerSeason)
                    .min()
                    .getAsInt();

            int diff = max - min;

            if (diff > value) {
                index = i;
                value = diff;
            }

        }

        final String[] seasons = {"WINTER", "SPRING", "SUMMER", "AUTUMN"};
        return seasons[index];

    }

}
