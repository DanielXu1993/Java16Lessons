package codes11112.ThreeLinkBinTree;

import java.util.List;

public class ThreeLinkBinTreeTest {
    public static void main(String[] args) {
        ThreeLinkBinTree<String> binTree = new ThreeLinkBinTree<String>("根节点");
        ThreeLinkBinTree.TreeNode tn1 = binTree.addNode(binTree.root(), "第二层左节点", true);
        ThreeLinkBinTree.TreeNode tn2 = binTree.addNode(binTree.root(), "第二层右节点", false);
        ThreeLinkBinTree.TreeNode tn3 = binTree.addNode(tn2, "第三层左节点", true);
        ThreeLinkBinTree.TreeNode tn4 = binTree.addNode(tn2, "第三层右节点", false);
        ThreeLinkBinTree.TreeNode tn5 = binTree.addNode(tn3, "第四层左节点", true);

        // List<ThreeLinkBinTree.TreeNode> treeNodes = binTree.breadthFirst();
        // List<ThreeLinkBinTree.TreeNode> treeNodes = binTree.preIterator();
        // List<ThreeLinkBinTree.TreeNode> treeNodes = binTree.inIterator();
        List<ThreeLinkBinTree.TreeNode> treeNodes = binTree.postIterator();
        for (ThreeLinkBinTree.TreeNode treeNode : treeNodes) {
            System.out.println(treeNode.data);
        }


    }
}
