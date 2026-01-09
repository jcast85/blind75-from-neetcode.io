package com.blind75.problems.binary_search.find_minimum_in_rotated_sorted_array;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class FindMinimumInRotatedSortedArrayTest {

  private static final List<FindMinimumInRotatedSortedArray> findMinimumInRotatedSortedArrayList = List.of(
    new FindMinimumInRotatedSortedArrayNaive()
  );

  private static final List<InputAndOutput> findMinimumInRotatedSortedArrayInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {3,4,5,6,1,2})
      .output(1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {4,5,6,7})
      .output(4)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1, 2, 3, 4, 5, 6, 7})
      .output(1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {7, 1, 2, 3, 4, 5, 6})
      .output(1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {6, 7, 1, 2, 3, 4, 5})
      .output(1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {5, 6, 7, 1, 2, 3, 4})
      .output(1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {4, 5, 6, 7, 1, 2, 3})
      .output(1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {3, 4, 5, 6, 7, 1, 2})
      .output(1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {2, 3, 4, 5, 6, 7, 1})
      .output(1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1})
      .output(1)
      .build()
  );

  static Stream<SingleMethodTestConfig<FindMinimumInRotatedSortedArray>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<FindMinimumInRotatedSortedArray>> streamBuilder = Stream.builder();
    for (FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray : findMinimumInRotatedSortedArrayList) {
      for (InputAndOutput findMinimumInRotatedSortedArrayInputAndOutput : findMinimumInRotatedSortedArrayInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<FindMinimumInRotatedSortedArray>()
          .implementationToTest(findMinimumInRotatedSortedArray)
          .inputAndOutput(findMinimumInRotatedSortedArrayInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<FindMinimumInRotatedSortedArray> singleMethodTestConfig) {
    SingleInputAndOutput<int[], Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int result = singleMethodTestConfig.implementationToTest().findMin(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
