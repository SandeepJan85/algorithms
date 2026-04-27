package org.unplugged.greedy;

import java.util.Arrays;

public class JobSequencingWithDeadlines {
    public static void main(String[] a) {
        int[] profits = {35, 10, 25, 20, 15, 12, 10};
        int[] deadlines = {2, 1, 2, 2, 3, 3, 3};
        System.out.println(calculateMaxProfit(profits, deadlines));
    }

    /**
     * This function calculates the max profit that can be made by executing the jobs
     * that produce the maximum profit within the available slots, The criteria to apply
     * greedy method here is to have the profits to be arranged in a non-increasing order
     *
     * Each element in the arrays represent the profit and the deadline for each job
     *
     * @param profits is the profit that can be made for each job
     * @param deadlines is the amount of time a job can wait
     * @return
     */
    public static int calculateMaxProfit(int[] profits, int[] deadlines) {
        //find out the maximum number of slots available
        int numSlots = Arrays.stream(deadlines).max().getAsInt();
        int[] slots = new int[numSlots];
        int profit = 0;
        for (int i = 0; i < profits.length; i++) {
            int slot = deadlines[i];
            while (slot - 1 >= 0) {
                if (slots[slot - 1] == 0) {
                    slots[slot - 1] = profits[i];
                    profit += profits[i];
                    break;
                }
                slot -= 1;
            }
            if (slots.length == deadlines[i]) break;
        }
        return profit;
    }
}
