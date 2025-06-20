package org.apache.commons.lang3.mutable;

import java.io.Serializable;

public class MutableBoolean implements Mutable<Boolean>, Serializable, Comparable<MutableBoolean> {
    private static final long serialVersionUID = -4830728138360036487L;
    private boolean value;

    public MutableBoolean() {
    }

    public boolean booleanValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableBoolean) && this.value == ((MutableBoolean) obj).booleanValue();
    }

    public Boolean getValue() {
        return Boolean.valueOf(this.value);
    }

    public int hashCode() {
        return (this.value ? Boolean.TRUE : Boolean.FALSE).hashCode();
    }

    public boolean isFalse() {
        return !this.value;
    }

    public boolean isTrue() {
        return this.value;
    }

    public void setFalse() {
        this.value = false;
    }

    public void setTrue() {
        this.value = true;
    }

    public void setValue(Boolean bool) {
        this.value = bool.booleanValue();
    }

    public Boolean toBoolean() {
        return Boolean.valueOf(booleanValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableBoolean(Boolean bool) {
        this.value = bool.booleanValue();
    }

    public int compareTo(MutableBoolean mutableBoolean) {
        boolean z = mutableBoolean.value;
        boolean z2 = this.value;
        if (z2 == z) {
            return 0;
        }
        return z2 ? 1 : -1;
    }

    public MutableBoolean(boolean z) {
        this.value = z;
    }

    public void setValue(boolean z) {
        this.value = z;
    }
}
