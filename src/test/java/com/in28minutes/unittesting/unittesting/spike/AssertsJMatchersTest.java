package com.in28minutes.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class AssertsJMatchersTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12,15,45);
          assertThat(numbers)
          	.hasSize(3)
          	.contains(12,15)
          	.allMatch(n -> n >10)
          	.allMatch(n -> n < 100)
          	.noneMatch(n -> n < 0);
          
          assertThat("").isEmpty();
          assertThat("ABCDE")
            .contains("BCD")
            .startsWith("ABC")
            .endsWith("CDE");
    }

}
