package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
public class DefaultLoadControl implements LoadControl {
    public static final int A = 144310272;
    public static final int B = 13107200;

    /* renamed from: m  reason: collision with root package name */
    public static final int f10145m = 50000;

    /* renamed from: n  reason: collision with root package name */
    public static final int f10146n = 50000;
    public static final int o = 2500;
    public static final int p = 5000;
    public static final int q = -1;
    public static final boolean r = false;
    public static final int s = 0;
    public static final boolean t = false;
    public static final int u = 131072000;
    public static final int v = 13107200;
    public static final int w = 131072;
    public static final int x = 131072;
    public static final int y = 131072;
    public static final int z = 131072;

    /* renamed from: b  reason: collision with root package name */
    private final DefaultAllocator f10147b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10148c;

    /* renamed from: d  reason: collision with root package name */
    private final long f10149d;

    /* renamed from: e  reason: collision with root package name */
    private final long f10150e;

    /* renamed from: f  reason: collision with root package name */
    private final long f10151f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10152g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f10153h;

    /* renamed from: i  reason: collision with root package name */
    private final long f10154i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f10155j;

    /* renamed from: k  reason: collision with root package name */
    private int f10156k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10157l;

    public static final class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private DefaultAllocator f10158a;

        /* renamed from: b  reason: collision with root package name */
        private int f10159b = 50000;

        /* renamed from: c  reason: collision with root package name */
        private int f10160c = 50000;

        /* renamed from: d  reason: collision with root package name */
        private int f10161d = DefaultLoadControl.o;

        /* renamed from: e  reason: collision with root package name */
        private int f10162e = 5000;

        /* renamed from: f  reason: collision with root package name */
        private int f10163f = -1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f10164g = false;

        /* renamed from: h  reason: collision with root package name */
        private int f10165h = 0;

        /* renamed from: i  reason: collision with root package name */
        private boolean f10166i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f10167j;

        public DefaultLoadControl a() {
            Assertions.i(!this.f10167j);
            this.f10167j = true;
            if (this.f10158a == null) {
                this.f10158a = new DefaultAllocator(true, 65536);
            }
            return new DefaultLoadControl(this.f10158a, this.f10159b, this.f10160c, this.f10161d, this.f10162e, this.f10163f, this.f10164g, this.f10165h, this.f10166i);
        }

        @CanIgnoreReturnValue
        public Builder b(DefaultAllocator defaultAllocator) {
            Assertions.i(!this.f10167j);
            this.f10158a = defaultAllocator;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c(int i2, boolean z) {
            Assertions.i(!this.f10167j);
            DefaultLoadControl.m(i2, 0, "backBufferDurationMs", "0");
            this.f10165h = i2;
            this.f10166i = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d(int i2, int i3, int i4, int i5) {
            Assertions.i(!this.f10167j);
            DefaultLoadControl.m(i4, 0, "bufferForPlaybackMs", "0");
            DefaultLoadControl.m(i5, 0, "bufferForPlaybackAfterRebufferMs", "0");
            DefaultLoadControl.m(i2, i4, "minBufferMs", "bufferForPlaybackMs");
            DefaultLoadControl.m(i2, i5, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            DefaultLoadControl.m(i3, i2, "maxBufferMs", "minBufferMs");
            this.f10159b = i2;
            this.f10160c = i3;
            this.f10161d = i4;
            this.f10162e = i5;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e(boolean z) {
            Assertions.i(!this.f10167j);
            this.f10164g = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder f(int i2) {
            Assertions.i(!this.f10167j);
            this.f10163f = i2;
            return this;
        }
    }

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536), 50000, 50000, o, 5000, -1, false, 0, false);
    }

    /* access modifiers changed from: private */
    public static void m(int i2, int i3, String str, String str2) {
        boolean z2 = i2 >= i3;
        Assertions.b(z2, str + " cannot be less than " + str2);
    }

    private static int o(int i2) {
        switch (i2) {
            case -2:
                return 0;
            case 0:
                return A;
            case 1:
                return 13107200;
            case 2:
                return u;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void p(boolean z2) {
        int i2 = this.f10152g;
        if (i2 == -1) {
            i2 = 13107200;
        }
        this.f10156k = i2;
        this.f10157l = false;
        if (z2) {
            this.f10147b.g();
        }
    }

    public void b() {
        p(false);
    }

    public boolean c() {
        return this.f10155j;
    }

    public boolean d(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, float f2, boolean z2, long j3) {
        long G0 = Util.G0(j2, f2);
        long j4 = z2 ? this.f10151f : this.f10150e;
        if (j3 != C.f9084b) {
            j4 = Math.min(j3 / 2, j4);
        }
        return j4 <= 0 || G0 >= j4 || (!this.f10153h && this.f10147b.e() >= this.f10156k);
    }

    public /* synthetic */ void e(Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        E0.b(this, rendererArr, trackGroupArray, exoTrackSelectionArr);
    }

    public long f() {
        return this.f10154i;
    }

    public void g() {
        p(true);
    }

    public void h(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        int i2 = this.f10152g;
        if (i2 == -1) {
            i2 = n(rendererArr, exoTrackSelectionArr);
        }
        this.f10156k = i2;
        this.f10147b.h(i2);
    }

    public /* synthetic */ boolean i(long j2, float f2, boolean z2, long j3) {
        return E0.c(this, j2, f2, z2, j3);
    }

    public boolean j(long j2, long j3, float f2) {
        boolean z2 = true;
        boolean z3 = this.f10147b.e() >= this.f10156k;
        long j4 = this.f10148c;
        if (f2 > 1.0f) {
            j4 = Math.min(Util.A0(j4, f2), this.f10149d);
        }
        if (j3 < Math.max(j4, 500000)) {
            if (!this.f10153h && z3) {
                z2 = false;
            }
            this.f10157l = z2;
            if (!z2 && j3 < 500000) {
                Log.n("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j3 >= this.f10149d || z3) {
            this.f10157l = false;
        }
        return this.f10157l;
    }

    public Allocator k() {
        return this.f10147b;
    }

    public void l() {
        p(true);
    }

    /* access modifiers changed from: protected */
    public int n(Renderer[] rendererArr, ExoTrackSelection[] exoTrackSelectionArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < rendererArr.length; i3++) {
            if (exoTrackSelectionArr[i3] != null) {
                i2 += o(rendererArr[i3].i());
            }
        }
        return Math.max(13107200, i2);
    }

    protected DefaultLoadControl(DefaultAllocator defaultAllocator, int i2, int i3, int i4, int i5, int i6, boolean z2, int i7, boolean z3) {
        m(i4, 0, "bufferForPlaybackMs", "0");
        m(i5, 0, "bufferForPlaybackAfterRebufferMs", "0");
        m(i2, i4, "minBufferMs", "bufferForPlaybackMs");
        m(i2, i5, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        m(i3, i2, "maxBufferMs", "minBufferMs");
        m(i7, 0, "backBufferDurationMs", "0");
        this.f10147b = defaultAllocator;
        this.f10148c = Util.I1((long) i2);
        this.f10149d = Util.I1((long) i3);
        this.f10150e = Util.I1((long) i4);
        this.f10151f = Util.I1((long) i5);
        this.f10152g = i6;
        this.f10156k = i6 == -1 ? 13107200 : i6;
        this.f10153h = z2;
        this.f10154i = Util.I1((long) i7);
        this.f10155j = z3;
    }
}
