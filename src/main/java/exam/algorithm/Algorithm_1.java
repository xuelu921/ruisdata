package exam.algorithm;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author lx
 */
public class Algorithm_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isTrue = true;
        while (isTrue) {
            try {
                System.out.println("请输入一个整数：");
                Integer inputNum = input.nextInt();
                System.out.println(isPowerOfTwo(inputNum));
                // 当输入的数是整数时，跳出循环
                isTrue = false;
            } catch (InputMismatchException e) {
                System.out.println("输入的数字有误，请重新输入！");
                // 清空输入的数字
                input.nextLine();
            }
        }
    }

    /**
     * 是否是2的整数幂
     * 2的整数次幂转换成二进制：第一位都是1，其余n位都是0；
     * 2的整数次幂-1转换成二进制：第一位都是0，其余n位都是1；
     * 2^n & (2^n - 1) = 0
     *
     * @param num num
     * @return if it is a power of 2,true;otherwise false
     */
    private static boolean isPowerOfTwo(Integer num) {
        return (num & (num - 1)) == 0;
    }
}
