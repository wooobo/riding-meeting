package com.slowin.ridingmeeting.domain;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RidingTime {

    @Column(nullable = false)
    private LocalDateTime startTime;
    @Column(nullable = false)
    private LocalDateTime endTime;

    protected RidingTime() {
    }

    public RidingTime(LocalDateTime startTime, LocalDateTime endTime) {
        validTime(startTime, endTime);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private void validTime(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime.isAfter(endTime)) {
            throw new InvalidParameterException("시작시간보다 끝나는 시간이 이전 일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RidingTime that = (RidingTime) o;
        return Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
