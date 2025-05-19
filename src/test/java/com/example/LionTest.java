package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    Feline felineMock;

    @Test
    public void testLionConstructorMale() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionConstructorFemale() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testLionConstructorInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестный", felineMock);
        });

        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", felineMock);

        when(felineMock.getKittens()).thenReturn(3);

        assertEquals(3, lion.getKittens());

        Mockito.verify(felineMock).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самка", felineMock);

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);

        Mockito.verify(felineMock).getFood("Хищник");
    }
}