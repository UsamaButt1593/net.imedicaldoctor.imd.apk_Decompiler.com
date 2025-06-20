package kotlinx.coroutines.channels;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmInline
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b@\u0018\u0000  *\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003!\"#B\u0016\b\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u001f\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001a\u0001\u0003\u0001\u0004\u0018\u00010\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult;", "T", "", "holder", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "h", "i", "", "f", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "", "n", "(Ljava/lang/Object;)Ljava/lang/String;", "", "j", "(Ljava/lang/Object;)I", "other", "", "d", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "a", "Ljava/lang/Object;", "g", "()V", "m", "(Ljava/lang/Object;)Z", "isSuccess", "l", "isFailure", "k", "isClosed", "b", "Closed", "Companion", "Failed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ChannelResult<T> {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f29243b = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final Failed f29244c = new Failed();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Object f29245a;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Closed;", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "", "cause", "<init>", "(Ljava/lang/Throwable;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class Closed extends Failed {
        @Nullable
        @JvmField

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f29246a;

        public Closed(@Nullable Throwable th) {
            this.f29246a = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Closed) && Intrinsics.g(this.f29246a, ((Closed) obj).f29246a);
        }

        public int hashCode() {
            Throwable th = this.f29246a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "Closed(" + this.f29246a + ASCIIPropertyListParser.f18650h;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u0001H\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u0004H\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ.\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Companion;", "", "<init>", "()V", "E", "value", "Lkotlinx/coroutines/channels/ChannelResult;", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "", "cause", "a", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "failed", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    @InternalCoroutinesApi
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        @InternalCoroutinesApi
        public final <E> Object a(@Nullable Throwable th) {
            return ChannelResult.c(new Closed(th));
        }

        @NotNull
        @InternalCoroutinesApi
        public final <E> Object b() {
            return ChannelResult.c(ChannelResult.f29244c);
        }

        @NotNull
        @InternalCoroutinesApi
        public final <E> Object c(E e2) {
            return ChannelResult.c(e2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Failed;", "", "()V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class Failed {
        @NotNull
        public String toString() {
            return "Failed";
        }
    }

    @PublishedApi
    private /* synthetic */ ChannelResult(Object obj) {
        this.f29245a = obj;
    }

    public static final /* synthetic */ ChannelResult b(Object obj) {
        return new ChannelResult(obj);
    }

    @NotNull
    @PublishedApi
    public static <T> Object c(@Nullable Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof ChannelResult) && Intrinsics.g(obj, ((ChannelResult) obj2).o());
    }

    public static final boolean e(Object obj, Object obj2) {
        return Intrinsics.g(obj, obj2);
    }

    @Nullable
    public static final Throwable f(Object obj) {
        Closed closed = obj instanceof Closed ? (Closed) obj : null;
        if (closed != null) {
            return closed.f29246a;
        }
        return null;
    }

    @PublishedApi
    public static /* synthetic */ void g() {
    }

    @Nullable
    public static final T h(Object obj) {
        if (!(obj instanceof Failed)) {
            return obj;
        }
        return null;
    }

    public static final T i(Object obj) {
        Throwable th;
        if (!(obj instanceof Failed)) {
            return obj;
        }
        if (!(obj instanceof Closed) || (th = ((Closed) obj).f29246a) == null) {
            throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + obj).toString());
        }
        throw th;
    }

    public static int j(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean k(Object obj) {
        return obj instanceof Closed;
    }

    public static final boolean l(Object obj) {
        return obj instanceof Failed;
    }

    public static final boolean m(Object obj) {
        return !(obj instanceof Failed);
    }

    @NotNull
    public static String n(Object obj) {
        if (obj instanceof Closed) {
            return ((Closed) obj).toString();
        }
        return "Value(" + obj + ASCIIPropertyListParser.f18650h;
    }

    public boolean equals(Object obj) {
        return d(this.f29245a, obj);
    }

    public int hashCode() {
        return j(this.f29245a);
    }

    public final /* synthetic */ Object o() {
        return this.f29245a;
    }

    @NotNull
    public String toString() {
        return n(this.f29245a);
    }
}
