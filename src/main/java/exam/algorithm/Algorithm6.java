package exam.algorithm;

import java.util.Scanner;

/**
 * @author Administrator
 */
public class Algorithm6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入正确的待匹配字符串：");
        String inputStr = input.next();
        System.out.println("请输入正确的字符匹配模式：");
        String inputPattern = input.next();

        if (isMatch(inputStr, inputPattern)) {
            System.out.println("字符串： " + inputStr + " 通过模式[ " + inputPattern + " ]匹配后，结果为：匹配成功。");
        } else {
            System.out.println("字符串： " + inputStr + " 通过模式[ " + inputPattern + " ]匹配后，结果为：匹配失败。");
        }

    }

    /**
     * match string
     *
     * @param str     string
     * @param pattern pattern
     * @return boolean
     */
    private static boolean isMatch(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        char[] strChar = str.toCharArray();
        char[] patternChar = pattern.toCharArray();

        return match(strChar, patternChar, 0, 0);
    }

    /**
     * @param str     string
     * @param pattern pattern
     * @param i       string index
     * @param j       pattern index
     * @return boolean
     */
    private static boolean match(char[] str, char[] pattern, int i, int j) {
        //如果模式先遍历完，则一定不匹配；如果同时遍历完，则一定匹配；
        if (j == pattern.length) {
            return i == str.length;
        }

        if (j < pattern.length - 1 && pattern[j + 1] == '*') {
            //如果模式下一个为'*'，且当前匹配；
            if (i < str.length && (str[i] == pattern[j] || (pattern[j] == '.'))) {
                //模式后移两位[“*”可匹配0个字符]，或者模式不变，字符串后移一位；
                return match(str, pattern, i, j + 2) || match(str, pattern, i + 1, j);
            } else {
                //当前不匹配，模式后移两位；
                return match(str, pattern, i, j + 2);
            }
        }
        //模式下一个不为'*'，且当前匹配，则往后匹配；
        if (str.length != i && (str[i] == pattern[j] || pattern[j] == '.')) {
            return match(str, pattern, i + 1, j + 1);
        }
        return false;
    }
}
