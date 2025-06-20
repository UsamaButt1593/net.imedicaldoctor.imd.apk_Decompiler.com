package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\"\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00028\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u00028\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0015"}, d2 = {"Lkotlin/ranges/UIntProgressionIterator;", "", "Lkotlin/UInt;", "first", "last", "", "step", "<init>", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "hasNext", "()Z", "a", "()I", "s", "I", "finalElement", "X", "Z", "Y", "next", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SinceKotlin(version = "1.3")
final class UIntProgressionIterator implements Iterator<UInt>, KMappedMarker {
    private boolean X;
    private final int Y;
    private int Z;
    private final int s;

    private UIntProgressionIterator(int i2, int i3, int i4) {
        this.s = i3;
        boolean z = false;
        int a2 = Integer.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
        if (i4 <= 0 ? a2 >= 0 : a2 <= 0) {
            z = true;
        }
        this.X = z;
        this.Y = UInt.i(i4);
        this.Z = !this.X ? i3 : i2;
    }

    public int a() {
        int i2 = this.Z;
        if (i2 != this.s) {
            this.Z = UInt.i(this.Y + i2);
        } else if (this.X) {
            this.X = false;
        } else {
            throw new NoSuchElementException();
        }
        return i2;
    }

    public boolean hasNext() {
        return this.X;
    }

    public /* bridge */ /* synthetic */ Object next() {
        return UInt.b(a());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ UIntProgressionIterator(int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, i4);
    }
}
