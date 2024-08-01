package ru.job4j;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void isFizz() {
        assertThat(Fool.checkValue(9)).isEqualTo("Fizz");
        assertThat(Fool.checkValue(27)).isEqualTo("Fizz");
    }

    @Test
    void isBuzz() {
        assertThat(Fool.checkValue(10)).isEqualTo("Buzz");
        assertThat(Fool.checkValue(55)).isEqualTo("Buzz");
    }

    @Test
    void isFizzBuzz() {
        assertThat(Fool.checkValue(15)).isEqualTo("FizzBuzz");
        assertThat(Fool.checkValue(75)).isEqualTo("FizzBuzz");
    }

    @Test
    void isJustNumber() {
        assertThat(Fool.checkValue(4)).isEqualTo("4");
        assertThat(Fool.checkValue(52)).isEqualTo("52");
    }
}