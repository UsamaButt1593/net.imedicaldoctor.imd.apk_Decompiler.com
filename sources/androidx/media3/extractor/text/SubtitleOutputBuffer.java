package androidx.media3.extractor.text;

import androidx.annotation.Nullable;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderOutputBuffer;
import java.util.List;

@UnstableApi
public abstract class SubtitleOutputBuffer extends DecoderOutputBuffer implements Subtitle {
    @Nullable
    private Subtitle X2;
    private long Y2;

    public int a(long j2) {
        return ((Subtitle) Assertions.g(this.X2)).a(j2 - this.Y2);
    }

    public long b(int i2) {
        return ((Subtitle) Assertions.g(this.X2)).b(i2) + this.Y2;
    }

    public List<Cue> c(long j2) {
        return ((Subtitle) Assertions.g(this.X2)).c(j2 - this.Y2);
    }

    public int e() {
        return ((Subtitle) Assertions.g(this.X2)).e();
    }

    public void g() {
        super.g();
        this.X2 = null;
    }

    public void r(long j2, Subtitle subtitle, long j3) {
        this.X = j2;
        this.X2 = subtitle;
        if (j3 != Long.MAX_VALUE) {
            j2 = j3;
        }
        this.Y2 = j2;
    }
}
