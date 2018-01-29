package codes11112.TwoLinkBinTree;

// 二叉树的二叉链表的存储的实现
public class TwoLinkBinTree<E> {
    // 该内部类的实例表示一个二叉树节点
    public static class TreeNode {
        // 节点的数据
        Object data;
        // 左子节点
        TreeNode left;
        // 右子节点
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(Object data) {
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // 二叉树的根节点
    private TreeNode root;

    public TwoLinkBinTree() {
        this.root = new TreeNode();
    }

    // 以指定根节点创建二叉树
    public TwoLinkBinTree(E data) {
        this.root = new TreeNode(data);
    }


    /**
     * 为指定节点添加子节点
     *
     * @param parent 需要添加子节点的父节点
     * @param data   新子节点的数据
     * @param isLeft 是否为左子节点
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
            // 让父节点的left指向新节点
            parent.left = newNode;
        } else {
            // 让父节点的right指向新节点
            parent.right = newNode;
        }
        return newNode;
    }

    // 判断二叉树是否为空
    public boolean empty() {
        return root.data == null;
    }

    // 返回根节点
    public TreeNode root() {
        if (empty()) {
            throw new RuntimeException("树为空，无法访问根节点");
        }
        return root;
    }

    // 返回指定节点的左子节点
    public E leftChild(TreeNode parent) {
        if (parent == null) {
            throw new RuntimeException(parent + "节点为null,没有子节点");
        }
        return parent.left == null ? null : (E) parent.left.data;
    }

    // 返回指定节点的右子节点
    public E rightChild(TreeNode parent) {
        if (parent == null) {
            throw new RuntimeException(parent + "节点为null,没有子节点");
        }
        return parent.left == null ? null : (E) parent.right.data;
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
}
