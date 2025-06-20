package okio;

import androidx.lifecycle.g;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000bH\u0002¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\u00020\u000e8\u0006XD¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\"\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000b0\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0012¨\u0006\u001b"}, d2 = {"Lokio/SegmentPool;", "", "<init>", "()V", "Lokio/Segment;", "e", "()Lokio/Segment;", "segment", "", "d", "(Lokio/Segment;)V", "Ljava/util/concurrent/atomic/AtomicReference;", "a", "()Ljava/util/concurrent/atomic/AtomicReference;", "", "b", "I", "c", "()I", "MAX_SIZE", "Lokio/Segment;", "LOCK", "HASH_BUCKET_COUNT", "", "[Ljava/util/concurrent/atomic/AtomicReference;", "hashBuckets", "byteCount", "okio"}, k = 1, mv = {1, 5, 1})
public final class SegmentPool {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final SegmentPool f31389a = new SegmentPool();

    /* renamed from: b  reason: collision with root package name */
    private static final int f31390b = 65536;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Segment f31391c = new Segment(new byte[0], 0, 0, false, false);

    /* renamed from: d  reason: collision with root package name */
    private static final int f31392d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReference<Segment>[] f31393e;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f31392d = highestOneBit;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i2 = 0; i2 < highestOneBit; i2++) {
            atomicReferenceArr[i2] = new AtomicReference<>();
        }
        f31393e = atomicReferenceArr;
    }

    private SegmentPool() {
    }

    private final AtomicReference<Segment> a() {
        return f31393e[(int) (Thread.currentThread().getId() & (((long) f31392d) - 1))];
    }

    @JvmStatic
    public static final void d(@NotNull Segment segment) {
        AtomicReference<Segment> a2;
        Segment segment2;
        Intrinsics.p(segment, "segment");
        if (!(segment.f31387f == null && segment.f31388g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!segment.f31385d && (segment2 = a2.get()) != f31391c) {
            int i2 = segment2 == null ? 0 : segment2.f31384c;
            if (i2 < f31390b) {
                segment.f31387f = segment2;
                segment.f31383b = 0;
                segment.f31384c = i2 + 8192;
                if (!g.a((a2 = f31389a.a()), segment2, segment)) {
                    segment.f31387f = null;
                }
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final Segment e() {
        AtomicReference<Segment> a2 = f31389a.a();
        Segment segment = f31391c;
        Segment andSet = a2.getAndSet(segment);
        if (andSet == segment) {
            return new Segment();
        }
        if (andSet == null) {
            a2.set((Object) null);
            return new Segment();
        }
        a2.set(andSet.f31387f);
        andSet.f31387f = null;
        andSet.f31384c = 0;
        return andSet;
    }

    public final int b() {
        Segment segment = a().get();
        if (segment == null) {
            return 0;
        }
        return segment.f31384c;
    }

    public final int c() {
        return f31390b;
    }
}
