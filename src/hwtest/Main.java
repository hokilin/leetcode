package hwtest;

import java.math.BigInteger;
import java.util.*;

/**
 * @author linhuankai
 * @date 2021/3/21 12:02
 */
public class Main {

    public static void main(String[] args) {
        /*Main.hexToDec();*/
        /*Main.hexToDec1();*/
        /*Main.primeFactor();*/
        /*Main.approximation();*/
        /*Main.mergeHash();*/
        /*Main.nonRepeatInteger();*/
        /*Main.countStr();*/
        /*Main.reverseInteger();*/
        /*Main.reverseString();*/
        /*Main.reverseSentence();*/
    }

    /**
     * 题目描述
     * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
     * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
     * 示例：
     * I P 地址　 192.168.0.1
     * 子网掩码　 255.255.255.0
     * 转化为二进制进行运算：
     * I P 地址　11010000.10101000.00000000.00000001
     * 子网掩码　11111111.11111111.11111111.00000000
     * AND运算
     * 11000000.10101000.00000000.00000000
     * 转化为十进制后为：
     * 192.168.0.0
     * I P 地址　 192.168.0.254
     * 子网掩码　 255.255.255.0
     * 转化为二进制进行运算：
     * I P 地址　11010000.10101000.00000000.11111110
     * 子网掩码　11111111.11111111.11111111.00000000
     * AND运算
     * 11000000.10101000.00000000.00000000
     * 转化为十进制后为：
     * 192.168.0.0
     * <p>
     * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
     * 输入一个子网掩码以及两个ip地址，判断这两个ip地址是否是一个子网络。
     * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2。
     * 输入描述:
     * 输入子网掩码、两个ip地址
     * 输出描述:
     * 得到计算结果
     * 示例1
     * 输入
     * 255.255.255.0
     * 192.168.224.256
     * 192.168.10.4
     * 255.0.0.0
     * 193.194.202.15
     * 232.43.7.59
     * 输出
     * 1
     * 2
     */
    private static void sameSubNetworkIp() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String subNetwork = in.nextLine();
            String ip1 = in.nextLine();
            String ip2 = in.nextLine();
            
        }
    }

    /**
     * 题目描述
     * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
     * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
     * <p>
     * 输入描述:
     * 输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
     * <p>
     * 输出描述:
     * 得到逆序的句子
     * <p>
     * 示例1
     * 输入
     * I am a boy
     * 输出
     * boy a am I
     */
    private static void reverseSentence() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] split = s.split(" ");
            for (int i = split.length - 1; i >= 0; i--) {
                System.out.print(split[i] + " ");
            }
        }
    }

    private static void reverseString() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.length() > 1000) {
                s = s.substring(0, 1000);
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                System.out.print(s.charAt(i));
            }
        }
    }

    /**
     * 题目描述
     * 输入一个整数，将这个整数以字符串的形式逆序输出
     * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
     * <p>
     * <p>
     * 输入描述:
     * 输入一个int整数
     * <p>
     * 输出描述:
     * 将这个整数以字符串的形式逆序输出
     * <p>
     * 示例1
     * 输入
     * 1516000
     * 输出
     * 0006151
     */
    private static void reverseInteger() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int anInt = in.nextInt();
            String s = String.valueOf(anInt);
            for (int i = s.length() - 1; i >= 0; i--) {
                System.out.print(s.charAt(i));
            }
        }
    }

    /**
     * 题目描述
     * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
     * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
     * 输入描述:
     * 输入一行没有空格的字符串。
     * <p>
     * 输出描述:
     * 输出范围在(0~127)字符的个数。
     * <p>
     * 示例1
     * 输入
     * abc
     * 输出
     * 3
     */
    private static void countStr() {
        Scanner in = new Scanner(System.in);
        boolean[] array = new boolean[128];
        Arrays.fill(array, false);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            for (char c : s.toCharArray()) {
                array[c] = true;
            }
            int count = 0;
            for (boolean b : array) {
                if (b) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    /**
     * 题目描述
     * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
     * 保证输入的整数最后一位不是0。
     * 输入描述:
     * 输入一个int型整数
     * <p>
     * 输出描述:
     * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
     * <p>
     * 示例1
     * 输入
     * 9876673
     * 输出
     * 37689
     */
    private static void nonRepeatInteger() {
        Scanner in = new Scanner(System.in);
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        while (in.hasNextInt()) {
            int i = in.nextInt();
            String s = String.valueOf(i);
            for (int j = s.length() - 1; j >= 0; j--) {
                char c = s.charAt(j);
                int anInt = Integer.parseInt(c + "");
                set.add(anInt);
            }
            for (Integer integer : set) {
                System.out.print(integer);
            }
        }
    }

    /**
     * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
     * 输入描述:
     * 先输入键值对的个数
     * 然后输入成对的index和value值，以空格隔开
     * <p>
     * 输出描述:
     * 输出合并后的键值对（多行）
     * <p>
     * 输入
     * 4
     * 0 1
     * 0 2
     * 1 2
     * 3 4
     * 输出
     * 0 3
     * 1 2
     * 3 4
     */
    private static void mergeHash() {
        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> map = new TreeMap<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            int count = Integer.parseInt(s);
            for (int i = 0; i < count; i++) {
                String s1 = in.nextLine();
                String[] s2 = s1.split(" ");
                if (s2.length == 2) {
                    int key = Integer.parseInt(s2[0]);
                    int value = Integer.parseInt(s2[1]);
                    if (map.containsKey(key)) {
                        map.put(key, map.get(key) + value);
                    } else {
                        map.put(key, value);
                    }
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    /**
     * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
     * <p>
     * 输入描述:
     * 输入一个正浮点数值
     * <p>
     * 输出描述:
     * 输出该数值的近似整数值
     * <p>
     * 示例1
     * 输入
     * 5.5
     * 输出
     * 6
     */
    private static void approximation() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble()) {
            double aDouble = in.nextDouble();
            String s = String.valueOf(aDouble);
            String[] split = s.split("\\.", 2);
            long num = Long.parseLong(split[0]);
            if (split.length > 1) {
                String afterDot = split[1];
                char c = afterDot.charAt(0);
                if (Integer.parseInt(c + "") >= 5) {
                    num += 1;
                }
            }
            System.out.println(num);
        }
    }

    /**
     * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
     * 输入一个long型整数
     * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
     * 输入
     * 180
     * 输出
     * 2 2 3 3 5
     */
    private static void primeFactor() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLong()) {
            long aLong = in.nextLong();
            while (aLong > 1) {
                if (aLong <= 3) {
                    System.out.print(aLong + " ");
                    break;
                } else if (aLong % 2 == 0) {
                    System.out.print(2 + " ");
                    aLong = aLong / 2;
                } else {
                    boolean flag = false;
                    for (int i = 3; i <= Math.sqrt(aLong); i += 2) {
                        if (aLong % i == 0) {
                            System.out.print(i + " ");
                            aLong = aLong / i;
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.print(aLong + " ");
                        break;
                    }
                }
            }
        }
    }


    /**
     * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
     * 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。
     * 输入
     * 0xA
     * 0xAA
     * 输出
     * 10
     * 170
     */
    private static void hexToDec() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            s = s.replace("0x", "");
            if (s.length() == 0) {
                System.out.println(0);
            }
            int decNum = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                double pow = Math.pow(16, s.length() - 1 - i);
                if (Character.isDigit(c)) {
                    decNum += Integer.parseInt(c + "") * pow;
                } else {
                    int value = (int) c - 65 + 10;
                    decNum += value * pow;
                }
            }
            System.out.println(decNum);
        }
    }

    /**
     * 十六位进制转十进制，大数据版本，防止溢出
     */
    private static void hexToDec1() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            s = s.replace("0x", "");
            if (s.length() == 0) {
                System.out.println(0);
            }
            BigInteger decNum = BigInteger.ZERO;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                double pow = Math.pow(16, s.length() - 1 - i);
                if (Character.isDigit(c)) {
                    decNum = decNum.add(BigInteger.valueOf((long) (Long.parseLong(c + "") * pow)));
                } else {
                    long value = (int) c - 65 + 10;
                    decNum = decNum.add(BigInteger.valueOf((long) (value * pow)));
                }
            }
            System.out.println(decNum);
        }
    }
}
