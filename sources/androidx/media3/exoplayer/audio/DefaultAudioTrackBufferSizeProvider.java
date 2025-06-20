package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.OpusUtil;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
public class DefaultAudioTrackBufferSizeProvider implements DefaultAudioSink.AudioTrackBufferSizeProvider {

    /* renamed from: i  reason: collision with root package name */
    private static final int f10878i = 250000;

    /* renamed from: j  reason: collision with root package name */
    private static final int f10879j = 750000;

    /* renamed from: k  reason: collision with root package name */
    private static final int f10880k = 4;

    /* renamed from: l  reason: collision with root package name */
    private static final int f10881l = 250000;

    /* renamed from: m  reason: collision with root package name */
    private static final int f10882m = 50000000;

    /* renamed from: n  reason: collision with root package name */
    private static final int f10883n = 2;
    private static final int o = 4;

    /* renamed from: b  reason: collision with root package name */
    protected final int f10884b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f10885c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f10886d;

    /* renamed from: e  reason: collision with root package name */
    protected final int f10887e;

    /* renamed from: f  reason: collision with root package name */
    protected final int f10888f;

    /* renamed from: g  reason: collision with root package name */
    public final int f10889g;

    /* renamed from: h  reason: collision with root package name */
    public final int f10890h;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f10891a = 250000;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f10892b = DefaultAudioTrackBufferSizeProvider.f10879j;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f10893c = 4;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f10894d = 250000;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f10895e = DefaultAudioTrackBufferSizeProvider.f10882m;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f10896f = 2;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f10897g = 4;

        public DefaultAudioTrackBufferSizeProvider h() {
            return new DefaultAudioTrackBufferSizeProvider(this);
        }

        @CanIgnoreReturnValue
        public Builder i(int i2) {
            this.f10896f = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder j(int i2) {
            this.f10897g = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder k(int i2) {
            this.f10892b = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder l(int i2) {
            this.f10891a = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder m(int i2) {
            this.f10895e = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder n(int i2) {
            this.f10894d = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder o(int i2) {
            this.f10893c = i2;
            return this;
        }
    }

    protected DefaultAudioTrackBufferSizeProvider(Builder builder) {
        this.f10884b = builder.f10891a;
        this.f10885c = builder.f10892b;
        this.f10886d = builder.f10893c;
        this.f10887e = builder.f10894d;
        this.f10888f = builder.f10895e;
        this.f10889g = builder.f10896f;
        this.f10890h = builder.f10897g;
    }

    protected static int b(int i2, int i3, int i4) {
        return Ints.d(((((long) i2) * ((long) i3)) * ((long) i4)) / 1000000);
    }

    protected static int d(int i2) {
        switch (i2) {
            case 5:
                return Ac3Util.f12888a;
            case 6:
            case 18:
                return 768000;
            case 7:
                return DtsUtil.f13020f;
            case 8:
                return DtsUtil.f13021g;
            case 9:
                return MpegAudioUtil.f13088b;
            case 10:
                return AacUtil.f12876f;
            case 11:
                return AacUtil.f12877g;
            case 12:
                return 7000;
            case 14:
                return Ac3Util.f12890c;
            case 15:
                return 8000;
            case 16:
                return AacUtil.f12879i;
            case 17:
                return Ac4Util.f12914c;
            case 20:
                return OpusUtil.f13108b;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int a(int i2, int i3, int i4, int i5, int i6, int i7, double d2) {
        return (((Math.max(i2, (int) (((double) c(i2, i3, i4, i5, i6, i7)) * d2)) + i5) - 1) / i5) * i5;
    }

    /* access modifiers changed from: protected */
    public int c(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i4 == 0) {
            return g(i2, i6, i5);
        }
        if (i4 == 1) {
            return e(i3);
        }
        if (i4 == 2) {
            return f(i3, i7);
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: protected */
    public int e(int i2) {
        return Ints.d((((long) this.f10888f) * ((long) d(i2))) / 1000000);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int f(int r4, int r5) {
        /*
            r3 = this;
            int r0 = r3.f10887e
            r1 = 5
            r2 = 8
            if (r4 != r1) goto L_0x000c
            int r1 = r3.f10889g
        L_0x0009:
            int r0 = r0 * r1
            goto L_0x0011
        L_0x000c:
            if (r4 != r2) goto L_0x0011
            int r1 = r3.f10890h
            goto L_0x0009
        L_0x0011:
            r1 = -1
            if (r5 == r1) goto L_0x001b
            java.math.RoundingMode r4 = java.math.RoundingMode.CEILING
            int r4 = com.google.common.math.IntMath.g(r5, r2, r4)
            goto L_0x001f
        L_0x001b:
            int r4 = d(r4)
        L_0x001f:
            long r0 = (long) r0
            long r4 = (long) r4
            long r0 = r0 * r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 / r4
            int r4 = com.google.common.primitives.Ints.d(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioTrackBufferSizeProvider.f(int, int):int");
    }

    /* access modifiers changed from: protected */
    public int g(int i2, int i3, int i4) {
        return Util.w(i2 * this.f10886d, b(this.f10884b, i3, i4), b(this.f10885c, i3, i4));
    }
}
