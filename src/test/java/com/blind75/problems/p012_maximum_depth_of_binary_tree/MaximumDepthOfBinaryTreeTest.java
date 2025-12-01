package com.blind75.problems.p012_maximum_depth_of_binary_tree;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class MaximumDepthOfBinaryTreeTest {

  private static final List<MaximumDepthOfBinaryTree> maximumDepthOfBinaryTreeList = List.of(
    new MaximumDepthOfBinaryTreeFirstTry()
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

  static Stream<TestConfig<MaximumDepthOfBinaryTree>> testConfigs() {
    Stream.Builder<TestConfig<MaximumDepthOfBinaryTree>> streamBuilder = Stream.builder();
    for (MaximumDepthOfBinaryTree maximumDepthOfBinaryTree : maximumDepthOfBinaryTreeList) {
      for (InputAndOutput maximumDepthOfBinaryTreeInputAndOutput : maximumDepthOfBinaryTreeInputAndOutputList) {
        streamBuilder.add(new TestConfigBuilder<MaximumDepthOfBinaryTree>()
          .interfaceToTest(maximumDepthOfBinaryTree)
          .inputAndOutput(maximumDepthOfBinaryTreeInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(TestConfig<MaximumDepthOfBinaryTree> testConfig) {
    SingleInputAndOutput<TreeNode, Integer> inputAndOutput = (SingleInputAndOutput) testConfig.inputAndOutput();
    int result = testConfig.interfaceToTest().maxDepth(inputAndOutput.input());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
