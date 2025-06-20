package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B!\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\b@\bX\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001a\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\f¨\u0006\u001b"}, d2 = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Lkotlin/Function0;", "initializer", "", "lock", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "a", "()Ljava/lang/Object;", "", "m", "()Z", "", "toString", "()Ljava/lang/String;", "s", "Lkotlin/jvm/functions/Function0;", "X", "Ljava/lang/Object;", "_value", "Y", "getValue", "value", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {
    @Nullable
    private volatile Object X;
    @NotNull
    private final Object Y;
    @Nullable
    private Function0<? extends T> s;

    public SynchronizedLazyImpl(@NotNull Function0<? extends T> function0, @Nullable Object obj) {
        Intrinsics.p(function0, "initializer");
        this.s = function0;
        this.X = UNINITIALIZED_VALUE.f28778a;
        this.Y = obj == null ? this : obj;
    }

    private final Object a() {
        return new InitializedLazyImpl(getValue());
    }

    public T getValue() {
        T t;
        T t2 = this.X;
        T t3 = UNINITIALIZED_VALUE.f28778a;
        if (t2 != t3) {
            return t2;
        }
        synchronized (this.Y) {
            t = this.X;
            if (t == t3) {
                Function0 function0 = this.s;
                Intrinsics.m(function0);
                t = function0.o();
                this.X = t;
                this.s = null;
            }
        }
        return t;
    }

    public boolean m() {
        return this.X != UNINITIALIZED_VALUE.f28778a;
    }

    @NotNull
    public String toString() {
        return m() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i2 & 2) != 0 ? null : obj);
    }
}
