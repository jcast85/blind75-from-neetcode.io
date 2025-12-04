package com.blind75.problems.p011_invert_binary_tree;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class InvertBinaryTreeTest {

  private static final List<InvertBinaryTree> invertBinaryTreeList = List.of(
    new InvertBinaryTreeFirstTry()
  );

  private static final List<InputAndOutput> invertBinaryTreeInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(1, 2, 3, 4, 5, 6, 7))
      .output(TreeNode.of(1, 3, 2, 7, 6, 5, 4))
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of(3, 2, 1))
      .output(TreeNode.of(3, 1, 2))
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(TreeNode.of())
      .output(TreeNode.of())
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(null)
      .output(null)
      .build()
  );

  static Stream<SingleMethodTestConfig<InvertBinaryTree>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<InvertBinaryTree>> streamBuilder = Stream.builder();
    for (InvertBinaryTree invertBinaryTree : invertBinaryTreeList) {
      for (InputAndOutput invertBinaryTreeInputAndOutput : invertBinaryTreeInputAndOutputList) {
        streamBuilder.add(new TestConfigBuilder<InvertBinaryTree>()
          .interfaceToTest(invertBinaryTree)
          .inputAndOutput(invertBinaryTreeInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<InvertBinaryTree> singleMethodTestConfig) {
    SingleInputAndOutput<TreeNode, TreeNode> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    TreeNode result = singleMethodTestConfig.implementationToTest().invertTree(inputAndOutput.input());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
