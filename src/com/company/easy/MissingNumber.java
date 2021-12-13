package com.company.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber(Main.nums));
    }

    public static int missingNumber(int[] nums) { //xor
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i))
                return i;
        }
        return -1;
    }

    public static int missingNumber5(int[] nums) { //xor
        int res = nums.length;//3
        System.out.println(res);
        for (int i = 0; i < nums.length; i++) {// 0 1 2
            res = res+i-nums[i];
        }
        return res;
    }

    public static int missingNumber2(int[] nums) { //xor
        int res = nums.length;
        System.out.println(res);
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            System.out.println(res);
            res ^= nums[i];
            System.out.println(res);
            System.out.println("----");
        }
        return res;
    }


    public static int missingNumber1(int[] nums) {
        int sum = nums.length;
        System.out.println("sum - " + sum);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(sum + " ");
            sum = sum + i - nums[i];
        }
        System.out.println();
        return sum;
    }

    public static int missingNumber3(int[] nums) {
        int sumOfNums = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(nums.length);
        int sumOfNth = 0;
        for (int i = 0; i <= nums.length; i++) {
            sumOfNth+=i;
        }
        System.out.println(sumOfNth - sumOfNums);
        return nums.length;
    }
}
