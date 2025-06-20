package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aB\u0010\u0006\u001a\u00078\u0000¢\u0006\u0002\b\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u001e\b\u0004\u0010\u0005\u001a\u0018\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u0004\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u00040\u0002HHø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"R", "Landroidx/activity/contextaware/ContextAware;", "Lkotlin/Function1;", "Landroid/content/Context;", "Lkotlin/jvm/JvmSuppressWildcards;", "onContextAvailable", "a", "(Landroidx/activity/contextaware/ContextAware;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nContextAware.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,94:1\n314#2,11:95\n*S KotlinDebug\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt\n*L\n81#1:95,11\n*E\n"})
public final class ContextAwareKt {
    @Nullable
    public static final <R> Object a(@NotNull ContextAware contextAware, @NotNull Function1<Context, R> function1, @NotNull Continuation<R> continuation) {
        Context p = contextAware.p();
        if (p != null) {
            return function1.f(p);
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.e(continuation), 1);
        cancellableContinuationImpl.W();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(cancellableContinuationImpl, function1);
        contextAware.J(contextAwareKt$withContextAvailable$2$listener$1);
        cancellableContinuationImpl.M(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        Object y = cancellableContinuationImpl.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y;
    }

    private static final <R> Object b(ContextAware contextAware, Function1<Context, R> function1, Continuation<R> continuation) {
        Context p = contextAware.p();
        if (p != null) {
            return function1.f(p);
        }
        InlineMarker.e(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.e(continuation), 1);
        cancellableContinuationImpl.W();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(cancellableContinuationImpl, function1);
        contextAware.J(contextAwareKt$withContextAvailable$2$listener$1);
        cancellableContinuationImpl.M(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        Unit unit = Unit.f28779a;
        Object y = cancellableContinuationImpl.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        InlineMarker.e(1);
        return y;
    }
}
