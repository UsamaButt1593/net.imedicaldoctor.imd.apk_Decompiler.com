package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n205#1:209\n205#1:210\n205#1:211\n1#2:208\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n106#1:209\n176#1:210\n189#1:211\n*E\n"})
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\n\u0010\rJ\u001c\u0010\u000f\u001a\u00020\b*\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0014¢\u0006\u0004\b\u001b\u0010\u001dJ\u001b\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00028\u0000¢\u0006\u0004\b#\u0010$J\u0015\u0010\u000e\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\rR\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\f\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010(R$\u0010/\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b8\u0016@RX\u000e¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "", "buffer", "", "filledSize", "<init>", "([Ljava/lang/Object;I)V", "capacity", "(I)V", "n", "k", "(II)I", "index", "get", "(I)Ljava/lang/Object;", "", "m", "()Z", "", "iterator", "()Ljava/util/Iterator;", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "maxCapacity", "j", "(I)Lkotlin/collections/RingBuffer;", "element", "", "h", "(Ljava/lang/Object;)V", "X", "[Ljava/lang/Object;", "Y", "I", "Z", "startIndex", "<set-?>", "X2", "b", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    /* access modifiers changed from: private */
    @NotNull
    public final Object[] X;
    private int X2;
    /* access modifiers changed from: private */
    public final int Y;
    /* access modifiers changed from: private */
    public int Z;

    public RingBuffer(int i2) {
        this(new Object[i2], 0);
    }

    private final int k(int i2, int i3) {
        return (i2 + i3) % this.Y;
    }

    public int b() {
        return this.X2;
    }

    public T get(int i2) {
        AbstractList.s.b(i2, size());
        return this.X[(this.Z + i2) % this.Y];
    }

    public final void h(T t) {
        if (!m()) {
            this.X[(this.Z + size()) % this.Y] = t;
            this.X2 = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    @NotNull
    public Iterator<T> iterator() {
        return new RingBuffer$iterator$1(this);
    }

    @NotNull
    public final RingBuffer<T> j(int i2) {
        Object[] objArr;
        int i3 = this.Y;
        int B = RangesKt.B(i3 + (i3 >> 1) + 1, i2);
        if (this.Z == 0) {
            objArr = Arrays.copyOf(this.X, B);
            Intrinsics.o(objArr, "copyOf(this, newSize)");
        } else {
            objArr = toArray(new Object[B]);
        }
        return new RingBuffer<>(objArr, size());
    }

    public final boolean m() {
        return size() == this.Y;
    }

    public final void n(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i2).toString());
        } else if (i2 > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i2 + ", size = " + size()).toString());
        } else if (i2 > 0) {
            int i3 = this.Z;
            int d2 = (i3 + i2) % this.Y;
            Object[] objArr = this.X;
            if (i3 > d2) {
                ArraysKt.M1(objArr, null, i3, this.Y);
                ArraysKt.M1(this.X, null, 0, d2);
            } else {
                ArraysKt.M1(objArr, null, i3, d2);
            }
            this.Z = d2;
            this.X2 = size() - i2;
        }
    }

    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public RingBuffer(@NotNull Object[] objArr, int i2) {
        Intrinsics.p(objArr, "buffer");
        this.X = objArr;
        if (i2 < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i2).toString());
        } else if (i2 <= objArr.length) {
            this.Y = objArr.length;
            this.X2 = i2;
        } else {
            throw new IllegalArgumentException(("ring buffer filled size: " + i2 + " cannot be larger than the buffer size: " + objArr.length).toString());
        }
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        Intrinsics.p(tArr, "array");
        if (tArr.length < size()) {
            tArr = Arrays.copyOf(tArr, size());
            Intrinsics.o(tArr, "copyOf(this, newSize)");
        }
        int size = size();
        int i2 = this.Z;
        int i3 = 0;
        int i4 = 0;
        while (i4 < size && i2 < this.Y) {
            tArr[i4] = this.X[i2];
            i4++;
            i2++;
        }
        while (i4 < size) {
            tArr[i4] = this.X[i3];
            i4++;
            i3++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }
}
