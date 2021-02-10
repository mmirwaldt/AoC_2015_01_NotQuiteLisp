package net.mirwaldt.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasementFinderTest {
    private final static BasementFinder basementFinder = new LoopBasementFinder();

    private static Stream<Arguments> basementFinder() {
        return Stream.of(Arguments.of(basementFinder));
    }

    @ParameterizedTest
    @MethodSource("basementFinder")
    void test(BasementFinder basementFinder) {
        assertEquals(-1, basementFinder.findBasement(""));
        assertEquals(-1, basementFinder.findBasement("("));
        assertEquals(1, basementFinder.findBasement(")"));
        assertEquals(1, basementFinder.findBasement("))"));
        assertEquals(1, basementFinder.findBasement(")()"));
        assertEquals(3, basementFinder.findBasement("())"));
        assertEquals(5, basementFinder.findBasement("(()))"));
    }
}
