package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlexLionTest {

    private AlexLion alexLion;

    @Mock
    Feline felineMock;

    @BeforeEach
    public void setup() throws Exception {
        alexLion = new AlexLion(felineMock);
    }

    @Test
    public void testAlexLionIsAlwaysMale() {
        assertTrue(alexLion.doesHaveMane());
    }

    @Test
    public void testGetKittensReturnsZero() {
        assertEquals(0, alexLion.getKittens());
    }

    @Test
    public void testGetFriends() {
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        List<String> actual = alexLion.getFriends();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPlaceOfLiving() {
        String expected = "Нью-Йоркский зоопарк";
        String actual = alexLion.getPlaceOfLiving();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = alexLion.getFood();
        assertEquals(expectedFood, actualFood);

        verify(felineMock).getFood("Хищник");
    }
}