package com.blind75.problems.binary_search.time_based_key_value_store;

public interface TimeBasedKeyValueStore {
  void set(String key, String value, int timestamp);
  String get(String key, int timestamp);
}
