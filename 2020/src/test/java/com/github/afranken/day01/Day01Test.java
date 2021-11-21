package com.github.afranken.day01;

import static com.github.afranken.day01.Day01.NOT_FOUND;
import static com.github.afranken.day01.Day01.computePart1;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Day01Test {

  private static final List<Integer> AOC_INPUT = List.of(1721, 979, 366, 299, 675, 1456);
  private static final Integer AOC_RESULT = 514579;
  private static final int TARGET = 2020;

  @Test
  void testComputePart1OnRealInput() throws URISyntaxException, IOException {
    var result = computePart1(getInput(), TARGET);
    assertThat(result).isNotEqualTo(NOT_FOUND);
    assertThat(result).isEqualTo(788739); // correct result.
  }

  @Test
  void testComputePart1Success() {
    var result = computePart1(AOC_INPUT.toArray(Integer[]::new), TARGET);
    assertThat(result).isEqualTo(AOC_RESULT);
  }

  @Test
  void testComputePart1NotFound() {
    var result = computePart1(List.of(0, 1).toArray(Integer[]::new), TARGET);
    assertThat(result).isEqualTo(NOT_FOUND);
  }

  Integer[] getInput() throws URISyntaxException, IOException {
    var input = Day01Test.class.getClassLoader().getResource("com/github/afranken/day01/input.txt");
    var lines = Files
        .lines(Path.of(input.toURI()))
        .map(Integer::valueOf);
    return lines.toArray(Integer[]::new);
  }

}
