package org.apache.commons.lang3.mutable;

public class MutableFloat extends Number implements Comparable<MutableFloat>, Mutable<Number> {
    private static final long serialVersionUID = 5787169186L;
    private float value;

    public MutableFloat() {
    }

    public void add(float f2) {
        this.value += f2;
    }

    public void decrement() {
        this.value -= 1.0f;
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableFloat) && Float.floatToIntBits(((MutableFloat) obj).value) == Float.floatToIntBits(this.value);
    }

    public float floatValue() {
        return this.value;
    }

    public Float getValue() {
        return Float.valueOf(this.value);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    public void increment() {
        this.value += 1.0f;
    }

    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Float.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Float.isNaN(this.value);
    }

    public long longValue() {
        return (long) this.value;
    }

    public void setValue(float f2) {
        this.value = f2;
    }

    public void subtract(float f2) {
        this.value -= f2;
    }

    public Float toFloat() {
        return Float.valueOf(floatValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableFloat(float f2) {
        this.value = f2;
    }

    public void add(Number number) {
        this.value += number.floatValue();
    }

    public int compareTo(MutableFloat mutableFloat) {
        return Float.compare(this.value, mutableFloat.value);
    }

    public void setValue(Number number) {
        this.value = number.floatValue();
    }

    public void subtract(Number number) {
        this.value -= number.floatValue();
    }

    public MutableFloat(Number number) {
        this.value = number.floatValue();
    }

    public MutableFloat(String str) throws NumberFormatException {
        this.value = Float.parseFloat(str);
    }
}
