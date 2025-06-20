package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\b@\bX\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0019"}, d2 = {"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Lkotlin/Function0;", "initializer", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "", "a", "()Ljava/lang/Object;", "", "m", "()Z", "", "toString", "()Ljava/lang/String;", "s", "Lkotlin/jvm/functions/Function0;", "X", "Ljava/lang/Object;", "_value", "getValue", "value", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class UnsafeLazyImpl<T> implements Lazy<T>, Serializable {
    @Nullable
    private Object X = UNINITIALIZED_VALUE.f28778a;
    @Nullable
    private Function0<? extends T> s;

    public UnsafeLazyImpl(@NotNull Function0<? extends T> function0) {
        Intrinsics.p(function0, "initializer");
        this.s = function0;
    }

    private final Object a() {
        return new InitializedLazyImpl(getValue());
    }

    public T getValue() {
        if (this.X == UNINITIALIZED_VALUE.f28778a) {
            Function0<? extends T> function0 = this.s;
            Intrinsics.m(function0);
            this.X = function0.o();
            this.s = null;
        }
        return this.X;
    }

    public boolean m() {
        return this.X != UNINITIALIZED_VALUE.f28778a;
    }

    @NotNull
    public String toString() {
        return m() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
