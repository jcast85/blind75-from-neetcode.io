package com.blind75.problems.p17_kth_largest_element_in_a_stream;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Stream;

public class KthLargestElementInAStreamTest {

  private static final List<Class<?>> kthLargestList = List.of(
    KthLargestArray.class,
    KthLargestList.class,
    KthLargestPriorityQueue.class
  );

  private static final List<InputAndOutput> kthLargestConstructorInputAndOutputList = List.of(
    new DoubleInputAndOutputBuilder<>()
      .input1(3)
      .input2(new int[] {1, 2, 3, 3})
      .build()
  );

  private static final List<List<InputAndOutput>> kthLargestInputAndOutputList = List.of(
    List.of(
      new SingleInputAndOutputBuilder<>()
        .input(3)
        .output(3)
        .build(),
      new SingleInputAndOutputBuilder<>()
        .input(5)
        .output(3)
        .build(),
      new SingleInputAndOutputBuilder<>()
        .input(6)
        .output(3)
        .build(),
      new SingleInputAndOutputBuilder<>()
        .input(7)
        .output(5)
        .build(),
      new SingleInputAndOutputBuilder<>()
        .input(8)
        .output(6)
        .build()
    )
  );

  static Stream<ConstructorAndMethodTestConfig> testConfigs() {
    Stream.Builder<ConstructorAndMethodTestConfig> streamBuilder = Stream.builder();
    for (Class kthLargestClass : kthLargestList) {
      for(int i = 0; i < kthLargestConstructorInputAndOutputList.size(); i++) {
        streamBuilder.add(ConstructorAndMethodTestConfigBuilder.builder()
          .implementationToTest(kthLargestClass)
          .constructorInputAndOutput(kthLargestConstructorInputAndOutputList.get(i))
          .inputAndOutputList(kthLargestInputAndOutputList.get(i))
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(ConstructorAndMethodTestConfig testConfig)
    throws InvocationTargetException, InstantiationException, IllegalAccessException {
    DoubleInputAndOutput<TreeNode, TreeNode, Boolean> constructorInputAndOutput = (DoubleInputAndOutput) testConfig.constructorInputAndOutput();
    Class<?> klazz = testConfig.implementationToTest();
    Constructor<?> constructor = klazz.getConstructors()[0];
    constructor.setAccessible(true);
    Object instance = constructor.newInstance(constructorInputAndOutput.input1(), constructorInputAndOutput.input2());
    Class<?> klazzInterface = klazz.getInterfaces()[0];
    Object instanceCast = klazzInterface.cast(instance);

    for(InputAndOutput inputAndOutput : testConfig.inputAndOutputList()) {
      SingleInputAndOutput<Integer, Integer> methodInputAndOutput = (SingleInputAndOutput<Integer, Integer>) inputAndOutput;
      Object result = klazzInterface.getMethods()[0].invoke(instanceCast, methodInputAndOutput.input());
      Assertions.assertEquals(methodInputAndOutput.output(), result);
    }
  }
}
