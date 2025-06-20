package org.apache.commons.lang3.mutable;

public class MutableLong extends Number implements Comparable<MutableLong>, Mutable<Number> {
    private static final long serialVersionUID = 62986528375L;
    private long value;

    public MutableLong() {
    }

    public void add(long j2) {
        this.value += j2;
    }

    public void decrement() {
        this.value--;
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableLong) && this.value == ((MutableLong) obj).longValue();
    }

    public float floatValue() {
        return (float) this.value;
    }

    public Long getValue() {
        return Long.valueOf(this.value);
    }

    public int hashCode() {
        long j2 = this.value;
        return (int) (j2 ^ (j2 >>> 32));
    }

    public void increment() {
        this.value++;
    }

    public int intValue() {
        return (int) this.value;
    }

    public long longValue() {
        return this.value;
    }

    public void setValue(long j2) {
        this.value = j2;
    }

    public void subtract(long j2) {
        this.value -= j2;
    }

    public Long toLong() {
        return Long.valueOf(longValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableLong(long j2) {
        this.value = j2;
    }

    public void add(Number number) {
        this.value += number.longValue();
    }

    public int compareTo(MutableLong mutableLong) {
        long j2 = mutableLong.value;
        long j3 = this.value;
        if (j3 < j2) {
            return -1;
        }
        return j3 == j2 ? 0 : 1;
    }

    public void setValue(Number number) {
        this.value = number.longValue();
    }

    public void subtract(Number number) {
        this.value -= number.longValue();
    }

    public MutableLong(Number number) {
        this.value = number.longValue();
    }

    public MutableLong(String str) throws NumberFormatException {
        this.value = Long.parseLong(str);
    }
}
