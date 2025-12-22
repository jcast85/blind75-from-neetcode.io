package com.blind75.problems.arrays_and_hashing.encode_and_decode_strings;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class DecodeStringsTest {

  private static final List<DecodeStrings> decodeStringsList = List.of(
    new DecodeStringsNaive()
  );

  private static final List<InputAndOutput> decodeStringsInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input("4[neet]4[code]4[love]3[you]")
      .output(List.of("neet","code","love","you"))
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input("2[we]3[say]1[:]3[yes]")
      .output(List.of("we","say",":","yes"))
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input("0[]")
      .output(List.of(""))
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input("")
      .output(List.of())
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input("2[we]3[say]1[:]3[yes]10[!@#$%^&*()]")
      .output(List.of("we","say",":","yes","!@#$%^&*()"))
      .build()
  );

  static Stream<SingleMethodTestConfig<DecodeStrings>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<DecodeStrings>> streamBuilder = Stream.builder();
    for (DecodeStrings decodeStrings : decodeStringsList) {
      for (InputAndOutput inputAndOutput : decodeStringsInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<DecodeStrings>()
          .implementationToTest(decodeStrings)
          .inputAndOutput(inputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<DecodeStrings> singleMethodTestConfig) {
    SingleInputAndOutput<String, List<String>> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    List<String> result = singleMethodTestConfig.implementationToTest().decode(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
