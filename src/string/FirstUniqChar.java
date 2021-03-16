package string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author linhuankai
 * @date 2020/11/19 22:46
 * <p>
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例：
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 提示：你可以假定该字符串只包含小写字母
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        char[] ss = s.toCharArray();
        if (ss.length == 0) {
            return -1;
        }
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < ss.length; i++) {
            if (map.get(ss[i]) == null) {
                map.put(ss[i], i);
            } else {
                map.put(ss[i], -1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 0) {
                return entry.getValue();
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (result[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int leetcode = new FirstUniqChar().firstUniqChar("leetcode");
        System.out.println(leetcode);
    }
}
