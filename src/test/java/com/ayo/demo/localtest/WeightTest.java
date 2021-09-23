package com.ayo.demo.localtest;

import com.ayo.demo.model.Weight;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class WeightTest {

    @InjectMocks
    private Weight weightService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(WeightTest.class);
    }

    @Test
    public void testWeightImperialConversion() {
        weightService.setValue(100);
        assertEquals(220.5, weightService.convertToImperial());
    }

    @Test
    public void testWeightMetricConversion() {
        weightService.setValue(220.5);
        assertEquals(100, weightService.convertToMetric());
    }

}
