package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class DummyExtractorOutput implements ExtractorOutput {
    public TrackOutput d(int i2, int i3) {
        return new DummyTrackOutput();
    }

    public void j(SeekMap seekMap) {
    }

    public void o() {
    }
}
