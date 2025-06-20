package kotlin;

import com.itextpdf.tool.xml.css.CSS;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0010\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a4\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\n\u0010\u000b\u001aI\u0010\u000f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u0007*\u00028\u00002\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001aM\u0010\u0012\u001a\u00028\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u00072\u0006\u0010\u0011\u001a\u00028\u00002\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0012\u0010\u0010\u001aC\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\u00028\u00002\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\r¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0014\u0010\u0010\u001a>\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\u00028\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\rH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0015\u0010\u0010\u001aD\u0010\u0016\u001a\u00028\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u0007*\u00028\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0016\u0010\u0010\u001a@\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\u00028\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\rH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0019\u0010\u0010\u001a@\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\u00028\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\rH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u001a\u0010\u0010\u001a:\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00130\rH\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u0002\u0007\n\u0005\b20\u0001¨\u0006 "}, d2 = {"", "a", "()Ljava/lang/Void;", "", "reason", "b", "(Ljava/lang/String;)Ljava/lang/Void;", "R", "Lkotlin/Function0;", "block", "h", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "g", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "receiver", "k", "", "d", "c", "e", "", "predicate", "i", "j", "", "times", "action", "f", "(ILkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/StandardKt")
class StandardKt__StandardKt {
    @InlineOnly
    private static final Void a() {
        throw new NotImplementedError((String) null, 1, (DefaultConstructorMarker) null);
    }

    @InlineOnly
    private static final Void b(String str) {
        Intrinsics.p(str, "reason");
        throw new NotImplementedError("An operation is not implemented: " + str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> T c(T t, Function1<? super T, Unit> function1) {
        Intrinsics.p(function1, CSS.Value.v0);
        function1.f(t);
        return t;
    }

    @InlineOnly
    private static final <T> T d(T t, Function1<? super T, Unit> function1) {
        Intrinsics.p(function1, CSS.Value.v0);
        function1.f(t);
        return t;
    }

    @InlineOnly
    private static final <T, R> R e(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.p(function1, CSS.Value.v0);
        return function1.f(t);
    }

    @InlineOnly
    private static final void f(int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.p(function1, "action");
        for (int i3 = 0; i3 < i2; i3++) {
            function1.f(Integer.valueOf(i3));
        }
    }

    @InlineOnly
    private static final <T, R> R g(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.p(function1, CSS.Value.v0);
        return function1.f(t);
    }

    @InlineOnly
    private static final <R> R h(Function0<? extends R> function0) {
        Intrinsics.p(function0, CSS.Value.v0);
        return function0.o();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> T i(T t, Function1<? super T, Boolean> function1) {
        Intrinsics.p(function1, "predicate");
        if (function1.f(t).booleanValue()) {
            return t;
        }
        return null;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> T j(T t, Function1<? super T, Boolean> function1) {
        Intrinsics.p(function1, "predicate");
        if (!function1.f(t).booleanValue()) {
            return t;
        }
        return null;
    }

    @InlineOnly
    private static final <T, R> R k(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.p(function1, CSS.Value.v0);
        return function1.f(t);
    }
}
