package com.blind75.problems.binary_search.search_in_rotated_sorted_array;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SearchInRotatedSortedArrayTest {

  private static final List<SearchInRotatedSortedArray> searchInRotatedSortedArrayList = List.of(new SearchInRotatedSortedArrayNaive());

  private static final List<InputAndOutput> searchInRotatedSortedArrayInputAndOutputList = List.of(
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {3,4,5,6,1,2})
      .input2(1)
      .output(4)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {3,5,6,0,1,2})
      .input2(4)
      .output(-1)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {1})
      .input2(1)
      .output(0)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {1})
      .input2(2)
      .output(-1)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {1,3})
      .input2(0)
      .output(-1)
      .build()
  );

  static Stream<SingleMethodTestConfig<SearchInRotatedSortedArray>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<SearchInRotatedSortedArray>> streamBuilder = Stream.builder();
    for (SearchInRotatedSortedArray searchInRotatedSortedArray : searchInRotatedSortedArrayList) {
      for (InputAndOutput searchInRotatedSortedArrayInputAndOutput : searchInRotatedSortedArrayInputAndOutputList
//        .subList(4, 5)
      ) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<SearchInRotatedSortedArray>()
          .implementationToTest(searchInRotatedSortedArray)
          .inputAndOutput(searchInRotatedSortedArrayInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<SearchInRotatedSortedArray> singleMethodTestConfig) {
    DoubleInputAndOutput<int[], Integer, Integer> inputAndOutput = (DoubleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int result = singleMethodTestConfig.implementationToTest().search(inputAndOutput.input1(), inputAndOutput.input2());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
