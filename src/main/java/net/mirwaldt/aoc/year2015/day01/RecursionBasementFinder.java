package net.mirwaldt.aoc.year2015.day01;

public class RecursionBasementFinder implements BasementFinder {
    public static final int BASEMENT_FLOOR = -1;

    @Override
    public int findBasement(String input) {
        return findBasementRecursive(input, 0, 1);
    }

    private int findBasementRecursive(String input, int floor, int position) {
        if(floor == BASEMENT_FLOOR) {
            return position - 1;
        } else if(input.isEmpty()) {
            return -1;
        } else {
            if(input.charAt(0) == '(') {
                return findBasementRecursive(input.substring(1), floor + 1, position + 1);
            } else { // char == ')'
                return findBasementRecursive(input.substring(1), floor - 1, position + 1);
            }
        }
    }
}
