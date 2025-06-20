package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.util.List;

@UnstableApi
public final class MaskingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private final long X;
    private MediaPeriod X2;
    private final Allocator Y;
    @Nullable
    private MediaPeriod.Callback Y2;
    private MediaSource Z;
    @Nullable
    private PrepareListener Z2;
    private boolean a3;
    private long b3 = C.f9084b;
    public final MediaSource.MediaPeriodId s;

    public interface PrepareListener {
        void a(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);

        void b(MediaSource.MediaPeriodId mediaPeriodId);
    }

    public MaskingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        this.s = mediaPeriodId;
        this.Y = allocator;
        this.X = j2;
    }

    private long v(long j2) {
        long j3 = this.b3;
        return j3 != C.f9084b ? j3 : j2;
    }

    public void A(PrepareListener prepareListener) {
        this.Z2 = prepareListener;
    }

    public boolean a(LoadingInfo loadingInfo) {
        MediaPeriod mediaPeriod = this.X2;
        return mediaPeriod != null && mediaPeriod.a(loadingInfo);
    }

    public boolean c() {
        MediaPeriod mediaPeriod = this.X2;
        return mediaPeriod != null && mediaPeriod.c();
    }

    public void d(MediaSource.MediaPeriodId mediaPeriodId) {
        long v = v(this.X);
        MediaPeriod E = ((MediaSource) Assertions.g(this.Z)).E(mediaPeriodId, this.Y, v);
        this.X2 = E;
        if (this.Y2 != null) {
            E.r(this, v);
        }
    }

    public long e() {
        return ((MediaPeriod) Util.o(this.X2)).e();
    }

    public long f(long j2, SeekParameters seekParameters) {
        return ((MediaPeriod) Util.o(this.X2)).f(j2, seekParameters);
    }

    public long g() {
        return ((MediaPeriod) Util.o(this.X2)).g();
    }

    public void h(long j2) {
        ((MediaPeriod) Util.o(this.X2)).h(j2);
    }

    public void i(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Util.o(this.Y2)).i(this);
        PrepareListener prepareListener = this.Z2;
        if (prepareListener != null) {
            prepareListener.b(this.s);
        }
    }

    public /* synthetic */ List k(List list) {
        return n.a(this, list);
    }

    public void l() throws IOException {
        try {
            MediaPeriod mediaPeriod = this.X2;
            if (mediaPeriod != null) {
                mediaPeriod.l();
                return;
            }
            MediaSource mediaSource = this.Z;
            if (mediaSource != null) {
                mediaSource.I();
            }
        } catch (IOException e2) {
            PrepareListener prepareListener = this.Z2;
            if (prepareListener == null) {
                throw e2;
            } else if (!this.a3) {
                this.a3 = true;
                prepareListener.a(this.s, e2);
            }
        }
    }

    public long m(long j2) {
        return ((MediaPeriod) Util.o(this.X2)).m(j2);
    }

    public long n(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        long j3 = this.b3;
        long j4 = (j3 == C.f9084b || j2 != this.X) ? j2 : j3;
        this.b3 = C.f9084b;
        return ((MediaPeriod) Util.o(this.X2)).n(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j4);
    }

    public long p() {
        return this.b3;
    }

    public long q() {
        return ((MediaPeriod) Util.o(this.X2)).q();
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.Y2 = callback;
        MediaPeriod mediaPeriod = this.X2;
        if (mediaPeriod != null) {
            mediaPeriod.r(this, v(this.X));
        }
    }

    public TrackGroupArray s() {
        return ((MediaPeriod) Util.o(this.X2)).s();
    }

    public void t(long j2, boolean z) {
        ((MediaPeriod) Util.o(this.X2)).t(j2, z);
    }

    public long u() {
        return this.X;
    }

    /* renamed from: w */
    public void j(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Util.o(this.Y2)).j(this);
    }

    public void x(long j2) {
        this.b3 = j2;
    }

    public void y() {
        if (this.X2 != null) {
            ((MediaSource) Assertions.g(this.Z)).X(this.X2);
        }
    }

    public void z(MediaSource mediaSource) {
        Assertions.i(this.Z == null);
        this.Z = mediaSource;
    }
}
