package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aE\u0010\u0007\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0002\b\u0005H\b¢\u0006\u0004\b\u0007\u0010\b\u001a)\u0010\n\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0000*\u00020\t*\b\u0012\u0004\u0012\u00028\u00000\u0004H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\"\b\b\u0000\u0010\u0000*\u00020\t*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001aR\u0010\u000f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00042\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0002\b\u0005H\b\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a7\u0010\u0013\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u0003HHø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u000b\u001a7\u0010\u0017\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u0003HHø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a!\u0010\u001b\u001a\u00020\u0011*\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\"\u0014\u0010\u001e\u001a\u00020\u001d8\u0000XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"E", "R", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlin/ExtensionFunctionType;", "block", "b", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "i", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectClause1;", "h", "(Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlinx/coroutines/selects/SelectClause1;", "c", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "action", "e", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "j", "d", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "a", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Throwable;)V", "", "DEFAULT_CLOSE_MESSAGE", "Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/channels/ChannelsKt")
final /* synthetic */ class ChannelsKt__Channels_commonKt {
    @PublishedApi
    public static final void a(@NotNull ReceiveChannel<?> receiveChannel, @Nullable Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = ExceptionsKt.a("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.i(cancellationException);
    }

    @ObsoleteCoroutinesApi
    public static final <E, R> R b(@NotNull BroadcastChannel<E> broadcastChannel, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        ReceiveChannel<E> V = broadcastChannel.V();
        try {
            return function1.f(V);
        } finally {
            InlineMarker.d(1);
            ReceiveChannel.DefaultImpls.b(V, (CancellationException) null, 1, (Object) null);
            InlineMarker.c(1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        kotlin.jvm.internal.InlineMarker.d(1);
        kotlinx.coroutines.channels.ChannelsKt.b(r2, r3);
        kotlin.jvm.internal.InlineMarker.c(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E, R> R c(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.channels.ReceiveChannel<? extends E>, ? extends R> r3) {
        /*
            r0 = 1
            java.lang.Object r3 = r3.f(r2)     // Catch:{ all -> 0x0010 }
            kotlin.jvm.internal.InlineMarker.d(r0)
            r1 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r2, r1)
            kotlin.jvm.internal.InlineMarker.c(r0)
            return r3
        L_0x0010:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r0)
            kotlinx.coroutines.channels.ChannelsKt.b(r2, r3)
            kotlin.jvm.internal.InlineMarker.c(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.c(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d A[Catch:{ all -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    @kotlinx.coroutines.ObsoleteCoroutinesApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object d(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BroadcastChannel<E> r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, kotlin.Unit> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$3
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r4) goto L_0x003c
            java.lang.Object r6 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.Z
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.n(r8)     // Catch:{ all -> 0x003a }
            r5 = r0
            r0 = r7
            r7 = r2
        L_0x0038:
            r2 = r5
            goto L_0x0065
        L_0x003a:
            r6 = move-exception
            goto L_0x008d
        L_0x003c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0044:
            kotlin.ResultKt.n(r8)
            kotlinx.coroutines.channels.ReceiveChannel r6 = r6.V()
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x0089 }
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0052:
            r0.Z = r7     // Catch:{ all -> 0x0086 }
            r0.X2 = r8     // Catch:{ all -> 0x0086 }
            r0.Y2 = r6     // Catch:{ all -> 0x0086 }
            r0.a3 = r4     // Catch:{ all -> 0x0086 }
            java.lang.Object r2 = r6.a(r0)     // Catch:{ all -> 0x0086 }
            if (r2 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L_0x0038
        L_0x0065:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0077 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0077 }
            if (r8 == 0) goto L_0x007a
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0077 }
            r7.f(r8)     // Catch:{ all -> 0x0077 }
            r8 = r0
            r0 = r2
            goto L_0x0052
        L_0x0077:
            r6 = move-exception
            r7 = r0
            goto L_0x008d
        L_0x007a:
            kotlin.Unit r6 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0077 }
            kotlin.jvm.internal.InlineMarker.d(r4)
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.b(r0, r3, r4, r3)
            kotlin.jvm.internal.InlineMarker.c(r4)
            return r6
        L_0x0086:
            r6 = move-exception
            r7 = r8
            goto L_0x008d
        L_0x0089:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x008d:
            kotlin.jvm.internal.InlineMarker.d(r4)
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.b(r7, r3, r4, r3)
            kotlin.jvm.internal.InlineMarker.c(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.d(kotlinx.coroutines.channels.BroadcastChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, kotlin.Unit> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r5 = r0.Y2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.Z
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.n(r7)     // Catch:{ all -> 0x0035 }
            goto L_0x005c
        L_0x0035:
            r5 = move-exception
            goto L_0x007e
        L_0x0037:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003f:
            kotlin.ResultKt.n(r7)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch:{ all -> 0x007a }
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L_0x004a:
            r0.Z = r7     // Catch:{ all -> 0x0035 }
            r0.X2 = r6     // Catch:{ all -> 0x0035 }
            r0.Y2 = r5     // Catch:{ all -> 0x0035 }
            r0.a3 = r3     // Catch:{ all -> 0x0035 }
            java.lang.Object r2 = r5.a(r0)     // Catch:{ all -> 0x0035 }
            if (r2 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r4 = r2
            r2 = r7
            r7 = r4
        L_0x005c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0035 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x006d
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0035 }
            r2.f(r7)     // Catch:{ all -> 0x0035 }
            r7 = r2
            goto L_0x004a
        L_0x006d:
            kotlin.Unit r5 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0035 }
            kotlin.jvm.internal.InlineMarker.d(r3)
            r7 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r7)
            kotlin.jvm.internal.InlineMarker.c(r3)
            return r5
        L_0x007a:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x007e:
            throw r5     // Catch:{ all -> 0x007f }
        L_0x007f:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r3)
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r5)
            kotlin.jvm.internal.InlineMarker.c(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.e(kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @ObsoleteCoroutinesApi
    private static final <E> Object f(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel<E> V = broadcastChannel.V();
        try {
            ChannelIterator<E> it2 = V.iterator();
            while (true) {
                InlineMarker.e(3);
                InlineMarker.e(0);
                Object a2 = it2.a((Continuation<? super Boolean>) null);
                InlineMarker.e(1);
                if (((Boolean) a2).booleanValue()) {
                    function1.f(it2.next());
                } else {
                    Unit unit = Unit.f28779a;
                    InlineMarker.d(1);
                    ReceiveChannel.DefaultImpls.b(V, (CancellationException) null, 1, (Object) null);
                    InlineMarker.c(1);
                    return unit;
                }
            }
        } catch (Throwable th) {
            InlineMarker.d(1);
            ReceiveChannel.DefaultImpls.b(V, (CancellationException) null, 1, (Object) null);
            InlineMarker.c(1);
            throw th;
        }
    }

    private static final <E> Object g(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        try {
            ChannelIterator<? extends E> it2 = receiveChannel.iterator();
            while (true) {
                InlineMarker.e(3);
                InlineMarker.e(0);
                Object a2 = it2.a((Continuation<? super Boolean>) null);
                InlineMarker.e(1);
                if (((Boolean) a2).booleanValue()) {
                    function1.f(it2.next());
                } else {
                    Unit unit = Unit.f28779a;
                    InlineMarker.d(1);
                    ChannelsKt.b(receiveChannel, (Throwable) null);
                    InlineMarker.c(1);
                    return unit;
                }
            }
        } catch (Throwable th) {
            InlineMarker.d(1);
            ChannelsKt.b(receiveChannel, th);
            InlineMarker.c(1);
            throw th;
        }
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final <E> SelectClause1<E> h(@NotNull ReceiveChannel<? extends E> receiveChannel) {
        return receiveChannel.z();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @Nullable
    public static final <E> Object i(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super E> continuation) {
        return receiveChannel.D(continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> java.lang.Object j(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends E>> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1 r0 = (kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1) r0
            int r1 = r0.b3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1 r0 = new kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.a3
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.b3
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r7 = r0.Z2
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r2 = r0.Y2
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r4 = r0.X2
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.Z
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.n(r8)     // Catch:{ all -> 0x0039 }
            goto L_0x0067
        L_0x0039:
            r7 = move-exception
            r8 = r2
            goto L_0x0089
        L_0x003c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0044:
            kotlin.ResultKt.n(r8)
            java.util.List r8 = kotlin.collections.CollectionsKt.i()
            kotlinx.coroutines.channels.ChannelIterator r2 = r7.iterator()     // Catch:{ all -> 0x0085 }
            r4 = r8
            r5 = r4
            r8 = r7
            r7 = r2
        L_0x0053:
            r0.Z = r5     // Catch:{ all -> 0x0083 }
            r0.X2 = r4     // Catch:{ all -> 0x0083 }
            r0.Y2 = r8     // Catch:{ all -> 0x0083 }
            r0.Z2 = r7     // Catch:{ all -> 0x0083 }
            r0.b3 = r3     // Catch:{ all -> 0x0083 }
            java.lang.Object r2 = r7.a(r0)     // Catch:{ all -> 0x0083 }
            if (r2 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r6 = r2
            r2 = r8
            r8 = r6
        L_0x0067:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0039 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0039 }
            if (r8 == 0) goto L_0x0078
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0039 }
            r4.add(r8)     // Catch:{ all -> 0x0039 }
            r8 = r2
            goto L_0x0053
        L_0x0078:
            kotlin.Unit r7 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0039 }
            r7 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r2, r7)
            java.util.List r7 = kotlin.collections.CollectionsKt.a(r5)
            return r7
        L_0x0083:
            r7 = move-exception
            goto L_0x0089
        L_0x0085:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x0089:
            throw r7     // Catch:{ all -> 0x008a }
        L_0x008a:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r8, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.j(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
