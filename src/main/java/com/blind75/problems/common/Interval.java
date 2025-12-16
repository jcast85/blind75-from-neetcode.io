package com.blind75.problems.common;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@Builder
@EqualsAndHashCode
public class Interval {
  public int start, end;
  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
