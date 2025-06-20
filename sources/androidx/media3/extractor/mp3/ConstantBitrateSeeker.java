package androidx.media3.extractor.mp3;

import androidx.media3.extractor.ConstantBitrateSeekMap;
import androidx.media3.extractor.MpegAudioUtil;

final class ConstantBitrateSeeker extends ConstantBitrateSeekMap implements Seeker {

    /* renamed from: k  reason: collision with root package name */
    private final int f13455k;

    public ConstantBitrateSeeker(long j2, long j3, MpegAudioUtil.Header header, boolean z) {
        super(j2, j3, header.f13105f, header.f13102c, z);
        this.f13455k = header.f13105f;
    }

    public long b(long j2) {
        return c(j2);
    }

    public long f() {
        return -1;
    }

    public int k() {
        return this.f13455k;
    }
}
