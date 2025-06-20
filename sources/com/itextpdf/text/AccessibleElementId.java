package com.itextpdf.text;

import java.io.Serializable;

public class AccessibleElementId implements Comparable<AccessibleElementId>, Serializable {
    private static int X;
    private int s;

    public AccessibleElementId() {
        int i2 = X + 1;
        X = i2;
        this.s = i2;
    }

    /* renamed from: a */
    public int compareTo(AccessibleElementId accessibleElementId) {
        int i2 = this.s;
        int i3 = accessibleElementId.s;
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof AccessibleElementId) && this.s == ((AccessibleElementId) obj).s;
    }

    public int hashCode() {
        return this.s;
    }

    public String toString() {
        return Integer.toString(this.s);
    }
}
