package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class Flight {
    private final List<Segment> segments;
    private int id;

    Flight(final List<Segment> segs, int id) {
        segments = segs;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
