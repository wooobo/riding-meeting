package com.slowin.ridingmeeting.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RidingRoute {

    @Column(name = "startingPoint")
    private String startingPoint;
    @Column(name = "destination")
    private String destination;

    protected RidingRoute() {
    }

    public RidingRoute(String startingPoint, String destination) {
        this.startingPoint = startingPoint;
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RidingRoute that = (RidingRoute) o;
        return Objects.equals(startingPoint, that.startingPoint) && Objects.equals(destination,
            that.destination);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
