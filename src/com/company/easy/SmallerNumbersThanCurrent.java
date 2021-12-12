package com.company.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
*  Input: nums = [8,1,2,2,3]
*  Output: [4,0,1,1,3]
*
 */
public class SmallerNumbersThanCurrent {

    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 2, 2, 3};
        smallerNumbersThanCurrent(nums);
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy); // 1 2 2 3 8
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < copy.length; i++) {
            if (map.get(copy[i]) == null) // or putIFAbsent(copy[i])
                map.put(copy[i], i);
        }
        System.out.println(map);
        for (int i = 0; i < copy.length; i++) {
            int position = nums[i]; //8
            nums[i] = map.get(position);
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
        return nums;
    }
}
