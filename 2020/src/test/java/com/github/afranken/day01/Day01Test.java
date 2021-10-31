package com.github.afranken.day01;

import static com.github.afranken.day01.Day01.NOT_FOUND;
import static com.github.afranken.day01.Day01.compute;
import static com.github.afranken.day01.Day01.computeSimple;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Day01Test {

  private static final List<Integer> AOC_INPUT = List.of(1721, 979, 366, 299, 675, 1456);
  private static final Integer AOC_RESULT = 514579;

  @Test
  void testComputeOnRealInput() throws URISyntaxException, IOException {
    int result = compute(getInput().collect(Collectors.toList()));
    assertThat(result).isNotEqualTo(NOT_FOUND);
    assertThat(result).isEqualTo(788739); // correct result.
  }

  @Test
  void testComputeSuccess() {
    int result = compute(AOC_INPUT);
    assertThat(result).isEqualTo(AOC_RESULT);
  }

  @Test
  void testComputeNotFound() {
    int result = compute(List.of(0, 1));
    assertThat(result).isEqualTo(NOT_FOUND);
  }

  @Test
  void testComputeSimpleSuccess() {
    int result = computeSimple(AOC_INPUT);
    assertThat(result).isEqualTo(AOC_RESULT);
  }

  @Test
  void testComputeSimpleNotFound() {
    int result = computeSimple(List.of(0, 1));
    assertThat(result).isEqualTo(NOT_FOUND);
  }

  Stream<Integer> getInput() throws URISyntaxException, IOException {
    Stream<Integer> lines =
        Files.lines(Path.of(Day01Test.class.getClassLoader().getResource("com/github/afranken/day01/input.txt").toURI())).map(
            Integer::valueOf);
    return lines;
  }

}
