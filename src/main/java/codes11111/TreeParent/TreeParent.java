package codes11111.TreeParent;

import java.util.ArrayList;
import java.util.List;

// 父节点表示法的实现
public class TreeParent<E> {
    // 树的节点
    public static class Node<T> {
        T data;
        // 记录父节点的位置(父节点在数组中的索引)
        int parent;

        public Node() {

        }

        public Node(T data, int parent) {
            this.data = data;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "TreeParent$Node[data=" + data + ", parent=" + parent + "]";
        }
    }

    // 用于记录该树中所有的节点
    private Node<E>[] nodes;
    // 默认nodes数组的长度
    private final int DEFAULT_TREE_SIZE = 100;
    // 实际nodes数组的长度
    private int treeSize = 0;
    // 节点的个数
    private int nodeNum;

    // 以指定根节点创建树
    public TreeParent(E data) {
        treeSize = DEFAULT_TREE_SIZE;
        nodes = new Node[treeSize];
        // 根节点的parent为-1
        nodes[0] = new Node<E>(data, -1);
        nodeNum++;
    }

    // 以指定根节点、指定treeSize创建树
    public TreeParent(E data, int treeSize) {
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        // 根节点的parent为-1
        nodes[0] = new Node<E>(data, -1);
        nodeNum++;
    }

    // 返回节点在数组中的索引
    public int pos(Node node) {
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] == node) {
                return i;
            }
        }
        return -1;
    }

    // 为指定的节点添加一个子节点
    public void addNode(E data, Node parent) {
        for (int i = 0; i < treeSize; i++) {
            // 在nodes中找到第一个为null的元素，该位置保存新的节点
            if (nodes[i] == null) {
                // 创建新的节点
                nodes[i] = new Node<E>(data, pos(parent));
                nodeNum++;
                return;
            }
        }
        throw new RuntimeException("该树已满，无法添加新的节点");
    }

    // 判断树是否为空
    public boolean empty() {
        return nodes[0] == null;
    }

    // 返回根节点
    public Node<E> root() {
        return nodes[0];
    }

    // 根据指定节点(非根)返回其父节点
    public Node<E> parent(Node node) {
        return nodes[node.parent];
    }

    /**
     * 返回指定节点的所有子节点
     *
     * @param parent 指定的父节点
     * @return 该父节点下的所有子节点的集合
     */
    public List<Node<E>> children(Node parent) {
        List<Node<E>> list = new ArrayList<Node<E>>();
        // 遍历数组中所有的节点
        // 依次判断节点的parent索引是否与指定的父节点的索引一致
        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] != null && nodes[i].parent == pos(parent)) {
                list.add(nodes[i]);
            }
        }
        return list;
    }

    // 返回树的深度
    public int deep() {
        // 用于记录节点的最大层次
        int max = 0;
        for (int i = 0; i < treeSize && nodes[i] != null; i++) {
            // 初始化当前节点的层次
            int def = 1;
            // 记录当前节点的父节点的索引
            int m = nodes[i].parent;
            //如果当前节点的父节点存在
            while (m != -1 && nodes[m] != null) {
                //向上接续搜索父节点
                m = nodes[m].parent;
                // 当前的节点的层次+1
                def++;
            }
            // 设置最大层次
            if (max < def) {
                max = def;
            }
        }
        return max;
    }
}
