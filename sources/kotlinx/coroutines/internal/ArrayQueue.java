package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\u0004R\u001e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/ArrayQueue;", "", "T", "<init>", "()V", "", "c", "element", "a", "(Ljava/lang/Object;)V", "e", "()Ljava/lang/Object;", "b", "", "[Ljava/lang/Object;", "elements", "", "I", "head", "tail", "", "d", "()Z", "isEmpty", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class ArrayQueue<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private Object[] f29327a = new Object[16];

    /* renamed from: b  reason: collision with root package name */
    private int f29328b;

    /* renamed from: c  reason: collision with root package name */
    private int f29329c;

    private final void c() {
        Object[] objArr = this.f29327a;
        int length = objArr.length;
        Object[] objArr2 = new Object[(length << 1)];
        Object[] objArr3 = objArr2;
        ArraysKt.K0(objArr, objArr3, 0, this.f29328b, 0, 10, (Object) null);
        Object[] objArr4 = this.f29327a;
        int length2 = objArr4.length;
        int i2 = this.f29328b;
        ArraysKt.K0(objArr4, objArr2, length2 - i2, 0, i2, 4, (Object) null);
        this.f29327a = objArr3;
        this.f29328b = 0;
        this.f29329c = length;
    }

    public final void a(@NotNull T t) {
        Object[] objArr = this.f29327a;
        int i2 = this.f29329c;
        objArr[i2] = t;
        int length = (objArr.length - 1) & (i2 + 1);
        this.f29329c = length;
        if (length == this.f29328b) {
            c();
        }
    }

    public final void b() {
        this.f29328b = 0;
        this.f29329c = 0;
        this.f29327a = new Object[this.f29327a.length];
    }

    public final boolean d() {
        return this.f29328b == this.f29329c;
    }

    @Nullable
    public final T e() {
        int i2 = this.f29328b;
        if (i2 == this.f29329c) {
            return null;
        }
        T[] tArr = this.f29327a;
        T t = tArr[i2];
        tArr[i2] = null;
        this.f29328b = (i2 + 1) & (tArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}
