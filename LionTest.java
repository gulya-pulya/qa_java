package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    Feline mockFeline = Mockito.mock(Feline.class);

    @Test
    public void testGetKittens_shouldCallFelineGetKittens() throws Exception{
        Lion lion = new Lion(mockFeline, "Самец");

        int expected = 1;

        Mockito.when(mockFeline.getKittens()).thenReturn(1);

        int actual = lion.getKittens();

        Assert.assertEquals(expected, actual);
        Mockito.verify(mockFeline, Mockito.times(1)).getKittens();
    }

    @Test
    public void testGetFood_shouldCallFelineGetFood() throws Exception{
        Lion lion = new Lion(mockFeline, "Самец");

        List<String> expected = List.of("Животные", "Птицы", "Рыба");;

        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(expected);

        List<String> actual = lion.getFood();

        Assert.assertEquals(expected, actual);
        Mockito.verify(mockFeline, Mockito.times(1)).getFood("Хищник");
    }
}
