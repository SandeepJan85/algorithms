package org.unplugged.pointers;

public class ContainerWithWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(calculateMostWaterInAContainer(height, 0, height.length - 1));
    }

    public static int calculateMostWaterInAContainer(int[] height, int begin, int end) {
        int maxWater = 0;
        while (begin < end) {
            if (height[begin] < height[end]) {
                maxWater = Math.max(maxWater, (end - begin) * height[begin]);
                begin ++;
            } else {
                maxWater = Math.max(maxWater, (end - begin) * height[end]);
                end --;
            }
        }
        return maxWater;
    }
}
