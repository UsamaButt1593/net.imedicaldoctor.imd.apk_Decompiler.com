package org.apache.commons.lang3.mutable;

public class MutableInt extends Number implements Comparable<MutableInt>, Mutable<Number> {
    private static final long serialVersionUID = 512176391864L;
    private int value;

    public MutableInt() {
    }

    public void add(int i2) {
        this.value += i2;
    }

    public void decrement() {
        this.value--;
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableInt) && this.value == ((MutableInt) obj).intValue();
    }

    public float floatValue() {
        return (float) this.value;
    }

    public Integer getValue() {
        return Integer.valueOf(this.value);
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value++;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public void setValue(int i2) {
        this.value = i2;
    }

    public void subtract(int i2) {
        this.value -= i2;
    }

    public Integer toInteger() {
        return Integer.valueOf(intValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableInt(int i2) {
        this.value = i2;
    }

    public void add(Number number) {
        this.value += number.intValue();
    }

    public int compareTo(MutableInt mutableInt) {
        int i2 = mutableInt.value;
        int i3 = this.value;
        if (i3 < i2) {
            return -1;
        }
        return i3 == i2 ? 0 : 1;
    }

    public void setValue(Number number) {
        this.value = number.intValue();
    }

    public void subtract(Number number) {
        this.value -= number.intValue();
    }

    public MutableInt(Number number) {
        this.value = number.intValue();
    }

    public MutableInt(String str) throws NumberFormatException {
        this.value = Integer.parseInt(str);
    }
}
