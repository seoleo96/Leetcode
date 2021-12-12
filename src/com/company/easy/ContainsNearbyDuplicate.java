package com.company.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1, 2, 3};
        int k = 2;
        containsNearbyDuplicate(nums, k);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {//&& Math.abs(one_i -two_i) <= k
        int len = nums.length - 1;
        int one_i = 0;
        int two_i = 1;
        while (one_i <= len) {
            int one = nums[one_i];
            int next = nums[two_i];

            if ((one == next) && Math.abs(one_i - two_i) <= k) {
                System.out.println(one_i + " " + two_i);
                return true;
            } else if (one == nums[len] && Math.abs(one_i - len) <= k) {
                System.out.println(one_i + " " + len);
                return true;

            } else if (two_i < len) {

                if (two_i + 1 == len) {
                    one_i++;
                    two_i = one_i + 1;
                } else {
                    two_i++;
                }
            } else {
                System.out.println(false);
                return false;
            }
        }
        System.out.println(false);
        return false;
    }

    public static boolean containsNearbyDuplicate1(int[] nums, int k) {//&& Math.abs(one_i -two_i) <= k

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
