package com.blind75.problems.trees.p013_diameter_of_binary_tree;

import com.blind75.problems.common.TreeNode;

public class DiameterOfBinaryTreeNoIOParam implements DiameterOfBinaryTree {
  @Override
  public int diameterOfBinaryTree(TreeNode root) {
    AccumulatorAndCurrentDepth accumulatorAndCurrentDepth = getAccumulatorAndCurrentDepth(root, new AccumulatorAndCurrentDepth(0, 0));
    return accumulatorAndCurrentDepth.accumulator;
  }

  private static AccumulatorAndCurrentDepth getAccumulatorAndCurrentDepth(TreeNode curr, AccumulatorAndCurrentDepth accumulatorAndCurrentDepth) {
    if (curr == null) return new AccumulatorAndCurrentDepth(accumulatorAndCurrentDepth.accumulator, 0);

    accumulatorAndCurrentDepth = getAccumulatorAndCurrentDepth(curr.left, accumulatorAndCurrentDepth);
    int left = accumulatorAndCurrentDepth.currentDepth;
    accumulatorAndCurrentDepth = getAccumulatorAndCurrentDepth(curr.right, accumulatorAndCurrentDepth);
    int right = accumulatorAndCurrentDepth.currentDepth;

    int accumulator = Math.max(accumulatorAndCurrentDepth.accumulator, left + right);

    return new AccumulatorAndCurrentDepth(accumulator, 1 + Math.max(left, right));
  }

  private record AccumulatorAndCurrentDepth(int accumulator, int currentDepth) {

  }
}
