package com.ayo.demo.localtest;

import com.ayo.demo.model.Temperature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TemperatureTest {

    @InjectMocks
    private Temperature temperatureService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(TemperatureTest.class);
    }

    @Test
    public  void testTemperatureMetricConversion() {
        temperatureService.setValue(100);
        assertEquals(37.78, temperatureService.convertToMetric());
    }

    @Test
    public  void testTemperatureImperialConversion() {
        temperatureService.setValue(37.78);
        assertEquals(100, temperatureService.convertToImperial());
    }
}
