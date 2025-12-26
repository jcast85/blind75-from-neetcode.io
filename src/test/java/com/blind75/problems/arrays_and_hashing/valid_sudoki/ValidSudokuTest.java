package com.blind75.problems.arrays_and_hashing.valid_sudoki;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ValidSudokuTest {

  private static final List<ValidSudoku> validSudokuList = List.of(
    new ValidSudokuNaive(),
    new ValidSudokuOptimized()
  );

  private static final List<InputAndOutput> validSudokuInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new char[][]
        {{'1','2','.','.','3','.','.','.','.'},
        {'4','.','.','5','.','.','.','.','.'},
        {'.','9','8','.','.','.','.','.','3'},
        {'5','.','.','.','6','.','.','.','4'},
        {'.','.','.','8','.','3','.','.','5'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','.','.','.','.','.','2','.','.'},
        {'.','.','.','4','1','9','.','.','8'},
        {'.','.','.','.','8','.','.','7','9'}})
      .output(true)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new char[][]
        {{'1','2','.','.','3','.','.','.','.'},
        {'4','.','.','5','.','.','.','.','.'},
        {'.','9','1','.','.','.','.','.','3'},
        {'5','.','.','.','6','.','.','.','4'},
        {'.','.','.','8','.','3','.','.','5'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','.','.','.','.','.','2','.','.'},
        {'.','.','.','4','1','9','.','.','8'},
        {'.','.','.','.','8','.','.','7','9'}})
      .output(false)
      .build()
  );

  static Stream<SingleMethodTestConfig<ValidSudoku>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<ValidSudoku>> streamBuilder = Stream.builder();
    for (ValidSudoku validSudoku : validSudokuList) {
      for (InputAndOutput inputAndOutput : validSudokuInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<ValidSudoku>()
          .implementationToTest(validSudoku)
          .inputAndOutput(inputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<ValidSudoku> singleMethodTestConfig) {
    SingleInputAndOutput<char[][], Boolean> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    boolean result = singleMethodTestConfig.implementationToTest().isValidSudoku(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
