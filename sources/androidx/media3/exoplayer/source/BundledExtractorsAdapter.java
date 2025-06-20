package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.mp3.Mp3Extractor;
import java.io.IOException;

@UnstableApi
public final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {

    /* renamed from: a  reason: collision with root package name */
    private final ExtractorsFactory f12082a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Extractor f12083b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ExtractorInput f12084c;

    public BundledExtractorsAdapter(ExtractorsFactory extractorsFactory) {
        this.f12082a = extractorsFactory;
    }

    public void a() {
        Extractor extractor = this.f12083b;
        if (extractor != null) {
            extractor.a();
            this.f12083b = null;
        }
        this.f12084c = null;
    }

    public void c(long j2, long j3) {
        ((Extractor) Assertions.g(this.f12083b)).c(j2, j3);
    }

    public long d() {
        ExtractorInput extractorInput = this.f12084c;
        if (extractorInput != null) {
            return extractorInput.getPosition();
        }
        return -1;
    }

    public void e() {
        Extractor extractor = this.f12083b;
        if (extractor != null) {
            Extractor e2 = extractor.e();
            if (e2 instanceof Mp3Extractor) {
                ((Mp3Extractor) e2).l();
            }
        }
    }

    public int f(PositionHolder positionHolder) throws IOException {
        return ((Extractor) Assertions.g(this.f12083b)).i((ExtractorInput) Assertions.g(this.f12084c), positionHolder);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        if (r0.getPosition() != r11) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006e, code lost:
        if (r0.getPosition() != r11) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(androidx.media3.common.DataReader r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, androidx.media3.extractor.ExtractorOutput r15) throws java.io.IOException {
        /*
            r7 = this;
            androidx.media3.extractor.DefaultExtractorInput r6 = new androidx.media3.extractor.DefaultExtractorInput
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.f12084c = r6
            androidx.media3.extractor.Extractor r8 = r7.f12083b
            if (r8 == 0) goto L_0x0010
            return
        L_0x0010:
            androidx.media3.extractor.ExtractorsFactory r8 = r7.f12082a
            androidx.media3.extractor.Extractor[] r8 = r8.d(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L_0x0020
            r8 = r8[r13]
            r7.f12083b = r8
            goto L_0x0078
        L_0x0020:
            int r10 = r8.length
            r0 = 0
        L_0x0022:
            if (r0 >= r10) goto L_0x0074
            r1 = r8[r0]
            boolean r2 = r1.h(r6)     // Catch:{ EOFException -> 0x0037, all -> 0x0035 }
            if (r2 == 0) goto L_0x0039
            r7.f12083b = r1     // Catch:{ EOFException -> 0x0037, all -> 0x0035 }
            androidx.media3.common.util.Assertions.i(r14)
            r6.n()
            goto L_0x0074
        L_0x0035:
            r8 = move-exception
            goto L_0x0050
        L_0x0037:
            goto L_0x0064
        L_0x0039:
            androidx.media3.extractor.Extractor r1 = r7.f12083b
            if (r1 != 0) goto L_0x0048
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r1 = 0
            goto L_0x0049
        L_0x0048:
            r1 = 1
        L_0x0049:
            androidx.media3.common.util.Assertions.i(r1)
            r6.n()
            goto L_0x0071
        L_0x0050:
            androidx.media3.extractor.Extractor r9 = r7.f12083b
            if (r9 != 0) goto L_0x005c
            long r9 = r6.getPosition()
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 != 0) goto L_0x005d
        L_0x005c:
            r13 = 1
        L_0x005d:
            androidx.media3.common.util.Assertions.i(r13)
            r6.n()
            throw r8
        L_0x0064:
            androidx.media3.extractor.Extractor r1 = r7.f12083b
            if (r1 != 0) goto L_0x0048
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0046
            goto L_0x0048
        L_0x0071:
            int r0 = r0 + 1
            goto L_0x0022
        L_0x0074:
            androidx.media3.extractor.Extractor r10 = r7.f12083b
            if (r10 == 0) goto L_0x007e
        L_0x0078:
            androidx.media3.extractor.Extractor r8 = r7.f12083b
            r8.d(r15)
            return
        L_0x007e:
            androidx.media3.exoplayer.source.UnrecognizedInputFormatException r10 = new androidx.media3.exoplayer.source.UnrecognizedInputFormatException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "None of the available extractors ("
            r11.append(r12)
            java.lang.String r8 = androidx.media3.common.util.Util.h0(r8)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            java.lang.Object r9 = androidx.media3.common.util.Assertions.g(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            r10.<init>(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.BundledExtractorsAdapter.g(androidx.media3.common.DataReader, android.net.Uri, java.util.Map, long, long, androidx.media3.extractor.ExtractorOutput):void");
    }
}
