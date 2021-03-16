package string;

/**
 * @author linhuankai
 * @date 2020/11/18 0:10
 * <p>
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseInt {
    public int reverse(int x) {
        boolean minus = false;
        if (x < 0) {
            minus = true;
            x *= -1;
            if (x < 0) {
                return 0;
            }
        }
        char[] s = String.valueOf(x).toCharArray();
        for (int i = 0; i < s.length / 2; i++) {
            int j = s.length - 1 - i;
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (char ss : s) {
            sb.append(ss);
        }
        String string = sb.toString();
        long value = Long.valueOf(string);
        if (minus) {
            value *= -1;
        }
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) value;
        }
    }

    /**
     * 数学计算法
     * @param x
     * @return
     */
    public int reverse1(int x) {
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)){
                return 0;
            }else if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10)){
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int reverse3(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }

    public int reverse4(int x) {
        long temp = 0;

        while(x != 0){
            int pop = x % 10;
            temp = temp * 10 + pop;

            if(temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE){
                return 0;
            }
            x /= 10;
        }
        return (int)temp;
    }

    public static void main(String[] args) {
        int reverse = new ReverseInt().reverse(-2147483648);
        System.out.println(reverse);
        int reverse1 = new ReverseInt().reverse1(-214648);
        System.out.println(reverse1);
    }
}
