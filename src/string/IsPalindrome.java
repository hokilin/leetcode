package string;

/**
 * @author linhuankai
 * @date 2020/12/13 23:42
 * <p>
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return true;
        }
        int j = length - 1;
        for (int i = 0; i < j; ) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if (!Character.isLetterOrDigit(left) || !Character.isLetterOrDigit(right)) {
                if (!Character.isLetterOrDigit(left)) {
                    i++;
                }
                if (!Character.isLetterOrDigit(right)) {
                    j--;
                }
                continue;
            }
            if (Character.toLowerCase(left) == Character.toLowerCase(right)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome1(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        boolean palindrome = IsPalindrome.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
        boolean palindrome1 = IsPalindrome.isPalindrome("race a car");
        System.out.println(palindrome1);
    }
}
