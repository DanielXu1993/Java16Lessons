package codes12122.SelectSort;

import java.util.Arrays;

//堆排序的实现
public class HeapSort {
    public static void heapSort(DataWrap[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        // 循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            // 建堆
            buildMaxHeap(data, arrayLength - 1 - i);
            // 交换堆顶元素和堆的最后一个元素
            swap(data, 0, arrayLength - 1 - i);
            System.out.println(Arrays.toString(data));
        }
    }

    // 对data数组从0到lastIndex建最大堆
    private static void buildMaxHeap(DataWrap[] data, int lastIndex) {
        // lastIndex的父节点的索引为(lastIndex - 1) / 2
        // 从lastIndex的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // 保存正在判断的节点的索引(lastIndex的父节点)
            int k = i;
            // 索引为k的子节点索引要么是2 * k + 1(左),要么是2 * k + 2(右)
            // 如果当前节点有子节点
            while (lastIndex >= k * 2 + 1) {
                // biggerIndex保存最大子节点值的索引
                int biggerIndex = 2 * k + 1;
                // 如果lastIndex是右子节点的索引
                if (biggerIndex < lastIndex) {
                    // 如果右子节点的值比左子节点的值大
                    if (data[biggerIndex].compareTo(data[biggerIndex + 1]) < 0) {
                        // 将biggerIndex设置成右子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果lastIndex是右子节点的索引,父节点需要跟左、右两个子节点比较最大值
                // 如果lastIndex不是右子节点的索引,父节点只需要跟左、子节点比较最大值
                // 父节点中的值与左节点中的值比较大小，或者是跟左、右子节点中较大值比较大小
                if (data[k].compareTo(data[biggerIndex]) < 0) {
                    // 父节点中的值更小，父节点与较大子节点交换
                    swap(data, k, biggerIndex);
                    // 将k设置成新的子节点的索引，需要循环调整以k为根节点的子堆是否是最大堆
                    k = biggerIndex;
                } else {
                    // 不需要调整，退出while循环
                    break;
                }
            }
        }
    }

    // 交换数据
    private static void swap(DataWrap[] data, int i, int j) {
        DataWrap tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }


    public static void main(String[] args) {
        DataWrap[] data = {new DataWrap(21, ""),
                new DataWrap(30, ""),
                new DataWrap(49, ""),
                new DataWrap(30, "*"),
                new DataWrap(21, "*"),
                new DataWrap(16, ""),
                new DataWrap(9, ""),
        };
        System.out.println("排序之前：\n" + Arrays.toString(data));
        heapSort(data);
        System.out.println("排序之后：\n" + Arrays.toString(data));
    }
}
