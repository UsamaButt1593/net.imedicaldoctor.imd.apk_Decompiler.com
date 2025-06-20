package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$7", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "isEmpty", "()Z", "element", "c", "(Z)Z", "", "index", "d", "(I)Ljava/lang/Boolean;", "g", "(Z)I", "h", "b", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class ArraysKt___ArraysJvmKt$asList$7 extends AbstractList<Boolean> implements RandomAccess {
    final /* synthetic */ boolean[] X;

    ArraysKt___ArraysJvmKt$asList$7(boolean[] zArr) {
        this.X = zArr;
    }

    public int b() {
        return this.X.length;
    }

    public boolean c(boolean z) {
        return ArraysKt___ArraysKt.u8(this.X, z);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Boolean)) {
            return false;
        }
        return c(((Boolean) obj).booleanValue());
    }

    @NotNull
    /* renamed from: d */
    public Boolean get(int i2) {
        return Boolean.valueOf(this.X[i2]);
    }

    public int g(boolean z) {
        return ArraysKt___ArraysKt.Kf(this.X, z);
    }

    public int h(boolean z) {
        return ArraysKt___ArraysKt.Oh(this.X, z);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        return g(((Boolean) obj).booleanValue());
    }

    public boolean isEmpty() {
        return this.X.length == 0;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        return h(((Boolean) obj).booleanValue());
    }
}
