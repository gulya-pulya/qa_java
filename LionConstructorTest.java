package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Objects;

import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class LionConstructorTest {

    private final String sex;

    private final Boolean hasMane;

    Feline mockFeline = Mockito.mock(Feline.class);

    public LionConstructorTest(String sex, Boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void testLionConstructor() throws Exception {
        Lion lion = new Lion(mockFeline, sex);

        Assert.assertEquals(hasMane, lion.doesHaveMane());
    }
}
