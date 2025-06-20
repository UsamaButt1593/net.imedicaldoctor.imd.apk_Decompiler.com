package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0003*\u00028\u0000H$¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00038\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0006R\"\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00178\u0002X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u0012\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "T", "", "size", "<init>", "(I)V", "c", "(Ljava/lang/Object;)I", "spreadArgument", "", "a", "(Ljava/lang/Object;)V", "f", "()I", "values", "result", "g", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "I", "b", "e", "position", "", "[Ljava/lang/Object;", "d", "()V", "spreads", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public abstract class PrimitiveSpreadBuilder<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f28957a;

    /* renamed from: b  reason: collision with root package name */
    private int f28958b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final T[] f28959c;

    public PrimitiveSpreadBuilder(int i2) {
        this.f28957a = i2;
        this.f28959c = new Object[i2];
    }

    private static /* synthetic */ void d() {
    }

    public final void a(@NotNull T t) {
        Intrinsics.p(t, "spreadArgument");
        T[] tArr = this.f28959c;
        int i2 = this.f28958b;
        this.f28958b = i2 + 1;
        tArr[i2] = t;
    }

    /* access modifiers changed from: protected */
    public final int b() {
        return this.f28958b;
    }

    /* access modifiers changed from: protected */
    public abstract int c(@NotNull T t);

    /* access modifiers changed from: protected */
    public final void e(int i2) {
        this.f28958b = i2;
    }

    /* access modifiers changed from: protected */
    public final int f() {
        int i2 = 0;
        IntIterator n2 = new IntRange(0, this.f28957a - 1).iterator();
        while (n2.hasNext()) {
            T t = this.f28959c[n2.b()];
            i2 += t != null ? c(t) : 1;
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final T g(@NotNull T t, @NotNull T t2) {
        Intrinsics.p(t, "values");
        Intrinsics.p(t2, "result");
        IntIterator n2 = new IntRange(0, this.f28957a - 1).iterator();
        int i2 = 0;
        int i3 = 0;
        while (n2.hasNext()) {
            int b2 = n2.b();
            T t3 = this.f28959c[b2];
            if (t3 != null) {
                if (i2 < b2) {
                    int i4 = b2 - i2;
                    System.arraycopy(t, i2, t2, i3, i4);
                    i3 += i4;
                }
                int c2 = c(t3);
                System.arraycopy(t3, 0, t2, i3, c2);
                i3 += c2;
                i2 = b2 + 1;
            }
        }
        int i5 = this.f28957a;
        if (i2 < i5) {
            System.arraycopy(t, i2, t2, i3, i5 - i2);
        }
        return t2;
    }
}
