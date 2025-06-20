package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class LongAddables {

    /* renamed from: a  reason: collision with root package name */
    private static final Supplier<LongAddable> f22347a;

    private static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        public void a(long j2) {
            getAndAdd(j2);
        }

        public void b() {
            getAndIncrement();
        }

        public long c() {
            return get();
        }
    }

    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new Supplier<LongAddable>() {
                /* renamed from: a */
                public LongAddable get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable unused) {
            supplier = new Supplier<LongAddable>() {
                /* renamed from: a */
                public LongAddable get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        f22347a = supplier;
    }

    LongAddables() {
    }

    public static LongAddable a() {
        return f22347a.get();
    }
}
