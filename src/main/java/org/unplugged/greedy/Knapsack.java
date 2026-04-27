package org.unplugged.greedy;

import java.util.Arrays;

public class Knapsack {
    public static void main(String[] a) {
        int[] profit = {10, 5, 15, 7, 6, 18, 3};
        int[] weight = {2, 3, 5, 7, 1, 4, 1};
        int capacity = 15;
        System.out.println(calculateMaxProfit(profit, weight, capacity));
    }

    public static float calculateMaxProfit(int[] profit, int[] weight, int capacity) {
        float[] profitPerWeight = new float[profit.length];
        float[] quantity = new float[profit.length];
        for (int i = 0; i < profit.length; i++) {
            profitPerWeight[i] = (float) profit[i] / weight[i];
        }
        while (capacity > 0) {
            int maxProfitIndex = -1;
            float maxProfit = 0;
            for (int i = 0; i < profitPerWeight.length; i++) {
                if (maxProfit < profitPerWeight[i] && quantity[i] == 0) {
                    maxProfit = profitPerWeight[i];
                    maxProfitIndex = i;
                }
            }

            if (maxProfitIndex == -1) break;
            if (capacity - weight[maxProfitIndex] >= 0) {
                capacity = capacity - weight[maxProfitIndex];
                quantity[maxProfitIndex] = 1;
            } else {
                quantity[maxProfitIndex] = (float) capacity / weight[maxProfitIndex];
                capacity = 0;
            }
        }

        float maxProfit = 0;
        for (int i = 0; i < quantity.length; i++) {
            maxProfit = maxProfit + quantity[i] * profit[i];
        }
        return maxProfit;
    }
}
