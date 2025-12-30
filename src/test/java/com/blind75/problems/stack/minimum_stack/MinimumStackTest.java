package com.blind75.problems.stack.minimum_stack;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MinimumStackTest {

  private static final List<Class<?>> minimumStackList = List.of(
    MinimumStackNaive.class
  );

  private static final List<InputAndOutput> minimumStackPushInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new Object[] {"MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"})
      .output(new Object[] {null,null,null,null,0,null,2,1})
      .build()
  );

  static Stream<ConstructorAndMethodTestConfig> testConfigs() {
    Stream.Builder<ConstructorAndMethodTestConfig> streamBuilder = Stream.builder();
    for (Class<?> minimumStack : minimumStackList) {
      for(int i = 0; i < minimumStackPushInputAndOutputList.size(); i++) {
        streamBuilder.add(ConstructorAndMethodTestConfigBuilder.builder()
          .implementationToTest(minimumStack)
          .inputAndOutputList(List.of(minimumStackPushInputAndOutputList.get(i)))
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(ConstructorAndMethodTestConfig testConfig)
    throws InvocationTargetException, InstantiationException, IllegalAccessException {
    Class<?> klazz = testConfig.implementationToTest();
    Constructor<?> constructor = klazz.getConstructors()[0];
    constructor.setAccessible(true);
    Object instance = constructor.newInstance();
    Class<?> klazzInterface = klazz.getInterfaces()[0];
    Object instanceCast = klazzInterface.cast(instance);
    List<Method> methodList = Arrays.asList(klazzInterface.getMethods());
    List<String> methodNames = methodList.stream().map(Method::getName).toList();

    for(InputAndOutput inputAndOutput : testConfig.inputAndOutputList()) {
      int inputInnerIndex = 1;
      int outputInnerIndex = 1;
      SingleInputAndOutput<Object[], Object[]> methodInputAndOutput = (SingleInputAndOutput<Object[], Object[]>) inputAndOutput;
      while(inputInnerIndex < methodInputAndOutput.input().length
        && outputInnerIndex < methodInputAndOutput.output().length
      ) {
        String methodName = (String) methodInputAndOutput.input()[inputInnerIndex];
        Method method = methodList.stream()
          .filter(methodI -> methodI.getName().equals(methodName))
          .findFirst().get();
        Stream.Builder<Object> streamBuilder = Stream.builder();
        while(inputInnerIndex+1<methodInputAndOutput.input().length && !methodNames.contains(methodInputAndOutput.input()[inputInnerIndex + 1])) {
          streamBuilder.add(methodInputAndOutput.input()[inputInnerIndex + 1]);
          inputInnerIndex++;
        }
        Object result = method.invoke(instanceCast, streamBuilder.build().toArray());
        Assertions.assertEquals(methodInputAndOutput.output()[outputInnerIndex], result);
        inputInnerIndex++;
        outputInnerIndex++;
      }
    }
  }
}
