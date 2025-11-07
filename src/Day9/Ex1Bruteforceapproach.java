package Day9;

//Write a java program to left rotate an array for k times(Both Brute force approach and Recursive Approach)
// Brute force approach

import java.util.*;

public class Ex1Bruteforceapproach {
    public static void leftRotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        for (int i = 0; i < k; i++) {
            int first = nums[0];
            for (int j = 0; j < n - 1; j++) {
                nums[j] = nums[j + 1];
            }
            nums[n - 1] = first;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        leftRotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
