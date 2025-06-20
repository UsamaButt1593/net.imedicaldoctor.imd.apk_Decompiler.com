package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u0004\u0018\u00010\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\u0014\u0010\u000b\u001a\u00020\b8\u0000XT¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0014\u0010\r\u001a\u00020\b8\u0000XT¢\u0006\u0006\n\u0004\b\f\u0010\n\"\u001a\u0010\u0012\u001a\u00020\u000e8\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\t\u0010\u0011\"\u001a\u0010\u0015\u001a\u00020\u000e8\u0000X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u0012\u0004\b\u0014\u0010\u0011\"\u001a\u0010\u0016\u001a\u00020\u000e8\u0000X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u0012\u0004\b\u0013\u0010\u0011\"\u001a\u0010\u0018\u001a\u00020\u000e8\u0000X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u0012\u0004\b\u0017\u0010\u0011\"\u001a\u0010\u0019\u001a\u00020\u000e8\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u0012\u0004\b\f\u0010\u0011\"\u001a\u0010\u001a\u001a\u00020\u000e8\u0000X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u0012\u0004\b\u000f\u0010\u0011*(\b\u0000\u0010\u001e\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u001d0\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"E", "", "Lkotlinx/coroutines/channels/ChannelResult;", "g", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "h", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Object;", "", "a", "I", "RECEIVE_THROWS_ON_CLOSE", "b", "RECEIVE_RESULT", "Lkotlinx/coroutines/internal/Symbol;", "c", "Lkotlinx/coroutines/internal/Symbol;", "()V", "EMPTY", "d", "e", "OFFER_SUCCESS", "OFFER_FAILED", "f", "POLL_FAILED", "ENQUEUE_FAILED", "HANDLER_INVOKED", "Lkotlin/Function1;", "", "", "Handler", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class AbstractChannelKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f29224a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f29225b = 1;
    @NotNull
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final Symbol f29226c = new Symbol("EMPTY");
    @NotNull
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public static final Symbol f29227d = new Symbol("OFFER_SUCCESS");
    @NotNull
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final Symbol f29228e = new Symbol("OFFER_FAILED");
    @NotNull
    @JvmField

    /* renamed from: f  reason: collision with root package name */
    public static final Symbol f29229f = new Symbol("POLL_FAILED");
    @NotNull
    @JvmField

    /* renamed from: g  reason: collision with root package name */
    public static final Symbol f29230g = new Symbol("ENQUEUE_FAILED");
    @NotNull
    @JvmField

    /* renamed from: h  reason: collision with root package name */
    public static final Symbol f29231h = new Symbol("ON_CLOSE_HANDLER_INVOKED");

    public static /* synthetic */ void a() {
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void c() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void e() {
    }

    public static /* synthetic */ void f() {
    }

    private static final <E> Object g(Object obj) {
        return obj instanceof Closed ? ChannelResult.f29243b.a(((Closed) obj).Z) : ChannelResult.f29243b.c(obj);
    }

    private static final <E> Object h(Closed<?> closed) {
        return ChannelResult.f29243b.a(closed.Z);
    }
}
