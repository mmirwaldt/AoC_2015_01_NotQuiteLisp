package net.mirwaldt.aoc.year2015.day01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FloorCounterMain {
    public static void main(String[] args) throws IOException {
        String content = Files.readString(Path.of("input.txt"), StandardCharsets.US_ASCII);
        FloorCounter floorCounter = new StreamFloorCounter();
        System.out.println(floorCounter.countFloors(content)); // result: 280
    }
}
