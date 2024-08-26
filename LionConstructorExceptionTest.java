package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionConstructorExceptionTest {

    Feline mockFeline = Mockito.mock(Feline.class);

    @Test(expected = Exception.class)
    public void testLionConstructor_shouldThrowException_ifSexTypeInvalid() throws Exception {
        new Lion(mockFeline, "test");
    }
}
