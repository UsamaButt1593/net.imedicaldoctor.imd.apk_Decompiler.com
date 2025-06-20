package kotlinx.coroutines.channels;

import androidx.concurrent.futures.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 D*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004EFGHB\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0006J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\f2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0018\u00010\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0017\u0010\u0018JX\u0010!\u001a\u00020\t\"\u0004\b\u0001\u0010\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001a2\u0006\u0010\u0015\u001a\u00028\u00002(\u0010 \u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010'\u001a\u00020&2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b'\u0010(J)\u0010,\u001a\u00020\t2\u0018\u0010+\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\t0)j\u0002`*H\u0016¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u00020&2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0017¢\u0006\u0004\b.\u0010(J\u001f\u00101\u001a\u00020\t2\u000e\u0010\u0012\u001a\n\u0018\u00010/j\u0004\u0018\u0001`0H\u0016¢\u0006\u0004\b1\u00102J\u001b\u00103\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b3\u00104J&\u00106\u001a\b\u0012\u0004\u0012\u00020\t052\u0006\u0010\u0015\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b6\u00107R\u0017\u0010\u0005\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b:\u0010\u0004\u001a\u0004\b8\u00109R\u0013\u0010<\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b;\u00109R\u0014\u0010?\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R&\u0010C\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d0@8VX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "<init>", "()V", "value", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "subscriber", "", "f", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "", "list", "e", "([Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "n", "", "cause", "k", "(Ljava/lang/Throwable;)V", "element", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "l", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "block", "m", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlinx/coroutines/channels/ReceiveChannel;", "V", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "", "T", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "X", "(Lkotlin/jvm/functions/Function1;)V", "d", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "i", "(Ljava/util/concurrent/CancellationException;)V", "g0", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "Y", "(Ljava/lang/Object;)Ljava/lang/Object;", "g", "()Ljava/lang/Object;", "h", "j", "valueOrNull", "i0", "()Z", "isClosedForSend", "Lkotlinx/coroutines/selects/SelectClause2;", "G", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "s", "Closed", "Companion", "State", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@ObsoleteCoroutinesApi
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater X;
    @NotNull
    @Deprecated
    private static final Closed X2 = new Closed((Throwable) null);
    private static final /* synthetic */ AtomicIntegerFieldUpdater Y;
    @NotNull
    @Deprecated
    private static final Symbol Y2;
    private static final /* synthetic */ AtomicReferenceFieldUpdater Z;
    @NotNull
    @Deprecated
    private static final State<Object> Z2;
    @NotNull
    private static final Companion s = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private volatile /* synthetic */ Object _state;
    @NotNull
    private volatile /* synthetic */ int _updating;
    @NotNull
    private volatile /* synthetic */ Object onCloseHandler;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "", "", "closeCause", "<init>", "(Ljava/lang/Throwable;)V", "a", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "sendException", "b", "valueException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class Closed {
        @Nullable
        @JvmField

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f29248a;

        public Closed(@Nullable Throwable th) {
            this.f29248a = th;
        }

        @NotNull
        public final Throwable a() {
            Throwable th = this.f29248a;
            return th == null ? new ClosedSendChannelException(ChannelsKt.f29247a) : th;
        }

        @NotNull
        public final Throwable b() {
            Throwable th = this.f29248a;
            return th == null ? new IllegalStateException(ChannelsKt.f29247a) : th;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Companion;", "", "()V", "CLOSED", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "INITIAL_STATE", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B'\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "E", "", "value", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "subscribers", "<init>", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "a", "Ljava/lang/Object;", "b", "[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class State<E> {
        @Nullable
        @JvmField

        /* renamed from: a  reason: collision with root package name */
        public final Object f29249a;
        @Nullable
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<E>[] f29250b;

        public State(@Nullable Object obj, @Nullable Subscriber<E>[] subscriberArr) {
            this.f29249a = obj;
            this.f29250b = subscriberArr;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/ConflatedChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "broadcastChannel", "<init>", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "", "wasClosed", "", "h0", "(Z)V", "element", "", "F", "(Ljava/lang/Object;)Ljava/lang/Object;", "Y2", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class Subscriber<E> extends ConflatedChannel<E> implements ReceiveChannel<E> {
        @NotNull
        private final ConflatedBroadcastChannel<E> Y2;

        public Subscriber(@NotNull ConflatedBroadcastChannel<E> conflatedBroadcastChannel) {
            super((Function1) null);
            this.Y2 = conflatedBroadcastChannel;
        }

        @NotNull
        public Object F(E e2) {
            return super.F(e2);
        }

        /* access modifiers changed from: protected */
        public void h0(boolean z) {
            if (z) {
                this.Y2.f(this);
            }
        }
    }

    static {
        Symbol symbol = new Symbol("UNDEFINED");
        Y2 = symbol;
        Z2 = new State<>(symbol, (Subscriber<E>[]) null);
        Class<ConflatedBroadcastChannel> cls = ConflatedBroadcastChannel.class;
        Class<Object> cls2 = Object.class;
        X = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        Y = AtomicIntegerFieldUpdater.newUpdater(cls, "_updating");
        Z = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "onCloseHandler");
    }

    public ConflatedBroadcastChannel() {
        this._state = Z2;
        this._updating = 0;
        this.onCloseHandler = null;
    }

    private final Subscriber<E>[] e(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        if (subscriberArr != null) {
            return (Subscriber[]) ArraysKt.w3(subscriberArr, subscriber);
        }
        return new Subscriber[]{subscriber};
    }

    /* access modifiers changed from: private */
    public final void f(Subscriber<E> subscriber) {
        Object obj;
        Object obj2;
        Subscriber<E>[] subscriberArr;
        do {
            obj = this._state;
            if (!(obj instanceof Closed)) {
                if (obj instanceof State) {
                    State state = (State) obj;
                    obj2 = state.f29249a;
                    subscriberArr = state.f29250b;
                    Intrinsics.m(subscriberArr);
                } else {
                    throw new IllegalStateException(("Invalid state " + obj).toString());
                }
            } else {
                return;
            }
        } while (!a.a(X, this, obj, new State(obj2, n(subscriberArr, subscriber))));
    }

    public static /* synthetic */ void h() {
    }

    private final void k(Throwable th) {
        Symbol symbol;
        Object obj = this.onCloseHandler;
        if (obj != null && obj != (symbol = AbstractChannelKt.f29231h) && a.a(Z, this, obj, symbol)) {
            ((Function1) TypeIntrinsics.q(obj, 1)).f(th);
        }
    }

    private final Closed l(E e2) {
        Object obj;
        if (!Y.compareAndSet(this, 0, 1)) {
            return null;
        }
        do {
            try {
                obj = this._state;
                if (obj instanceof Closed) {
                    Closed closed = (Closed) obj;
                    this._updating = 0;
                    return closed;
                } else if (obj instanceof State) {
                } else {
                    throw new IllegalStateException(("Invalid state " + obj).toString());
                }
            } finally {
                this._updating = 0;
            }
        } while (!a.a(X, this, obj, new State(e2, ((State) obj).f29250b)));
        Subscriber<E>[] subscriberArr = ((State) obj).f29250b;
        if (subscriberArr != null) {
            for (Subscriber<E> F : subscriberArr) {
                F.F(e2);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final <R> void m(SelectInstance<? super R> selectInstance, E e2, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        if (selectInstance.y()) {
            Closed l2 = l(e2);
            if (l2 != null) {
                selectInstance.g0(l2.a());
            } else {
                UndispatchedKt.d(function2, this, selectInstance.J());
            }
        }
    }

    private final Subscriber<E>[] n(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        int length = subscriberArr.length;
        int If = ArraysKt.If(subscriberArr, subscriber);
        if (length == 1) {
            return null;
        }
        Subscriber<E>[] subscriberArr2 = new Subscriber[(length - 1)];
        Subscriber<E>[] subscriberArr3 = subscriberArr;
        Subscriber<E>[] subscriberArr4 = subscriberArr2;
        ArraysKt.K0(subscriberArr3, subscriberArr4, 0, 0, If, 6, (Object) null);
        ArraysKt.K0(subscriberArr3, subscriberArr4, If, If + 1, 0, 8, (Object) null);
        return subscriberArr2;
    }

    @NotNull
    public SelectClause2<E, SendChannel<E>> G() {
        return new ConflatedBroadcastChannel$onSend$1(this);
    }

    /* renamed from: T */
    public boolean d(@Nullable Throwable th) {
        Object obj;
        int i2;
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                return false;
            }
            if (!(obj instanceof State)) {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!a.a(X, this, obj, th == null ? X2 : new Closed(th)));
        Subscriber<E>[] subscriberArr = ((State) obj).f29250b;
        if (subscriberArr != null) {
            for (Subscriber<E> T : subscriberArr) {
                T.T(th);
            }
        }
        k(th);
        return true;
    }

    @NotNull
    public ReceiveChannel<E> V() {
        Object obj;
        State state;
        Subscriber subscriber = new Subscriber(this);
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                subscriber.T(((Closed) obj).f29248a);
                return subscriber;
            } else if (obj instanceof State) {
                state = (State) obj;
                Object obj2 = state.f29249a;
                if (obj2 != Y2) {
                    subscriber.F(obj2);
                }
            } else {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!a.a(X, this, obj, new State(state.f29249a, e(state.f29250b, subscriber))));
        return subscriber;
    }

    public void X(@NotNull Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = Z;
        if (!a.a(atomicReferenceFieldUpdater, this, (Object) null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.f29231h) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Object obj2 = this._state;
        if ((obj2 instanceof Closed) && a.a(atomicReferenceFieldUpdater, this, function1, AbstractChannelKt.f29231h)) {
            function1.f(((Closed) obj2).f29248a);
        }
    }

    @NotNull
    public Object Y(E e2) {
        Closed l2 = l(e2);
        return l2 != null ? ChannelResult.f29243b.a(l2.a()) : ChannelResult.f29243b.c(Unit.f28779a);
    }

    public final E g() {
        Object obj = this._state;
        if (obj instanceof Closed) {
            throw ((Closed) obj).b();
        } else if (obj instanceof State) {
            E e2 = ((State) obj).f29249a;
            if (e2 != Y2) {
                return e2;
            }
            throw new IllegalStateException("No value");
        } else {
            throw new IllegalStateException(("Invalid state " + obj).toString());
        }
    }

    @Nullable
    public Object g0(E e2, @NotNull Continuation<? super Unit> continuation) {
        Closed l2 = l(e2);
        if (l2 != null) {
            throw l2.a();
        } else if (IntrinsicsKt.l() == null) {
            return null;
        } else {
            return Unit.f28779a;
        }
    }

    public void i(@Nullable CancellationException cancellationException) {
        d(cancellationException);
    }

    public boolean i0() {
        return this._state instanceof Closed;
    }

    @Nullable
    public final E j() {
        Object obj = this._state;
        if (obj instanceof Closed) {
            return null;
        }
        if (obj instanceof State) {
            E e2 = Y2;
            E e3 = ((State) obj).f29249a;
            if (e3 == e2) {
                return null;
            }
            return e3;
        }
        throw new IllegalStateException(("Invalid state " + obj).toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e2) {
        return BroadcastChannel.DefaultImpls.c(this, e2);
    }

    public ConflatedBroadcastChannel(E e2) {
        this();
        X.lazySet(this, new State(e2, (Subscriber<E>[]) null));
    }
}
