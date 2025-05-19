package com.example.parameterized;

import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionSexParameterizedTest {

    @Mock
    Feline feline;

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void testHasMane(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}