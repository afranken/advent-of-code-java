package com.github.afranken.day01;

import java.util.HashMap;

/**
 * This implements the answer to Day 2020/12/01
 * https://adventofcode.com/2020/day/1
 */
class Day01 {

  static int NOT_FOUND = -1;

  /**
   * Implements Part1 of the Day1 puzzle.
   * This is an optimized twoSum with only one pass-through of the incoming Array/List, making
   * this a O(N) runtime while trading for memory
   */
  static int computePart1(Integer[] inputs, int target) {
    var lookupTable = new HashMap<Integer, Integer>();

    for (var i = 0; i < inputs.length; i++) {
      var input = inputs[i];
      var index = lookupTable.get(target - input);
      if (index != null) {
        return input * inputs[index];
      }
      lookupTable.put(input, i);
    }

    return NOT_FOUND;
  }

}
