package com.slowin.ridingmeeting.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class RideMeet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hostId;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "content")
    private String content;

    @Embedded
    private RidingTime ridingTime;

    @Embedded
    private ParticipantsRange participantsRange;

    @Embedded
    private RidingRoute ridingRoute;

    private double distance;

    protected RideMeet() {
    }

    public RideMeet(Long hostId, String title, String content, RidingTime ridingTime,
        double distance, RidingRoute ridingRoute, ParticipantsRange participantsRange) {
        this.hostId = hostId;
        this.title = title;
        this.content = content;
        this.ridingTime = ridingTime;
        this.distance = distance;
        this.ridingRoute = ridingRoute;
        this.participantsRange = participantsRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RideMeet rideMeet = (RideMeet) o;
        return Objects.equals(id, rideMeet.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
