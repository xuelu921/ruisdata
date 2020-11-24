package exam.algorithm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author lx
 */
public class Algorithm5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入几个整数并用逗号隔开：");
        String inputStr = input.next();
        String[] inputStrArr = inputStr.split(",");
        int[] inputIntArr = new int[inputStrArr.length];
        for (int i = 0; i < inputIntArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputStrArr[i]);
        }

        System.out.println(getLongestConsecutive(inputIntArr));
    }

    /**
     * 获取连续的最长序列
     *
     * @param nums nums
     * @return longest consecutive
     */
    public static int getLongestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int res = 0;

        for (int num : nums) {
            if (!numSet.remove(num)) {
                continue;
            }
            //连续长度
            int length = 1;
            int tmp = num;
            //包含当前值的最长连续长度
            while (numSet.remove(--num)) {
                length += 1;
            }
            while (numSet.remove(++tmp)) {
                length += 1;
            }
            //连续长度取较大值
            res = Math.max(res, length);

            if (res >= numSet.size()) {
                break;
            }
        }

        return res;
    }
}
