package Day9;

//Write a java program to left rotate an array for k times(Both Brute force approach and Recursive Approach)
//Recursive Approach

import java.util.*;

public class Ex1RecursiveApproach {
    public static void leftRotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        rotateRecursive(nums, k);
    }

    private static void rotateRecursive(int[] nums, int k) {
        if (k == 0) return;
        int first = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = first;
        rotateRecursive(nums, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        leftRotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
