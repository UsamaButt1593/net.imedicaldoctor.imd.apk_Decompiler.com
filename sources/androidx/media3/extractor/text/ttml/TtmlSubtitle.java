package androidx.media3.extractor.text.ttml;

import androidx.annotation.VisibleForTesting;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.Subtitle;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class TtmlSubtitle implements Subtitle {
    private final long[] X;
    private final Map<String, String> X2;
    private final Map<String, TtmlStyle> Y;
    private final Map<String, TtmlRegion> Z;
    private final TtmlNode s;

    public TtmlSubtitle(TtmlNode ttmlNode, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, Map<String, String> map3) {
        this.s = ttmlNode;
        this.Z = map2;
        this.X2 = map3;
        this.Y = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.X = ttmlNode.j();
    }

    public int a(long j2) {
        int j3 = Util.j(this.X, j2, false, false);
        if (j3 < this.X.length) {
            return j3;
        }
        return -1;
    }

    public long b(int i2) {
        return this.X[i2];
    }

    public List<Cue> c(long j2) {
        return this.s.h(j2, this.Y, this.Z, this.X2);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Map<String, TtmlStyle> d() {
        return this.Y;
    }

    public int e() {
        return this.X.length;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public TtmlNode f() {
        return this.s;
    }
}
