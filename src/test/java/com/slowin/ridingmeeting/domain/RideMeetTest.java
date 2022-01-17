package com.slowin.ridingmeeting.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class RideMeetTest {

    @Test
    void 라이딩모임_생성() {
        // given
        Long hostId = 1L;
        String title = "한강 라이딩 출발";
        String content = "토요일 빠르게 라이딩 진행합니다.";
        RidingTime ridingTime = new RidingTime(LocalDateTime.of(2021, 1, 2, 8, 30),
            LocalDateTime.of(2021, 1, 2, 10, 30));
        ParticipantsRange participantsRange = new ParticipantsRange(1, 10);
        RidingRoute ridingRoute = new RidingRoute("한강", "팔당댐");
        double distance = 15;

        // when
        RideMeet rideMeet = new RideMeet(hostId, title, content, ridingTime, distance, ridingRoute,
            participantsRange);

        // then
        assertThat(rideMeet).isNotNull();
    }

}
