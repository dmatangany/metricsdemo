package com.ayo.demo.model;
import org.apache.commons.math3.util.Precision;
import com.ayo.demo.utils.IConvert;

public class Area implements IConvert{
    public double Value;
    public Area(){
        this.Value = 25;
    }
    public Area(double value) {
        this.Value = value;
    }

    public double getValue() {
        return Value;
    }
    public void setValue(double value) {
        this.Value = value;
    }

    public double convertToMetric() {
        Double val = Precision.round(getValue() / 2.471, 2);
        System.out.println("Metric-IN: " + getValue() + " OUT: " + val);
        return val;
    }
    public double convertToImperial() {
        Double val = Precision.round(getValue() * 2.471, 2);
        System.out.println("Imperial-IN: " + getValue() + " OUT: " + val);
        return val;
    }
}
