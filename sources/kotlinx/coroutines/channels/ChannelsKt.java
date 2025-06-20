package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
public final class ChannelsKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final String f29247a = "Channel was closed";

    @NotNull
    @PublishedApi
    public static final <E, R> ReceiveChannel<R> J(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ChannelsKt__DeprecatedKt.E(receiveChannel, coroutineContext, function2);
    }

    @NotNull
    @PublishedApi
    public static final <E, R> ReceiveChannel<R> L(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ChannelsKt__DeprecatedKt.G(receiveChannel, coroutineContext, function3);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final <E> SelectClause1<E> U(@NotNull ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__Channels_commonKt.h(receiveChannel);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @Nullable
    public static final <E> Object V(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.i(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @ReplaceWith(expression = "trySendBlocking(element)", imports = {}))
    public static final <E> void X(@NotNull SendChannel<? super E> sendChannel, E e2) {
        ChannelsKt__ChannelsKt.a(sendChannel, e2);
    }

    @PublishedApi
    public static final void b(@NotNull ReceiveChannel<?> receiveChannel, @Nullable Throwable th) {
        ChannelsKt__Channels_commonKt.a(receiveChannel, th);
    }

    @ObsoleteCoroutinesApi
    public static final <E, R> R c(@NotNull BroadcastChannel<E> broadcastChannel, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        return ChannelsKt__Channels_commonKt.b(broadcastChannel, function1);
    }

    public static final <E, R> R d(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        return ChannelsKt__Channels_commonKt.c(receiveChannel, function1);
    }

    @Nullable
    @ObsoleteCoroutinesApi
    public static final <E> Object e(@NotNull BroadcastChannel<E> broadcastChannel, @NotNull Function1<? super E, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        return ChannelsKt__Channels_commonKt.d(broadcastChannel, function1, continuation);
    }

    @Nullable
    @PublishedApi
    public static final <E, C extends SendChannel<? super E>> Object e0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c2, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.W(receiveChannel, c2, continuation);
    }

    @Nullable
    public static final <E> Object f(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        return ChannelsKt__Channels_commonKt.e(receiveChannel, function1, continuation);
    }

    @Nullable
    @PublishedApi
    public static final <E, C extends Collection<? super E>> Object f0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c2, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.X(receiveChannel, c2, continuation);
    }

    @NotNull
    @PublishedApi
    public static final Function1<Throwable, Unit> g(@NotNull ReceiveChannel<?> receiveChannel) {
        return ChannelsKt__DeprecatedKt.b(receiveChannel);
    }

    @Nullable
    public static final <E> Object g0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.j(receiveChannel, continuation);
    }

    @NotNull
    @PublishedApi
    public static final Function1<Throwable, Unit> h(@NotNull ReceiveChannel<?>... receiveChannelArr) {
        return ChannelsKt__DeprecatedKt.c(receiveChannelArr);
    }

    @Nullable
    @PublishedApi
    public static final <K, V, M extends Map<? super K, ? super V>> Object h0(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, @NotNull M m2, @NotNull Continuation<? super M> continuation) {
        return ChannelsKt__DeprecatedKt.Y(receiveChannel, m2, continuation);
    }

    @NotNull
    @PublishedApi
    public static final <E, K> ReceiveChannel<E> k(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ChannelsKt__DeprecatedKt.f(receiveChannel, coroutineContext, function2);
    }

    @Nullable
    @PublishedApi
    public static final <E> Object k0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super Set<E>> continuation) {
        return ChannelsKt__DeprecatedKt.b0(receiveChannel, continuation);
    }

    @NotNull
    public static final <E> Object m0(@NotNull SendChannel<? super E> sendChannel, E e2) {
        return ChannelsKt__ChannelsKt.b(sendChannel, e2);
    }

    @NotNull
    @PublishedApi
    public static final <E, R, V> ReceiveChannel<V> q0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull ReceiveChannel<? extends R> receiveChannel2, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super R, ? extends V> function2) {
        return ChannelsKt__DeprecatedKt.g0(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    @NotNull
    @PublishedApi
    public static final <E> ReceiveChannel<E> s(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ChannelsKt__DeprecatedKt.n(receiveChannel, coroutineContext, function2);
    }

    @NotNull
    @PublishedApi
    public static final <E> ReceiveChannel<E> y(@NotNull ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__DeprecatedKt.t(receiveChannel);
    }
}
