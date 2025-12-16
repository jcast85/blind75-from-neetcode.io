package com.blind75.problems.p021_meeting_rooms;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class MeetingRoomsTest {

  private static final List<MeetingRooms> meetingRoomsList = List.of(
    new MeetingRoomsSortingIntervals()
  );

  private static final List<InputAndOutput> meetingRoomsInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(List.of(
        Interval.builder()
          .start(0)
          .end(30)
          .build(),
        Interval.builder()
          .start(5)
          .end(10)
          .build(),
        Interval.builder()
          .start(15)
          .end(20)
          .build()
      ))
      .output(false)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(List.of(
        Interval.builder()
          .start(5)
          .end(8)
          .build(),
        Interval.builder()
          .start(9)
          .end(15)
          .build()
      ))
      .output(true)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(List.of(
        Interval.builder()
          .start(1)
          .end(5)
          .build(),
        Interval.builder()
          .start(1)
          .end(3)
          .build()
      ))
      .output(false)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(List.of(
        Interval.builder()
          .start(5)
          .end(10)
          .build(),
        Interval.builder()
          .start(0)
          .end(4)
          .build()
      ))
      .output(true)
      .build()
  );

  static Stream<SingleMethodTestConfig<MeetingRooms>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<MeetingRooms>> streamBuilder = Stream.builder();
    for (MeetingRooms meetingRooms : meetingRoomsList) {
      for (InputAndOutput meetingRoomsInputAndOutput : meetingRoomsInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<MeetingRooms>()
          .implementationToTest(meetingRooms)
          .inputAndOutput(meetingRoomsInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<MeetingRooms> singleMethodTestConfig) {
    SingleInputAndOutput<List<Interval>, Boolean> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    boolean result = singleMethodTestConfig.implementationToTest().canAttendMeetings(inputAndOutput.input());
    org.hamcrest.MatcherAssert.assertThat(result, org.hamcrest.Matchers.equalTo(inputAndOutput.output()));
  }
}
