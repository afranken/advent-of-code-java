package com.github.afranken.day01;

import java.util.List;
import java.util.Objects;

/**
 * This implements the answer to Day 2020/12/01
 * https://adventofcode.com/2020/day/1
 */
public class Day01 {

  static int NOT_FOUND = -1;
  static int ADDITION_RESULT = 2020;

  /**
   * Solution using Java 8+ API. Not sure if this is actually better or more readable.
   */
  static int compute(List<Integer> input) {
    return input
        .stream()
        .flatMap(a -> input.stream()
            .filter(b -> !Objects.equals(b, a) && a + b == 2020)
            .map(b -> a * b)
        )
        .findAny()
        .orElse(NOT_FOUND);
  }

  /**
   * Simplest solution by iterating across input twice and trying to multiply
   */
  static int computeSimple(List<Integer> input) {
    int result = NOT_FOUND;

    for (int i = 0; i < input.size(); i++) {
      int element1 = input.get(i);
      for (int j = 0; j < input.size(); j++) {
        if (i != j) {
          int element2 = input.get(j);
          int addResult = element1 + element2;
          if (ADDITION_RESULT == addResult) {
            return element1 * element2;
          }
        }
      }
    }
    return result;
  }
}
