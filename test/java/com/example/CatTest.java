package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Feline mockFeline = Mockito.mock(Feline.class);

    private final Cat cat = new Cat(mockFeline);

    @Test
    public void testGetSound_shouldReturnSound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood_shouldCallPredatorEatMeat(){
        try {
            cat.getFood();

            Mockito.verify(mockFeline, Mockito.times(1)).eatMeat();
        } catch (Exception e) {
            fail();
        }
    }
}
