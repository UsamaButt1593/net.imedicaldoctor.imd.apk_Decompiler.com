package kotlinx.coroutines.internal;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b@\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0014\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\u0001\u0004\u0001\u0004\u0018\u00010\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/internal/SegmentOrClosed;", "Lkotlinx/coroutines/internal/Segment;", "S", "", "value", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "i", "(Ljava/lang/Object;)Ljava/lang/String;", "", "g", "(Ljava/lang/Object;)I", "other", "", "c", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "a", "Ljava/lang/Object;", "h", "(Ljava/lang/Object;)Z", "isClosed", "f", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "e", "()V", "segment", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@JvmInline
public final class SegmentOrClosed<S extends Segment<S>> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Object f29392a;

    private /* synthetic */ SegmentOrClosed(Object obj) {
        this.f29392a = obj;
    }

    public static final /* synthetic */ SegmentOrClosed a(Object obj) {
        return new SegmentOrClosed(obj);
    }

    @NotNull
    public static <S extends Segment<S>> Object b(@Nullable Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof SegmentOrClosed) && Intrinsics.g(obj, ((SegmentOrClosed) obj2).j());
    }

    public static final boolean d(Object obj, Object obj2) {
        return Intrinsics.g(obj, obj2);
    }

    public static /* synthetic */ void e() {
    }

    @NotNull
    public static final S f(Object obj) {
        if (obj == ConcurrentLinkedListKt.f29338b) {
            throw new IllegalStateException("Does not contain segment".toString());
        } else if (obj != null) {
            return (Segment) obj;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        }
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj == ConcurrentLinkedListKt.f29338b;
    }

    public static String i(Object obj) {
        return "SegmentOrClosed(value=" + obj + ASCIIPropertyListParser.f18650h;
    }

    public boolean equals(Object obj) {
        return c(this.f29392a, obj);
    }

    public int hashCode() {
        return g(this.f29392a);
    }

    public final /* synthetic */ Object j() {
        return this.f29392a;
    }

    public String toString() {
        return i(this.f29392a);
    }
}
