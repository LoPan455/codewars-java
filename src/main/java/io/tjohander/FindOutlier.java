package io.tjohander;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
  https://www.codewars.com/kata/find-the-parity-outlier/train/java
 */
public class FindOutlier {

    static int find(int[] integers) {
        int result;
        // counts the even numbers in the stream
        IntStream stream = Arrays.stream(integers).filter(value -> value % 2 == 0);
        // if the size of the filtered stream is 1, the even number is the outlier, otherwise the odd number is the outlier
        if (stream.count() == 1) {
            result = Arrays.stream(integers).filter(value -> value % 2 == 0).findFirst().getAsInt();
        } else {
            result = Arrays.stream(integers).filter(value -> value % 2 != 0).findFirst().getAsInt();
        }
        return result;
    }
}
