package androidx.media3.extractor.text;

import android.util.SparseArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;

@UnstableApi
public final class SubtitleTranscodingExtractorOutput implements ExtractorOutput {
    private final SubtitleParser.Factory X;
    private final SparseArray<SubtitleTranscodingTrackOutput> Y = new SparseArray<>();
    private final ExtractorOutput s;

    public SubtitleTranscodingExtractorOutput(ExtractorOutput extractorOutput, SubtitleParser.Factory factory) {
        this.s = extractorOutput;
        this.X = factory;
    }

    public void a() {
        for (int i2 = 0; i2 < this.Y.size(); i2++) {
            this.Y.valueAt(i2).k();
        }
    }

    public TrackOutput d(int i2, int i3) {
        if (i3 != 3) {
            return this.s.d(i2, i3);
        }
        SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput = this.Y.get(i2);
        if (subtitleTranscodingTrackOutput != null) {
            return subtitleTranscodingTrackOutput;
        }
        SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput2 = new SubtitleTranscodingTrackOutput(this.s.d(i2, i3), this.X);
        this.Y.put(i2, subtitleTranscodingTrackOutput2);
        return subtitleTranscodingTrackOutput2;
    }

    public void j(SeekMap seekMap) {
        this.s.j(seekMap);
    }

    public void o() {
        this.s.o();
    }
}
