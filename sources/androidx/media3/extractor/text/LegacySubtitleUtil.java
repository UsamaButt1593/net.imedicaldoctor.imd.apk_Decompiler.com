package androidx.media3.extractor.text;

import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.List;

@UnstableApi
public class LegacySubtitleUtil {
    private LegacySubtitleUtil() {
    }

    private static int a(Subtitle subtitle, SubtitleParser.OutputOptions outputOptions) {
        long j2 = outputOptions.f13785a;
        if (j2 == C.f9084b) {
            return 0;
        }
        int a2 = subtitle.a(j2);
        if (a2 == -1) {
            return subtitle.e();
        }
        return (a2 <= 0 || subtitle.b(a2 + -1) != outputOptions.f13785a) ? a2 : a2 - 1;
    }

    private static void b(Subtitle subtitle, int i2, Consumer<CuesWithTiming> consumer) {
        long b2 = subtitle.b(i2);
        List<Cue> c2 = subtitle.c(b2);
        if (!c2.isEmpty()) {
            if (i2 != subtitle.e() - 1) {
                long b3 = subtitle.b(i2 + 1) - subtitle.b(i2);
                if (b3 > 0) {
                    consumer.accept(new CuesWithTiming(c2, b2, b3));
                    return;
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f A[LOOP:0: B:11:0x0039->B:13:0x003f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(androidx.media3.extractor.text.Subtitle r13, androidx.media3.extractor.text.SubtitleParser.OutputOptions r14, androidx.media3.common.util.Consumer<androidx.media3.extractor.text.CuesWithTiming> r15) {
        /*
            int r0 = a(r13, r14)
            long r1 = r14.f13785a
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x0037
            java.util.List r8 = r13.c(r1)
            long r1 = r13.b(r0)
            boolean r3 = r8.isEmpty()
            if (r3 != 0) goto L_0x0037
            int r3 = r13.e()
            if (r0 >= r3) goto L_0x0037
            long r9 = r14.f13785a
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0037
            androidx.media3.extractor.text.CuesWithTiming r3 = new androidx.media3.extractor.text.CuesWithTiming
            long r11 = r1 - r9
            r7 = r3
            r7.<init>(r8, r9, r11)
            r15.accept(r3)
            r1 = 1
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            r2 = r0
        L_0x0039:
            int r3 = r13.e()
            if (r2 >= r3) goto L_0x0045
            b(r13, r2, r15)
            int r2 = r2 + 1
            goto L_0x0039
        L_0x0045:
            boolean r2 = r14.f13786b
            if (r2 == 0) goto L_0x0072
            if (r1 == 0) goto L_0x004d
            int r0 = r0 + -1
        L_0x004d:
            if (r5 >= r0) goto L_0x0055
            b(r13, r5, r15)
            int r5 = r5 + 1
            goto L_0x004d
        L_0x0055:
            if (r1 == 0) goto L_0x0072
            androidx.media3.extractor.text.CuesWithTiming r1 = new androidx.media3.extractor.text.CuesWithTiming
            long r2 = r14.f13785a
            java.util.List r7 = r13.c(r2)
            long r8 = r13.b(r0)
            long r2 = r14.f13785a
            long r13 = r13.b(r0)
            long r10 = r2 - r13
            r6 = r1
            r6.<init>(r7, r8, r10)
            r15.accept(r1)
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.LegacySubtitleUtil.c(androidx.media3.extractor.text.Subtitle, androidx.media3.extractor.text.SubtitleParser$OutputOptions, androidx.media3.common.util.Consumer):void");
    }
}
