package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RestrictsSuspension
@SinceKotlin(version = "1.7")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\f\u001a\u00028\u0003\"\u0004\b\u0002\u0010\t\"\u0004\b\u0003\u0010\n*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000b2\u0006\u0010\u0006\u001a\u00028\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ&\u0010\u000f\u001a\u00020\u000e*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u0001\u0001\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlin/DeepRecursiveScope;", "T", "R", "", "<init>", "()V", "value", "a", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "U", "S", "Lkotlin/DeepRecursiveFunction;", "c", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "e", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Void;", "Lkotlin/DeepRecursiveScopeImpl;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
public abstract class DeepRecursiveScope<T, R> {
    private DeepRecursiveScope() {
    }

    @Nullable
    public abstract Object a(T t, @NotNull Continuation<? super R> continuation);

    @Nullable
    public abstract <U, S> Object c(@NotNull DeepRecursiveFunction<U, S> deepRecursiveFunction, U u, @NotNull Continuation<? super S> continuation);

    @NotNull
    @Deprecated(level = DeprecationLevel.X, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @ReplaceWith(expression = "this.callRecursive(value)", imports = {}))
    public final Void e(@NotNull DeepRecursiveFunction<?, ?> deepRecursiveFunction, @Nullable Object obj) {
        Intrinsics.p(deepRecursiveFunction, "<this>");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }

    public /* synthetic */ DeepRecursiveScope(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
