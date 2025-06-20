package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\"\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00028\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u00028\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0015"}, d2 = {"Lkotlin/ranges/ULongProgressionIterator;", "", "Lkotlin/ULong;", "first", "last", "", "step", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "hasNext", "()Z", "a", "()J", "s", "J", "finalElement", "X", "Z", "Y", "next", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SinceKotlin(version = "1.3")
final class ULongProgressionIterator implements Iterator<ULong>, KMappedMarker {
    private boolean X;
    private final long Y;
    private long Z;
    private final long s;

    private ULongProgressionIterator(long j2, long j3, long j4) {
        this.s = j3;
        boolean z = false;
        int i2 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        int a2 = Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE);
        if (i2 <= 0 ? a2 >= 0 : a2 <= 0) {
            z = true;
        }
        this.X = z;
        this.Y = ULong.i(j4);
        this.Z = !this.X ? j3 : j2;
    }

    public long a() {
        long j2 = this.Z;
        if (j2 != this.s) {
            this.Z = ULong.i(this.Y + j2);
        } else if (this.X) {
            this.X = false;
        } else {
            throw new NoSuchElementException();
        }
        return j2;
    }

    public boolean hasNext() {
        return this.X;
    }

    public /* bridge */ /* synthetic */ Object next() {
        return ULong.b(a());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ ULongProgressionIterator(long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, j3, j4);
    }
}
