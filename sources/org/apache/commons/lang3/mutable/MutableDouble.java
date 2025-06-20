package org.apache.commons.lang3.mutable;

public class MutableDouble extends Number implements Comparable<MutableDouble>, Mutable<Number> {
    private static final long serialVersionUID = 1587163916;
    private double value;

    public MutableDouble() {
    }

    public void add(double d2) {
        this.value += d2;
    }

    public void decrement() {
        this.value -= 1.0d;
    }

    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableDouble) && Double.doubleToLongBits(((MutableDouble) obj).value) == Double.doubleToLongBits(this.value);
    }

    public float floatValue() {
        return (float) this.value;
    }

    public Double getValue() {
        return Double.valueOf(this.value);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.value);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public void increment() {
        this.value += 1.0d;
    }

    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Double.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Double.isNaN(this.value);
    }

    public long longValue() {
        return (long) this.value;
    }

    public void setValue(double d2) {
        this.value = d2;
    }

    public void subtract(double d2) {
        this.value -= d2;
    }

    public Double toDouble() {
        return Double.valueOf(doubleValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableDouble(double d2) {
        this.value = d2;
    }

    public void add(Number number) {
        this.value += number.doubleValue();
    }

    public int compareTo(MutableDouble mutableDouble) {
        return Double.compare(this.value, mutableDouble.value);
    }

    public void setValue(Number number) {
        this.value = number.doubleValue();
    }

    public void subtract(Number number) {
        this.value -= number.doubleValue();
    }

    public MutableDouble(Number number) {
        this.value = number.doubleValue();
    }

    public MutableDouble(String str) throws NumberFormatException {
        this.value = Double.parseDouble(str);
    }
}
