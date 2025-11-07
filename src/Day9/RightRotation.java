package Day9;

import java.util.Arrays;

//Right Rotation Using Brute force approach
public class RightRotation {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        int k=2;
        for(int i=0;i<k;i++){
            int j;
            int temp=nums[nums.length-1];
            for(j=nums.length-1;j>0;j--){
                nums[j]=nums[j-1];
            }
            nums[0]=temp;
        }
        System.out.println(Arrays.toString(nums));
    }

}
