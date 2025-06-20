package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/channels/Channel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Q2", "Factory", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface Channel<E> extends SendChannel<E>, ReceiveChannel<E> {
    @NotNull
    public static final Factory Q2 = Factory.f29235a;
    public static final int R2 = Integer.MAX_VALUE;
    public static final int S2 = 0;
    public static final int T2 = -1;
    public static final int U2 = -2;
    public static final int V2 = -3;
    @NotNull
    public static final String W2 = "kotlinx.coroutines.channels.defaultBuffer";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static <E> SelectClause1<E> b(@NotNull Channel<E> channel) {
            return ReceiveChannel.DefaultImpls.d(channel);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean c(@NotNull Channel<E> channel, E e2) {
            return SendChannel.DefaultImpls.c(channel, e2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
        @Nullable
        public static <E> E d(@NotNull Channel<E> channel) {
            return ReceiveChannel.DefaultImpls.h(channel);
        }

        @Nullable
        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
        @LowPriorityInOverloadResolution
        public static <E> Object e(@NotNull Channel<E> channel, @NotNull Continuation<? super E> continuation) {
            return ReceiveChannel.DefaultImpls.i(channel, continuation);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0000XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u00108\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/channels/Channel$Factory;", "", "<init>", "()V", "", "b", "I", "UNLIMITED", "c", "RENDEZVOUS", "d", "CONFLATED", "e", "BUFFERED", "f", "OPTIONAL_CHANNEL", "", "g", "Ljava/lang/String;", "DEFAULT_BUFFER_PROPERTY_NAME", "h", "a", "()I", "CHANNEL_DEFAULT_CAPACITY", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Factory f29235a = new Factory();

        /* renamed from: b  reason: collision with root package name */
        public static final int f29236b = Integer.MAX_VALUE;

        /* renamed from: c  reason: collision with root package name */
        public static final int f29237c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static final int f29238d = -1;

        /* renamed from: e  reason: collision with root package name */
        public static final int f29239e = -2;

        /* renamed from: f  reason: collision with root package name */
        public static final int f29240f = -3;
        @NotNull

        /* renamed from: g  reason: collision with root package name */
        public static final String f29241g = "kotlinx.coroutines.channels.defaultBuffer";

        /* renamed from: h  reason: collision with root package name */
        private static final int f29242h = SystemPropsKt.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        private Factory() {
        }

        public final int a() {
            return f29242h;
        }
    }
}
