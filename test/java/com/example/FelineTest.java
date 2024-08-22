package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private final Feline spyFeline = Mockito.spy(Feline.class);

    @Test
    public void testEatMeat_shouldReturnList() {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        try {
            List<String> actual = spyFeline.eatMeat();

            Assert.assertArrayEquals(expected.toArray(), actual.toArray());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testGetFamily_shouldReturnFamily() {
        String expected = "Кошачьи";

        String actual = spyFeline.getFamily();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetKittens_shouldReturnOneKitten_ifCallWithoutArgument() {
        int expected = 1;

        int actual = spyFeline.getKittens();

        Mockito.verify(spyFeline, Mockito.times(1)).getKittens(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetKittens_shouldReturnMatchKittens_matchCountIntArgument() {
        int expected = 10;

        int actual = spyFeline.getKittens(expected);

        Assert.assertEquals(expected, actual);
    }
}
