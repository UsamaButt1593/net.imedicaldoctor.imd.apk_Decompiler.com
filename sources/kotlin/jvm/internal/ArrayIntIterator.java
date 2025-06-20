package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lkotlin/jvm/internal/ArrayIntIterator;", "Lkotlin/collections/IntIterator;", "", "array", "<init>", "([I)V", "", "hasNext", "()Z", "", "b", "()I", "s", "[I", "X", "I", "index", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class ArrayIntIterator extends IntIterator {
    private int X;
    @NotNull
    private final int[] s;

    public ArrayIntIterator(@NotNull int[] iArr) {
        Intrinsics.p(iArr, "array");
        this.s = iArr;
    }

    public int b() {
        try {
            int[] iArr = this.s;
            int i2 = this.X;
            this.X = i2 + 1;
            return iArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.X--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public boolean hasNext() {
        return this.X < this.s.length;
    }
}
