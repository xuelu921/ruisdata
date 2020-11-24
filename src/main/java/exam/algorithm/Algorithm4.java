package exam.algorithm;

import java.util.Scanner;

/**
 * @author lx
 */
public class Algorithm4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入几个数并用逗号隔开：");
        String inputStr = input.next();
        String[] inputStrArr = inputStr.split(",");
        int[] inputIntArr = new int[inputStrArr.length];
        for (int i = 0; i < inputIntArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputStrArr[i]);
        }
        //考虑到线性复杂度，采用桶排序
        System.out.println("最大相邻差为:" + getMaxSortedDistance(inputIntArr));

    }

    /**
     * 桶排序数组
     *
     * @param array array
     * @return
     */
    private static Bucket[] sortArray(int[] array) {
        // 获取数组中的最大值和最小值，构建数组的长度
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int distance = max - min;

        // 初始化桶
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }

        // 遍历原始数组，确定每个桶的最大最小值
        for (int i = 0; i < array.length; i++) {
            //元素放入桶的下标
            int index = (array[i] - min) * (bucketNum - 1) / distance;
            if (buckets[index].min == null || buckets[index].min > array[i]) {
                buckets[index].min = array[i];
            }
            if (buckets[index].max == null || buckets[index].max < array[i]) {
                buckets[index].max = array[i];
            }
        }

        return buckets;
    }


    /**
     * 计算相邻最大差值
     *
     * @param array array
     * @return
     */
    public static int getMaxSortedDistance(int[] array) {
        Bucket[] buckets = sortArray(array);

        // 遍历桶，找到最大差值
        int leftIndex = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }
            if (buckets[i].min - leftIndex > maxDistance) {
                maxDistance = buckets[i].min - leftIndex;
            }
            leftIndex = buckets[i].max;
        }
        return maxDistance;
    }

    /**
     * 桶
     */
    private static class Bucket {
        Integer min;
        Integer max;
    }
}
