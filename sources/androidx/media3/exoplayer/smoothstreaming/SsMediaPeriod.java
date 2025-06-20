package androidx.media3.exoplayer.smoothstreaming;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.StreamKey;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.smoothstreaming.SsChunkSource;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest;
import androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.chunk.ChunkSampleStream;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class SsMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<SsChunkSource>> {
    @Nullable
    private final TransferListener X;
    @Nullable
    private final CmcdConfiguration X2;
    private final LoaderErrorThrower Y;
    private final DrmSessionEventListener.EventDispatcher Y2;
    private final DrmSessionManager Z;
    private final LoadErrorHandlingPolicy Z2;
    private final MediaSourceEventListener.EventDispatcher a3;
    private final Allocator b3;
    private final TrackGroupArray c3;
    private final CompositeSequenceableLoaderFactory d3;
    @Nullable
    private MediaPeriod.Callback e3;
    private SsManifest f3;
    private ChunkSampleStream<SsChunkSource>[] g3 = w(0);
    private SequenceableLoader h3;
    private final SsChunkSource.Factory s;

    public SsMediaPeriod(SsManifest ssManifest, SsChunkSource.Factory factory, @Nullable TransferListener transferListener, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, @Nullable CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, LoaderErrorThrower loaderErrorThrower, Allocator allocator) {
        this.f3 = ssManifest;
        this.s = factory;
        this.X = transferListener;
        this.Y = loaderErrorThrower;
        this.X2 = cmcdConfiguration;
        this.Z = drmSessionManager;
        this.Y2 = eventDispatcher;
        this.Z2 = loadErrorHandlingPolicy;
        this.a3 = eventDispatcher2;
        this.b3 = allocator;
        this.d3 = compositeSequenceableLoaderFactory;
        this.c3 = u(ssManifest, drmSessionManager, factory);
        this.h3 = compositeSequenceableLoaderFactory.b();
    }

    private ChunkSampleStream<SsChunkSource> p(ExoTrackSelection exoTrackSelection, long j2) {
        int f2 = this.c3.f(exoTrackSelection.d());
        return new ChunkSampleStream(this.f3.f12020f[f2].f12026a, (int[]) null, (Format[]) null, this.s.d(this.Y, this.f3, f2, exoTrackSelection, this.X, this.X2), this, this.b3, j2, this.Z, this.Y2, this.Z2, this.a3);
    }

    private static TrackGroupArray u(SsManifest ssManifest, DrmSessionManager drmSessionManager, SsChunkSource.Factory factory) {
        TrackGroup[] trackGroupArr = new TrackGroup[ssManifest.f12020f.length];
        int i2 = 0;
        while (true) {
            SsManifest.StreamElement[] streamElementArr = ssManifest.f12020f;
            if (i2 >= streamElementArr.length) {
                return new TrackGroupArray(trackGroupArr);
            }
            Format[] formatArr = streamElementArr[i2].f12035j;
            Format[] formatArr2 = new Format[formatArr.length];
            for (int i3 = 0; i3 < formatArr.length; i3++) {
                Format format = formatArr[i3];
                formatArr2[i3] = factory.c(format.c().P(drmSessionManager.d(format)).I());
            }
            trackGroupArr[i2] = new TrackGroup(Integer.toString(i2), formatArr2);
            i2++;
        }
    }

    private static ChunkSampleStream<SsChunkSource>[] w(int i2) {
        return new ChunkSampleStream[i2];
    }

    public boolean a(LoadingInfo loadingInfo) {
        return this.h3.a(loadingInfo);
    }

    public boolean c() {
        return this.h3.c();
    }

    public long e() {
        return this.h3.e();
    }

    public long f(long j2, SeekParameters seekParameters) {
        for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.g3) {
            if (chunkSampleStream.s == 2) {
                return chunkSampleStream.f(j2, seekParameters);
            }
        }
        return j2;
    }

    public long g() {
        return this.h3.g();
    }

    public void h(long j2) {
        this.h3.h(j2);
    }

    public List<StreamKey> k(List<ExoTrackSelection> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            ExoTrackSelection exoTrackSelection = list.get(i2);
            int f2 = this.c3.f(exoTrackSelection.d());
            for (int i3 = 0; i3 < exoTrackSelection.length(); i3++) {
                arrayList.add(new StreamKey(f2, exoTrackSelection.k(i3)));
            }
        }
        return arrayList;
    }

    public void l() throws IOException {
        this.Y.b();
    }

    public long m(long j2) {
        for (ChunkSampleStream<SsChunkSource> S : this.g3) {
            S.S(j2);
        }
        return j2;
    }

    public long n(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        ExoTrackSelection exoTrackSelection;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            ChunkSampleStream chunkSampleStream = sampleStreamArr[i2];
            if (chunkSampleStream != null) {
                ChunkSampleStream chunkSampleStream2 = chunkSampleStream;
                if (exoTrackSelectionArr[i2] == null || !zArr[i2]) {
                    chunkSampleStream2.P();
                    sampleStreamArr[i2] = null;
                } else {
                    ((SsChunkSource) chunkSampleStream2.D()).c((ExoTrackSelection) Assertions.g(exoTrackSelectionArr[i2]));
                    arrayList.add(chunkSampleStream2);
                }
            }
            if (sampleStreamArr[i2] == null && (exoTrackSelection = exoTrackSelectionArr[i2]) != null) {
                ChunkSampleStream<SsChunkSource> p = p(exoTrackSelection, j2);
                arrayList.add(p);
                sampleStreamArr[i2] = p;
                zArr2[i2] = true;
            }
        }
        ChunkSampleStream<SsChunkSource>[] w = w(arrayList.size());
        this.g3 = w;
        arrayList.toArray(w);
        this.h3 = this.d3.a(arrayList, Lists.D(arrayList, new b()));
        return j2;
    }

    public long q() {
        return C.f9084b;
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.e3 = callback;
        callback.i(this);
    }

    public TrackGroupArray s() {
        return this.c3;
    }

    public void t(long j2, boolean z) {
        for (ChunkSampleStream<SsChunkSource> t : this.g3) {
            t.t(j2, z);
        }
    }

    /* renamed from: x */
    public void j(ChunkSampleStream<SsChunkSource> chunkSampleStream) {
        ((MediaPeriod.Callback) Assertions.g(this.e3)).j(this);
    }

    public void y() {
        for (ChunkSampleStream<SsChunkSource> P : this.g3) {
            P.P();
        }
        this.e3 = null;
    }

    public void z(SsManifest ssManifest) {
        this.f3 = ssManifest;
        for (ChunkSampleStream<SsChunkSource> D : this.g3) {
            D.D().h(ssManifest);
        }
        ((MediaPeriod.Callback) Assertions.g(this.e3)).j(this);
    }
}
