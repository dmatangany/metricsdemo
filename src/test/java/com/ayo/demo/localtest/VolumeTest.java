package com.ayo.demo.localtest;

import com.ayo.demo.model.Volume;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class VolumeTest {

    @InjectMocks
    private Volume volumeService;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.openMocks(VolumeTest.class);
    }

    @Test
    public void testVolumeImperialConversion() {
        volumeService.setValue(45.46);
        assertEquals(10.0, volumeService.convertToImperial());
    }

    @Test
    public void testVolumeMetricConversion() {
        volumeService.setValue(10.0);
        assertEquals(45.46, volumeService.convertToMetric());
    }
}
