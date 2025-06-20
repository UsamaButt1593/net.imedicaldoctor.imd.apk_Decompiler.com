package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.Subtitle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class WebvttSubtitle implements Subtitle {
    private final long[] X;
    private final long[] Y;
    private final List<WebvttCueInfo> s;

    public WebvttSubtitle(List<WebvttCueInfo> list) {
        this.s = Collections.unmodifiableList(new ArrayList(list));
        this.X = new long[(list.size() * 2)];
        for (int i2 = 0; i2 < list.size(); i2++) {
            WebvttCueInfo webvttCueInfo = list.get(i2);
            int i3 = i2 * 2;
            long[] jArr = this.X;
            jArr[i3] = webvttCueInfo.f14120b;
            jArr[i3 + 1] = webvttCueInfo.f14121c;
        }
        long[] jArr2 = this.X;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.Y = copyOf;
        Arrays.sort(copyOf);
    }

    public int a(long j2) {
        int j3 = Util.j(this.Y, j2, false, false);
        if (j3 < this.Y.length) {
            return j3;
        }
        return -1;
    }

    public long b(int i2) {
        boolean z = false;
        Assertions.a(i2 >= 0);
        if (i2 < this.Y.length) {
            z = true;
        }
        Assertions.a(z);
        return this.Y[i2];
    }

    public List<Cue> c(long j2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            long[] jArr = this.X;
            int i3 = i2 * 2;
            if (jArr[i3] <= j2 && j2 < jArr[i3 + 1]) {
                WebvttCueInfo webvttCueInfo = this.s.get(i2);
                Cue cue = webvttCueInfo.f14119a;
                if (cue.X2 == -3.4028235E38f) {
                    arrayList2.add(webvttCueInfo);
                } else {
                    arrayList.add(cue);
                }
            }
        }
        Collections.sort(arrayList2, new b());
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            arrayList.add(((WebvttCueInfo) arrayList2.get(i4)).f14119a.b().t((float) (-1 - i4), 1).a());
        }
        return arrayList;
    }

    public int e() {
        return this.Y.length;
    }
}
