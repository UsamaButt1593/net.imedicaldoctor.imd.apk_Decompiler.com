package androidx.media3.exoplayer.source;

import androidx.media3.common.C;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import java.io.IOException;
import java.util.List;

final class TimeOffsetMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private final long X;
    private MediaPeriod.Callback Y;
    private final MediaPeriod s;

    private static final class TimeOffsetSampleStream implements SampleStream {
        private final long X;
        private final SampleStream s;

        public TimeOffsetSampleStream(SampleStream sampleStream, long j2) {
            this.s = sampleStream;
            this.X = j2;
        }

        public SampleStream a() {
            return this.s;
        }

        public void b() throws IOException {
            this.s.b();
        }

        public boolean d() {
            return this.s.d();
        }

        public int j(long j2) {
            return this.s.j(j2 - this.X);
        }

        public int o(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            int o = this.s.o(formatHolder, decoderInputBuffer, i2);
            if (o == -4) {
                decoderInputBuffer.Y2 += this.X;
            }
            return o;
        }
    }

    public TimeOffsetMediaPeriod(MediaPeriod mediaPeriod, long j2) {
        this.s = mediaPeriod;
        this.X = j2;
    }

    public boolean a(LoadingInfo loadingInfo) {
        return this.s.a(loadingInfo.a().f(loadingInfo.f10228a - this.X).d());
    }

    public boolean c() {
        return this.s.c();
    }

    public MediaPeriod d() {
        return this.s;
    }

    public long e() {
        long e2 = this.s.e();
        if (e2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.X + e2;
    }

    public long f(long j2, SeekParameters seekParameters) {
        return this.s.f(j2 - this.X, seekParameters) + this.X;
    }

    public long g() {
        long g2 = this.s.g();
        if (g2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.X + g2;
    }

    public void h(long j2) {
        this.s.h(j2 - this.X);
    }

    public void i(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.g(this.Y)).i(this);
    }

    public List<StreamKey> k(List<ExoTrackSelection> list) {
        return this.s.k(list);
    }

    public void l() throws IOException {
        this.s.l();
    }

    public long m(long j2) {
        return this.s.m(j2 - this.X) + this.X;
    }

    public long n(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        SampleStream[] sampleStreamArr3 = new SampleStream[sampleStreamArr2.length];
        int i2 = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i2 >= sampleStreamArr2.length) {
                break;
            }
            TimeOffsetSampleStream timeOffsetSampleStream = (TimeOffsetSampleStream) sampleStreamArr2[i2];
            if (timeOffsetSampleStream != null) {
                sampleStream = timeOffsetSampleStream.a();
            }
            sampleStreamArr3[i2] = sampleStream;
            i2++;
        }
        long n2 = this.s.n(exoTrackSelectionArr, zArr, sampleStreamArr3, zArr2, j2 - this.X);
        for (int i3 = 0; i3 < sampleStreamArr2.length; i3++) {
            SampleStream sampleStream2 = sampleStreamArr3[i3];
            if (sampleStream2 == null) {
                sampleStreamArr2[i3] = null;
            } else {
                SampleStream sampleStream3 = sampleStreamArr2[i3];
                if (sampleStream3 == null || ((TimeOffsetSampleStream) sampleStream3).a() != sampleStream2) {
                    sampleStreamArr2[i3] = new TimeOffsetSampleStream(sampleStream2, this.X);
                }
            }
        }
        return n2 + this.X;
    }

    /* renamed from: p */
    public void j(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.g(this.Y)).j(this);
    }

    public long q() {
        long q = this.s.q();
        return q == C.f9084b ? C.f9084b : this.X + q;
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.Y = callback;
        this.s.r(this, j2 - this.X);
    }

    public TrackGroupArray s() {
        return this.s.s();
    }

    public void t(long j2, boolean z) {
        this.s.t(j2 - this.X, z);
    }
}
