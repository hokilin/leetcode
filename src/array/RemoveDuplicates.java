package array;

/**
 * @author linhuankai
 * @date 2020/9/26 0:15
 * 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {
    /**
     * 首次提交的，效率差
     * @param nums
     * @return
     */
    public int firstSubmit(int[] nums) {
        int result = 1;
        for(int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    nums[i + 1] = nums[j];
                    result ++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        return result;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
