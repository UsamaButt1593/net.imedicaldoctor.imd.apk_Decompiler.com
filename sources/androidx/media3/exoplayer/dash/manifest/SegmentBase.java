package androidx.media3.exoplayer.dash.manifest;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.math.BigIntegerMath;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

@UnstableApi
public abstract class SegmentBase {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    final RangedUri f11195a;

    /* renamed from: b  reason: collision with root package name */
    final long f11196b;

    /* renamed from: c  reason: collision with root package name */
    final long f11197c;

    public static abstract class MultiSegmentBase extends SegmentBase {

        /* renamed from: d  reason: collision with root package name */
        final long f11198d;

        /* renamed from: e  reason: collision with root package name */
        final long f11199e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        final List<SegmentTimelineElement> f11200f;

        /* renamed from: g  reason: collision with root package name */
        private final long f11201g;

        /* renamed from: h  reason: collision with root package name */
        private final long f11202h;
        @VisibleForTesting

        /* renamed from: i  reason: collision with root package name */
        final long f11203i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MultiSegmentBase(@Nullable RangedUri rangedUri, long j2, long j3, long j4, long j5, @Nullable List<SegmentTimelineElement> list, long j6, long j7, long j8) {
            super(rangedUri, j2, j3);
            this.f11198d = j4;
            this.f11199e = j5;
            this.f11200f = list;
            this.f11203i = j6;
            this.f11201g = j7;
            this.f11202h = j8;
        }

        public long c(long j2, long j3) {
            long g2 = g(j2);
            return g2 != -1 ? g2 : (long) ((int) (i((j3 - this.f11202h) + this.f11203i, j2) - d(j2, j3)));
        }

        public long d(long j2, long j3) {
            if (g(j2) == -1) {
                long j4 = this.f11201g;
                if (j4 != C.f9084b) {
                    return Math.max(e(), i((j3 - this.f11202h) - j4, j2));
                }
            }
            return e();
        }

        public long e() {
            return this.f11198d;
        }

        public long f(long j2, long j3) {
            if (this.f11200f != null) {
                return C.f9084b;
            }
            long d2 = d(j2, j3) + c(j2, j3);
            return (j(d2) + h(d2, j2)) - this.f11203i;
        }

        public abstract long g(long j2);

        public final long h(long j2, long j3) {
            List<SegmentTimelineElement> list = this.f11200f;
            if (list != null) {
                return (list.get((int) (j2 - this.f11198d)).f11209b * 1000000) / this.f11196b;
            }
            long g2 = g(j3);
            return (g2 == -1 || j2 != (e() + g2) - 1) ? (this.f11199e * 1000000) / this.f11196b : j3 - j(j2);
        }

        public long i(long j2, long j3) {
            long e2 = e();
            long g2 = g(j3);
            if (g2 == 0) {
                return e2;
            }
            if (this.f11200f == null) {
                long j4 = this.f11198d + (j2 / ((this.f11199e * 1000000) / this.f11196b));
                if (j4 < e2) {
                    return e2;
                }
                return g2 == -1 ? j4 : Math.min(j4, (e2 + g2) - 1);
            }
            long j5 = (g2 + e2) - 1;
            long j6 = e2;
            while (j6 <= j5) {
                long j7 = ((j5 - j6) / 2) + j6;
                int i2 = (j(j7) > j2 ? 1 : (j(j7) == j2 ? 0 : -1));
                if (i2 < 0) {
                    j6 = j7 + 1;
                } else if (i2 <= 0) {
                    return j7;
                } else {
                    j5 = j7 - 1;
                }
            }
            return j6 == e2 ? j6 : j5;
        }

        public final long j(long j2) {
            List<SegmentTimelineElement> list = this.f11200f;
            return Util.c2(list != null ? list.get((int) (j2 - this.f11198d)).f11208a - this.f11197c : (j2 - this.f11198d) * this.f11199e, 1000000, this.f11196b);
        }

        public abstract RangedUri k(Representation representation, long j2);

        public boolean l() {
            return this.f11200f != null;
        }
    }

    public static final class SegmentList extends MultiSegmentBase {
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        final List<RangedUri> f11204j;

        public SegmentList(RangedUri rangedUri, long j2, long j3, long j4, long j5, @Nullable List<SegmentTimelineElement> list, long j6, @Nullable List<RangedUri> list2, long j7, long j8) {
            super(rangedUri, j2, j3, j4, j5, list, j6, j7, j8);
            this.f11204j = list2;
        }

