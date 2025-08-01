package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "()Z", "element", "c", "(I)Z", "index", "d", "(I)Ljava/lang/Integer;", "g", "(I)I", "h", "b", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class ArraysKt___ArraysJvmKt$asList$3 extends AbstractList<Integer> implements RandomAccess {
    final /* synthetic */ int[] X;

    ArraysKt___ArraysJvmKt$asList$3(int[] iArr) {
        this.X = iArr;
    }

    public int b() {
        return this.X.length;
    }

    public boolean c(int i2) {
        return ArraysKt.q8(this.X, i2);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Integer)) {
            return false;
        }
        return c(((Number) obj).intValue());
    }

    @NotNull
    /* renamed from: d */
    public Integer get(int i2) {
        return Integer.valueOf(this.X[i2]);
    }

    public int g(int i2) {
        return ArraysKt.Gf(this.X, i2);
    }

    public int h(int i2) {
        return ArraysKt.Kh(this.X, i2);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        return g(((Number) obj).intValue());
    }

    public boolean isEmpty() {
        return this.X.length == 0;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        return h(((Number) obj).intValue());
    }
}
