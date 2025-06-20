package kotlin.collections;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0005\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Lkotlin/collections/IndexedValue;", "T", "", "", "index", "value", "<init>", "(ILjava/lang/Object;)V", "a", "()I", "b", "()Ljava/lang/Object;", "c", "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "e", "Ljava/lang/Object;", "f", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class IndexedValue<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f28797a;

    /* renamed from: b  reason: collision with root package name */
    private final T f28798b;

    public IndexedValue(int i2, T t) {
        this.f28797a = i2;
        this.f28798b = t;
    }

    public static /* synthetic */ IndexedValue d(IndexedValue indexedValue, int i2, T t, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = indexedValue.f28797a;
        }
        if ((i3 & 2) != 0) {
            t = indexedValue.f28798b;
        }
        return indexedValue.c(i2, t);
    }

    public final int a() {
        return this.f28797a;
    }

    public final T b() {
        return this.f28798b;
    }

    @NotNull
    public final IndexedValue<T> c(int i2, T t) {
        return new IndexedValue<>(i2, t);
    }

    public final int e() {
        return this.f28797a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndexedValue)) {
            return false;
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        return this.f28797a == indexedValue.f28797a && Intrinsics.g(this.f28798b, indexedValue.f28798b);
    }

    public final T f() {
        return this.f28798b;
    }

    public int hashCode() {
        int i2 = this.f28797a * 31;
        T t = this.f28798b;
        return i2 + (t == null ? 0 : t.hashCode());
    }

    @NotNull
    public String toString() {
        return "IndexedValue(index=" + this.f28797a + ", value=" + this.f28798b + ASCIIPropertyListParser.f18650h;
    }
}