        public long g(long j2) {
            return (long) this.f11204j.size();
        }

        public RangedUri k(Representation representation, long j2) {
            return this.f11204j.get((int) (j2 - this.f11198d));
        }

        public boolean l() {
            return true;
        }
    }

    public static final class SegmentTemplate extends MultiSegmentBase {
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        final UrlTemplate f11205j;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        final UrlTemplate f11206k;

        /* renamed from: l  reason: collision with root package name */
        final long f11207l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SegmentTemplate(RangedUri rangedUri, long j2, long j3, long j4, long j5, long j6, @Nullable List<SegmentTimelineElement> list, long j7, @Nullable UrlTemplate urlTemplate, @Nullable UrlTemplate urlTemplate2, long j8, long j9) {
            super(rangedUri, j2, j3, j4, j6, list, j7, j8, j9);
            this.f11205j = urlTemplate;
            this.f11206k = urlTemplate2;
            this.f11207l = j5;
        }

        @Nullable
        public RangedUri a(Representation representation) {
            UrlTemplate urlTemplate = this.f11205j;
            if (urlTemplate == null) {
                return SegmentBase.super.a(representation);
            }
            Format format = representation.f11183c;
            return new RangedUri(urlTemplate.a(format.s, 0, format.b3, 0), 0, -1);
        }

        public long g(long j2) {
            List<SegmentTimelineElement> list = this.f11200f;
            if (list != null) {
                return (long) list.size();
            }
            long j3 = this.f11207l;
            if (j3 != -1) {
                return (j3 - this.f11198d) + 1;
            }
            if (j2 != C.f9084b) {
                return BigIntegerMath.c(BigInteger.valueOf(j2).multiply(BigInteger.valueOf(this.f11196b)), BigInteger.valueOf(this.f11199e).multiply(BigInteger.valueOf(1000000)), RoundingMode.CEILING).longValue();
            }
            return -1;
        }

        public RangedUri k(Representation representation, long j2) {
            List<SegmentTimelineElement> list = this.f11200f;
            long j3 = list != null ? list.get((int) (j2 - this.f11198d)).f11208a : (j2 - this.f11198d) * this.f11199e;
            UrlTemplate urlTemplate = this.f11206k;
            Format format = representation.f11183c;
            return new RangedUri(urlTemplate.a(format.s, j2, format.b3, j3), 0, -1);
        }
    }

    public static final class SegmentTimelineElement {

        /* renamed from: a  reason: collision with root package name */
        final long f11208a;

        /* renamed from: b  reason: collision with root package name */
        final long f11209b;

        public SegmentTimelineElement(long j2, long j3) {
            this.f11208a = j2;
            this.f11209b = j3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SegmentTimelineElement.class != obj.getClass()) {
                return false;
            }
            SegmentTimelineElement segmentTimelineElement = (SegmentTimelineElement) obj;
            return this.f11208a == segmentTimelineElement.f11208a && this.f11209b == segmentTimelineElement.f11209b;
        }

        public int hashCode() {
            return (((int) this.f11208a) * 31) + ((int) this.f11209b);
        }
    }

    public static class SingleSegmentBase extends SegmentBase {

        /* renamed from: d  reason: collision with root package name */
        final long f11210d;

        /* renamed from: e  reason: collision with root package name */
        final long f11211e;

        public SingleSegmentBase() {
            this((RangedUri) null, 1, 0, 0, 0);
        }

        @Nullable
        public RangedUri c() {
            long j2 = this.f11211e;
            if (j2 <= 0) {
                return null;
            }
            return new RangedUri((String) null, this.f11210d, j2);
        }

        public SingleSegmentBase(@Nullable RangedUri rangedUri, long j2, long j3, long j4, long j5) {
            super(rangedUri, j2, j3);
            this.f11210d = j4;
            this.f11211e = j5;
        }
    }

    public SegmentBase(@Nullable RangedUri rangedUri, long j2, long j3) {
        this.f11195a = rangedUri;
        this.f11196b = j2;
        this.f11197c = j3;
    }

    @Nullable
    public RangedUri a(Representation representation) {
        return this.f11195a;
    }

    public long b() {
        return Util.c2(this.f11197c, 1000000, this.f11196b);
    }
}
