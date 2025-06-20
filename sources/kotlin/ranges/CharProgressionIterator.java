package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u0017"}, d2 = {"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", "", "first", "last", "", "step", "<init>", "(CCI)V", "", "hasNext", "()Z", "b", "()C", "s", "I", "c", "()I", "X", "finalElement", "Y", "Z", "next", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class CharProgressionIterator extends CharIterator {
    private final int X;
    private boolean Y;
    private int Z;
    private final int s;

    public CharProgressionIterator(char c2, char c3, int i2) {
        this.s = i2;
        this.X = c3;
        boolean z = false;
        if (i2 <= 0 ? Intrinsics.t(c2, c3) >= 0 : Intrinsics.t(c2, c3) <= 0) {
            z = true;
        }
        this.Y = z;
        this.Z = !z ? c3 : c2;
    }

    public char b() {
        int i2 = this.Z;
        if (i2 != this.X) {
            this.Z = this.s + i2;
        } else if (this.Y) {
            this.Y = false;
        } else {
            throw new NoSuchElementException();
        }
        return (char) i2;
    }

    public final int c() {
        return this.s;
    }

    public boolean hasNext() {
        return this.Y;
    }
}
