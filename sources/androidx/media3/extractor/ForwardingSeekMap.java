package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.SeekMap;

@UnstableApi
public class ForwardingSeekMap implements SeekMap {

    /* renamed from: d  reason: collision with root package name */
    private final SeekMap f13064d;

    public ForwardingSeekMap(SeekMap seekMap) {
        this.f13064d = seekMap;
    }

    public boolean g() {
        return this.f13064d.g();
    }

    public SeekMap.SeekPoints j(long j2) {
        return this.f13064d.j(j2);
    }

    public long l() {
        return this.f13064d.l();
    }
}
