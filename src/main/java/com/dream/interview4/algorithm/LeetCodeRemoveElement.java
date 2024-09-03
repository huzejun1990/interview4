package com.dream.interview4.algorithm;

/**
 * @Author : huzejun
 * @Date: 2024/9/4-5:14
 */
public class LeetCodeRemoveElement {
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

}
