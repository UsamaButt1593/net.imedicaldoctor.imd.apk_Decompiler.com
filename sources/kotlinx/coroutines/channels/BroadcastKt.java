package kotlinx.coroutines.channels;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a \u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042-\b\u0002\u0010\u0013\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fj\u0004\u0018\u0001`\u00122/\b\u0001\u0010\u0019\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"E", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "capacity", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlinx/coroutines/channels/BroadcastChannel;", "b", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlinx/coroutines/CoroutineStart;)Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/BroadcastChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class BroadcastKt {
    @NotNull
    @ObsoleteCoroutinesApi
    public static final <E> BroadcastChannel<E> a(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i2, @NotNull CoroutineStart coroutineStart, @Nullable Function1<? super Throwable, Unit> function1, @NotNull @BuilderInference Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        CoroutineContext e2 = CoroutineContextKt.e(coroutineScope, coroutineContext);
        BroadcastChannel a2 = BroadcastChannelKt.a(i2);
        BroadcastCoroutine lazyBroadcastCoroutine = coroutineStart.e() ? new LazyBroadcastCoroutine(e2, a2, function2) : new BroadcastCoroutine(e2, a2, true);
        if (function1 != null) {
            lazyBroadcastCoroutine.Z(function1);
        }
        lazyBroadcastCoroutine.J1(coroutineStart, lazyBroadcastCoroutine, function2);
        return lazyBroadcastCoroutine;
    }

    @NotNull
    @ObsoleteCoroutinesApi
    public static final <E> BroadcastChannel<E> b(@NotNull ReceiveChannel<? extends E> receiveChannel, int i2, @NotNull CoroutineStart coroutineStart) {
        return c(CoroutineScopeKt.m(CoroutineScopeKt.m(GlobalScope.s, Dispatchers.g()), new BroadcastKt$broadcast$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.O2)), (CoroutineContext) null, i2, coroutineStart, new BroadcastKt$broadcast$1(receiveChannel), new BroadcastKt$broadcast$2(receiveChannel, (Continuation<? super BroadcastKt$broadcast$2>) null), 1, (Object) null);
    }

    public static /* synthetic */ BroadcastChannel c(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i2, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.s;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i4 = (i3 & 2) != 0 ? 1 : i2;
        if ((i3 & 4) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        return a(coroutineScope, coroutineContext2, i4, coroutineStart2, function1, function2);
    }

    public static /* synthetic */ BroadcastChannel d(ReceiveChannel receiveChannel, int i2, CoroutineStart coroutineStart, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 1;
        }
        if ((i3 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return b(receiveChannel, i2, coroutineStart);
    }
}
