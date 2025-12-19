package com.blind75.problems.trees.p011_invert_binary_tree;

import com.blind75.problems.common.TreeNode;

public class InvertBinaryTreeFirstTry implements InvertBinaryTree {
  @Override
  public TreeNode invertTree(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return root;
    }
    return new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
  }
}
