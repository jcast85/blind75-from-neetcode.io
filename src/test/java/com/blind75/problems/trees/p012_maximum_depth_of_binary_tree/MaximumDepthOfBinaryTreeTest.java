package com.blind75.problems.trees.p012_maximum_depth_of_binary_tree;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class MaximumDepthOfBinaryTreeTest {

  private static final List<MaximumDepthOfBinaryTree> maximumDepthOfBinaryTreeList = List.of(
    new MaximumDepthOfBinaryTreeNaive()
  );

  private static final List<InputAndOutput> maximumDepthOfBinaryTreeInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(1,2,3,null,null,4))
      .output(3)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(null)
      .output(0)
      .build()
  );

  static Stream<SingleMethodTestConfig<MaximumDepthOfBinaryTree>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<MaximumDepthOfBinaryTree>> streamBuilder = Stream.builder();
    for (MaximumDepthOfBinaryTree maximumDepthOfBinaryTree : maximumDepthOfBinaryTreeList) {
      for (InputAndOutput maximumDepthOfBinaryTreeInputAndOutput : maximumDepthOfBinaryTreeInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<MaximumDepthOfBinaryTree>()
          .implementationToTest(maximumDepthOfBinaryTree)
          .inputAndOutput(maximumDepthOfBinaryTreeInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<MaximumDepthOfBinaryTree> singleMethodTestConfig) {
    SingleInputAndOutput<TreeNode, Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int result = singleMethodTestConfig.implementationToTest().maxDepth(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
