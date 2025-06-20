package org.apache.commons.lang3.mutable;

public class MutableByte extends Number implements Comparable<MutableByte>, Mutable<Number> {
    private static final long serialVersionUID = -1585823265;
    private byte value;

    public MutableByte() {
    }

    public void add(byte b2) {
        this.value = (byte) (this.value + b2);
    }

    public byte byteValue() {
        return this.value;
    }

    public void decrement() {
        this.value = (byte) (this.value - 1);
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableByte) && this.value == ((MutableByte) obj).byteValue();
    }

    public float floatValue() {
        return (float) this.value;
    }

    public Byte getValue() {
        return Byte.valueOf(this.value);
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = (byte) (this.value + 1);
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public void setValue(byte b2) {
        this.value = b2;
    }

    public void subtract(byte b2) {
        this.value = (byte) (this.value - b2);
    }

    public Byte toByte() {
        return Byte.valueOf(byteValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableByte(byte b2) {
        this.value = b2;
    }

    public void add(Number number) {
        this.value = (byte) (this.value + number.byteValue());
    }

    public int compareTo(MutableByte mutableByte) {
        byte b2 = mutableByte.value;
        byte b3 = this.value;
        if (b3 < b2) {
            return -1;
        }
        return b3 == b2 ? 0 : 1;
    }

    public void setValue(Number number) {
        this.value = number.byteValue();
    }

    public void subtract(Number number) {
        this.value = (byte) (this.value - number.byteValue());
    }

    public MutableByte(Number number) {
        this.value = number.byteValue();
    }

    public MutableByte(String str) throws NumberFormatException {
        this.value = Byte.parseByte(str);
    }
}
