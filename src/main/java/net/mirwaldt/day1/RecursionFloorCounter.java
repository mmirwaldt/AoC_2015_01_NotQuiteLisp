package net.mirwaldt.day1;

public class RecursionFloorCounter implements FloorCounter {
    @Override
    public int countFloors(String input) {
        return countFloorsRecursive(input, 0);
    }

    private int countFloorsRecursive(String input, int floor) {
        if(input.isEmpty()) {
            return floor;
        } else {
            if(input.charAt(0) == '(') {
                return countFloorsRecursive(input.substring(1), floor + 1);
            } else { // char == ')'
                return countFloorsRecursive(input.substring(1), floor - 1);
            }
        }
    }
}
