package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.SeekMap;

@UnstableApi
public final class SingleSampleSeekMap implements SeekMap {

    /* renamed from: d  reason: collision with root package name */
    private final long f13130d;

    /* renamed from: e  reason: collision with root package name */
    private final long f13131e;

    public SingleSampleSeekMap(long j2) {
        this(j2, 0);
    }

    public boolean g() {
        return true;
    }

    public SeekMap.SeekPoints j(long j2) {
        return new SeekMap.SeekPoints(new SeekPoint(j2, this.f13131e));
    }

    public long l() {
        return this.f13130d;
    }

    public SingleSampleSeekMap(long j2, long j3) {
        this.f13130d = j2;
        this.f13131e = j3;
    }
}
