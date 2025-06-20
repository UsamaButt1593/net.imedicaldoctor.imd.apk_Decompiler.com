package androidx.media3.extractor.text;

import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

@UnstableApi
public final class CuesWithTimingSubtitle implements Subtitle {
    private static final String Y = "CuesWithTimingSubtitle";
    private static final Ordering<CuesWithTiming> Z = Ordering.z().D(new b());
    private final long[] X;
    private final ImmutableList<ImmutableList<Cue>> s;

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CuesWithTimingSubtitle(java.util.List<androidx.media3.extractor.text.CuesWithTiming> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = 2
            r2 = 0
            r17.<init>()
            int r3 = r18.size()
            r4 = 1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 != r4) goto L_0x004c
            java.lang.Object r3 = com.google.common.collect.Iterables.z(r18)
            androidx.media3.extractor.text.CuesWithTiming r3 = (androidx.media3.extractor.text.CuesWithTiming) r3
            long r7 = r3.f13769b
            long r7 = h(r7)
            long r9 = r3.f13770c
            int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r11 != 0) goto L_0x0034
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r1 = r3.f13768a
            com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.K(r1)
            r0.s = r1
            long[] r1 = new long[r4]
            r1[r2] = r7
            r0.X = r1
            goto L_0x004b
        L_0x0034:
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r5 = r3.f13768a
            com.google.common.collect.ImmutableList r6 = com.google.common.collect.ImmutableList.I()
            com.google.common.collect.ImmutableList r5 = com.google.common.collect.ImmutableList.L(r5, r6)
            r0.s = r5
            long r5 = r3.f13770c
            long r5 = r5 + r7
            long[] r1 = new long[r1]
            r1[r2] = r7
            r1[r4] = r5
            r0.X = r1
        L_0x004b:
            return
        L_0x004c:
            int r3 = r18.size()
            int r3 = r3 * 2
            long[] r1 = new long[r3]
            r0.X = r1
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.util.Arrays.fill(r1, r7)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.google.common.collect.Ordering<androidx.media3.extractor.text.CuesWithTiming> r3 = Z
            r7 = r18
            com.google.common.collect.ImmutableList r3 = com.google.common.collect.ImmutableList.a0(r3, r7)
            r7 = 0
        L_0x006c:
            int r8 = r3.size()
            if (r2 >= r8) goto L_0x00d2
            java.lang.Object r8 = r3.get(r2)
            androidx.media3.extractor.text.CuesWithTiming r8 = (androidx.media3.extractor.text.CuesWithTiming) r8
            long r9 = r8.f13769b
            long r9 = h(r9)
            long r11 = r8.f13770c
            long r11 = r11 + r9
            if (r7 == 0) goto L_0x00b0
            long[] r13 = r0.X
            int r14 = r7 + -1
            r15 = r13[r14]
            int r13 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r13 >= 0) goto L_0x008e
            goto L_0x00b0
        L_0x008e:
            int r13 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r13 != 0) goto L_0x00a4
            java.lang.Object r13 = r1.get(r14)
            com.google.common.collect.ImmutableList r13 = (com.google.common.collect.ImmutableList) r13
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x00a4
        L_0x009e:
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r9 = r8.f13768a
            r1.set(r14, r9)
            goto L_0x00bc
        L_0x00a4:
            java.lang.String r13 = "CuesWithTimingSubtitle"
            java.lang.String r15 = "Truncating unsupported overlapping cues."
            androidx.media3.common.util.Log.n(r13, r15)
            long[] r13 = r0.X
            r13[r14] = r9
            goto L_0x009e
        L_0x00b0:
            long[] r13 = r0.X
            int r14 = r7 + 1
            r13[r7] = r9
            com.google.common.collect.ImmutableList<androidx.media3.common.text.Cue> r7 = r8.f13768a
            r1.add(r7)
            r7 = r14
        L_0x00bc:
            long r8 = r8.f13770c
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x00d0
            long[] r8 = r0.X
            int r9 = r7 + 1
            r8[r7] = r11
            com.google.common.collect.ImmutableList r7 = com.google.common.collect.ImmutableList.I()
            r1.add(r7)
            r7 = r9
        L_0x00d0:
            int r2 = r2 + r4
            goto L_0x006c
        L_0x00d2:
            com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.B(r1)
            r0.s = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.CuesWithTimingSubtitle.<init>(java.util.List):void");
    }

    private static long h(long j2) {
        if (j2 == C.f9084b) {
            return 0;
        }
        return j2;
    }

    public int a(long j2) {
        int j3 = Util.j(this.X, j2, false, false);
        if (j3 < this.s.size()) {
            return j3;
        }
        return -1;
    }

    public long b(int i2) {
        Assertions.a(i2 < this.s.size());
        return this.X[i2];
    }

    public int e() {
        return this.s.size();
    }

    /* renamed from: f */
    public ImmutableList<Cue> c(long j2) {
        int n2 = Util.n(this.X, j2, true, false);
        return n2 == -1 ? ImmutableList.I() : this.s.get(n2);
    }
}
