package com.dream.interview4.algorithm;

/**
 * @Author : huzejun
 * @Date: 2024/9/4-1:47
 * 167.两数之和 II -输入有序数组
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class LeetCodeArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        //一左一右两个指针相向而行
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // 题目要求：给你他一个下标从1 开始的整数数组 number... 所以两个下标指针都+1
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;//让sum大一点，左指针向右变大
            }else if (sum > target) {
                right--;    //让sum小一点，右指针向左变小
            }
        }
        return new int[]{-1, -1};
    }
}

