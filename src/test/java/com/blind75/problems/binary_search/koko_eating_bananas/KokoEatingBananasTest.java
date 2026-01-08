package com.blind75.problems.binary_search.koko_eating_bananas;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class KokoEatingBananasTest {

  private static final List<KokoEatingBananas> kokoEatingBananasList = List.of(
    new KokoEatingBananasNaive(),
//    new KokoEatingBananasBinarySearchTooManyResources(),
    new KokoEatingBananasBinarySearch()
  );

  private static final List<InputAndOutput> kokoEatingBananasInputAndOutputList = List.of(
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {1,4,3,2})
      .input2(9)
      .output(2)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {25,10,23,4})
      .input2(4)
      .output(25)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {4,4,3,2,1})
      .input2(6)
      .output(4)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {4,4,3,2,1})
      .input2(7)
      .output(3)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {4,4,3,2,1})
      .input2(8)
      .output(2)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {4,4,3,2,1})
      .input2(9)
      .output(2)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {4,4,3,2,1})
      .input2(10)
      .output(2)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {4,4,3,2,1})
      .input2(11)
      .output(2)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {4,4,3,2,1})
      .input2(12)
      .output(2)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {4,4,3,2,1})
      .input2(13)
      .output(2)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {4,4,3,2,1})
      .input2(14)
      .output(1)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184})
      .input2(823855818)
      .output(14)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {1,1,1,999999999})
      .input2(10)
      .output(142857143)
      .build()
  );

  static Stream<SingleMethodTestConfig<KokoEatingBananas>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<KokoEatingBananas>> streamBuilder = Stream.builder();
    for (KokoEatingBananas kokoEatingBananas : kokoEatingBananasList) {
      for (InputAndOutput kokoEatingBananasInputAndOutput : kokoEatingBananasInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<KokoEatingBananas>()
          .implementationToTest(kokoEatingBananas)
          .inputAndOutput(kokoEatingBananasInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<KokoEatingBananas> singleMethodTestConfig) {
    DoubleInputAndOutput<int[], Integer, Integer> inputAndOutput = (DoubleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int result = singleMethodTestConfig.implementationToTest().minEatingSpeed(inputAndOutput.input1(), inputAndOutput.input2());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
