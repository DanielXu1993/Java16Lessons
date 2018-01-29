package codes11112.ThreeLinkBinTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 二叉树的三叉链表存储的实现以及二叉树遍历的实现
public class ThreeLinkBinTree<E> {
    // 该内部类的一个实例表示一个二叉树的节点
    public static class TreeNode {
        // 节点中存储的数据
        Object data;
        // 指向该节点的左子节点
        TreeNode left;
        // 指向该节点的右子节点
        TreeNode right;
        // 指向该节点的父节点
        TreeNode parent;

        public TreeNode() {
        }

        public TreeNode(Object data) {
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right, TreeNode parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    // 该二叉树的根节点
    private TreeNode root;

    public ThreeLinkBinTree() {
        this.root = new TreeNode();
    }

    public ThreeLinkBinTree(E data) {
        this.root = new TreeNode(data);
    }

    /**
     * 为指定的节点添加子节点
     *
     * @param parent 需要添加子节点的父节点
     * @param data   新的子节点中的数据
     * @param isLeft 新的节点是否为左子节点
     * @return 新增的节点
     */
    public TreeNode addNode(TreeNode parent, E data, boolean isLeft) {
        if (parent == null) {
            throw new RuntimeException(parent + "节点为null，无法添加子节点");
        }
        if (isLeft && parent.left != null) {
            throw new RuntimeException(parent + "节点已有左子节点，无法添加");
        }
        if (!isLeft && parent.right != null) {
            throw new RuntimeException(parent + "节点已有右子节点，无法添加");
        }
        TreeNode newNode = new TreeNode(data);
        if (isLeft) {
            // 添加左子节点，让父节点的left指向新的左子节点
            parent.left = newNode;
        } else {
            // 添加右子节点，让父节点的right指向新的右子节点
            parent.right = newNode;
        }
        // 新的子节点的parent指向它的父节点
        newNode.parent = parent;
        return newNode;
    }

    // 判断二叉树是否为空
    public boolean empty() {
        return root.data == null;
    }

    // 返回二叉树的根节点
    public TreeNode root() {
        if (empty()) {
            throw new RuntimeException("树为空，无法访问根节点");
        }
        return root;
    }

    // 根据指定的节点(非根节点)返回父节点中的数据
    public E parent(TreeNode node) {
        if (node == null) {
            throw new RuntimeException(node + "节点为null，无法访其父节点");
        }
        return (E) node.parent.data;
    }

    // 根据指定的节点返回其左子节点的数据
    public E leftChild(TreeNode parent) {
        if (parent == null) {
            throw new RuntimeException(parent + "节点为null，左子节点不存在");
        }
        return parent.left == null ? null : (E) parent.left.data;
    }

    // 根据指定的节点返回其右子节点的数据
    public E rightChild(TreeNode parent) {
        if (parent == null) {
            throw new RuntimeException(parent + "节点为null，右子节点不存在");
        }
        return parent.right == null ? null : (E) parent.right.data;
    }

    // 递归方法：计算以指定的节点作为根节点的子树的深度
    private int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 没有子树，深度为1
        if (node.left == null && node.right == null) {
            return 1;
        }
        // 计算左子树的深度
        int leftDeep = deep(node.left);
        // 计算右子树的深度
        int rightDeep = deep(node.right);
        int max = leftDeep > rightDeep ? leftDeep : rightDeep;
        // 当前子树的深度为左右子树深度的最大值+1
        return max + 1;
    }

    // 返回该二叉树的深度
    public int deep() {
        return deep(root);
    }


    // <!------------ 先序遍历二叉树----start--------------->
    //递归：遍历以指定节点为根节点的子树
    private List<TreeNode> preIterator(TreeNode node) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        // 首先处理根节点
        list.add(node);
        // 其次处理左子树
        if (node.left != null) {
            list.addAll(preIterator(node.left));
        }
        // 最后处理右子树
        if (node.right != null) {
            list.addAll(preIterator(node.right));
        }
        return list;
    }

    // 先序遍历二叉树
    public List<TreeNode> preIterator() {
        return preIterator(root);
    }
    // <!------------ 先序遍历二叉树----end--------------->

    // <!------------ 中序遍历二叉树----start--------------->
    private List<TreeNode> inIterator(TreeNode node) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        // 首先处理左子树
        if (node.left != null) {
            list.addAll(inIterator(node.left));
        }
        // 其次处理根节点(传入的节点作为子树的根节点)
        list.add(node);
        // 最后处理右子树
        if (node.right != null) {
            list.addAll(inIterator(node.right));
        }
        return list;
    }

    public List<TreeNode> inIterator() {
        return inIterator(root);
    }
    // <!------------ 中序遍历二叉树----end--------------->

    // <!------------ 后序遍历二叉树----start--------------->
    private List<TreeNode> postIterator(TreeNode node) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        // 首先处理左子树
        if (node.left != null) {
            list.addAll(postIterator(node.left));
        }
        // 其次处理右子树
        if (node.right != null) {
            list.addAll(postIterator(node.right));
        }
        // 最后处理根节点
        list.add(node);
        return list;
    }

    public List<TreeNode> postIterator() {
        return postIterator(root);
    }
    // <!------------ 后序遍历二叉树----end--------------->

    // <!------------ 广度优先遍历二叉树----start--------------->
    public List<TreeNode> breadthFirst() {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (root != null) {
            // 将根节点插入队列
            queue.offer(root);
        }
        // 每一个节点都进、出过队列一次
        while (!queue.isEmpty()) {
            // 将队列中的头元素加入到list中，但不移除
            list.add(queue.peek());
            // 移除队列的头元素并保存
            TreeNode p = queue.poll();
            if (p.left != null) {
                // 如果移除的节点的左子节点不为空,将左子节点加入队列
                queue.offer(p.left);
            }
            if (p.right != null) {
                // 如果移除的节点的右子节点不为空,将右子节点加入队列
                queue.offer(p.right);
            }
        }
        return list;
    }
    // <!------------ 广度优先遍历二叉树----end--------------->
}
