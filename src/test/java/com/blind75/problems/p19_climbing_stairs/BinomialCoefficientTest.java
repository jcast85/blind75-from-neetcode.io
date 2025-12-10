package com.blind75.problems.p19_climbing_stairs;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class BinomialCoefficientTest {

  private static final List<BinomialCoefficient> binomialCoefficientList = List.of(
    new BinomialCoefficientManualReasoning(),
    new BinomialCoefficientFromFormula()
  );

  private static final List<InputAndOutput> binomialCoefficientInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(0)
      .output(1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(1)
      .output(1+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(2)
      .output(1+2+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(3)
      .output(1+3+3+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(4)
      .output(1+4+6+4+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(5)
      .output(1+5+10+10+5+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(6)
      .output(1+6+15+20+15+6+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(7)
      .output(1+7+21+35+35+21+7+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(8)
      .output(1+8+28+56+70+56+28+8+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(9)
      .output(1+9+36+84+126+126+84+36+9+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(10)
      .output(1+10+45+120+210+252+210+120+45+10+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(30)
      .output(1+30+435+4060+27405+142506+593775+2035800+5852925+14307150+30045015+54627300+86493225+119759850+145422675+155117520+145422675+119759850+86493225+54627300+30045015+14307150+5852925+2035800+593775+142506+27405+4060+435+30+1)
      .build()
  );

  static Stream<SingleMethodTestConfig<BinomialCoefficient>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<BinomialCoefficient>> streamBuilder = Stream.builder();
    for (BinomialCoefficient binomialCoefficient : binomialCoefficientList) {
      for (InputAndOutput binomialCoefficientInputAndOutput : binomialCoefficientInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<BinomialCoefficient>()
          .implementationToTest(binomialCoefficient)
          .inputAndOutput(binomialCoefficientInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<BinomialCoefficient> singleMethodTestConfig) {
    SingleInputAndOutput<Integer, Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int result = singleMethodTestConfig.implementationToTest().binomialCoefficient(inputAndOutput.input());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
