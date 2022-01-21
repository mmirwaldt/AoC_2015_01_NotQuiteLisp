package net.mirwaldt.aoc.year2015.day01;

public class StreamFloorCounter implements FloorCounter {
    @Override
    public int countFloors(String input) {
        return input.chars().map(aChar -> ((aChar == '(') ? 1 : -1)).sum();
    }
}
