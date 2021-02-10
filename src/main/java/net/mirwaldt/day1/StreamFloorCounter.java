package net.mirwaldt.day1;

public class StreamFloorCounter implements FloorCounter {
    @Override
    public int countFloors(String s) {
        return s.chars().map(aChar -> ((aChar=='(')?1:-1)).sum();
    }
}
