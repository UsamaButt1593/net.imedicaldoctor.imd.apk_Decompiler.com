package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H¦@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0001\u0010\u0004J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH¦\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u000e2\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0004\b\u0017\u0010\u0007J\u0015\u0010\u0018\u001a\u0004\u0018\u00018\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001d\u0010\u001aR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R#\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u001f8&X¦\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b#\u0010!R\"\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001f8VX\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0012\u001a\u0004\b%\u0010!\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "", "Q", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "B", "()Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "i", "(Ljava/util/concurrent/CancellationException;)V", "cancel", "()V", "", "", "d", "(Ljava/lang/Throwable;)Z", "poll", "D", "l", "()Z", "isClosedForReceive$annotations", "isClosedForReceive", "isEmpty", "isEmpty$annotations", "Lkotlinx/coroutines/selects/SelectClause1;", "m", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "o", "onReceiveCatching", "z", "getOnReceiveOrNull$annotations", "onReceiveOrNull", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface ReceiveChannel<E> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void b(ReceiveChannel receiveChannel, CancellationException cancellationException, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    cancellationException = null;
                }
                receiveChannel.i(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ boolean c(ReceiveChannel receiveChannel, Throwable th, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    th = null;
                }
                return receiveChannel.d(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        @NotNull
        public static <E> SelectClause1<E> d(@NotNull ReceiveChannel<? extends E> receiveChannel) {
            return new ReceiveChannel$onReceiveOrNull$1(receiveChannel);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of onReceiveCatching extension", replaceWith = @ReplaceWith(expression = "onReceiveCatching", imports = {}))
        public static /* synthetic */ void e() {
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void f() {
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void g() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
        @Nullable
        public static <E> E h(@NotNull ReceiveChannel<? extends E> receiveChannel) {
            Object B = receiveChannel.B();
            if (ChannelResult.m(B)) {
                return ChannelResult.i(B);
            }
            Throwable f2 = ChannelResult.f(B);
            if (f2 == null) {
                return null;
            }
            throw StackTraceRecoveryKt.p(f2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        @org.jetbrains.annotations.Nullable
        @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @kotlin.ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
        @kotlin.internal.LowPriorityInOverloadResolution
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static <E> java.lang.Object i(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r5) {
            /*
                boolean r0 = r5 instanceof kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1
                if (r0 == 0) goto L_0x0013
                r0 = r5
                kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1 r0 = (kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1) r0
                int r1 = r0.X2
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.X2 = r1
                goto L_0x0018
            L_0x0013:
                kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1 r0 = new kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1
                r0.<init>(r5)
            L_0x0018:
                java.lang.Object r5 = r0.Z
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
                int r2 = r0.X2
                r3 = 1
                if (r2 == 0) goto L_0x0037
                if (r2 != r3) goto L_0x002f
                kotlin.ResultKt.n(r5)
                kotlinx.coroutines.channels.ChannelResult r5 = (kotlinx.coroutines.channels.ChannelResult) r5
                java.lang.Object r4 = r5.o()
                goto L_0x0043
            L_0x002f:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L_0x0037:
                kotlin.ResultKt.n(r5)
                r0.X2 = r3
                java.lang.Object r4 = r4.E(r0)
                if (r4 != r1) goto L_0x0043
                return r1
            L_0x0043:
                java.lang.Object r4 = kotlinx.coroutines.channels.ChannelResult.h(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.i(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @NotNull
    Object B();

    @Nullable
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    Object D(@NotNull Continuation<? super E> continuation);

    @Nullable
    Object E(@NotNull Continuation<? super ChannelResult<? extends E>> continuation);

    @Nullable
    Object Q(@NotNull Continuation<? super E> continuation);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean d(Throwable th);

    void i(@Nullable CancellationException cancellationException);

    boolean isEmpty();

    @NotNull
    ChannelIterator<E> iterator();

    boolean l();

    @NotNull
    SelectClause1<E> m();

    @NotNull
    SelectClause1<ChannelResult<E>> o();

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    E poll();

    @NotNull
    SelectClause1<E> z();
}
