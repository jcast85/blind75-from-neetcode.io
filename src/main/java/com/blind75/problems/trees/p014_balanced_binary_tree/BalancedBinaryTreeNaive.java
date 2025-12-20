package com.blind75.problems.trees.p014_balanced_binary_tree;

import com.blind75.problems.common.TreeNode;

public class BalancedBinaryTreeNaive implements BalancedBinaryTree {
  @Override
  public boolean isBalanced(TreeNode root) {
    if(root == null) {
      return true;
    }
    return isBalancedTail(root).isBalanced;
  }

  private IsBalancedResult isBalancedTail(TreeNode root) {
    if(root == null) {
      return new IsBalancedResult(true, 0);
    }
    if(root.left == null && root.right == null) {
      return new IsBalancedResult(true, 1);
    }
    if(root.left == null) {
      IsBalancedResult rightResult = isBalancedTail(root.right);
      return new IsBalancedResult(
        rightResult.height <= 1,
        rightResult.height + 1
      );
    }
    if(root.right == null) {
      IsBalancedResult leftResult = isBalancedTail(root.left);
      return new IsBalancedResult(
        leftResult.height <= 1,
        leftResult.height + 1
      );
    }
    IsBalancedResult leftResult = isBalancedTail(root.left);
    IsBalancedResult rightResult = isBalancedTail(root.right);
    return new IsBalancedResult(
      Math.abs(leftResult.height - rightResult.height) <= 1 && leftResult.isBalanced
        && rightResult.isBalanced,
      Math.max(leftResult.height, rightResult.height) + 1);
  }

  private static class IsBalancedResult {
    boolean isBalanced;
    int height;
    public IsBalancedResult(boolean isBalanced, int height) {
      this.isBalanced = isBalanced;
      this.height = height;
    }
  }
}
