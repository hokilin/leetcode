package string;

/**
 * @author linhuankai
 * @date 2021/1/27 0:07
 */
public class MyAtoi {
    public static int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int index = 0;
        //正负, 默认为正
        int pm = 1;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (index == 0) {
                    continue;
                } else {
                    break;
                }
            }
            if (c == '-') {
                if (index == 0) {
                    index++;
                    pm = -1;
                    continue;
                } else {
                    break;
                }
            }
            if (c == '+') {
                if (index == 0) {
                    index++;
                    continue;
                } else {
                    break;
                }
            }
            if (Character.isDigit(c)) {
                sb.append(c);
                index++;
            } else {
                break;
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        try {
            return Integer.valueOf(sb.toString()) * pm;
        } catch (NumberFormatException e) {
            if (pm == -1) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("+-12"));
    }
}
