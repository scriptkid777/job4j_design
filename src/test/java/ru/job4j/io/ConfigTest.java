package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    public void whenOneLineEmpty() {
        String path = "./data/empty_oneLine_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Key")).isEqualTo("Value");
    }


    @Test
    public void whenBrokenPatternThenException() {
        String path = "./data/broken_pattern_without_comment.properties";
        Config config = new Config(path);
        config.load();
    }
}

