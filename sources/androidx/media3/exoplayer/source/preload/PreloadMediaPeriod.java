package androidx.media3.exoplayer.source.preload;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.n;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

final class PreloadMediaPeriod implements MediaPeriod {
    private boolean X;
    @Nullable
    private PreloadTrackSelectionHolder X2;
    /* access modifiers changed from: private */
    public boolean Y;
    /* access modifiers changed from: private */
    @Nullable
    public MediaPeriod.Callback Z;
    public final MediaPeriod s;

    private static class PreloadTrackSelectionHolder {

        /* renamed from: a  reason: collision with root package name */
        public final ExoTrackSelection[] f12328a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f12329b;

        /* renamed from: c  reason: collision with root package name */
        public final SampleStream[] f12330c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean[] f12331d;

        /* renamed from: e  reason: collision with root package name */
        public final long f12332e;

        public PreloadTrackSelectionHolder(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
            this.f12328a = exoTrackSelectionArr;
            this.f12329b = zArr;
            this.f12330c = sampleStreamArr;
            this.f12331d = zArr2;
            this.f12332e = j2;
        }
    }

    public PreloadMediaPeriod(MediaPeriod mediaPeriod) {
        this.s = mediaPeriod;
    }

    private static boolean i(ExoTrackSelection exoTrackSelection, ExoTrackSelection exoTrackSelection2) {
        if (!Objects.equals(exoTrackSelection.d(), exoTrackSelection2.d()) || exoTrackSelection.length() != exoTrackSelection2.length()) {
            return false;
        }
        for (int i2 = 0; i2 < exoTrackSelection.length(); i2++) {
            if (exoTrackSelection.k(i2) != exoTrackSelection2.k(i2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean j(ExoTrackSelection[] exoTrackSelectionArr, PreloadTrackSelectionHolder preloadTrackSelectionHolder) {
        ExoTrackSelection[] exoTrackSelectionArr2 = ((PreloadTrackSelectionHolder) Assertions.g(preloadTrackSelectionHolder)).f12328a;
        boolean z = false;
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
            ExoTrackSelection exoTrackSelection2 = exoTrackSelectionArr2[i2];
            if (exoTrackSelection != null || exoTrackSelection2 != null) {
                preloadTrackSelectionHolder.f12329b[i2] = false;
                if (exoTrackSelection == null) {
                    preloadTrackSelectionHolder.f12328a[i2] = null;
                } else if (exoTrackSelection2 == null) {
                    preloadTrackSelectionHolder.f12328a[i2] = exoTrackSelection;
                } else if (!i(exoTrackSelection, exoTrackSelection2)) {
                    preloadTrackSelectionHolder.f12328a[i2] = exoTrackSelection;
                } else if (exoTrackSelection.d().Y == 2 || exoTrackSelection.d().Y == 1 || exoTrackSelection.n() == exoTrackSelection2.n()) {
                    preloadTrackSelectionHolder.f12329b[i2] = true;
                } else {
                    preloadTrackSelectionHolder.f12328a[i2] = exoTrackSelection;
                }
                z = true;
            }
        }
        return z;
    }

    private void p(long j2) {
        this.X = true;
        this.s.r(new MediaPeriod.Callback() {
            /* renamed from: a */
            public void j(MediaPeriod mediaPeriod) {
                ((MediaPeriod.Callback) Assertions.g(PreloadMediaPeriod.this.Z)).j(PreloadMediaPeriod.this);
            }

            public void i(MediaPeriod mediaPeriod) {
                boolean unused = PreloadMediaPeriod.this.Y = true;
                ((MediaPeriod.Callback) Assertions.g(PreloadMediaPeriod.this.Z)).i(PreloadMediaPeriod.this);
            }
        }, j2);
    }

    private long v(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        PreloadTrackSelectionHolder preloadTrackSelectionHolder = this.X2;
        if (preloadTrackSelectionHolder == null) {
            return this.s.n(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
        }
        Assertions.i(sampleStreamArr2.length == preloadTrackSelectionHolder.f12330c.length);
        PreloadTrackSelectionHolder preloadTrackSelectionHolder2 = this.X2;
        if (j2 != preloadTrackSelectionHolder2.f12332e) {
            int i2 = 0;
            while (true) {
                SampleStream[] sampleStreamArr3 = this.X2.f12330c;
                if (i2 < sampleStreamArr3.length) {
                    SampleStream sampleStream = sampleStreamArr3[i2];
                    if (sampleStream != null) {
                        sampleStreamArr2[i2] = sampleStream;
                        zArr[i2] = false;
                    }
                    i2++;
                } else {
                    this.X2 = null;
                    return this.s.n(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
                }
            }
        } else {
            PreloadTrackSelectionHolder preloadTrackSelectionHolder3 = (PreloadTrackSelectionHolder) Assertions.g(preloadTrackSelectionHolder2);
            long j3 = preloadTrackSelectionHolder3.f12332e;
            boolean[] zArr3 = preloadTrackSelectionHolder3.f12331d;
            if (j(exoTrackSelectionArr, preloadTrackSelectionHolder3)) {
                boolean[] zArr4 = new boolean[zArr3.length];
                long n2 = this.s.n(preloadTrackSelectionHolder3.f12328a, preloadTrackSelectionHolder3.f12329b, preloadTrackSelectionHolder3.f12330c, zArr4, preloadTrackSelectionHolder3.f12332e);
                int i3 = 0;
                while (true) {
                    boolean[] zArr5 = preloadTrackSelectionHolder3.f12329b;
                    if (i3 >= zArr5.length) {
                        break;
                    }
                    if (zArr5[i3]) {
                        zArr4[i3] = true;
                    }
                    i3++;
                }
                zArr3 = zArr4;
                j3 = n2;
            }
            SampleStream[] sampleStreamArr4 = preloadTrackSelectionHolder3.f12330c;
            System.arraycopy(sampleStreamArr4, 0, sampleStreamArr2, 0, sampleStreamArr4.length);
            System.arraycopy(zArr3, 0, zArr2, 0, zArr3.length);
            this.X2 = null;
            return j3;
        }
    }

    public boolean a(LoadingInfo loadingInfo) {
        return this.s.a(loadingInfo);
    }

    public boolean c() {
        return this.s.c();
    }

    public long e() {
        return this.s.e();
    }

    public long f(long j2, SeekParameters seekParameters) {
        return this.s.f(j2, seekParameters);
    }

    public long g() {
        return this.s.g();
    }

    public void h(long j2) {
        this.s.h(j2);
    }

    public /* synthetic */ List k(List list) {
        return n.a(this, list);
    }

    public void l() throws IOException {
        this.s.l();
    }

    public long m(long j2) {
        return this.s.m(j2);
    }

    public long n(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        return v(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
    }

    /* access modifiers changed from: package-private */
    public void o(MediaPeriod.Callback callback, long j2) {
        this.Z = callback;
        if (this.Y) {
            callback.i(this);
        }
        if (!this.X) {
            p(j2);
        }
    }

    public long q() {
        return this.s.q();
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.Z = callback;
        if (this.Y) {
            callback.i(this);
        } else if (!this.X) {
            p(j2);
        }
    }

    public TrackGroupArray s() {
        return this.s.s();
    }

    public void t(long j2, boolean z) {
        this.s.t(j2, z);
    }

    /* access modifiers changed from: package-private */
    public long u(ExoTrackSelection[] exoTrackSelectionArr, long j2) {
        boolean[] zArr = new boolean[exoTrackSelectionArr.length];
        ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
        boolean[] zArr2 = new boolean[exoTrackSelectionArr.length];
        SampleStream[] sampleStreamArr = new SampleStream[exoTrackSelectionArr.length];
        boolean[] zArr3 = zArr;
        long v = v(exoTrackSelectionArr2, zArr2, sampleStreamArr, zArr3, j2);
        this.X2 = new PreloadTrackSelectionHolder(exoTrackSelectionArr2, zArr2, sampleStreamArr, zArr3, v);
        return v;
    }
}
