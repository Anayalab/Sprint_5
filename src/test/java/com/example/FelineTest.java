package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        List<String> actual = feline.eatMeat();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String expected = "Кошачьи";

        String actual = feline.getFamily();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetKittensWithoutParameters() {
        Feline feline = new Feline();
        int expected = 1;

        int actual = feline.getKittens();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetKittensWithCustomParameter() {
        Feline feline = new Feline();
        int expected = 5;

        int actual = feline.getKittens(5);

        assertEquals(expected, actual);
    }
}