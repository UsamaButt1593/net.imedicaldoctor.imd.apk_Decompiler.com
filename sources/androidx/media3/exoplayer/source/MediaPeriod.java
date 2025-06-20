package androidx.media3.exoplayer.source;

import androidx.media3.common.StreamKey;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import java.io.IOException;
import java.util.List;

@UnstableApi
public interface MediaPeriod extends SequenceableLoader {

    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void i(MediaPeriod mediaPeriod);
    }

    boolean a(LoadingInfo loadingInfo);

    boolean c();

    long e();

    long f(long j2, SeekParameters seekParameters);

    long g();

    void h(long j2);

    List<StreamKey> k(List<ExoTrackSelection> list);

    void l() throws IOException;

    long m(long j2);

    long n(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2);

    long q();

    void r(Callback callback, long j2);

    TrackGroupArray s();

    void t(long j2, boolean z);
}
