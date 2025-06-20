package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H¤@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u0013\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010!R\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R9\u0010.\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140*\u0012\u0006\u0012\u0004\u0018\u00010+0)8@X\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlinx/coroutines/flow/Flow;", "j", "()Lkotlinx/coroutines/flow/Flow;", "c", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "g", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "", "f", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "o", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "a", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "d", "()Ljava/lang/String;", "toString", "s", "Lkotlin/coroutines/CoroutineContext;", "X", "I", "Y", "Lkotlinx/coroutines/channels/BufferOverflow;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "k", "()Lkotlin/jvm/functions/Function2;", "collectToFun", "n", "()I", "produceCapacity", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@InternalCoroutinesApi
public abstract class ChannelFlow<T> implements FusibleFlow<T> {
    @JvmField
    public final int X;
    @NotNull
    @JvmField
    public final BufferOverflow Y;
    @NotNull
    @JvmField
    public final CoroutineContext s;

    public ChannelFlow(@NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        this.s = coroutineContext;
        this.X = i2;
        this.Y = bufferOverflow;
    }

    static /* synthetic */ Object e(ChannelFlow channelFlow, FlowCollector flowCollector, Continuation continuation) {
        Object g2 = CoroutineScopeKt.g(new ChannelFlow$collect$2(flowCollector, channelFlow, (Continuation<? super ChannelFlow$collect$2>) null), continuation);
        return g2 == IntrinsicsKt.l() ? g2 : Unit.f28779a;
    }

    @Nullable
    public Object a(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        return e(this, flowCollector, continuation);
    }

    @NotNull
    public Flow<T> c(@NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        CoroutineContext v = coroutineContext.v(this.s);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i3 = this.X;
            if (i3 != -3) {
                if (i2 != -3) {
                    if (i3 != -2) {
                        if (i2 != -2) {
                            i2 += i3;
                            if (i2 < 0) {
                                i2 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i2 = i3;
            }
            bufferOverflow = this.Y;
        }
        return (Intrinsics.g(v, this.s) && i2 == this.X && bufferOverflow == this.Y) ? this : g(v, i2, bufferOverflow);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String d() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract Object f(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation);

    /* access modifiers changed from: protected */
    @NotNull
    public abstract ChannelFlow<T> g(@NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow);

    @Nullable
    public Flow<T> j() {
        return null;
    }

    @NotNull
    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> k() {
        return new ChannelFlow$collectToFun$1(this, (Continuation<? super ChannelFlow$collectToFun$1>) null);
    }

    public final int n() {
        int i2 = this.X;
        if (i2 == -3) {
            return -2;
        }
        return i2;
    }

    @NotNull
    public ReceiveChannel<T> o(@NotNull CoroutineScope coroutineScope) {
        return ProduceKt.h(coroutineScope, this.s, n(), this.Y, CoroutineStart.ATOMIC, (Function1) null, k(), 16, (Object) null);
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String d2 = d();
        if (d2 != null) {
            arrayList.add(d2);
        }
        if (this.s != EmptyCoroutineContext.s) {
            arrayList.add("context=" + this.s);
        }
        if (this.X != -3) {
            arrayList.add("capacity=" + this.X);
        }
        if (this.Y != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.Y);
        }
        return DebugStringsKt.a(this) + '[' + CollectionsKt.j3(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + ']';
    }
}
