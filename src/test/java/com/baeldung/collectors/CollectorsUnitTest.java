package com.baeldung.collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.*;

/**
 * Unit tests for collectors additions in Java 12.
 */
public class CollectorsUnitTest {

    @Test
    public void whenTeeing_ItShouldCombineTheResultsAsExpected() {
        List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
        Range range = numbers.stream()
                .collect(teeing(minBy(Integer::compareTo), maxBy(Integer::compareTo), (min, max) -> new Range(min.orElse(null), max.orElse(null))));

        Assertions.assertEquals(new Range(2, 42), range);
//        assertThat(range).isEqualTo(new Range(2, 42));  //Assertj not working
    }

    /**
         * Represents a closed range of numbers between {@link #min} and
         * {@link #max}, both inclusive.
         */
        private record Range(Integer min, Integer max) {

        @Override
            public boolean equals(Object o) {
                if (this == o)
                    return true;
                if (o == null || getClass() != o.getClass())
                    return false;
                Range range = (Range) o;
                return Objects.equals(min(), range.min()) && Objects.equals(max(), range.max());
            }

            @Override
            public int hashCode() {
                return Objects.hash(min(), max());
            }

            @Override
            public String toString() {
                return "Range{" + "min=" + min + ", max=" + max + '}';
            }
        }
}
