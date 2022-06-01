package com.slowin.ridingmeeting.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class RidingTimeTest {

    @Test
    void 시작시간_보다_종료시간_이전_실패() {
        LocalDateTime startDate = LocalDateTime.of(2021, 1, 2, 8, 30);
        LocalDateTime endDate = LocalDateTime.of(2020, 1, 2, 10, 30);

        assertThatExceptionOfType(InvalidParameterException.class)
            .isThrownBy(() -> new RidingTime(startDate, endDate));
    }
}
