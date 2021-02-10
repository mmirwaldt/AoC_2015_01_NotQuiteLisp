package net.mirwaldt.day1;

public class StreamFloorCounter implements FloorCounter {
    @Override
    public int countFloors(String input) {
        return input.chars().map(aChar -> ((aChar == '(') ? 1 : -1)).sum();
    }
}
