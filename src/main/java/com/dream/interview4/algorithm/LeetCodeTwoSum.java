package com.dream.interview4.algorithm;

import lombok.val;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : huzejun
 * @Date: 2024/9/1-22:17
 */
public class LeetCodeTwoSum {
    /**
     * 输入：nums = [2,7,11,15],target = 9
     * 输出：[0,1]
     * 解释: 因为 nums[0]+nums[1] == 9 ,返回[0,1]
     *
     * @param nums
     * @param target
     * @return
     */

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);

        /**
         * 输入：nums = [2,7,11,15], target = 9
         * 输出：[0,1]
         */
        for (int i = 0; i < nums.length; i++) {
            //伙伴数
            int partnerNumber = target - nums[i];

            if (map.containsKey(partnerNumber)) {
                return new int[]{map.get(partnerNumber),i};
            }
            /**
             *  map    k    v(数组下标)
             * 1       2    0
             */
            map.put(nums[i],i);
        }

        return null;
    }

    public static void main(String[] args) {
        LeetCodeTwoSum test = new LeetCodeTwoSum();

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

//        int[] ints = test.twoSum(nums, target);
        int[] ints = test.twoSum2(nums, target);

        for (int element : ints) {
            System.out.println(element);
        }

    }
}
