package com.blind75.problems.binary_search.time_based_key_value_store;

import java.util.HashMap;
import java.util.Map;

public class TimeBasedKeyValueStoreNaive implements TimeBasedKeyValueStore {
  Map<String, Map<Integer, String>> map;
  Map<String, Integer> minTimestampMap;

  public TimeBasedKeyValueStoreNaive() {
    map = new HashMap<>();
    minTimestampMap = new HashMap<>();
  }

  @Override
  public void set(String key, String value, int timestamp) {
    Map<Integer, String> timestampMap;
    if(!map.containsKey(key)) {
      timestampMap = new HashMap<>();
    } else {
      timestampMap = map.get(key);
    }
    timestampMap.put(timestamp, value);
    map.put(key, timestampMap);
    if(!minTimestampMap.containsKey(key) || timestamp < minTimestampMap.get(key)) {
      minTimestampMap.put(key, timestamp);
    }
  }

  @Override
  public String get(String key, int timestamp) {
    if(!map.containsKey(key)) {
      return "";
    }
    if(map.containsKey(key) && map.get(key).containsKey(timestamp)) {
      return map.get(key).get(timestamp);
    }
    Integer minTs = minTimestampMap.get(key);
    if(timestamp < minTs) {
      return "";
    }
    return get(key, timestamp - 1);
  }
}
