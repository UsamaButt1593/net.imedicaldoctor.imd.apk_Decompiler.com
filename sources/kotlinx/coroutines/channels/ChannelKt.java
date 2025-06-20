package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.ChannelResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aX\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00028\u00000\u0002H\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\b\u0010\t\u001a\\\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0002H\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\r\u0010\t\u001a^\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u000b0\u0002H\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u000e\u0010\t\u001a^\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u000b0\u0002H\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u000f\u0010\t\u001aE\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"T", "Lkotlinx/coroutines/channels/ChannelResult;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "exception", "onFailure", "e", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "value", "", "action", "h", "g", "f", "E", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "onUndeliveredElement", "Lkotlinx/coroutines/channels/Channel;", "b", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/channels/Channel;", "a", "(I)Lkotlinx/coroutines/channels/Channel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class ChannelKt {
    @NotNull
    public static final <E> Channel<E> b(int i2, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, Unit> function1) {
        int i3 = 1;
        if (i2 == -2) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                i3 = Channel.Q2.a();
            }
            return new ArrayChannel(i3, bufferOverflow, function1);
        } else if (i2 != -1) {
            if (i2 == 0) {
                return bufferOverflow == BufferOverflow.SUSPEND ? new RendezvousChannel(function1) : new ArrayChannel(1, bufferOverflow, function1);
            }
            if (i2 != Integer.MAX_VALUE) {
                return (i2 == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) ? new ConflatedChannel(function1) : new ArrayChannel(i2, bufferOverflow, function1);
            }
            return new LinkedListChannel(function1);
        } else if (bufferOverflow == BufferOverflow.SUSPEND) {
            return new ConflatedChannel(function1);
        } else {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
    }

    public static /* synthetic */ Channel c(int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return d(i2, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    }

    public static /* synthetic */ Channel d(int i2, BufferOverflow bufferOverflow, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        return b(i2, bufferOverflow, function1);
    }

    public static final <T> T e(@NotNull Object obj, @NotNull Function1<? super Throwable, ? extends T> function1) {
        return obj instanceof ChannelResult.Failed ? function1.f(ChannelResult.f(obj)) : obj;
    }

    @NotNull
    public static final <T> Object f(@NotNull Object obj, @NotNull Function1<? super Throwable, Unit> function1) {
        if (obj instanceof ChannelResult.Closed) {
            function1.f(ChannelResult.f(obj));
        }
        return obj;
    }

    @NotNull
    public static final <T> Object g(@NotNull Object obj, @NotNull Function1<? super Throwable, Unit> function1) {
        if (obj instanceof ChannelResult.Failed) {
            function1.f(ChannelResult.f(obj));
        }
        return obj;
    }

    @NotNull
    public static final <T> Object h(@NotNull Object obj, @NotNull Function1<? super T, Unit> function1) {
        if (!(obj instanceof ChannelResult.Failed)) {
            function1.f(obj);
        }
        return obj;
    }
}
