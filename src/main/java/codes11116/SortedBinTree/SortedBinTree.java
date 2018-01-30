package codes11116.SortedBinTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 排序二叉树的实现
public class SortedBinTree<T extends Comparable> {
    // 排序二叉树的一个节点
    static class Node {
        Object data;
        Node parent;
        Node left;
        Node right;

        public Node(Object data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() {
            return "[data=" + data + "]";
        }
    }

    // 排序二叉树的根节点
    private Node root;

    public SortedBinTree() {
        root = null;
    }

    // 以指定根元素的值来创建只有一个根元素的排序二叉树
    public SortedBinTree(T o) {
        root = new Node(o, null, null, null);
    }

    // 向排序二叉树中添加指定元素的节点
    public void add(T element) {
        // 根节点为null
        if (root == null) {
            root = new Node(element, null, null, null);
        } else {
            // 从根节点开始，寻找插入子节点的父节点
            Node current = root;
            Node parent = null;
            // 表示节点中值的大小比较结果
            int cmp = 0;
            do {
                parent = current;
                cmp = element.compareTo(current.data);
                // 插入的数据比比较的节点的数据大
                // 放在比较节点的右边
                if (cmp > 0) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            } while (current != null);
            // 以指定的元素和搜索到的父节点创建要插入的节点
            Node newNode = new Node(element, parent, null, null);
            if (cmp > 0) {
                // 新节点的值比父节点大，放在右边
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
        }
    }

    // 根据指定的元素值搜索节点
    public Node getNode(T element) {
        // 从根节点开始搜索
        Node p = root;
        while (p != null) {
            int cmp = element.compareTo(p.data);
            // 搜索到的节点的值小于元素值，向左子树搜索
            if (cmp < 0) {
                p = p.left;
            }
            // 搜索到的节点的值大于元素值，向右子树搜索
            else if (cmp > 0) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    // 删除指定元素的节点
    public void remove(T element) {
        // 获取要删除的节点
        Node target = getNode(element);
        if (target == null) {
            return;
        }
        // 删除节点为叶子节点
        if (target.left == null && target.right == null) {
            if (target == root) {
                // 被删除节点是根节点
                root = null;
            } else {
                // 被删除节点是父节点的左子节点
                if (target == target.parent.left) {
                    target.parent.left = null;
                }
                // 被删除节点是父节点的右子节点
                else {
                    target.parent.right = null;
                }
                // 将被删除节点的parent引用设置为null
                target.parent = null;
            }
        }
        // 删除节点的左子树为空，右子树不为空
        // 将删除节点的右子树设置成删除节点的父节点的右子树即可
        else if (target.left == null && target.right != null) {
            if (target == root) {
                // 删除的节点是root
                // 把删除节点的右子节点设置成root
                root = target.right;
            } else {
                if (target == target.parent.left) {
                    // 删除节点是父节点的左节点
                    // 将父节点的左节点设置成删除节点的右子节点
                    target.parent.left = target.right;
                } else {
                    // 删除节点是父节点的右节点
                    // 将父节点的右节点设置成删除节点的右子节点
                    target.parent.right = target.right;
                }
                // 将删除节点的右子节点的parent指针指向删除节点的父节点
                target.right.parent = target.parent;
            }
        }
        // 删除节点的右子树为空，左子树不为空
        // 将删除节点的左子树设置成删除节点的父节点的左子树即可
        else if (target.left != null && target.right == null) {
            if (target == root) {
                root = target.left;
            } else {
                // 删除节点是父节点的左节点
                // 将父节点的左节点设置成删除节点的左子节点
                if (target == target.parent.left) {
                    target.parent.left = target.left;
                } else {
                    // 删除节点是父节点的右节点
                    // 将父节点的右节点设置成删除节点的左子节点
                    target.parent.right = target.left;
                }
                // 将删除节点的左子节点的parent指针指向删除节点的父节点
                target.left.parent = target.parent;
            }
        }
        // 左右节点都不为空
        // 在左子树中找最大的节点替代删除的节点
        // (或者在在右子树中找最小的节点替代删除的节点)
        else {
            // 保存左子树中最大的节点
            Node leftMaxNode = target.left;
            // 如果leftMaxNode存在右子节点
            // 说明leftMaxNode的右子节点比leftMaxNode大
            while (leftMaxNode.right != null) {
                leftMaxNode = leftMaxNode.right;
            }
            // 将leftMaxNode的父节点的right引用设置为null
            leftMaxNode.parent.right = null;
            // 将leftMaxNode的parent指向要替代的target节点的parent
            leftMaxNode.parent = target.parent;
            if (target == target.parent.left) {
                // 删除节点是它的父节点的左子节点
                // 将它的左子节点指向要替换删除节点的leftMaxNode
                target.parent.left = leftMaxNode;
            } else {
                // 删除节点是它的父节点的右子节点
                // 将它的右子节点指向要替换删除节点的leftMaxNode
                target.parent.right = leftMaxNode;
            }
            // leftMaxNode的left指向替换目标的left
            leftMaxNode.left = target.left;
            // leftMaxNode的right指向替换目标的right
            leftMaxNode.right = target.right;
            // 清空被替换的节点
            target.parent = null;
            target.left = null;
            target.right = null;
        }
    }

    // 广度优先遍历
    public List<Node> breadthFirst() {
        Queue<Node> queue = new ArrayDeque<Node>();
        List<Node> list = new ArrayList<Node>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            list.add(queue.peek());
            Node p = queue.poll();
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
        return list;
    }

    // 中序遍历顺序树
    public List<Node> inIterator(Node node) {
        List<Node> list = new ArrayList<Node>();
        if (node != null) {
            if (node.left != null) {
                list.addAll(inIterator(node.left));
            }
            list.add(node);
            if (node.right != null) {
                list.addAll(inIterator(node.right));
            }
        }
        return list;
    }

    public List<Node> inIterator() {
        return inIterator(root);
    }
}
