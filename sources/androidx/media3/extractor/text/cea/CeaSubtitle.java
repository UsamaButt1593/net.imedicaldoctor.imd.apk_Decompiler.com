package androidx.media3.extractor.text.cea;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.Subtitle;
import java.util.Collections;
import java.util.List;

final class CeaSubtitle implements Subtitle {
    private final List<Cue> s;

    public CeaSubtitle(List<Cue> list) {
        this.s = list;
    }

    public int a(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    public long b(int i2) {
        Assertions.a(i2 == 0);
        return 0;
    }

    public List<Cue> c(long j2) {
        return j2 >= 0 ? this.s : Collections.emptyList();
    }

    public int e() {
        return 1;
    }
}
