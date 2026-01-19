package com.blind75.problems.binary_search.time_based_key_value_store;

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

public class TimeBasedKeyValueStoreTest {

  private static final List<Class<?>> timeBasedKeyValueStoreList = List.of(
    TimeBasedKeyValueStoreNaive.class,
    TimeBasedKeyValueStoreBinarySearch.class
  );

  private static final List<InputAndOutput> timeBasedKeyValueStorePushInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new Object[] {"TimeBasedKeyValueStore", "set", "alice", "happy", 1, "get", "alice", 1, "get", "alice", 2, "set", "alice", "sad", 3, "get", "alice", 3})
      .output(new Object[] {null,null,"happy","happy",null,"sad"})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new Object[] {"TimeBasedKeyValueStore", "set", "key1", "value1", 10, "get", "key1", 1, "get", "key1", 10, "get", "key1", 11})
      .output(new Object[] {null,null,"","value1","value1"})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new Object[] {"TimeBasedKeyValueStore", "set", "foo", "bar", 1, "get", "foo", 1, "get", "foo", 3,"set", "foo", "bar2", 4, "get", "foo", 4, "get", "foo", 5})
      .output(new Object[] {null,null,"bar","bar",null,"bar2","bar2"})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new Object[] {"TimeBasedKeyValueStore", "set", "test", "one", 10, "set", "test", "two", 20, "set", "test", "three", 30, "get", "test", 15, "get", "test", 25, "get", "test", 35})
      .output(new Object[] {null,null,null,null,"one","two","three"})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new Object[] {"TimeBasedKeyValueStore", "set", "sequence", "alpha", 100, "set", "sequence", "beta", 200, "set", "sequence", "gamma", 300, "get", "sequence", 150, "get", "sequence", 250, "get", "sequence", 350})
      .output(new Object[] {null,null,null,null,"alpha","beta","gamma"})
      .build()
  );

  static Stream<ConstructorAndMethodTestConfig> testConfigs() {
    Stream.Builder<ConstructorAndMethodTestConfig> streamBuilder = Stream.builder();
    for (Class<?> timeBasedKeyValueStore : timeBasedKeyValueStoreList) {
      for (InputAndOutput inputAndOutput : timeBasedKeyValueStorePushInputAndOutputList
    //    .subList(3,4)
      ) {
        streamBuilder.add(ConstructorAndMethodTestConfigBuilder.builder()
          .implementationToTest(timeBasedKeyValueStore)
          .inputAndOutputList(List.of(inputAndOutput))
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
