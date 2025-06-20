package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a#\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\b\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a4\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001\u0000\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001¢\u0006\u0004\b\b\u0010\t\u001a1\u0010\u000b\u001a\u00028\u0000\"\b\b\u0000\u0010\n*\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00018\u0000H\b\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\u000b\u0010\f\u001aB\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\n*\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00018\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001\u0000\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a#\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\b\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001¢\u0006\u0004\b\u000f\u0010\u0004\u001a4\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001\u0000\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001¢\u0006\u0004\b\u0010\u0010\t\u001a1\u0010\u0011\u001a\u00028\u0000\"\b\b\u0000\u0010\n*\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00018\u0000H\b\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\u0011\u0010\f\u001aB\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\n*\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00018\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001\u0000\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\u0012\u0010\u000e\u001a\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0006H\b¢\u0006\u0004\b\u0015\u0010\u0016\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0017"}, d2 = {"", "value", "", "h", "(Z)V", "Lkotlin/Function0;", "", "lazyMessage", "i", "(ZLkotlin/jvm/functions/Function0;)V", "T", "j", "(Ljava/lang/Object;)Ljava/lang/Object;", "k", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "c", "d", "e", "f", "message", "", "g", "(Ljava/lang/Object;)Ljava/lang/Void;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/PreconditionsKt")
@SourceDebugExtension({"SMAP\nPreconditions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Preconditions.kt\nkotlin/PreconditionsKt__PreconditionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,144:1\n1#2:145\n*E\n"})
class PreconditionsKt__PreconditionsKt extends PreconditionsKt__AssertionsJVMKt {
    @InlineOnly
    private static final void c(boolean z) {
        if (!z) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @InlineOnly
    private static final void d(boolean z, Function0<? extends Object> function0) {
        Intrinsics.p(function0, "lazyMessage");
        if (!z) {
            throw new IllegalStateException(function0.o().toString());
        }
    }

    @InlineOnly
    private static final <T> T e(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @InlineOnly
    private static final <T> T f(T t, Function0<? extends Object> function0) {
        Intrinsics.p(function0, "lazyMessage");
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(function0.o().toString());
    }

    @InlineOnly
    private static final Void g(Object obj) {
        Intrinsics.p(obj, "message");
        throw new IllegalStateException(obj.toString());
    }

    @InlineOnly
    private static final void h(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @InlineOnly
    private static final void i(boolean z, Function0<? extends Object> function0) {
        Intrinsics.p(function0, "lazyMessage");
        if (!z) {
            throw new IllegalArgumentException(function0.o().toString());
        }
    }

    @InlineOnly
    private static final <T> T j(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @InlineOnly
    private static final <T> T k(T t, Function0<? extends Object> function0) {
        Intrinsics.p(function0, "lazyMessage");
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(function0.o().toString());
    }
}
