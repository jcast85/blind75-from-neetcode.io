package com.blind75.problems.common;

import java.util.*;

public class CommonStaticTestMethods {
  private CommonStaticTestMethods() {}

  public static List<List<Comparable>> normalize(List<List<Comparable>> input) {
    return input.stream()
      .map(inner -> {
        List<Comparable> copy = new ArrayList<>(inner);
        java.util.Collections.sort(copy);
        return copy;
      })
      .sorted((a, b) -> {
        int sizeCompare = Integer.compare(a.size(), b.size());
        if (sizeCompare != 0) {
          return sizeCompare;
        }
        for (int i = 0; i < a.size(); i++) {
          int cmp = a.get(i).compareTo(b.get(i));
          if (cmp != 0) {
            return cmp;
          }
        }
        return 0;
      })
      .toList();
  }

  public static boolean isListOfLists(List<?> list) {
    return list.stream().allMatch(element -> element instanceof List<?>);
  }

  public static void assertions(Object actual, Object expected) {
    if (actual instanceof List<?> actualList
      && expected instanceof List<?> expectedList
      && isListOfLists(actualList)
      && isListOfLists(expectedList)) {

      List<List<?>> actualCastedList = normalize((List) actualList);
      List<List<?>> expectedCastedList = normalize((List) expectedList);
      org.hamcrest.MatcherAssert.assertThat(actualCastedList, org.hamcrest.Matchers.equalTo(expectedCastedList));
      return;
    }
    if (actual instanceof List<?> actualList
      && expected instanceof List<?> expectedList) {
      boolean sameElements =
        actualList.size() == expectedList.size() &&
          actualList.stream().allMatch(e ->
            Collections.frequency(actualList, e)
              == Collections.frequency(expectedList, e));
      org.hamcrest.MatcherAssert.assertThat(sameElements, org.hamcrest.Matchers.equalTo(true));
      return;
    }
    org.hamcrest.MatcherAssert.assertThat(actual, org.hamcrest.Matchers.equalTo(expected));
  }
}
