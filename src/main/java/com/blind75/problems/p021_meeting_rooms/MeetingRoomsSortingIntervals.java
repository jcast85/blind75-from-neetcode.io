package com.blind75.problems.p021_meeting_rooms;

import com.blind75.problems.common.Interval;

import java.util.Comparator;
import java.util.List;

public class MeetingRoomsSortingIntervals implements MeetingRooms {
  @Override
  public boolean canAttendMeetings(List<Interval> intervals) {
    List<Interval> sortedIntervals = intervals.stream().sorted(comparator).toList();
    for (int i=0; i<sortedIntervals.size()-1; i++) {
      if(sortedIntervals.get(i+1).start < sortedIntervals.get(i).end) {
        return false;
      }
    }
    return true;
  }

  private final java.util.Comparator<Interval> comparator = Comparator.comparingInt(interval -> interval.start);
}
