package kotlin;

import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0004\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0004ø\u0001\u0000¢\u0006\f\n\u0004\b\b\u0010\t\u0012\u0004\b\n\u0010\u000b*r\b\u0002\u0010\u0011\"5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r¢\u0006\u0002\b\u001025\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r¢\u0006\u0002\b\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"T", "R", "Lkotlin/DeepRecursiveFunction;", "value", "c", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Result;", "", "a", "Ljava/lang/Object;", "b", "()V", "UNDEFINED_RESULT", "Lkotlin/Function3;", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "DeepRecursiveFunctionBlock", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class DeepRecursiveKt {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Object f28775a = Result.b(IntrinsicsKt.l());

    static {
        Result.Companion companion = Result.X;
    }

    private static /* synthetic */ void b() {
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> R c(@NotNull DeepRecursiveFunction<T, R> deepRecursiveFunction, T t) {
        Intrinsics.p(deepRecursiveFunction, "<this>");
        return new DeepRecursiveScopeImpl(deepRecursiveFunction.a(), t).k();
    }
}
