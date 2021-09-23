package com.ayo.demo.model;
import com.ayo.demo.utils.IConvert;
import org.apache.commons.math3.util.Precision;
public class Temperature implements IConvert {
    public double Value;
    public Temperature(){}
    public Temperature(double value) {
        this.Value = value;
    }

    public double getValue() {
        return Value;
    }
    public void setValue(double value) {
        this.Value = value;
    }
	public double convertToImperial() {
        return Precision.round((getValue() * 1.8) + 32, 2);
    }
	
   public double convertToMetric() {
        return Precision.round((getValue() - 32) / 1.8, 2);
    }
}

