package com.dream.interview4.algorithm;

/**
 * @Author : huzejun
 * @Date: 2024/9/4-4:58
 *
 * 快慢相等值不变，慢针不动快针走
 * 快慢不等值，我是题型2，快针慢针互换，慢针向前一步走，快针向前一步走
 */
public class LeetCodeMoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null) return;

        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                //1 通过交换，快针赋值给慢针
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                //2 慢针向前一步走
                slow++;
            }
            //3 快针向前一步走
            fast++;
        }
    }

}
