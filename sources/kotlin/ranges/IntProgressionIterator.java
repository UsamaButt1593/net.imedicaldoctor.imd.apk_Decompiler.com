package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000e¨\u0006\u0015"}, d2 = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "", "first", "last", "step", "<init>", "(III)V", "", "hasNext", "()Z", "b", "()I", "s", "I", "c", "X", "finalElement", "Y", "Z", "next", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class IntProgressionIterator extends IntIterator {
    private final int X;
    private boolean Y;
    private int Z;
    private final int s;

    public IntProgressionIterator(int i2, int i3, int i4) {
        this.s = i4;
        this.X = i3;
        boolean z = false;
        if (i4 <= 0 ? i2 >= i3 : i2 <= i3) {
            z = true;
        }
        this.Y = z;
        this.Z = !z ? i3 : i2;
    }

    public int b() {
        int i2 = this.Z;
        if (i2 != this.X) {
            this.Z = this.s + i2;
        } else if (this.Y) {
            this.Y = false;
        } else {
            throw new NoSuchElementException();
        }
        return i2;
    }

    public final int c() {
        return this.s;
    }

    public boolean hasNext() {
        return this.Y;
    }
}
