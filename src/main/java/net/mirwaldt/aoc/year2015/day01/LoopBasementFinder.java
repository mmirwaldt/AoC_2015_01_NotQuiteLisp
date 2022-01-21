package net.mirwaldt.aoc.year2015.day01;

public class LoopBasementFinder implements  BasementFinder {
    public static final int BASEMENT_FLOOR = -1;

    @Override
    public int findBasement(String input) {
        int position = 1;
        int floor = 0;
        final char[] charArray = input.toCharArray();
        boolean wasFound = false;
        for (; position <= input.length(); position++) {
            final char currentChar = charArray[position - 1];
            if(currentChar == '(') {
                floor++;
            } else if(currentChar == ')'){
                floor--;
            } else {
                throw new AssertionError("Unknown char '" + currentChar + "'");
            }
            if(floor == BASEMENT_FLOOR) {
                wasFound = true;
                break;
            }
        }
        return (wasFound) ? position : -1;
    }
}
