package com.ayo.demo.webtest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {
        HttpEntity<String> httpEntity = new HttpEntity<>(null, new HttpHeaders());
		private final TestRestTemplate conversionRestTemplate = new TestRestTemplate();;

    @LocalServerPort
    private int port;


    @Test
    public void testWebTemperatureMetricConversion() {
        double inputValue = 100.0;
        double outputValue = 37.78;
        ResponseEntity<String> responseEntity = conversionRestTemplate.exchange(getFullURL("/temperature/metric/" + inputValue),
                HttpMethod.GET,
                httpEntity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(outputValue), responseEntity.getBody());
    }

    @Test
    public void testWebTemperatureImperialConversion() {
        double inputValue = 37.78;
        double outputValue = 100.0;
        ResponseEntity<String> responseEntity = conversionRestTemplate.exchange(getFullURL("/temperature/imperial/" + inputValue),
                HttpMethod.GET,
                httpEntity,
                String.class);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertEquals(String.valueOf(outputValue), responseEntity.getBody());
    }

    private String getFullURL(final String uri) {
        return "http://localhost:" + port + "/ayo" + uri;
    }
}
