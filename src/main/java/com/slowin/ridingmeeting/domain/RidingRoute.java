package com.slowin.ridingmeeting.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RidingRoute {

    @Column(name = "start_point")
    private String startPoint;
    @Column(name = "destination")
    private String destination;

    protected RidingRoute() {
    }

    public RidingRoute(String startingPoint, String destination) {
        this.startPoint = startingPoint;
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
        return Objects.equals(startPoint, that.startPoint) && Objects.equals(destination,
            that.destination);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
