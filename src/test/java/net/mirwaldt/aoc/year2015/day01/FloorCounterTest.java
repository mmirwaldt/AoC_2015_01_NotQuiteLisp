package net.mirwaldt.aoc.year2015.day01;

import net.mirwaldt.aoc.year2015.day01.FloorCounter;
import net.mirwaldt.aoc.year2015.day01.RecursionFloorCounter;
import net.mirwaldt.aoc.year2015.day01.StreamFloorCounter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloorCounterTest {
    private final static FloorCounter streamFloorCounter = new StreamFloorCounter();
    private final static FloorCounter recursionFloorCounter = new RecursionFloorCounter();

    private static Stream<Arguments> floorCounter() {
        return Stream.of(Arguments.of(streamFloorCounter),
                Arguments.of(recursionFloorCounter));
    }

    @ParameterizedTest
    @MethodSource("floorCounter")
    void test_groundFloor(FloorCounter floorCounter) {
        assertEquals(0, floorCounter.countFloors(""));
        assertEquals(0, floorCounter.countFloors("()"));
        assertEquals(0, floorCounter.countFloors("()()"));
        assertEquals(0, floorCounter.countFloors("(())"));
    }

    @ParameterizedTest
    @MethodSource("floorCounter")
    void test_firstFloorAboveGround(FloorCounter floorCounter) {
        assertEquals(1, floorCounter.countFloors("("));
        assertEquals(1, floorCounter.countFloors("(()"));
        assertEquals(1, floorCounter.countFloors("()("));
        assertEquals(1, floorCounter.countFloors("()(()"));
    }

    @ParameterizedTest
    @MethodSource("floorCounter")
    void test_firstFloorBelowGround(FloorCounter floorCounter) {
        assertEquals(-1, floorCounter.countFloors(")"));
        assertEquals(-1, floorCounter.countFloors("())"));
        assertEquals(-1, floorCounter.countFloors(")()"));
        assertEquals(-1, floorCounter.countFloors("())()"));
    }

    @ParameterizedTest
    @MethodSource("floorCounter")
    void test_secondFloorAboveGround(FloorCounter floorCounter) {
        assertEquals(2, floorCounter.countFloors("(("));
        assertEquals(2, floorCounter.countFloors("((()"));
        assertEquals(2, floorCounter.countFloors("()(("));
        assertEquals(2, floorCounter.countFloors("()((()"));
        assertEquals(2, floorCounter.countFloors("(()()("));
    }

    @ParameterizedTest
    @MethodSource("floorCounter")
    void test_secondFloorBelowGround(FloorCounter floorCounter) {
        assertEquals(-2, floorCounter.countFloors("))"));
        assertEquals(-2, floorCounter.countFloors("))()"));
        assertEquals(-2, floorCounter.countFloors("()))"));
        assertEquals(-2, floorCounter.countFloors("()))()"));
        assertEquals(-2, floorCounter.countFloors(")()())"));
    }

    @ParameterizedTest
    @MethodSource("floorCounter")
    void test_mixed(FloorCounter floorCounter) {
        assertEquals(3, floorCounter.countFloors("((("));
        assertEquals(3, floorCounter.countFloors("(()(()("));
        assertEquals(3, floorCounter.countFloors("))((((("));
        assertEquals(-3, floorCounter.countFloors(")())())"));
    }
}
