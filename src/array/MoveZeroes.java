package array;

/**
 * @author linhuankai
 * @date 2020/11/13 0:16
 *
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == 0 && nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    break;
                }
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        int length = nums.length;
        int notZero = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[notZero ++] = nums[i];
            }
        }
        if (notZero > 0) {
            for (int i = notZero; i < length; i++) {
                nums[i] = 0;
            }
        }
    }
}
