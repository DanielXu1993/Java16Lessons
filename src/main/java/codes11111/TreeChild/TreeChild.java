package codes11111.TreeChild;

import java.util.ArrayList;
import java.util.List;

// 子节点链表示法的实现
public class TreeChild<E> {
    // 表示一个父节点指向的链表中的一个子节点
    private static class SonNode {
        // 该子节点在数组中的索引
        private int pos;
        // 指向链表中的下一个节点
        private SonNode next;

        public SonNode(int pos, SonNode next) {
            this.pos = pos;
            this.next = next;
        }
    }

    // 该类的实例表示一个数组中的一个节点
    public static class Node<T> {
        // 节点中的数据
        T data;
        // 指向它的第一个子节点
        SonNode first;

        public Node(T data) {
            this.data = data;
            this.first = null;
        }

        @Override
        public String toString() {
            if (first != null) {
                return "TreeChild$Node[data="+data+",first"+first.pos+"]";
            } else {
                return "TreeChild$Node[data=" + data + ",first = -1]";
            }
        }
    }

    // 默认初始化树的大小
    private final int DEFAULT_TREE_SIZE = 100;
    // 实际树的大小(最多能有多少节点)
    private int treeSize = 0;
    // 记录树中所有的节点
    private Node<E>[] nodes;
    // 实际的节点个数
    private int nodeNums;

    // 以指定的根节点来创建树
    public TreeChild(E data) {
        treeSize = DEFAULT_TREE_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data);
        nodeNums++;
    }

    // 以指定的根节点、指定treeSize来创建树
    public TreeChild(E data, int treeSize) {
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data);
        nodeNums++;
    }

    // 为指定的节点添加子节点
    public void addNode(E data, Node parent) {
        for (int i = 0; i < treeSize; i++) {
            // 遍历nodes数组，寻找第一个为null的位置插入新节点
            if (nodes[i] == null) {
                // 在nodes数组中插入新节点
                nodes[i] = new Node<E>(data);
                if (parent.first == null) {
                    // 父节点没有子节点
                    // 构造SonNode节点让父节点的first指向它
                    parent.first = new SonNode(i, null);
                } else {
                    //父节点的第一个子节点
                    SonNode current = parent.first;
                    // 子节点链中的最后一个节点的next指向的时null
                    while (current.next != null) {
                        // 在子节点链中逐个向后搜索
                        // 搜索到子节点链中的最后一个节点
                        current = current.next;
                    }
                    // 最后一个节点指向一个新的子节点
                    current.next = new SonNode(i, null);
                }
                nodeNums++;
                return;
            }
        }
        throw new RuntimeException("该树已满，无法添加新节点");
    }

    // 判断树是否为空
    public boolean empty() {
        return nodes[0] == null;
    }

    // 返回根节点
    public Node<E> root() {
        return nodes[0];
    }

    // 返回指定节点(非叶子节点)的所有子节点
    public List<Node<E>> children(Node parent) {
        List<Node<E>> list = new ArrayList<Node<E>>();
        // 指定节点的子节点链中的第一个节点
        SonNode current = parent.first;
        // 将链中所有的节点添加到list中
        while (current != null) {
            // 子节点链中记录的是子节点在数组中的位置
            list.add(nodes[current.pos]);
            current = current.next;
        }
        return list;
    }

    // 返回指定节点(非叶子节点)在index处的子节点
    public Node<E> child(Node parent, int index) {
        SonNode current = parent.first;
        for (int i = 0; current != null; i++) {
            if (index == i) {
                return nodes[current.pos];
            }
            current = current.next;
        }
        return null;
    }

    // 返回以指定节点为根节点的子树的深度
    public int deep(Node node) {
        // 没有子节点，深度为1
        if (node.first == null) {
            return 1;
        } else {
            // 记录最大的层次
            int max = 0;
            SonNode current = node.first;
            // 搜索子节点链中的所有的节点
            while (current != null) {
                // 递归，获取每个以子节点为根的子树的深度
                int tmp = deep(nodes[current.pos]);
                // 设置最大层次
                if (tmp > max) {
                    max = tmp;
                }
                current = current.next;
            }
            // 最大层次+指定的节点的层次即为子树的深度
            return max + 1;
        }
    }

    // 返回树的深度
    public int deep() {
        return deep(root());
    }

    // 返回指定节点在数组中的位置
    public int pos(Node node) {
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] == node) {
                return i;
            }
        }
        return -1;
    }

}
