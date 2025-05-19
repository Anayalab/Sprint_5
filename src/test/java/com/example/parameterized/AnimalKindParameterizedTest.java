package com.example.parameterized;

import com.example.Animal;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AnimalKindParameterizedTest {

    static List<Arguments> animalKinds() {
        return List.of(
                Arguments.of("Травоядное", List.of("Трава", "Различные растения")),
                Arguments.of("Хищник", List.of("Животные", "Птицы", "Рыба")));
    }

    @ParameterizedTest
    @MethodSource("animalKinds")
    public void testGetFoodForAnimalKind(String animalKind, List<String> expectedFood) throws Exception {
        Animal animal = new Animal();
        List<String> actualFood = animal.getFood(animalKind);
        assertEquals(expectedFood, actualFood);
    }
}