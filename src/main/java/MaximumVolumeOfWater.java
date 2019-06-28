package main.java;

public class MaximumVolumeOfWater {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        maxArea(nums);
    }

    private static void maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        int maximumVolume = Integer.MIN_VALUE;
        int currentVolume, selectedLeft = 0, selectedRight = height.length-1;

        while (left < right) {
            currentVolume = (right - left) * Math.min(height[left], height[right]);

            if(maximumVolume < currentVolume)
            {
                maximumVolume = currentVolume;
                selectedLeft = left;
                selectedRight = right;
            }

            if(height[left] < height[right])
            {
                left++;

                // some optimization
                if(height[left] <= height[left-1])
                {
                    left++;
                }
            }
            else
            {
                right--;

                // some optimization
                if(height[right] <= height[right+1])
                {
                    right--;
                }
            }
        }


        System.out.println("Maximum water - " + maximumVolume);
        System.out.println("Left - " + selectedLeft + " Right - " + selectedRight);
    }
}
