package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnimalTest {

    @Test
    public void testGetFoodThrowsExceptionForUnknownAnimal() {
        Animal animal = new Animal();

        Exception exception = assertThrows(Exception.class, () ->
                animal.getFood("Неизвестное животное"));

        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        String actual = animal.getFamily();

        assertEquals(expected, actual);
    }
}