package com.blind75.problems.arrays_and_hashing.products_of_array_except_self;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ProductsOfArrayExceptSelfTest {

  private static final List<ProductsOfArrayExceptSelf> productsOfArrayExceptSelfList = List.of(
    new ProductsOfArrayExceptSelfNaive(),
    new ProductsOfArrayExceptSelfWithoutDivision(),
    new ProductsOfArrayExceptSelfWithoutDivisionLessSpace()
  );

  private static final List<InputAndOutput> productsOfArrayExceptSelfInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1,2,4,6})
      .output(new int[] {48,24,12,8})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {-1,0,1,2,3})
      .output(new int[] {0,-6,0,0,0})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {0,0})
      .output(new int[] {0,0})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {0,8,0})
      .output(new int[] {0,0,0})
      .build());

  static Stream<SingleMethodTestConfig<ProductsOfArrayExceptSelf>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<ProductsOfArrayExceptSelf>> streamBuilder = Stream.builder();
    for (ProductsOfArrayExceptSelf productsOfArrayExceptSelf : productsOfArrayExceptSelfList) {
      for (InputAndOutput productsOfArrayExceptSelfInputAndOutput : productsOfArrayExceptSelfInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<ProductsOfArrayExceptSelf>()
          .implementationToTest(productsOfArrayExceptSelf)
          .inputAndOutput(productsOfArrayExceptSelfInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<ProductsOfArrayExceptSelf> singleMethodTestConfig) {
    SingleInputAndOutput<int[], int[]> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int[] result = singleMethodTestConfig.implementationToTest().productExceptSelf(inputAndOutput.input());
    Assertions.assertArrayEquals(inputAndOutput.output(), result);
  }
}
