package com.ayo.demo.localtest;

import com.ayo.demo.model.Area;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AreaTest {

    @InjectMocks
    private Area areaService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(AreaTest.class);
    }

    @Test
    public void testAreaImperialConversion() {
        areaService.setValue(25);
        assertEquals(areaService.convertToImperial(), 61.78);
    }

    @Test
    public void testAreaMetricConversion() {
        areaService.setValue(25);
        assertEquals(areaService.convertToMetric(), 10.12);
    }
}
