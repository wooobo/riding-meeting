package com.slowin.ridingmeeting.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParticipantsRange {

    @Column(name = "minPeople")
    private Integer minPeople;
    @Column(name = "maxPeople")
    private Integer maxPeople;

    protected ParticipantsRange() {
    }

    public ParticipantsRange(Integer minPeople, Integer maxPeople) {
        this.minPeople = minPeople;
        this.maxPeople = maxPeople;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParticipantsRange that = (ParticipantsRange) o;
        return Objects.equals(minPeople, that.minPeople) && Objects.equals(maxPeople,
            that.maxPeople);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
