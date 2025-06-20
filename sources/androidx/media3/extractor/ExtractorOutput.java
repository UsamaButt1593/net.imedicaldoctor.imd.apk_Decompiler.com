package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface ExtractorOutput {
    public static final ExtractorOutput b0 = new ExtractorOutput() {
        public TrackOutput d(int i2, int i3) {
            throw new UnsupportedOperationException();
        }

        public void j(SeekMap seekMap) {
            throw new UnsupportedOperationException();
        }

        public void o() {
            throw new UnsupportedOperationException();
        }
    };

    TrackOutput d(int i2, int i3);

    void j(SeekMap seekMap);

    void o();
}
