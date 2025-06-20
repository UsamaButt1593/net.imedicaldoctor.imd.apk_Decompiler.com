package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0017¢\u0006\u0004\b\u0014\u0010\u0013J'\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00112\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "<init>", "()V", "Lkotlin/coroutines/CoroutineContext;", "context", "", "T", "(Lkotlin/coroutines/CoroutineContext;)Z", "", "parallelism", "W", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "R", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "S", "Lkotlin/coroutines/Continuation;", "continuation", "t", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "q", "(Lkotlin/coroutines/Continuation;)V", "other", "g0", "(Lkotlinx/coroutines/CoroutineDispatcher;)Lkotlinx/coroutines/CoroutineDispatcher;", "", "toString", "()Ljava/lang/String;", "X", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements ContinuationInterceptor {
    @NotNull
    public static final Key X = new Key((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @ExperimentalStdlibApi
    public static final class Key extends AbstractCoroutineContextKey<ContinuationInterceptor, CoroutineDispatcher> {
        private Key() {
            super(ContinuationInterceptor.N2, AnonymousClass1.X);
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.N2);
    }

    public abstract void R(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable);

    @InternalCoroutinesApi
    public void S(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        R(coroutineContext, runnable);
    }

    public boolean T(@NotNull CoroutineContext coroutineContext) {
        return true;
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public CoroutineDispatcher W(int i2) {
        LimitedDispatcherKt.a(i2);
        return new LimitedDispatcher(this, i2);
    }

    @Nullable
    public <E extends CoroutineContext.Element> E e(@NotNull CoroutineContext.Key<E> key) {
        return ContinuationInterceptor.DefaultImpls.b(this, key);
    }

    @NotNull
    public CoroutineContext f(@NotNull CoroutineContext.Key<?> key) {
        return ContinuationInterceptor.DefaultImpls.c(this, key);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    public final CoroutineDispatcher g0(@NotNull CoroutineDispatcher coroutineDispatcher) {
        return coroutineDispatcher;
    }

    public final void q(@NotNull Continuation<?> continuation) {
        ((DispatchedContinuation) continuation).u();
    }

    @NotNull
    public final <T> Continuation<T> t(@NotNull Continuation<? super T> continuation) {
        return new DispatchedContinuation(this, continuation);
    }

    @NotNull
    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this);
    }
}
