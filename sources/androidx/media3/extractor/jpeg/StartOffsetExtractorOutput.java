package androidx.media3.extractor.jpeg;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ForwardingSeekMap;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;

@UnstableApi
public final class StartOffsetExtractorOutput implements ExtractorOutput {
    private final ExtractorOutput X;
    /* access modifiers changed from: private */
    public final long s;

    public StartOffsetExtractorOutput(long j2, ExtractorOutput extractorOutput) {
        this.s = j2;
        this.X = extractorOutput;
    }

    public TrackOutput d(int i2, int i3) {
        return this.X.d(i2, i3);
    }

    public void j(final SeekMap seekMap) {
        this.X.j(new ForwardingSeekMap(seekMap) {
            public SeekMap.SeekPoints j(long j2) {
                SeekMap.SeekPoints j3 = seekMap.j(j2);
                SeekPoint seekPoint = j3.f13112a;
                SeekPoint seekPoint2 = new SeekPoint(seekPoint.f13117a, seekPoint.f13118b + StartOffsetExtractorOutput.this.s);
                SeekPoint seekPoint3 = j3.f13113b;
                return new SeekMap.SeekPoints(seekPoint2, new SeekPoint(seekPoint3.f13117a, seekPoint3.f13118b + StartOffsetExtractorOutput.this.s));
            }
        });
    }

    public void o() {
        this.X.o();
    }
}
