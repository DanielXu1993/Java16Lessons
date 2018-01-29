package codes11112.TwoLinkBinTree;

public class TwoLinkBinTreeTest {
    public static void main(String[] args) {
        TwoLinkBinTree<String> binTree = new TwoLinkBinTree<String>("根节点");
        TwoLinkBinTree.TreeNode tn1 = binTree.addNode(binTree.root(), "第二层左节点", true);
        TwoLinkBinTree.TreeNode tn2 = binTree.addNode(binTree.root(), "第二层右节点", false);
        TwoLinkBinTree.TreeNode tn3 = binTree.addNode(tn2, "第三层左节点", true);
        TwoLinkBinTree.TreeNode tn4 = binTree.addNode(tn2, "第三层右节点", false);
        TwoLinkBinTree.TreeNode tn5 = binTree.addNode(tn3, "第四层左节点", true);
        System.out.println(binTree.deep());
        System.out.println(binTree.leftChild(tn2));
        System.out.println(binTree.rightChild(tn2));
    }
}
