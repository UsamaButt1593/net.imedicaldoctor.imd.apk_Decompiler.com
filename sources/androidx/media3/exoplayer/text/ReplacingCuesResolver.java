package androidx.media3.exoplayer.text;

import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.extractor.text.CuesWithTiming;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.ArrayList;

final class ReplacingCuesResolver implements CuesResolver {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<CuesWithTiming> f12345a = new ArrayList<>();

    private int f(long j2) {
        for (int i2 = 0; i2 < this.f12345a.size(); i2++) {
            if (j2 < this.f12345a.get(i2).f13769b) {
                return i2;
            }
        }
        return this.f12345a.size();
    }

    public long a(long j2) {
        if (this.f12345a.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j2 < this.f12345a.get(0).f13769b) {
            return this.f12345a.get(0).f13769b;
        }
        for (int i2 = 1; i2 < this.f12345a.size(); i2++) {
            CuesWithTiming cuesWithTiming = this.f12345a.get(i2);
            if (j2 < cuesWithTiming.f13769b) {
                long j3 = this.f12345a.get(i2 - 1).f13771d;
                return (j3 == C.f9084b || j3 <= j2 || j3 >= cuesWithTiming.f13769b) ? cuesWithTiming.f13769b : j3;
            }
        }
        long j4 = ((CuesWithTiming) Iterables.w(this.f12345a)).f13771d;
        if (j4 == C.f9084b || j2 >= j4) {
            return Long.MIN_VALUE;
        }
        return j4;
    }

    public ImmutableList<Cue> b(long j2) {
        int f2 = f(j2);
        if (f2 == 0) {
            return ImmutableList.I();
        }
        CuesWithTiming cuesWithTiming = this.f12345a.get(f2 - 1);
        long j3 = cuesWithTiming.f13771d;
        return (j3 == C.f9084b || j2 < j3) ? cuesWithTiming.f13768a : ImmutableList.I();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(androidx.media3.extractor.text.CuesWithTiming r10, long r11) {
        /*
            r9 = this;
            long r0 = r10.f13769b
            r2 = 0
            r3 = 1
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x000f
            r0 = 1
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            androidx.media3.common.util.Assertions.a(r0)
            long r0 = r10.f13769b
            int r6 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r6 > 0) goto L_0x0025
            long r0 = r10.f13771d
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0023
            int r4 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x0025
        L_0x0023:
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            java.util.ArrayList<androidx.media3.extractor.text.CuesWithTiming> r1 = r9.f12345a
            int r1 = r1.size()
            int r1 = r1 - r3
        L_0x002d:
            if (r1 < 0) goto L_0x0058
            long r4 = r10.f13769b
            java.util.ArrayList<androidx.media3.extractor.text.CuesWithTiming> r6 = r9.f12345a
            java.lang.Object r6 = r6.get(r1)
            androidx.media3.extractor.text.CuesWithTiming r6 = (androidx.media3.extractor.text.CuesWithTiming) r6
            long r6 = r6.f13769b
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0046
            java.util.ArrayList<androidx.media3.extractor.text.CuesWithTiming> r11 = r9.f12345a
            int r1 = r1 + r3
            r11.add(r1, r10)
            return r0
        L_0x0046:
            java.util.ArrayList<androidx.media3.extractor.text.CuesWithTiming> r4 = r9.f12345a
            java.lang.Object r4 = r4.get(r1)
            androidx.media3.extractor.text.CuesWithTiming r4 = (androidx.media3.extractor.text.CuesWithTiming) r4
            long r4 = r4.f13769b
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 > 0) goto L_0x0055
            r0 = 0
        L_0x0055:
            int r1 = r1 + -1
            goto L_0x002d
        L_0x0058:
            java.util.ArrayList<androidx.media3.extractor.text.CuesWithTiming> r11 = r9.f12345a
            r11.add(r2, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.text.ReplacingCuesResolver.c(androidx.media3.extractor.text.CuesWithTiming, long):boolean");
    }

    public void clear() {
        this.f12345a.clear();
    }

    public long d(long j2) {
        if (this.f12345a.isEmpty() || j2 < this.f12345a.get(0).f13769b) {
            return C.f9084b;
        }
        for (int i2 = 1; i2 < this.f12345a.size(); i2++) {
            long j3 = this.f12345a.get(i2).f13769b;
            int i3 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
            if (i3 == 0) {
                return j3;
            }
            if (i3 < 0) {
                CuesWithTiming cuesWithTiming = this.f12345a.get(i2 - 1);
                long j4 = cuesWithTiming.f13771d;
                return (j4 == C.f9084b || j4 > j2) ? cuesWithTiming.f13769b : j4;
            }
        }
        CuesWithTiming cuesWithTiming2 = (CuesWithTiming) Iterables.w(this.f12345a);
        long j5 = cuesWithTiming2.f13771d;
        return (j5 == C.f9084b || j2 < j5) ? cuesWithTiming2.f13769b : j5;
    }

    public void e(long j2) {
        int f2 = f(j2);
        if (f2 > 0) {
            this.f12345a.subList(0, f2).clear();
        }
    }
}
