package array;

import java.util.Arrays;

/**
 * @author linhuankai
 * @date 2020/10/19 0:18
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度:O(n)。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例   2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 2) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] < nums[i + 1]) {
                return nums[i];
            } else if (i == (nums.length - 1) && nums[i] > nums[i - 1]) {
                return nums[i];
            } else if (i != 0 && i != nums.length - 1 && nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 异或解法
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1};
//        int result = singleNumber(nums);
//        System.out.println(result);
        System.out.println(1 ^ 4);
    }
}
