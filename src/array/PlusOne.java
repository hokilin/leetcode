package array;

/**
 * @author linhuankai
 * @date 2020/11/12 0:47
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例   1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例   2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]   
 * <p>
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        if (digits[length - 1] == 9) {
            digits[length - 1] = 0;
            if (length - 2 < 0) {
                return new int[]{1, 0};
            }
            digits[length - 2]++;
            for (int i = digits.length - 2; i >= 0; i--) {
                if (digits[i] == 10) {
                    digits[i] = 0;
                    if (i > 0) {
                        digits[i - 1]++;
                    } else {
                        int[] result = new int[length + 1];
                        result[0] = 1;
                        return result;
                    }
                } else {
                    return digits;
                }
            }
        } else {
            digits[length - 1]++;
        }
        return digits;
    }


    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }

        }
        //如果所有位都是进位，则长度+1
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
