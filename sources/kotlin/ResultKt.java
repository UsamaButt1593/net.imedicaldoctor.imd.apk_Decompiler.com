package kotlin;

import com.itextpdf.tool.xml.css.CSS;
import kotlin.Result;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a0\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001aE\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\t*\u00028\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\u0002\b\u0010H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a#\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a`\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\u000e*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00052!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000fH\bø\u0001\u0001ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0018\u0010\u0012\u001a5\u0010\u001a\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\u000e*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0019\u001a\u00028\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0001\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00010\u00052!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00028\u00000\u000f2!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000fH\bø\u0001\u0001ø\u0001\u0000\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001ab\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00010\u00052!\u0010 \u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00028\u00000\u000fH\bø\u0001\u0001ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b!\u0010\u0012\u001aU\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00010\u00052!\u0010 \u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00028\u00000\u000fH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0012\u001af\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\u000e*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00052!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000fH\bø\u0001\u0001ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b#\u0010\u0012\u001aY\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\u000e*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00052!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000fH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0012\u001a\\\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000\u00052!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00020\u00060\u000fH\bø\u0001\u0001ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b&\u0010\u0012\u001a\\\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000\u00052!\u0010%\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u000fH\bø\u0001\u0001ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b'\u0010\u0012\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006("}, d2 = {"", "exception", "", "a", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "Lkotlin/Result;", "", "n", "(Ljava/lang/Object;)V", "R", "Lkotlin/Function0;", "block", "m", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "l", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "e", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/ParameterName;", "name", "onFailure", "d", "defaultValue", "c", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "value", "onSuccess", "b", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "transform", "f", "g", "j", "k", "action", "h", "i", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Result.kt\nkotlin/ResultKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,340:1\n1#2:341\n*E\n"})
public final class ResultKt {
    @NotNull
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Object a(@NotNull Throwable th) {
        Intrinsics.p(th, "exception");
        return new Result.Failure(th);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> R b(Object obj, Function1<? super T, ? extends R> function1, Function1<? super Throwable, ? extends R> function12) {
        Intrinsics.p(function1, "onSuccess");
        Intrinsics.p(function12, "onFailure");
        Throwable e2 = Result.e(obj);
        return e2 == null ? function1.f(obj) : function12.f(e2);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R c(Object obj, R r) {
        return Result.i(obj) ? r : obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R d(Object obj, Function1<? super Throwable, ? extends R> function1) {
        Intrinsics.p(function1, "onFailure");
        Throwable e2 = Result.e(obj);
        return e2 == null ? obj : function1.f(e2);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> T e(Object obj) {
        n(obj);
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object f(Object obj, Function1<? super T, ? extends R> function1) {
        Intrinsics.p(function1, "transform");
        if (Result.j(obj)) {
            Result.Companion companion = Result.X;
            obj = function1.f(obj);
        }
        return Result.b(obj);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object g(Object obj, Function1<? super T, ? extends R> function1) {
        Intrinsics.p(function1, "transform");
        if (Result.j(obj)) {
            try {
                Result.Companion companion = Result.X;
                return Result.b(function1.f(obj));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.X;
                obj = a(th);
            }
        }
        return Result.b(obj);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object h(Object obj, Function1<? super Throwable, Unit> function1) {
        Intrinsics.p(function1, "action");
        Throwable e2 = Result.e(obj);
        if (e2 != null) {
            function1.f(e2);
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object i(Object obj, Function1<? super T, Unit> function1) {
        Intrinsics.p(function1, "action");
        if (Result.j(obj)) {
            function1.f(obj);
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> Object j(Object obj, Function1<? super Throwable, ? extends R> function1) {
        Intrinsics.p(function1, "transform");
        Throwable e2 = Result.e(obj);
        if (e2 == null) {
            return obj;
        }
        Result.Companion companion = Result.X;
        return Result.b(function1.f(e2));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> Object k(Object obj, Function1<? super Throwable, ? extends R> function1) {
        Intrinsics.p(function1, "transform");
        Throwable e2 = Result.e(obj);
        if (e2 == null) {
            return obj;
        }
        try {
            Result.Companion companion = Result.X;
            return Result.b(function1.f(e2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            return Result.b(a(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T, R> Object l(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.p(function1, CSS.Value.v0);
        try {
            Result.Companion companion = Result.X;
            return Result.b(function1.f(t));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            return Result.b(a(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R> Object m(Function0<? extends R> function0) {
        Intrinsics.p(function0, CSS.Value.v0);
        try {
            Result.Companion companion = Result.X;
            return Result.b(function0.o());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            return Result.b(a(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final void n(@NotNull Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).s;
        }
    }
}
