package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$4", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "()Z", "element", "c", "(J)Z", "", "index", "d", "(I)Ljava/lang/Long;", "g", "(J)I", "h", "b", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class ArraysKt___ArraysJvmKt$asList$4 extends AbstractList<Long> implements RandomAccess {
    final /* synthetic */ long[] X;

    ArraysKt___ArraysJvmKt$asList$4(long[] jArr) {
        this.X = jArr;
    }

    public int b() {
        return this.X.length;
    }

    public boolean c(long j2) {
        return ArraysKt.r8(this.X, j2);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Long)) {
            return false;
        }
        return c(((Number) obj).longValue());
    }

    @NotNull
    /* renamed from: d */
    public Long get(int i2) {
        return Long.valueOf(this.X[i2]);
    }

    public int g(long j2) {
        return ArraysKt.Hf(this.X, j2);
    }

    public int h(long j2) {
        return ArraysKt.Lh(this.X, j2);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        return g(((Number) obj).longValue());
    }

    public boolean isEmpty() {
        return this.X.length == 0;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        return h(((Number) obj).longValue());
    }
}
