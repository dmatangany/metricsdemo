package com.ayo.demo.localtest;

import com.ayo.demo.model.Length;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LengthTest {

    @InjectMocks
    private Length lengthService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(LengthTest.class);
    }

    @Test
    public void testLengthMetricConversion() {
        lengthService.setValue(100);
        assertEquals(160.9, lengthService.convertToMetric());
    }

    @Test
    public void testLengthImperialConversion() {
        lengthService.setValue(160.9);
        assertEquals(100, lengthService.convertToImperial());
    }
}
