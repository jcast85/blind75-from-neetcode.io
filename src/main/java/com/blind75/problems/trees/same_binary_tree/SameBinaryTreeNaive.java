package com.blind75.problems.trees.same_binary_tree;

import com.blind75.problems.common.TreeNode;

public class SameBinaryTreeNaive implements SameBinaryTree {
  @Override
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) {
      return true;
    }
    if(p == null || q == null) {
      return false;
    }
    if(p.left == null && q.left != null || p.right == null && q.right != null) {
      return false;
    }
    if(p.val == q.val) {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    return false;
  }
}
