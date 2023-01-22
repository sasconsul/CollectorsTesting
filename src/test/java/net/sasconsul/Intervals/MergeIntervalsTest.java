package net.sasconsul.Intervals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeIntervalsTest {

    @ParameterizedTest
    @MethodSource("net.sasconsul.Intervals.IntervalDataProvider#zipDataProvider")
    public void testMerge(ArrayList<Interval> input, ArrayList<Interval> expected, String label) {
        ArrayList<Interval> results = MergeIntervals.merge(input);
        assertEquals(results, expected, label);
    }

   @ParameterizedTest
   @MethodSource("net.sasconsul.Intervals.IntervalDataProvider#largeZipDataProvider")
    public void testLargeUnitTest(ArrayList<Interval> input, ArrayList<Interval> expected, String label) {
        ArrayList<Interval> results = MergeIntervals.merge(input);
        assertEquals(results, expected, label);
    }

    @ParameterizedTest
    @MethodSource("net.sasconsul.Intervals.IntervalDataProvider#largeMergingZipDataProvider")
    public void testLargeMergeUnitTest(ArrayList<Interval> input, ArrayList<Interval> expected, String label) {
        ArrayList<Interval> results = MergeIntervals.merge(input);
        assertEquals(results, expected, label);
    }
    @ParameterizedTest
    @MethodSource("net.sasconsul.Intervals.IntervalDataProvider#largePathologicalZipDataProvider")
    public void testLargePathologicalUnitTest(ArrayList<Interval> input, ArrayList<Interval> expected, String label) {
        ArrayList<Interval> results = MergeIntervals.merge(input);
        assertEquals(results, expected, label);
    }


    @ParameterizedTest
    @MethodSource("net.sasconsul.Intervals.IntervalDataProvider#hugeZipDataProvider")
    public void hugeLargeMerge(ArrayList<Interval> input, ArrayList<Interval> expected, String label) {
        ArrayList<Interval> results = MergeIntervals.merge(input);
        assertEquals(results, expected, label);
    }
}
