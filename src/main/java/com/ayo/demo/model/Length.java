package com.ayo.demo.model;
import com.ayo.demo.utils.IConvert;
import org.apache.commons.math3.util.Precision;
public class Length implements IConvert {
    public double Value;
    public Length(){}
    public Length(double value) {
        this.Value = value;
    }

    public double getValue() {
        return Value;
    }
    public void setValue(double value) {
        this.Value = value;
    }
    public double convertToMetric() {
        return Precision.round(getValue() * 1.609, 2);
    }

    public double convertToImperial() {
        return Precision.round(getValue() / 1.609, 2);
    }
}
