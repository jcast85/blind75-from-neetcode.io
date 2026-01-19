package com.blind75.problems.binary_search.time_based_key_value_store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStoreBinarySearch implements TimeBasedKeyValueStore {
  Map<String, Map<Integer, String>> map;
  Map<String, List<Integer>> timestampListMap;

  public TimeBasedKeyValueStoreBinarySearch() {
    map = new HashMap<>();
    timestampListMap = new HashMap<>();
  }

  @Override
  public void set(String key, String value, int timestamp) {
    Map<Integer, String> timestampMap;
    List<Integer> timestampList;
    if(!map.containsKey(key)) {
      timestampMap = new HashMap<>();
      timestampList = new ArrayList<>();
    } else {
      timestampMap = map.get(key);
      timestampList = timestampListMap.get(key);
    }
    timestampMap.put(timestamp, value);
    timestampList.add(timestamp);
    map.put(key, timestampMap);
    timestampListMap.put(key, timestampList);
  }

  @Override
  public String get(String key, int timestamp) {
    if(!map.containsKey(key)) {
      return "";
    }

    Map<Integer, String> timestampMap = map.get(key);
    List<Integer> timestampList = timestampListMap.get(key);
    if(timestampMap.containsKey(timestamp)) {
      return timestampMap.get(timestamp);
    }

    int keyIndexFromBegin = 0;
    int keyIndexFromEnd = timestampList.size();
    int currentKeyIndex = -1;
    while(keyIndexFromBegin<keyIndexFromEnd) {
      int keyIndexMid = (keyIndexFromBegin + keyIndexFromEnd) / 2;
      if(timestampList.get(keyIndexMid) < timestamp) {
        currentKeyIndex = keyIndexMid;
        keyIndexFromBegin = keyIndexMid + 1;
      } else {
        keyIndexFromEnd = keyIndexMid;
      }
    }
    if(currentKeyIndex == -1) {
      return "";
    }
    return timestampMap.get(timestampList.get(currentKeyIndex));
  }
}
