package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\r\u001aM\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0000*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a1\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aC\u0010\u001f\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a#\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b!\u0010\"\u001a#\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000#¢\u0006\u0004\b$\u0010%\u001aU\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2-\u0010+\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0(\u0012\u0006\u0012\u0004\u0018\u00010)0&¢\u0006\u0002\b*ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/flow/SharingStarted;", "started", "", "replay", "Lkotlinx/coroutines/flow/SharedFlow;", "g", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;I)Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/SharingConfig;", "c", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/SharingConfig;", "Lkotlin/coroutines/CoroutineContext;", "context", "upstream", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "shared", "initialValue", "Lkotlinx/coroutines/Job;", "d", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/flow/StateFlow;", "j", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "i", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CompletableDeferred;", "result", "", "e", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CompletableDeferred;)V", "a", "(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "b", "(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "action", "f", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/SharedFlow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ShareKt {
    @NotNull
    public static final <T> SharedFlow<T> a(@NotNull MutableSharedFlow<T> mutableSharedFlow) {
        return new ReadonlySharedFlow(mutableSharedFlow, (Job) null);
    }

    @NotNull
    public static final <T> StateFlow<T> b(@NotNull MutableStateFlow<T> mutableStateFlow) {
        return new ReadonlyStateFlow(mutableStateFlow, (Job) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r3 == 0) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r1 = (kotlinx.coroutines.flow.internal.ChannelFlow) r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> kotlinx.coroutines.flow.SharingConfig<T> c(kotlinx.coroutines.flow.Flow<? extends T> r7, int r8) {
        /*
            kotlinx.coroutines.channels.Channel$Factory r0 = kotlinx.coroutines.channels.Channel.Q2
            int r0 = r0.a()
            int r0 = kotlin.ranges.RangesKt.u(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof kotlinx.coroutines.flow.internal.ChannelFlow
            if (r1 == 0) goto L_0x003c
            r1 = r7
            kotlinx.coroutines.flow.internal.ChannelFlow r1 = (kotlinx.coroutines.flow.internal.ChannelFlow) r1
            kotlinx.coroutines.flow.Flow r2 = r1.j()
            if (r2 == 0) goto L_0x003c
            kotlinx.coroutines.flow.SharingConfig r7 = new kotlinx.coroutines.flow.SharingConfig
            int r3 = r1.X
            r4 = -3
            if (r3 == r4) goto L_0x0026
            r4 = -2
            if (r3 == r4) goto L_0x0026
            if (r3 == 0) goto L_0x0026
            r0 = r3
            goto L_0x0034
        L_0x0026:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.Y
            kotlinx.coroutines.channels.BufferOverflow r5 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            r6 = 0
            if (r4 != r5) goto L_0x0031
            if (r3 != 0) goto L_0x0034
        L_0x002f:
            r0 = 0
            goto L_0x0034
        L_0x0031:
            if (r8 != 0) goto L_0x002f
            r0 = 1
        L_0x0034:
            kotlinx.coroutines.channels.BufferOverflow r8 = r1.Y
            kotlin.coroutines.CoroutineContext r1 = r1.s
            r7.<init>(r2, r0, r8, r1)
            return r7
        L_0x003c:
            kotlinx.coroutines.flow.SharingConfig r8 = new kotlinx.coroutines.flow.SharingConfig
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.s
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt.c(kotlinx.coroutines.flow.Flow, int):kotlinx.coroutines.flow.SharingConfig");
    }

    private static final <T> Job d(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Flow<? extends T> flow, MutableSharedFlow<T> mutableSharedFlow, SharingStarted sharingStarted, T t) {
        return BuildersKt.d(coroutineScope, coroutineContext, Intrinsics.g(sharingStarted, SharingStarted.f29313a.c()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED, new FlowKt__ShareKt$launchSharing$1(sharingStarted, flow, mutableSharedFlow, t, (Continuation<? super FlowKt__ShareKt$launchSharing$1>) null));
    }

    private static final <T> void e(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Flow<? extends T> flow, CompletableDeferred<StateFlow<T>> completableDeferred) {
        Job unused = BuildersKt__Builders_commonKt.f(coroutineScope, coroutineContext, (CoroutineStart) null, new FlowKt__ShareKt$launchSharingDeferred$1(flow, completableDeferred, (Continuation<? super FlowKt__ShareKt$launchSharingDeferred$1>) null), 2, (Object) null);
    }

    @NotNull
    public static final <T> SharedFlow<T> f(@NotNull SharedFlow<? extends T> sharedFlow, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new SubscribedSharedFlow(sharedFlow, function2);
    }

    @NotNull
    public static final <T> SharedFlow<T> g(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull SharingStarted sharingStarted, int i2) {
        SharingConfig<? extends T> c2 = c(flow, i2);
        MutableSharedFlow a2 = SharedFlowKt.a(i2, c2.f29310b, c2.f29311c);
        return new ReadonlySharedFlow(a2, d(coroutineScope, c2.f29312d, c2.f29309a, a2, sharingStarted, SharedFlowKt.f29306a));
    }

    public static /* synthetic */ SharedFlow h(Flow flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return FlowKt.F1(flow, coroutineScope, sharingStarted, i2);
    }

    @Nullable
    public static final <T> Object i(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super StateFlow<? extends T>> continuation) {
        SharingConfig<? extends T> c2 = c(flow, 1);
        CompletableDeferred c3 = CompletableDeferredKt.c((Job) null, 1, (Object) null);
        e(coroutineScope, c2.f29312d, c2.f29309a, c3);
        return c3.J(continuation);
    }

    @NotNull
    public static final <T> StateFlow<T> j(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull SharingStarted sharingStarted, T t) {
        SharingConfig<? extends T> c2 = c(flow, 1);
        MutableStateFlow a2 = StateFlowKt.a(t);
        return new ReadonlyStateFlow(a2, d(coroutineScope, c2.f29312d, c2.f29309a, a2, sharingStarted, t));
    }
}
