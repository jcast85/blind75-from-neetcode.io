package com.blind75.problems.p015_same_binary_tree;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SameBinaryTreeTest {

  private static final List<SameBinaryTree> sameBinaryTreeList = List.of(
    new SameBinaryTreeFirstTry()
  );

  private static final List<InputAndOutput> sameBinaryTreeInputAndOutputList = List.of(
    new DoubleInputAndOutputBuilder<>()
      .input1(TreeNode.of(1,2,3))
      .input2(TreeNode.of(1,2,3))
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(TreeNode.of(4,7))
      .input2(TreeNode.of(4,null,7))
      .output(false)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(TreeNode.of(1,2,3))
      .input2(TreeNode.of(1,3,2))
      .output(false)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(null)
      .input2(TreeNode.of(0))
      .output(false)
      .build()
  );

  static Stream<SingleMethodTestConfig<SameBinaryTree>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<SameBinaryTree>> streamBuilder = Stream.builder();
    for (SameBinaryTree sameBinaryTree : sameBinaryTreeList) {
      for (InputAndOutput sameBinaryTreeInputAndOutput : sameBinaryTreeInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<SameBinaryTree>()
          .implementationToTest(sameBinaryTree)
          .inputAndOutput(sameBinaryTreeInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<SameBinaryTree> singleMethodTestConfig) {
    DoubleInputAndOutput<TreeNode, TreeNode, Boolean> inputAndOutput = (DoubleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    boolean result = singleMethodTestConfig.implementationToTest().isSameTree(inputAndOutput.input1(), inputAndOutput.input2());
    org.hamcrest.MatcherAssert.assertThat(result, org.hamcrest.Matchers.equalTo(inputAndOutput.output()));
  }
}
