package com.blind75.problems.common;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;

@ToString
@Builder
@EqualsAndHashCode
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {
  }

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static TreeNode of(Integer... val) {
    if (val == null || val.length == 0 || val[0] == null) {
      return new TreeNode();
    }

    TreeNode root = new TreeNode(val[0]);
    java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
    queue.offer(root);

    int i = 1;
    while (!queue.isEmpty() && i < val.length) {
      TreeNode current = queue.poll();

      // Add left child
      if (val[i] != null) {
        current.left = new TreeNode(val[i]);
        queue.offer(current.left);
      }
      i++;

      // Add right child
      if (i < val.length && val[i] != null) {
        current.right = new TreeNode(val[i]);
        queue.offer(current.right);
      }
      i++;
    }

    return root;
  }


  public static TreeNode ofSorted(Integer... val) {
    return ofSorted(0, val.length, val);
  }

  private static TreeNode ofSorted(Integer startIndex, Integer endIndex, Integer... val) {
    if (val == null || Objects.equals(endIndex, startIndex)) {
      return null;
    }

    int centralIndex = (endIndex - startIndex) / 2 + startIndex;
    TreeNode root = new TreeNode(val[centralIndex]);
    root.left = ofSorted(startIndex, centralIndex, val);
    root.right = ofSorted(centralIndex + 1, endIndex, val);
    return root;
  }
}
