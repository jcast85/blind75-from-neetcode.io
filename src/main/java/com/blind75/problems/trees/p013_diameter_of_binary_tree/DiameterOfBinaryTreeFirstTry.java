package com.blind75.problems.trees.p013_diameter_of_binary_tree;

import com.blind75.problems.common.TreeNode;

public class DiameterOfBinaryTreeFirstTry implements DiameterOfBinaryTree {

  @Override
  public int diameterOfBinaryTree(TreeNode root) {
    int[] res = new int[1];
    dfs(root, res);
    return res[0];
  }

  private int dfs(TreeNode curr, int[] res) {
    if (curr == null) return 0;

    int left = dfs(curr.left, res);
    int right = dfs(curr.right, res);

    res[0] = Math.max(res[0], left + right);

    return 1 + Math.max(left, right);
  }

  @Override
  public String toString() {
    return "DiameterOfBinaryTreeFirstTry";
  }
}
