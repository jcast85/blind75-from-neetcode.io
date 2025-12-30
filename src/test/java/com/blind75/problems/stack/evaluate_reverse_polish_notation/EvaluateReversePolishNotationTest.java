package com.blind75.problems.stack.evaluate_reverse_polish_notation;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class EvaluateReversePolishNotationTest {

  private static final List<EvaluateReversePolishNotation> evaluateReversePolishNotationList = List.of(
    new EvaluateReversePolishNotationNaive()
  );

  private static final List<InputAndOutput> evaluateReversePolishNotationInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new String[] {"1","2","+","3","*","4","-"})
      .output(5)
      .build()
  );

  static Stream<SingleMethodTestConfig<EvaluateReversePolishNotation>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<EvaluateReversePolishNotation>> streamBuilder = Stream.builder();
    for (EvaluateReversePolishNotation evaluateReversePolishNotation : evaluateReversePolishNotationList) {
      for (InputAndOutput inputAndOutput : evaluateReversePolishNotationInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<EvaluateReversePolishNotation>()
          .implementationToTest(evaluateReversePolishNotation)
          .inputAndOutput(inputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<EvaluateReversePolishNotation> singleMethodTestConfig) {
    SingleInputAndOutput<String[], Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    Integer result = singleMethodTestConfig.implementationToTest().evalRPN(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
