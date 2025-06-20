package androidx.media3.exoplayer.dash.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.dash.DashSegmentIndex;
import androidx.media3.exoplayer.dash.manifest.SegmentBase;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;

@UnstableApi
public abstract class Representation {

    /* renamed from: j  reason: collision with root package name */
    public static final long f11181j = -1;

    /* renamed from: b  reason: collision with root package name */
    public final long f11182b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f11183c;

    /* renamed from: d  reason: collision with root package name */
    public final ImmutableList<BaseUrl> f11184d;

    /* renamed from: e  reason: collision with root package name */
    public final long f11185e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Descriptor> f11186f;

    /* renamed from: g  reason: collision with root package name */
    public final List<Descriptor> f11187g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Descriptor> f11188h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final RangedUri f11189i;

    public static class MultiSegmentRepresentation extends Representation implements DashSegmentIndex {
        @VisibleForTesting

        /* renamed from: k  reason: collision with root package name */
        final SegmentBase.MultiSegmentBase f11190k;

        public MultiSegmentRepresentation(long j2, Format format, List<BaseUrl> list, SegmentBase.MultiSegmentBase multiSegmentBase, @Nullable List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
            super(j2, format, list, multiSegmentBase, list2, list3, list4);
            this.f11190k = multiSegmentBase;
        }

        @Nullable
        public String a() {
            return null;
        }

        public long b(long j2) {
            return this.f11190k.j(j2);
        }

        public long c(long j2, long j3) {
            return this.f11190k.h(j2, j3);
        }

        public long d(long j2, long j3) {
            return this.f11190k.d(j2, j3);
        }

        public long e(long j2, long j3) {
            return this.f11190k.f(j2, j3);
        }

        public RangedUri f(long j2) {
            return this.f11190k.k(this, j2);
        }

        public long g(long j2, long j3) {
            return this.f11190k.i(j2, j3);
        }

        public boolean h() {
            return this.f11190k.l();
        }

        public long i() {
            return this.f11190k.e();
        }

        public long j(long j2) {
            return this.f11190k.g(j2);
        }

        public long k(long j2, long j3) {
            return this.f11190k.c(j2, j3);
        }

        public DashSegmentIndex l() {
            return this;
        }

        @Nullable
        public RangedUri m() {
            return null;
        }
    }

    public static class SingleSegmentRepresentation extends Representation {

        /* renamed from: k  reason: collision with root package name */
        public final Uri f11191k;

        /* renamed from: l  reason: collision with root package name */
        public final long f11192l;
        @Nullable

        /* renamed from: m  reason: collision with root package name */
        private final String f11193m;
        @Nullable

        /* renamed from: n  reason: collision with root package name */
        private final RangedUri f11194n;
        @Nullable
        private final SingleSegmentIndex o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SingleSegmentRepresentation(long j2, Format format, List<BaseUrl> list, SegmentBase.SingleSegmentBase singleSegmentBase, @Nullable List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4, @Nullable String str, long j3) {
            super(j2, format, list, singleSegmentBase, list2, list3, list4);
            List<BaseUrl> list5 = list;
            this.f11191k = Uri.parse(list.get(0).f11127a);
            RangedUri c2 = singleSegmentBase.c();
            this.f11194n = c2;
            this.f11193m = str;
            this.f11192l = j3;
            this.o = c2 != null ? null : new SingleSegmentIndex(new RangedUri((String) null, 0, j3));
        }

        public static SingleSegmentRepresentation q(long j2, Format format, String str, long j3, long j4, long j5, long j6, List<Descriptor> list, @Nullable String str2, long j7) {
            return new SingleSegmentRepresentation(j2, format, ImmutableList.K(new BaseUrl(str)), new SegmentBase.SingleSegmentBase(new RangedUri((String) null, j3, (j4 - j3) + 1), 1, 0, j5, (j6 - j5) + 1), list, ImmutableList.I(), ImmutableList.I(), str2, j7);
        }

        @Nullable
        public String a() {
            return this.f11193m;
        }

        @Nullable
        public DashSegmentIndex l() {
            return this.o;
        }

        @Nullable
        public RangedUri m() {
            return this.f11194n;
        }
    }

    private Representation(long j2, Format format, List<BaseUrl> list, SegmentBase segmentBase, @Nullable List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        Assertions.a(!list.isEmpty());
        this.f11182b = j2;
        this.f11183c = format;
        this.f11184d = ImmutableList.B(list);
        this.f11186f = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f11187g = list3;
        this.f11188h = list4;
        this.f11189i = segmentBase.a(this);
        this.f11185e = segmentBase.b();
    }

    public static Representation o(long j2, Format format, List<BaseUrl> list, SegmentBase segmentBase) {
        return p(j2, format, list, segmentBase, (List<Descriptor>) null, ImmutableList.I(), ImmutableList.I(), (String) null);
    }

    public static Representation p(long j2, Format format, List<BaseUrl> list, SegmentBase segmentBase, @Nullable List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4, @Nullable String str) {
        SegmentBase segmentBase2 = segmentBase;
        if (segmentBase2 instanceof SegmentBase.SingleSegmentBase) {
            return new SingleSegmentRepresentation(j2, format, list, (SegmentBase.SingleSegmentBase) segmentBase2, list2, list3, list4, str, -1);
        } else if (segmentBase2 instanceof SegmentBase.MultiSegmentBase) {
            return new MultiSegmentRepresentation(j2, format, list, (SegmentBase.MultiSegmentBase) segmentBase2, list2, list3, list4);
        } else {
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
    }

    @Nullable
    public abstract String a();

    @Nullable
    public abstract DashSegmentIndex l();

    @Nullable
    public abstract RangedUri m();

    @Nullable
    public RangedUri n() {
        return this.f11189i;
    }
}
