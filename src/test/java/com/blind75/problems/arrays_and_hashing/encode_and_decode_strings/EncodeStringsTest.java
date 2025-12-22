package com.blind75.problems.arrays_and_hashing.encode_and_decode_strings;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class EncodeStringsTest {

  private static final List<EncodeStrings> encodeStringsList = List.of(
    new EncodeStringsNaive()
  );

  private static final List<InputAndOutput> encodeStringsInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(List.of("neet","code","love","you"))
      .output("4[neet]4[code]4[love]3[you]")
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(List.of("we","say",":","yes"))
      .output("2[we]3[say]1[:]3[yes]")
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(List.of(""))
      .output("0[]")
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(List.of())
      .output("")
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(List.of("we","say",":","yes","!@#$%^&*()"))
      .output("2[we]3[say]1[:]3[yes]10[!@#$%^&*()]")
      .build()
  );

  static Stream<SingleMethodTestConfig<EncodeStrings>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<EncodeStrings>> streamBuilder = Stream.builder();
    for (EncodeStrings encodeStrings : encodeStringsList) {
      for (InputAndOutput inputAndOutput : encodeStringsInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<EncodeStrings>()
          .implementationToTest(encodeStrings)
          .inputAndOutput(inputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<EncodeStrings> singleMethodTestConfig) {
    SingleInputAndOutput<List<String>, String> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    String result = singleMethodTestConfig.implementationToTest().encode(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
