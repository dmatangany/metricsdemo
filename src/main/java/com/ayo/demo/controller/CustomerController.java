package com.ayo.demo.controller;

import com.ayo.demo.model.*;
import com.ayo.demo.utils.IConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
/**
 * Created by hendisantika on 4/24/17.
 */

@RestController
@RequestMapping(value = "/ayo")
public class CustomerController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Enum<HttpStatus> httpStatus = HttpStatus.OK;

    @RequestMapping(value = "/{measurement}/{toSystem}/{value}",
            method = RequestMethod.GET,
            produces = {
                    APPLICATION_JSON_VALUE,
            })
    public ResponseEntity<String> convert(@PathVariable final String measurement, @PathVariable final String toSystem, @PathVariable final Double value) {
        String result = "";
        System.out.println("measure: " + measurement + " to: " + toSystem + " val: " + value);
        if(measurement.toLowerCase().equals("area")){
            result = convert(new Area(value), toSystem);
        }
        if(measurement.toLowerCase().equals("length")){
            result = convert(new Length(value), toSystem);
        }
        if(measurement.toLowerCase().equals("temperature")){
            result = convert(new Temperature(value), toSystem);
        }
        if(measurement.toLowerCase().equals("volume")){
            result = convert(new Volume(value), toSystem);
        }
        if(measurement.toLowerCase().equals("weight")){
            result = convert(new Weight(value), toSystem);
        }
        System.out.println("Output: " + result);
        ResponseEntity<String> xx = new ResponseEntity<>(result, HttpStatus.OK);
        return xx;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> testController() {
        return new ResponseEntity<String>("Individual Customer Controller up and running!!!!", HttpStatus.OK);
    }

    private String convert(IConvert convert, String toSystem){
            String result = "";
            if(toSystem.toLowerCase().equals("imperial")){
                result = Double.toString(convert.convertToImperial());
            }
            if(toSystem.toLowerCase().equals("metric")){
                result = Double.toString(convert.convertToMetric());
            }
        return result;
    }
}
