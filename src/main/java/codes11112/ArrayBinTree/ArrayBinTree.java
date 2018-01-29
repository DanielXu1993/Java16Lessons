package codes11112.ArrayBinTree;

import java.util.Arrays;

// 二叉树的顺序存储的实现
public class ArrayBinTree<T> {
    // 使用数组记录该树的所有节点
    private Object[] datas;
    // 树的默认深度
    private int DEFAULT_DEEP = 8;
    // 树的实际深度
    private int deep;
    // datas数组的长度
    // arraySize =  (2 ^ deep) - 1
    private int arraySize;

    // 以默认深度创建二叉树
    public ArrayBinTree() {
        this.deep = DEFAULT_DEEP;
        this.arraySize = (int) (Math.pow(2, deep) - 1);
        datas = new Object[arraySize];
    }

    // 以指定深度创建二叉树
    public ArrayBinTree(int deep) {
        this.deep = deep;
        this.arraySize = (int) (Math.pow(2, deep) - 1);
        datas = new Object[arraySize];
    }

    // 以指定深度、指定的根节点创建二叉树
    public ArrayBinTree(int deep, T data) {
        this(deep);
        datas[0] = data;
    }

    /**
     * 为指定的节点添加子节点
     *
     * @param index 需要添加子节点的父节点的索引
     * @param data  新子节点的数据
     * @param left  新添加的子节点是否为左节点
     */
    public void add(int index, T data, boolean left) {
        if (datas[index] == null) {
            throw new RuntimeException(index + "处节点为空，无法添加子节点");
        }
        // 索引为index的节点的左子节点的索引为2 * index + 1
        if (2 * index + 1 >= arraySize) {
            throw new RuntimeException("树底层的数组已满，树越界异常");
        }
        if (left) {
            // 子节点为左子节点
            datas[2 * index + 1] = data;
        } else {
            // 子节点为右子节点
            datas[2 * index + 2] = data;
        }

    }

    // 判断二叉树是否为空
    public boolean empty() {
        return datas[0] == null;
    }

    // 返回根节点
    public T root() {
        return (T) datas[0];
    }

    // 返回指定节点(非根节点)的父节点
    public T parent(int index) {
        return (T) datas[(index - 1) / 2];
    }

    // 返回指定节点的左子节点
    public T left(int index) {
        if (2 * index + 1 >= arraySize) {
            throw new RuntimeException("该节点为叶子节点，无子节点");
        }
        return (T) datas[index * 2 + 1];
    }

    // 返回指定节点的右子节点
    public T right(int index) {
        if (2 * index + 1 >= arraySize) {
            throw new RuntimeException("该节点为叶子节点，无子节点");
        }
        return (T) datas[index * 2 + 2];
    }

    // 返回该二叉树的深度
    public int deep() {
        return deep;
    }

    // 返回指定节点在数组中的位置
    public int pos(T data) {
        for (int i = 0; i < arraySize; i++) {
            if (datas[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(datas);
    }
}
