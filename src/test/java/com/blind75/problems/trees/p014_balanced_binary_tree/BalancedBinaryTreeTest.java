package com.blind75.problems.trees.p014_balanced_binary_tree;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class BalancedBinaryTreeTest {

  private static final List<BalancedBinaryTree> balancedBinaryTreeList = List.of(
    new BalancedBinaryTreeFirstTry()
  );

  private static final List<InputAndOutput> balancedBinaryTreeInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(1,2,3,null,null,4))
      .output(true)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(1,2,3,null,null,4,null,5))
      .output(false)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of())
      .output(true)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(null)
      .output(true)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(1,null,2,null,3))
      .output(false)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(1,2,2,3,null,null,3,4,null,null,4))
      .output(false)
      .build()
  );

  static Stream<SingleMethodTestConfig<BalancedBinaryTree>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<BalancedBinaryTree>> streamBuilder = Stream.builder();
    for (BalancedBinaryTree balancedBinaryTree : balancedBinaryTreeList) {
      for (InputAndOutput balancedBinaryTreeInputAndOutput : balancedBinaryTreeInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<BalancedBinaryTree>()
          .implementationToTest(balancedBinaryTree)
          .inputAndOutput(balancedBinaryTreeInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<BalancedBinaryTree> singleMethodTestConfig) {
    SingleInputAndOutput<TreeNode, Boolean> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    boolean result = singleMethodTestConfig.implementationToTest().isBalanced(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
