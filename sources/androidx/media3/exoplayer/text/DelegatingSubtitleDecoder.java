package androidx.media3.exoplayer.text;

import androidx.media3.extractor.text.SimpleSubtitleDecoder;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;

final class DelegatingSubtitleDecoder extends SimpleSubtitleDecoder {
    private final SubtitleParser p;

    public DelegatingSubtitleDecoder(String str, SubtitleParser subtitleParser) {
        super(str);
        this.p = subtitleParser;
    }

    /* access modifiers changed from: protected */
    public Subtitle C(byte[] bArr, int i2, boolean z) {
        if (z) {
            this.p.reset();
        }
        return this.p.b(bArr, 0, i2);
    }
}
