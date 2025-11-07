package Day9;

import java.util.Scanner;

/*
Declaration
1. datatype arrName[];
2. datatype[] arrName;

Initialization
1. int[] nums={1,2,3,4,5};
2. int[] nums=new int[]{1,2,3,4,5};
3. int[] nums=new int[5];
nums[0]=1;
nums[1]=2;
nums[2]=3;
nums[3]=4;
nums[4]=5;
 */

public class Array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter No of elements");
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){//0<5 1<5 2<5 3<5 4<5 5<5
            nums[i]=sc.nextInt();//1 2 3 4 5
        }

        for(int i=0;i<n;i++){//0<5 1<5 2<5 3<5 4<5 5<5
            System.out.print(nums[i]+" ");//1 2 3 4 5
        }
        System.out.println();
        for(int i=n-1;i>=0;i--){
            System.out.print(nums[i]+" ");
        }

    }
}
