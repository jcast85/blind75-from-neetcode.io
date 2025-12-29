package com.blind75.problems.trees.diameter_of_binary_tree;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class DiameterOfBinaryTreeTest {

  private static final List<DiameterOfBinaryTree> diameterOfBinaryTreeList = List.of(
    new DiameterOfBinaryTreeNaive(),
    new DiameterOfBinaryTreeNoIOParam()
  );

  private static final List<InputAndOutput> diameterOfBinaryTreeInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(1))
      .output(0)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(1,2))
      .output(1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(1,2,3))
      .output(2)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(1,2,3,4))
      .output(3)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(1,2,3,4,null,6,null))
      .output(4)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(1,null,2,3,4,5))
      .output(3)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(1,null,2,3,4,5,null,null,6,7))
      .output(5)
      .build()
  );

  static Stream<SingleMethodTestConfig<DiameterOfBinaryTree>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<DiameterOfBinaryTree>> streamBuilder = Stream.builder();
    for (DiameterOfBinaryTree diameterOfBinaryTree : diameterOfBinaryTreeList) {
      for (InputAndOutput diameterOfBinaryTreeInputAndOutput : diameterOfBinaryTreeInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<DiameterOfBinaryTree>()
          .implementationToTest(diameterOfBinaryTree)
          .inputAndOutput(diameterOfBinaryTreeInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<DiameterOfBinaryTree> singleMethodTestConfig) {
    SingleInputAndOutput<TreeNode, Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int result = singleMethodTestConfig.implementationToTest().diameterOfBinaryTree(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
