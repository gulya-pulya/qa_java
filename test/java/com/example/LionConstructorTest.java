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

    private final Exception exception;

    Feline mockFeline = Mockito.mock(Feline.class);

    public LionConstructorTest(String sex, Boolean hasMane, Exception exception) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.exception = exception;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самец", true, null},
                {"Самка", false, null},
                {"test", null, new Exception("Используйте допустимые значения пола животного - самец или самка")}
        };
    }

    @Test
    public void testLionConstructor() {
        if (Objects.isNull(exception)) {
            try {
                Lion lion = new Lion(mockFeline, sex);
                Assert.assertEquals(hasMane, lion.doesHaveMane());
            } catch (Exception e) {
                fail();
            }
        } else {
            try {
                new Lion(mockFeline, sex);
                fail();
            } catch (Exception e) {
                Assert.assertEquals(exception.getMessage(), e.getMessage());
            }
        }
    }
}
