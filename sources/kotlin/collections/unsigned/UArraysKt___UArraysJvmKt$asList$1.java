package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0014"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$1", "Lkotlin/collections/AbstractList;", "Lkotlin/UInt;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "()Z", "element", "c", "(I)Z", "", "index", "d", "(I)I", "g", "h", "b", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class UArraysKt___UArraysJvmKt$asList$1 extends AbstractList<UInt> implements RandomAccess {
    final /* synthetic */ int[] X;

    UArraysKt___UArraysJvmKt$asList$1(int[] iArr) {
        this.X = iArr;
    }

    public int b() {
        return UIntArray.r(this.X);
    }

    public boolean c(int i2) {
        return UIntArray.j(this.X, i2);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UInt)) {
            return false;
        }
        return c(((UInt) obj).v0());
    }

    public int d(int i2) {
        return UIntArray.o(this.X, i2);
    }

    public int g(int i2) {
        return ArraysKt.Gf(this.X, i2);
    }

    public /* bridge */ /* synthetic */ Object get(int i2) {
        return UInt.b(d(i2));
    }

    public int h(int i2) {
        return ArraysKt.Kh(this.X, i2);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof UInt)) {
            return -1;
        }
        return g(((UInt) obj).v0());
    }

    public boolean isEmpty() {
        return UIntArray.B(this.X);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof UInt)) {
            return -1;
        }
        return h(((UInt) obj).v0());
    }
}
