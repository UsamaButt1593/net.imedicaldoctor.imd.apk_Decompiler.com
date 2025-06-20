package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class HlsMediaPlaylist extends HlsPlaylist {
    public static final int w = 0;
    public static final int x = 1;
    public static final int y = 2;

    /* renamed from: d  reason: collision with root package name */
    public final int f11557d;

    /* renamed from: e  reason: collision with root package name */
    public final long f11558e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f11559f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f11560g;

    /* renamed from: h  reason: collision with root package name */
    public final long f11561h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f11562i;

    /* renamed from: j  reason: collision with root package name */
    public final int f11563j;

    /* renamed from: k  reason: collision with root package name */
    public final long f11564k;

    /* renamed from: l  reason: collision with root package name */
    public final int f11565l;

    /* renamed from: m  reason: collision with root package name */
    public final long f11566m;

    /* renamed from: n  reason: collision with root package name */
    public final long f11567n;
    public final boolean o;
    public final boolean p;
    @Nullable
    public final DrmInitData q;
    public final List<Segment> r;
    public final List<Part> s;
    public final Map<Uri, RenditionReport> t;
    public final long u;
    public final ServerControl v;

    public static final class Part extends SegmentBase {
        public final boolean e3;
        public final boolean f3;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Part(String str, @Nullable Segment segment, long j2, int i2, long j3, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j4, long j5, boolean z, boolean z2, boolean z3) {
            super(str, segment, j2, i2, j3, drmInitData, str2, str3, j4, j5, z);
            this.e3 = z2;
            this.f3 = z3;
        }

        public Part b(long j2, int i2) {
            int i3 = i2;
            return new Part(this.s, this.X, this.Y, i3, j2, this.Y2, this.Z2, this.a3, this.b3, this.c3, this.d3, this.e3, this.f3);
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaylistType {
    }

    public static final class RenditionReport {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f11568a;

        /* renamed from: b  reason: collision with root package name */
        public final long f11569b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11570c;

        public RenditionReport(Uri uri, long j2, int i2) {
            this.f11568a = uri;
            this.f11569b = j2;
            this.f11570c = i2;
        }
    }

    public static final class Segment extends SegmentBase {
        public final String e3;
        public final List<Part> f3;

        public Segment(String str, long j2, long j3, @Nullable String str2, @Nullable String str3) {
            this(str, (Segment) null, "", 0, -1, C.f9084b, (DrmInitData) null, str2, str3, j2, j3, false, ImmutableList.I());
        }

        public Segment b(long j2, int i2) {
            ArrayList arrayList = new ArrayList();
            long j3 = j2;
            for (int i3 = 0; i3 < this.f3.size(); i3++) {
                Part part = this.f3.get(i3);
                arrayList.add(part.b(j3, i2));
                j3 += part.Y;
            }
            int i4 = i2;
            return new Segment(this.s, this.X, this.e3, this.Y, i2, j2, this.Y2, this.Z2, this.a3, this.b3, this.c3, this.d3, arrayList);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Segment(String str, @Nullable Segment segment, String str2, long j2, int i2, long j3, @Nullable DrmInitData drmInitData, @Nullable String str3, @Nullable String str4, long j4, long j5, boolean z, List<Part> list) {
            super(str, segment, j2, i2, j3, drmInitData, str3, str4, j4, j5, z);
            this.e3 = str2;
            this.f3 = ImmutableList.B(list);
        }
    }

    public static class SegmentBase implements Comparable<Long> {
        @Nullable
        public final Segment X;
        public final long X2;
        public final long Y;
        @Nullable
        public final DrmInitData Y2;
        public final int Z;
        @Nullable
        public final String Z2;
        @Nullable
        public final String a3;
        public final long b3;
        public final long c3;
        public final boolean d3;
        public final String s;

        private SegmentBase(String str, @Nullable Segment segment, long j2, int i2, long j3, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j4, long j5, boolean z) {
            this.s = str;
            this.X = segment;
            this.Y = j2;
            this.Z = i2;
            this.X2 = j3;
            this.Y2 = drmInitData;
            this.Z2 = str2;
            this.a3 = str3;
            this.b3 = j4;
            this.c3 = j5;
            this.d3 = z;
        }

        /* renamed from: a */
        public int compareTo(Long l2) {
            if (this.X2 > l2.longValue()) {
                return 1;
            }
            return this.X2 < l2.longValue() ? -1 : 0;
        }
    }

    public static final class ServerControl {

        /* renamed from: a  reason: collision with root package name */
        public final long f11571a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f11572b;

        /* renamed from: c  reason: collision with root package name */
        public final long f11573c;

        /* renamed from: d  reason: collision with root package name */
        public final long f11574d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f11575e;

        public ServerControl(long j2, boolean z, long j3, long j4, boolean z2) {
            this.f11571a = j2;
            this.f11572b = z;
            this.f11573c = j3;
            this.f11574d = j4;
            this.f11575e = z2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HlsMediaPlaylist(int r11, java.lang.String r12, java.util.List<java.lang.String> r13, long r14, boolean r16, long r17, boolean r19, int r20, long r21, int r23, long r24, long r26, boolean r28, boolean r29, boolean r30, @androidx.annotation.Nullable androidx.media3.common.DrmInitData r31, java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist.Segment> r32, java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist.Part> r33, androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist.ServerControl r34, java.util.Map<android.net.Uri, androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist.RenditionReport> r35) {
        /*
            r10 = this;
            r0 = r10
            r1 = r14
            r3 = r12
            r4 = r13
            r5 = r28
            r10.<init>(r12, r13, r5)
            r3 = r11
            r0.f11557d = r3
            r3 = r17
            r0.f11561h = r3
            r3 = r16
            r0.f11560g = r3
            r3 = r19
            r0.f11562i = r3
            r3 = r20
            r0.f11563j = r3
            r3 = r21
            r0.f11564k = r3
            r3 = r23
            r0.f11565l = r3
            r3 = r24
            r0.f11566m = r3
            r3 = r26
            r0.f11567n = r3
            r3 = r29
            r0.o = r3
            r3 = r30
            r0.p = r3
            r3 = r31
            r0.q = r3
            com.google.common.collect.ImmutableList r3 = com.google.common.collect.ImmutableList.B(r32)
            r0.r = r3
            com.google.common.collect.ImmutableList r3 = com.google.common.collect.ImmutableList.B(r33)
            r0.s = r3
            com.google.common.collect.ImmutableMap r3 = com.google.common.collect.ImmutableMap.g(r35)
            r0.t = r3
            boolean r3 = r33.isEmpty()
            r4 = 0
            if (r3 != 0) goto L_0x0060
            java.lang.Object r3 = com.google.common.collect.Iterables.w(r33)
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Part r3 = (androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist.Part) r3
        L_0x0058:
            long r6 = r3.X2
            long r8 = r3.Y
            long r6 = r6 + r8
            r0.u = r6
            goto L_0x006f
        L_0x0060:
            boolean r3 = r32.isEmpty()
            if (r3 != 0) goto L_0x006d
            java.lang.Object r3 = com.google.common.collect.Iterables.w(r32)
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment r3 = (androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist.Segment) r3
            goto L_0x0058
        L_0x006d:
            r0.u = r4
        L_0x006f:
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0079
            goto L_0x0089
        L_0x0079:
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            long r6 = r0.u
            if (r3 < 0) goto L_0x0084
            long r6 = java.lang.Math.min(r6, r14)
            goto L_0x0089
        L_0x0084:
            long r6 = r6 + r1
            long r6 = java.lang.Math.max(r4, r6)
        L_0x0089:
            r0.f11558e = r6
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r3 < 0) goto L_0x0091
            r1 = 1
            goto L_0x0092
        L_0x0091:
            r1 = 0
        L_0x0092:
            r0.f11559f = r1
            r1 = r34
            r0.v = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist.<init>(int, java.lang.String, java.util.List, long, boolean, long, boolean, int, long, int, long, long, boolean, boolean, boolean, androidx.media3.common.DrmInitData, java.util.List, java.util.List, androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$ServerControl, java.util.Map):void");
    }

    /* renamed from: b */
    public HlsMediaPlaylist a(List<StreamKey> list) {
        return this;
    }

    public HlsMediaPlaylist c(long j2, int i2) {
        int i3 = this.f11557d;
        return new HlsMediaPlaylist(i3, this.f11597a, this.f11598b, this.f11558e, this.f11560g, j2, true, i2, this.f11564k, this.f11565l, this.f11566m, this.f11567n, this.f11599c, this.o, this.p, this.q, this.r, this.s, this.v, this.t);
    }

    public HlsMediaPlaylist d() {
        if (this.o) {
            return this;
        }
        HlsMediaPlaylist hlsMediaPlaylist = r2;
        HlsMediaPlaylist hlsMediaPlaylist2 = new HlsMediaPlaylist(this.f11557d, this.f11597a, this.f11598b, this.f11558e, this.f11560g, this.f11561h, this.f11562i, this.f11563j, this.f11564k, this.f11565l, this.f11566m, this.f11567n, this.f11599c, true, this.p, this.q, this.r, this.s, this.v, this.t);
        return hlsMediaPlaylist;
    }

    public long e() {
        return this.f11561h + this.u;
    }

    public boolean f(@Nullable HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist == null) {
            return true;
        }
        long j2 = this.f11564k;
        long j3 = hlsMediaPlaylist.f11564k;
        if (j2 > j3) {
            return true;
        }
        if (j2 < j3) {
            return false;
        }
        int size = this.r.size() - hlsMediaPlaylist.r.size();
        if (size != 0) {
            return size > 0;
        }
        int size2 = this.s.size();
        int size3 = hlsMediaPlaylist.s.size();
        if (size2 <= size3) {
            return size2 == size3 && this.o && !hlsMediaPlaylist.o;
        }
        return true;
    }
}
