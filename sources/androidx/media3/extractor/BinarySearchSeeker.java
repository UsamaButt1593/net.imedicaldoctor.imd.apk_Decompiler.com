package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import java.io.IOException;

@UnstableApi
public abstract class BinarySearchSeeker {

    /* renamed from: e  reason: collision with root package name */
    private static final long f12935e = 262144;

    /* renamed from: a  reason: collision with root package name */
    protected final BinarySearchSeekMap f12936a;

    /* renamed from: b  reason: collision with root package name */
    protected final TimestampSeeker f12937b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    protected SeekOperationParams f12938c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12939d;

    public static class BinarySearchSeekMap implements SeekMap {

        /* renamed from: d  reason: collision with root package name */
        private final SeekTimestampConverter f12940d;

        /* renamed from: e  reason: collision with root package name */
        private final long f12941e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final long f12942f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final long f12943g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public final long f12944h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public final long f12945i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public final long f12946j;

        public BinarySearchSeekMap(SeekTimestampConverter seekTimestampConverter, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.f12940d = seekTimestampConverter;
            this.f12941e = j2;
            this.f12942f = j3;
            this.f12943g = j4;
            this.f12944h = j5;
            this.f12945i = j6;
            this.f12946j = j7;
        }

        public boolean g() {
            return true;
        }

        public long i(long j2) {
            return this.f12940d.a(j2);
        }

        public SeekMap.SeekPoints j(long j2) {
            return new SeekMap.SeekPoints(new SeekPoint(j2, SeekOperationParams.h(this.f12940d.a(j2), this.f12942f, this.f12943g, this.f12944h, this.f12945i, this.f12946j)));
        }

        public long l() {
            return this.f12941e;
        }
    }

    public static final class DefaultSeekTimestampConverter implements SeekTimestampConverter {
        public long a(long j2) {
            return j2;
        }
    }

    protected static class SeekOperationParams {

        /* renamed from: a  reason: collision with root package name */
        private final long f12947a;

        /* renamed from: b  reason: collision with root package name */
        private final long f12948b;

        /* renamed from: c  reason: collision with root package name */
        private final long f12949c;

        /* renamed from: d  reason: collision with root package name */
        private long f12950d;

        /* renamed from: e  reason: collision with root package name */
        private long f12951e;

        /* renamed from: f  reason: collision with root package name */
        private long f12952f;

        /* renamed from: g  reason: collision with root package name */
        private long f12953g;

        /* renamed from: h  reason: collision with root package name */
        private long f12954h;

        protected SeekOperationParams(long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
            this.f12947a = j2;
            this.f12948b = j3;
            this.f12950d = j4;
            this.f12951e = j5;
            this.f12952f = j6;
            this.f12953g = j7;
            this.f12949c = j8;
            this.f12954h = h(j3, j4, j5, j6, j7, j8);
        }

        protected static long h(long j2, long j3, long j4, long j5, long j6, long j7) {
            if (j5 + 1 >= j6 || j3 + 1 >= j4) {
                return j5;
            }
            long j8 = (long) (((float) (j2 - j3)) * (((float) (j6 - j5)) / ((float) (j4 - j3))));
            return Util.x(((j8 + j5) - j7) - (j8 / 20), j5, j6 - 1);
        }

        /* access modifiers changed from: private */
        public long i() {
            return this.f12953g;
        }

        /* access modifiers changed from: private */
        public long j() {
            return this.f12952f;
        }

        /* access modifiers changed from: private */
        public long k() {
            return this.f12954h;
        }

        /* access modifiers changed from: private */
        public long l() {
            return this.f12947a;
        }

        /* access modifiers changed from: private */
        public long m() {
            return this.f12948b;
        }

        private void n() {
            this.f12954h = h(this.f12948b, this.f12950d, this.f12951e, this.f12952f, this.f12953g, this.f12949c);
        }

        /* access modifiers changed from: private */
        public void o(long j2, long j3) {
            this.f12951e = j2;
            this.f12953g = j3;
            n();
        }

        /* access modifiers changed from: private */
        public void p(long j2, long j3) {
            this.f12950d = j2;
            this.f12952f = j3;
            n();
        }
    }

    protected interface SeekTimestampConverter {
        long a(long j2);
    }

    public static final class TimestampSearchResult {

