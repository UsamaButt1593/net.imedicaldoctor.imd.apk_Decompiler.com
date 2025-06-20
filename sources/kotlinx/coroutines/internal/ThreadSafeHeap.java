package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0010¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0007J2\u0010\u001a\u001a\u0004\u0018\u00018\u00002!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\u001cJ\u000f\u0010\u001d\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001d\u0010\u001cJ&\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180\u0014H\b¢\u0006\u0004\b\u001e\u0010\u001bJ\u0015\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0004\b \u0010!J.\u0010#\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00028\u00002\u0014\u0010\"\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00180\u0014H\b¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0004\b%\u0010&J\u0011\u0010'\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b'\u0010\u001cJ\u0017\u0010)\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\bH\u0001¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00028\u0000H\u0001¢\u0006\u0004\b+\u0010!R \u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R$\u00100\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b8F@BX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u0010\fR\u0011\u00103\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "", "i", "", "q", "(I)V", "p", "", "j", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "r", "(II)V", "d", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "predicate", "e", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "n", "m", "node", "b", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "cond", "c", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "k", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "f", "index", "l", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "g", "()I", "o", "size", "h", "()Z", "isEmpty", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@InternalCoroutinesApi
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    @NotNull
    private volatile /* synthetic */ int _size = 0;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private T[] f29403a;

    private final T[] j() {
        T[] tArr = this.f29403a;
        if (tArr == null) {
            T[] tArr2 = new ThreadSafeHeapNode[4];
            this.f29403a = tArr2;
            return tArr2;
        } else if (g() < tArr.length) {
            return tArr;
        } else {
            T[] copyOf = Arrays.copyOf(tArr, g() * 2);
            Intrinsics.o(copyOf, "copyOf(this, newSize)");
            T[] tArr3 = (ThreadSafeHeapNode[]) copyOf;
            this.f29403a = tArr3;
            return tArr3;
        }
    }

    private final void o(int i2) {
        this._size = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void p(int r6) {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.g()
            if (r1 < r2) goto L_0x000b
            return
        L_0x000b:
            T[] r2 = r5.f29403a
            kotlin.jvm.internal.Intrinsics.m(r2)
            int r0 = r0 + 2
            int r3 = r5.g()
            if (r0 >= r3) goto L_0x002b
            r3 = r2[r0]
            kotlin.jvm.internal.Intrinsics.m(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            kotlin.jvm.internal.Intrinsics.m(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            r1 = r2[r6]
            kotlin.jvm.internal.Intrinsics.m(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            kotlin.jvm.internal.Intrinsics.m(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L_0x003f
            return
        L_0x003f:
            r5.r(r6, r0)
            r6 = r0
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ThreadSafeHeap.p(int):void");
    }

    private final void q(int i2) {
        while (i2 > 0) {
            T[] tArr = this.f29403a;
            Intrinsics.m(tArr);
            int i3 = (i2 - 1) / 2;
            T t = tArr[i3];
            Intrinsics.m(t);
            T t2 = tArr[i2];
            Intrinsics.m(t2);
            if (((Comparable) t).compareTo(t2) > 0) {
                r(i2, i3);
                i2 = i3;
            } else {
                return;
            }
        }
    }

    private final void r(int i2, int i3) {
        T[] tArr = this.f29403a;
        Intrinsics.m(tArr);
        T t = tArr[i3];
        Intrinsics.m(t);
        T t2 = tArr[i2];
        Intrinsics.m(t2);
        tArr[i2] = t;
        tArr[i3] = t2;
        t.c(i2);
        t2.c(i3);
    }

    @PublishedApi
    public final void a(@NotNull T t) {
        t.a(this);
        ThreadSafeHeapNode[] j2 = j();
        int g2 = g();
        o(g2 + 1);
        j2[g2] = t;
        t.c(g2);
        q(g2);
    }

    public final void b(@NotNull T t) {
        synchronized (this) {
            a(t);
            Unit unit = Unit.f28779a;
        }
    }

    public final boolean c(@NotNull T t, @NotNull Function1<? super T, Boolean> function1) {
        boolean z;
        synchronized (this) {
            try {
                if (function1.f(f()).booleanValue()) {
                    a(t);
                    z = true;
                } else {
                    z = false;
                }
                InlineMarker.d(1);
            } catch (Throwable th) {
                InlineMarker.d(1);
                InlineMarker.c(1);
                throw th;
            }
        }
        InlineMarker.c(1);
        return z;
    }

    public final void d() {
        synchronized (this) {
            try {
                T[] tArr = this.f29403a;
                if (tArr != null) {
                    ArraysKt.V1(tArr, (Object) null, 0, 0, 6, (Object) null);
                }
                this._size = 0;
                Unit unit = Unit.f28779a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public final T e(@NotNull Function1<? super T, Boolean> function1) {
        T t;
        synchronized (this) {
            try {
                int g2 = g();
                int i2 = 0;
                while (true) {
                    t = null;
                    if (i2 >= g2) {
                        break;
                    }
                    T[] tArr = this.f29403a;
                    if (tArr != null) {
                        t = tArr[i2];
                    }
                    Intrinsics.m(t);
                    if (function1.f(t).booleanValue()) {
                        break;
                    }
                    i2++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    @Nullable
    @PublishedApi
    public final T f() {
        T[] tArr = this.f29403a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int g() {
        return this._size;
    }

    public final boolean h() {
        return g() == 0;
    }

    @Nullable
    public final T i() {
        T f2;
        synchronized (this) {
            f2 = f();
        }
        return f2;
    }

    public final boolean k(@NotNull T t) {
        boolean z;
        synchronized (this) {
            if (t.b() == null) {
                z = false;
            } else {
                l(t.j());
                z = true;
            }
        }
        return z;
    }

    @NotNull
    @PublishedApi
    public final T l(int i2) {
        T[] tArr = this.f29403a;
        Intrinsics.m(tArr);
        o(g() - 1);
        if (i2 < g()) {
            r(i2, g());
            int i3 = (i2 - 1) / 2;
            if (i2 > 0) {
                T t = tArr[i2];
                Intrinsics.m(t);
                T t2 = tArr[i3];
                Intrinsics.m(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    r(i2, i3);
                    q(i3);
                }
            }
            p(i2);
        }
        T t3 = tArr[g()];
        Intrinsics.m(t3);
        t3.a((ThreadSafeHeap<?>) null);
        t3.c(-1);
        tArr[g()] = null;
        return t3;
    }

    @Nullable
    public final T m(@NotNull Function1<? super T, Boolean> function1) {
        synchronized (this) {
            try {
                ThreadSafeHeapNode f2 = f();
                T t = null;
                if (f2 == null) {
                    InlineMarker.d(2);
                    InlineMarker.c(2);
                    return null;
                }
                if (function1.f(f2).booleanValue()) {
                    t = l(0);
                }
                InlineMarker.d(1);
                InlineMarker.c(1);
                return t;
            } catch (Throwable th) {
                InlineMarker.d(1);
                InlineMarker.c(1);
                throw th;
            }
        }
    }

    @Nullable
    public final T n() {
        T l2;
        synchronized (this) {
            l2 = g() > 0 ? l(0) : null;
        }
        return l2;
    }
}
