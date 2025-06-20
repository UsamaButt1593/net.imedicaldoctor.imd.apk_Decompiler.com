package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0003\u0010\u0002\u001a \u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\b¢\u0006\u0004\b\u0007\u0010\b\u001a\u0010\u0010\n\u001a\u00020\tH\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0010\u0010\f\u001a\u00020\tH\b¢\u0006\u0004\b\f\u0010\u000b\u001a\u0010\u0010\r\u001a\u00020\tH\b¢\u0006\u0004\b\r\u0010\u000b\u001a\u0010\u0010\u000e\u001a\u00020\tH\b¢\u0006\u0004\b\u000e\u0010\u000b\u001a \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\b¢\u0006\u0004\b\u0016\u0010\u0017\"$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0001\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"", "a", "()J", "c", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "k", "(Ljava/lang/Runnable;)Ljava/lang/Runnable;", "", "g", "()V", "h", "e", "j", "", "blocker", "nanos", "d", "(Ljava/lang/Object;J)V", "Ljava/lang/Thread;", "thread", "i", "(Ljava/lang/Thread;)V", "Lkotlinx/coroutines/AbstractTimeSource;", "Lkotlinx/coroutines/AbstractTimeSource;", "b", "()Lkotlinx/coroutines/AbstractTimeSource;", "f", "(Lkotlinx/coroutines/AbstractTimeSource;)V", "timeSource", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class AbstractTimeSourceKt {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static AbstractTimeSource f29147a;

    @InlineOnly
    private static final long a() {
        AbstractTimeSource b2 = b();
        return b2 != null ? b2.a() : System.currentTimeMillis();
    }

    @Nullable
    public static final AbstractTimeSource b() {
        return f29147a;
    }

    @InlineOnly
    private static final long c() {
        AbstractTimeSource b2 = b();
        return b2 != null ? b2.b() : System.nanoTime();
    }

    @InlineOnly
    private static final void d(Object obj, long j2) {
        Unit unit;
        AbstractTimeSource b2 = b();
        if (b2 != null) {
            b2.c(obj, j2);
            unit = Unit.f28779a;
        } else {
            unit = null;
        }
        if (unit == null) {
            LockSupport.parkNanos(obj, j2);
        }
    }

    @InlineOnly
    private static final void e() {
        AbstractTimeSource b2 = b();
        if (b2 != null) {
            b2.d();
        }
    }

    public static final void f(@Nullable AbstractTimeSource abstractTimeSource) {
        f29147a = abstractTimeSource;
    }

    @InlineOnly
    private static final void g() {
        AbstractTimeSource b2 = b();
        if (b2 != null) {
            b2.e();
        }
    }

    @InlineOnly
    private static final void h() {
        AbstractTimeSource b2 = b();
        if (b2 != null) {
            b2.f();
        }
    }

    @InlineOnly
    private static final void i(Thread thread) {
        Unit unit;
        AbstractTimeSource b2 = b();
        if (b2 != null) {
            b2.g(thread);
            unit = Unit.f28779a;
        } else {
            unit = null;
        }
        if (unit == null) {
            LockSupport.unpark(thread);
        }
    }

    @InlineOnly
    private static final void j() {
        AbstractTimeSource b2 = b();
        if (b2 != null) {
            b2.h();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.i(r1);
     */
    @kotlin.internal.InlineOnly
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.Runnable k(java.lang.Runnable r1) {
        /*
            kotlinx.coroutines.AbstractTimeSource r0 = b()
            if (r0 == 0) goto L_0x000e
            java.lang.Runnable r0 = r0.i(r1)
            if (r0 != 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r1 = r0
        L_0x000e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AbstractTimeSourceKt.k(java.lang.Runnable):java.lang.Runnable");
    }
}
