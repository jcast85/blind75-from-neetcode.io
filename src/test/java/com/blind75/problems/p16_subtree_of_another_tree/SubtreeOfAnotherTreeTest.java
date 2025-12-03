package com.blind75.problems.p16_subtree_of_another_tree;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SubtreeOfAnotherTreeTest {

  private static final List<SubtreeOfAnotherTree> subtreeOfAnotherTreeList = List.of(
    new SubtreeOfAnotherTreeFirstTry()
  );

  private static final List<InputAndOutput> subtreeOfAnotherTreeInputAndOutputList = List.of(
    new DoubleInputAndOutputBuilder<>()
      .input1(TreeNode.of(1,2,3,4,5))
      .input2(TreeNode.of(2,4,5))
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(TreeNode.of(1,2,3,4,5,null,null,6))
      .input2(TreeNode.of(2,4,5))
      .output(false)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(TreeNode.of(3,4,5,1,null,2))
      .input2(TreeNode.of(3,1,2))
      .output(false)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(TreeNode.of(3,3,5,1,2,null))
      .input2(TreeNode.of(3,1,2))
      .output(true)
      .build()
  );

  static Stream<TestConfig<SubtreeOfAnotherTree>> testConfigs() {
    Stream.Builder<TestConfig<SubtreeOfAnotherTree>> streamBuilder = Stream.builder();
    for (SubtreeOfAnotherTree subtreeOfAnotherTree : subtreeOfAnotherTreeList) {
      for (InputAndOutput subtreeOfAnotherTreeInputAndOutput : subtreeOfAnotherTreeInputAndOutputList) {
        streamBuilder.add(new TestConfigBuilder<SubtreeOfAnotherTree>()
          .interfaceToTest(subtreeOfAnotherTree)
          .inputAndOutput(subtreeOfAnotherTreeInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(TestConfig<SubtreeOfAnotherTree> testConfig) {
    DoubleInputAndOutput<TreeNode, TreeNode, Boolean> inputAndOutput = (DoubleInputAndOutput) testConfig.inputAndOutput();
    boolean result = testConfig.interfaceToTest().isSubtree(inputAndOutput.input1(), inputAndOutput.input2());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
