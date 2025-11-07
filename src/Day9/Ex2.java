package Day9;

//Write a java program to remove duplicates from an Array

import java.util.*;

public class Ex2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 1, 5, 3};
        Set<Integer> set = new LinkedHashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }

        System.out.println(Arrays.toString(result));
    }

}