        /* renamed from: d  reason: collision with root package name */
        public static final int f12955d = 0;

        /* renamed from: e  reason: collision with root package name */
        public static final int f12956e = -1;

        /* renamed from: f  reason: collision with root package name */
        public static final int f12957f = -2;

        /* renamed from: g  reason: collision with root package name */
        public static final int f12958g = -3;

        /* renamed from: h  reason: collision with root package name */
        public static final TimestampSearchResult f12959h = new TimestampSearchResult(-3, C.f9084b, -1);
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f12960a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f12961b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f12962c;

        private TimestampSearchResult(int i2, long j2, long j3) {
            this.f12960a = i2;
            this.f12961b = j2;
            this.f12962c = j3;
        }

        public static TimestampSearchResult d(long j2, long j3) {
            return new TimestampSearchResult(-1, j2, j3);
        }

        public static TimestampSearchResult e(long j2) {
            return new TimestampSearchResult(0, C.f9084b, j2);
        }

        public static TimestampSearchResult f(long j2, long j3) {
            return new TimestampSearchResult(-2, j2, j3);
        }
    }

    protected interface TimestampSeeker {
        TimestampSearchResult a(ExtractorInput extractorInput, long j2) throws IOException;

        void b();
    }

    protected BinarySearchSeeker(SeekTimestampConverter seekTimestampConverter, TimestampSeeker timestampSeeker, long j2, long j3, long j4, long j5, long j6, long j7, int i2) {
        this.f12937b = timestampSeeker;
        this.f12939d = i2;
        this.f12936a = new BinarySearchSeekMap(seekTimestampConverter, j2, j3, j4, j5, j6, j7);
    }

    /* access modifiers changed from: protected */
    public SeekOperationParams a(long j2) {
        long j3 = j2;
        return new SeekOperationParams(j3, this.f12936a.i(j3), this.f12936a.f12942f, this.f12936a.f12943g, this.f12936a.f12944h, this.f12936a.f12945i, this.f12936a.f12946j);
    }

    public final SeekMap b() {
        return this.f12936a;
    }

    public int c(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            SeekOperationParams seekOperationParams = (SeekOperationParams) Assertions.k(this.f12938c);
            long b2 = seekOperationParams.j();
            long c2 = seekOperationParams.i();
            long d2 = seekOperationParams.k();
            if (c2 - b2 <= ((long) this.f12939d)) {
                e(false, b2);
                return g(extractorInput, b2, positionHolder);
            } else if (!i(extractorInput, d2)) {
                return g(extractorInput, d2, positionHolder);
            } else {
                extractorInput.n();
                TimestampSearchResult a2 = this.f12937b.a(extractorInput, seekOperationParams.m());
                int a3 = a2.f12960a;
                if (a3 == -3) {
                    e(false, d2);
                    return g(extractorInput, d2, positionHolder);
                } else if (a3 == -2) {
                    seekOperationParams.p(a2.f12961b, a2.f12962c);
                } else if (a3 == -1) {
                    seekOperationParams.o(a2.f12961b, a2.f12962c);
                } else if (a3 == 0) {
                    i(extractorInput, a2.f12962c);
                    e(true, a2.f12962c);
                    return g(extractorInput, a2.f12962c, positionHolder);
                } else {
                    throw new IllegalStateException("Invalid case");
                }
            }
        }
    }

    public final boolean d() {
        return this.f12938c != null;
    }

    /* access modifiers changed from: protected */
    public final void e(boolean z, long j2) {
        this.f12938c = null;
        this.f12937b.b();
        f(z, j2);
    }

    /* access modifiers changed from: protected */
    public void f(boolean z, long j2) {
    }

    /* access modifiers changed from: protected */
    public final int g(ExtractorInput extractorInput, long j2, PositionHolder positionHolder) {
        if (j2 == extractorInput.getPosition()) {
            return 0;
        }
        positionHolder.f13111a = j2;
        return 1;
    }

    public final void h(long j2) {
        SeekOperationParams seekOperationParams = this.f12938c;
        if (seekOperationParams == null || seekOperationParams.l() != j2) {
            this.f12938c = a(j2);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean i(ExtractorInput extractorInput, long j2) throws IOException {
        long position = j2 - extractorInput.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        extractorInput.o((int) position);
        return true;
    }
}
