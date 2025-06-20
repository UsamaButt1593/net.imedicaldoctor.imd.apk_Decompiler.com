package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class Count implements Serializable {
    private int s;

    Count(int i2) {
        this.s = i2;
    }

    public void a(int i2) {
        this.s += i2;
    }

    public int b(int i2) {
        int i3 = this.s + i2;
        this.s = i3;
        return i3;
    }

    public int c() {
        return this.s;
    }

    public int d(int i2) {
        int i3 = this.s;
        this.s = i2;
        return i3;
    }

    public void e(int i2) {
        this.s = i2;
    }

    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof Count) && ((Count) obj).s == this.s;
    }

    public int hashCode() {
        return this.s;
    }

    public String toString() {
        return Integer.toString(this.s);
    }
}
