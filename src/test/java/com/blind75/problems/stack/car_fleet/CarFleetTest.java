package com.blind75.problems.stack.car_fleet;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class CarFleetTest {

  private static final List<CarFleet> carFleetList = List.of(
    new CarFleetNaive(),
    new CarFleetStack()
  );

  private static final List<InputAndOutput> carFleetInputAndOutputList = List.of(
    new TripleInputAndOutputBuilder<>()
      .input1(10)
      .input2(new int[] {1,4})
      .input3(new int[] {3,2})
      .output(1)
      .build(),
    new TripleInputAndOutputBuilder<>()
      .input1(10)
      .input2(new int[] {4,1,0,7})
      .input3(new int[] {2,2,1,1})
      .output(3)
      .build(),
    new TripleInputAndOutputBuilder<>()
      .input1(100)
      .input2(new int[] {0,2,4})
      .input3(new int[] {4,2,1})
      .output(1)
      .build(),
    new TripleInputAndOutputBuilder<>()
      .input1(10)
      .input2(new int[] {6,8})
      .input3(new int[] {3,2})
      .output(2)
      .build(),
    new TripleInputAndOutputBuilder<>()
      .input1(31)
      .input2(new int[] {5,26,18,25,29,21,22,12,19,6})
      .input3(new int[] {7,6,6,4,3,4,9,7,6,4})
      .output(6)
      .build(),
    new TripleInputAndOutputBuilder<>()
      .input1(16)
      .input2(new int[] {11,14,13,6})
      .input3(new int[] {2,2,6,7})
      .output(2)
      .build(),
    new TripleInputAndOutputBuilder<>()
      .input1(20)
      .input2(new int[] {2,6,5,13,19,18,1,12,10,16,4,11})
      .input3(new int[] {6,1,10,3,1,5,9,7,9,2,8,3})
      .output(5)
      .build(),
    new TripleInputAndOutputBuilder<>()
      .input1(21)
      .input2(new int[] {1,15,6,8,18,14,16,2,19,17,3,20,5})
      .input3(new int[] {8,5,5,7,10,10,7,9,3,4,4,10,2})
      .output(7)
      .build()
  );

  static Stream<SingleMethodTestConfig<CarFleet>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<CarFleet>> streamBuilder = Stream.builder();
    for (CarFleet carFleet : carFleetList) {
      for (InputAndOutput carFleetInputAndOutput : carFleetInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<CarFleet>()
          .implementationToTest(carFleet)
          .inputAndOutput(carFleetInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<CarFleet> singleMethodTestConfig) {
    TripleInputAndOutput<Integer, int[], int[], Integer> inputAndOutput = (TripleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    Integer result = singleMethodTestConfig.implementationToTest().carFleet(inputAndOutput.input1(), inputAndOutput.input2(), inputAndOutput.input3());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
