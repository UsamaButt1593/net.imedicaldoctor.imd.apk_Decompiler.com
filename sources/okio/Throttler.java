package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0005J+\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0013\u0010\bJ\u001f\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001fR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001f¨\u0006\""}, d2 = {"Lokio/Throttler;", "", "", "allocatedUntil", "<init>", "(J)V", "()V", "g", "(J)J", "f", "nanosToWait", "", "k", "bytesPerSecond", "waitByteCount", "maxByteCount", "d", "(JJJ)V", "byteCount", "j", "now", "a", "(JJ)J", "Lokio/Source;", "source", "i", "(Lokio/Source;)Lokio/Source;", "Lokio/Sink;", "sink", "h", "(Lokio/Sink;)Lokio/Sink;", "J", "b", "c", "okio"}, k = 1, mv = {1, 5, 1})
public final class Throttler {

    /* renamed from: a  reason: collision with root package name */
    private long f31395a;

    /* renamed from: b  reason: collision with root package name */
    private long f31396b;

    /* renamed from: c  reason: collision with root package name */
    private long f31397c;

    /* renamed from: d  reason: collision with root package name */
    private long f31398d;

    public Throttler() {
        this(System.nanoTime());
    }

    public static /* synthetic */ void e(Throttler throttler, long j2, long j3, long j4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j3 = throttler.f31397c;
        }
        long j5 = j3;
        if ((i2 & 4) != 0) {
            j4 = throttler.f31398d;
        }
        throttler.d(j2, j5, j4);
    }

    private final long f(long j2) {
        return (j2 * C.f9093k) / this.f31396b;
    }

    private final long g(long j2) {
        return (j2 * this.f31396b) / C.f9093k;
    }

    private final void k(long j2) {
        long j3 = j2 / 1000000;
        wait(j3, (int) (j2 - (1000000 * j3)));
    }

    public final long a(long j2, long j3) {
        long f2;
        if (this.f31396b == 0) {
            return j3;
        }
        long max = Math.max(this.f31395a - j2, 0);
        long g2 = this.f31398d - g(max);
        if (g2 >= j3) {
            j2 += max;
            f2 = f(j3);
        } else {
            long j4 = this.f31397c;
            if (g2 >= j4) {
                this.f31395a = j2 + f(this.f31398d);
                return g2;
            }
            j3 = Math.min(j4, j3);
            long f3 = max + f(j3 - this.f31398d);
            if (f3 != 0) {
                return -f3;
            }
            f2 = f(this.f31398d);
        }
        this.f31395a = j2 + f2;
        return j3;
    }

    @JvmOverloads
    public final void b(long j2) {
        e(this, j2, 0, 0, 6, (Object) null);
    }

    @JvmOverloads
    public final void c(long j2, long j3) {
        e(this, j2, j3, 0, 4, (Object) null);
    }

    @JvmOverloads
    public final void d(long j2, long j3, long j4) {
        synchronized (this) {
            boolean z = false;
            if (j2 >= 0) {
                if (j3 > 0) {
                    if (j4 >= j3) {
                        z = true;
                    }
                    if (z) {
                        this.f31396b = j2;
                        this.f31397c = j3;
                        this.f31398d = j4;
                        notifyAll();
                        Unit unit = Unit.f28779a;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    @NotNull
    public final Sink h(@NotNull Sink sink) {
        Intrinsics.p(sink, "sink");
        return new Throttler$sink$1(this, sink);
    }

    @NotNull
    public final Source i(@NotNull Source source) {
        Intrinsics.p(source, "source");
        return new Throttler$source$1(this, source);
    }

    public final long j(long j2) {
        long a2;
        if (j2 > 0) {
            synchronized (this) {
                while (true) {
                    a2 = a(System.nanoTime(), j2);
                    if (a2 < 0) {
                        k(-a2);
                    }
                }
            }
            return a2;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public Throttler(long j2) {
        this.f31395a = j2;
        this.f31397c = PlaybackStateCompat.s3;
        this.f31398d = PlaybackStateCompat.x3;
    }
}
