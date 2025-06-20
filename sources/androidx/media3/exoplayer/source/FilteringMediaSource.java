package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.StreamKey;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@UnstableApi
public class FilteringMediaSource extends WrappingMediaSource {
    private final ImmutableSet<Integer> f3;

    private static final class FilteringMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
        private final ImmutableSet<Integer> X;
        @Nullable
        private MediaPeriod.Callback Y;
        @Nullable
        private TrackGroupArray Z;
        public final MediaPeriod s;

        public FilteringMediaPeriod(MediaPeriod mediaPeriod, ImmutableSet<Integer> immutableSet) {
            this.s = mediaPeriod;
            this.X = immutableSet;
        }

        public boolean a(LoadingInfo loadingInfo) {
            return this.s.a(loadingInfo);
        }

        public boolean c() {
            return this.s.c();
        }

        /* renamed from: d */
        public void j(MediaPeriod mediaPeriod) {
            ((MediaPeriod.Callback) Assertions.g(this.Y)).j(this);
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

        public void i(MediaPeriod mediaPeriod) {
            TrackGroupArray s2 = mediaPeriod.s();
            ImmutableList.Builder r = ImmutableList.r();
            for (int i2 = 0; i2 < s2.s; i2++) {
                TrackGroup d2 = s2.d(i2);
                if (this.X.contains(Integer.valueOf(d2.Y))) {
                    r.g(d2);
                }
            }
            this.Z = new TrackGroupArray((TrackGroup[]) r.e().toArray(new TrackGroup[0]));
            ((MediaPeriod.Callback) Assertions.g(this.Y)).i(this);
        }

        public List<StreamKey> k(List<ExoTrackSelection> list) {
            return this.s.k(list);
        }

        public void l() throws IOException {
            this.s.l();
        }

        public long m(long j2) {
            return this.s.m(j2);
        }

        public long n(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
            return this.s.n(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
        }

        public long q() {
            return this.s.q();
        }

        public void r(MediaPeriod.Callback callback, long j2) {
            this.Y = callback;
            this.s.r(this, j2);
        }

        public TrackGroupArray s() {
            return (TrackGroupArray) Assertions.g(this.Z);
        }

        public void t(long j2, boolean z) {
            this.s.t(j2, z);
        }
    }

    public FilteringMediaSource(MediaSource mediaSource, int i2) {
        this(mediaSource, (Set<Integer>) ImmutableSet.L(Integer.valueOf(i2)));
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return new FilteringMediaPeriod(super.E(mediaPeriodId, allocator, j2), this.f3);
    }

    public void X(MediaPeriod mediaPeriod) {
        super.X(((FilteringMediaPeriod) mediaPeriod).s);
    }

    public FilteringMediaSource(MediaSource mediaSource, Set<Integer> set) {
        super(mediaSource);
        this.f3 = ImmutableSet.C(set);
    }
}
