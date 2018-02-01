package codes12122.Sort;

import java.util.Arrays;

// 快速选择排序的实现:方式一
public class SelectSort {
    public static void selectSort1(DataWrap[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        // 进行n-1趟比较
        for (int i = 0; i < arrayLength - 1; i++) {
            // 第i个元素与它后面的每一个元素进行比较
            // 保证索引为i的元素是最小的
            for (int j = i + 1; j < arrayLength; j++) {
                // 第i个元素大于第j个元素，交换它们的位置
                if (data[i].compareTo(data[j]) > 0) {
                    DataWrap tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
            System.out.println(Arrays.toString(data));
        }
    }

    // 快速选择排序的实现:方式二
    public static void selectSort2(DataWrap[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        // 进行n-1趟比较
        for (int i = 0; i < arrayLength - 1; i++) {
            // 第i趟比较后确保索引i处的元素值最小
            // 记录从i开始到最后一个元素中数值最小的数据的索引
            int minIndex = i;
            // 第i个元素与它后面的每一个元素进行比较
            for (int j = i + 1; j < arrayLength; j++) {
                // 确保minIndex记录的是最小数据的索引
                if (data[minIndex].compareTo(data[j]) > 0) {
                    minIndex = j;
                }
            }
            // 最小的元素与i处的元素交换位置
            // 如果最小的值就是索引i处的值，就不需要交换
            if (minIndex != i) {
                DataWrap tmp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = tmp;
            }
            System.out.println(Arrays.toString(data));
        }
    }

    public static void main(String[] args) {
        DataWrap[] data = {new DataWrap(21, ""),
                new DataWrap(30, ""),
                new DataWrap(49, ""),
                new DataWrap(30, "*"),
                new DataWrap(16, ""),
                new DataWrap(9, ""),
        };
        System.out.println("排序之前：\n" + Arrays.toString(data));
        //selectSort1(data);
        selectSort2(data);
        System.out.println("排序之后：\n" + Arrays.toString(data));
    }
}
