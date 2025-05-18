package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Feline felineMock;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(felineMock);
        String expected = "Мяу";

        String actual = cat.getSound();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(felineMock);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(felineMock.eatMeat()).thenReturn(expected);

        List<String> actual = cat.getFood();

        assertEquals(expected, actual);
        Mockito.verify(felineMock).eatMeat();
    }
}