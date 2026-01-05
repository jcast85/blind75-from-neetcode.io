package com.blind75.problems.binary_search.search_a_2d_matrix;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SearchA2DMatrixTest {

  private static final List<SearchA2DMatrix> searchA2DMatrixList = List.of(
    new SearchA2DMatrixDichotomicSearch(),
    new SearchA2DMatrixNoSpaceOverhead()
  );

  private static final List<InputAndOutput> searchA2DMatrixInputAndOutputList = List.of(
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}})
      .input2(1)
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}})
      .input2(2)
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}})
      .input2(4)
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}})
      .input2(8)
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}})
      .input2(10)
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}})
      .input2(11)
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}})
      .input2(12)
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}})
      .input2(13)
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}})
      .input2(14)
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}})
      .input2(20)
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}})
      .input2(30)
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}})
      .input2(40)
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,2,4,8},{10,11,12,13},{14,20,30,40}})
      .input2(15)
      .output(false)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}})
      .input2(3)
      .output(true)
      .build()
  );

  static Stream<SingleMethodTestConfig<SearchA2DMatrix>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<SearchA2DMatrix>> streamBuilder = Stream.builder();
    for (SearchA2DMatrix searchA2DMatrix : searchA2DMatrixList) {
      for (InputAndOutput searchA2DMatrixInputAndOutput : searchA2DMatrixInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<SearchA2DMatrix>()
          .implementationToTest(searchA2DMatrix)
          .inputAndOutput(searchA2DMatrixInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<SearchA2DMatrix> singleMethodTestConfig) {
    DoubleInputAndOutput<int[][], Integer, Boolean> inputAndOutput = (DoubleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    boolean result = singleMethodTestConfig.implementationToTest().searchMatrix(inputAndOutput.input1(), inputAndOutput.input2());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
