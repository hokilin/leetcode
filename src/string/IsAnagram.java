package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linhuankai
 * @date 2020/11/21 22:33
 * <p>
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            map.merge(a, 1, Integer::sum);
        }
        for (int i = 0; i < t.length(); i++) {
            char a = t.charAt(i);
            Integer count = map.get(a);
            if (count != null && count > 0) {
                map.put(a, count - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char a = t.charAt(i);
            Integer count = map.get(a);
            if (count != null && count > 0) {
                map.put(a, count - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
            map.merge(t.charAt(i), -1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (Arrays.equals(c1, c2)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int j = t.charAt(i) - 'a';
            table[j]--;
            if (table[j] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean anagram = new IsAnagram().isAnagram("anagram", "nagaram");
        System.out.println(anagram);
        boolean rat = new IsAnagram().isAnagram("rat", "car");
        System.out.println(rat);
        boolean ss = new IsAnagram().isAnagram("", "");
        System.out.println(ss);
    }
}
