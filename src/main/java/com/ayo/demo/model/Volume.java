package com.ayo.demo.model;
import com.ayo.demo.utils.IConvert;
import org.apache.commons.math3.util.Precision;
public class Volume  implements IConvert {
    public double Value;
    public Volume(){}
    public Volume(double value) {
        this.Value = value;
    }

    public double getValue() {
        return Value;
    }
    public void setValue(double value) {
        this.Value = value;
    }
    public double convertToMetric() {
        return Precision.round(getValue() * 4.546, 2);
    }

    public double convertToImperial() {
        return Precision.round(getValue() / 4.546, 2);
    }
}
