package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\r\u001a\u0004\u0018\u00010\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a-\u0010\u0011\u001a\u00020\u0010*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a=\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\"\u001a\u0010\u001e\u001a\u00020\u001a8\u0000X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u0012\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"T", "", "replay", "extraBufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "a", "(IILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "", "", "index", "f", "([Ljava/lang/Object;J)Ljava/lang/Object;", "item", "", "h", "([Ljava/lang/Object;JLjava/lang/Object;)V", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/flow/Flow;", "e", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/internal/Symbol;", "Lkotlinx/coroutines/internal/Symbol;", "g", "()V", "NO_VALUE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class SharedFlowKt {
    @NotNull
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f29306a = new Symbol("NO_VALUE");

    @NotNull
    public static final <T> MutableSharedFlow<T> a(int i2, int i3, @NotNull BufferOverflow bufferOverflow) {
        if (i2 < 0) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + i2).toString());
        } else if (i3 < 0) {
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i3).toString());
        } else if (i2 > 0 || i3 > 0 || bufferOverflow == BufferOverflow.SUSPEND) {
            int i4 = i3 + i2;
            if (i4 < 0) {
                i4 = Integer.MAX_VALUE;
            }
            return new SharedFlowImpl(i2, i4, bufferOverflow);
        } else {
            throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
        }
    }

    public static /* synthetic */ MutableSharedFlow b(int i2, int i3, BufferOverflow bufferOverflow, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return a(i2, i3, bufferOverflow);
    }

    @NotNull
    public static final <T> Flow<T> e(@NotNull SharedFlow<? extends T> sharedFlow, @NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        return ((i2 == 0 || i2 == -3) && bufferOverflow == BufferOverflow.SUSPEND) ? sharedFlow : new ChannelFlowOperatorImpl(sharedFlow, coroutineContext, i2, bufferOverflow);
    }

    /* access modifiers changed from: private */
    public static final Object f(Object[] objArr, long j2) {
        return objArr[(objArr.length - 1) & ((int) j2)];
    }

    public static /* synthetic */ void g() {
    }

    /* access modifiers changed from: private */
    public static final void h(Object[] objArr, long j2, Object obj) {
        objArr[(objArr.length - 1) & ((int) j2)] = obj;
    }
}
