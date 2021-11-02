package com.github.afranken.day01;

import java.util.List;
import java.util.Objects;

/**
 * This implements the answer to Day 2020/12/01
 * https://adventofcode.com/2020/day/1
 */
class Day01 {

  static int NOT_FOUND = -1;

  /**
   * Solution using Java 8+ API. Not sure if this is actually better or more readable.
   */
  static int compute(List<Integer> input) {
    return input
        .stream()
        .flatMap(a -> input.stream()
            .filter(b -> inputsSumCorrectly(a, b))
            .map(b -> a * b)
        )
        .findAny()
        .orElse(NOT_FOUND);
  }

  /**
   * Simplest solution by iterating across input twice and trying to multiply
   */
  static int computeSimple(List<Integer> input) {
    for (Integer element1 : input) {
      for (Integer element2 : input) {
        if (inputsSumCorrectly(element1, element2)) {
          return element1 * element2;
        }
      }
    }
    return NOT_FOUND;
  }

  private static boolean inputsSumCorrectly(Integer a, Integer b) {
    return !Objects.equals(b, a) && a + b == 2020;
  }
}
