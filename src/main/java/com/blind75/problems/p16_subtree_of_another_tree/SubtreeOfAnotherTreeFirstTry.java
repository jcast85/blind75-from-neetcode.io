package com.blind75.problems.p16_subtree_of_another_tree;

import com.blind75.problems.common.TreeNode;
import com.blind75.problems.p015_same_binary_tree.SameBinaryTree;
import com.blind75.problems.p015_same_binary_tree.SameBinaryTreeFirstTry;

public class SubtreeOfAnotherTreeFirstTry implements SubtreeOfAnotherTree {
  @Override
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if(root == null && subRoot == null) {
      return true;
    }
    if(root == null || subRoot == null) {
      return false;
    }
    if(root.val == subRoot.val) {
      boolean isSubtree = isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
      if(isSubtree) {
        return true;
      }
      if(isSubtree(root.right, subRoot)) {
        return true;
      }
      if(isSubtree(root.left, subRoot)) {
        return true;
      }
    }
    if(isSubtree(root.left, subRoot)) {
      return true;
    }
    if(isSubtree(root.right, subRoot)) {
      return true;
    }
    return false;
  }

  private boolean isSameTree(TreeNode p, TreeNode q) {
    SameBinaryTree sameBinaryTree = new SameBinaryTreeFirstTry();
    return sameBinaryTree.isSameTree(p, q);
  }
}
