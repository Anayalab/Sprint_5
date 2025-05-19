package com.example.parameterized;

import com.example.Feline;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FelineKittensParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 0})
    public void testGetKittensWithDifferentParameters(int kittensCount) {
        Feline feline = new Feline();
        
        int actualKittens = feline.getKittens(kittensCount);
        
        assertEquals(kittensCount, actualKittens,
                "Метод getKittens должен возвращать точно то количество котят, которое передано в параметре");
    }
}