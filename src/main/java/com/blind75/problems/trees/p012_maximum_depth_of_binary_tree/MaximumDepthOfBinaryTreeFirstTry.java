package com.blind75.problems.trees.p012_maximum_depth_of_binary_tree;

import com.blind75.problems.common.TreeNode;

public class MaximumDepthOfBinaryTreeFirstTry implements MaximumDepthOfBinaryTree {
  @Override
  public int maxDepth(TreeNode root) {
    if(root == null) {
      return 0;
    }
    if(root.left == null && root.right == null) {
      return 1;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
