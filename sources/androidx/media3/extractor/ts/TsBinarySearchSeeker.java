package androidx.media3.extractor.ts;

import androidx.media3.common.C;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.BinarySearchSeeker;
import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;

final class TsBinarySearchSeeker extends BinarySearchSeeker {

    /* renamed from: f  reason: collision with root package name */
    private static final long f14487f = 100000;

    /* renamed from: g  reason: collision with root package name */
    private static final int f14488g = 940;

    private static final class TsPcrSeeker implements BinarySearchSeeker.TimestampSeeker {

        /* renamed from: a  reason: collision with root package name */
        private final TimestampAdjuster f14489a;

        /* renamed from: b  reason: collision with root package name */
        private final ParsableByteArray f14490b = new ParsableByteArray();

        /* renamed from: c  reason: collision with root package name */
        private final int f14491c;

        /* renamed from: d  reason: collision with root package name */
        private final int f14492d;

        public TsPcrSeeker(int i2, TimestampAdjuster timestampAdjuster, int i3) {
            this.f14491c = i2;
            this.f14489a = timestampAdjuster;
            this.f14492d = i3;
        }

        private BinarySearchSeeker.TimestampSearchResult c(ParsableByteArray parsableByteArray, long j2, long j3) {
            int a2;
            int i2;
            ParsableByteArray parsableByteArray2 = parsableByteArray;
            long j4 = j3;
            int g2 = parsableByteArray.g();
            long j5 = -1;
            long j6 = -1;
            long j7 = -9223372036854775807L;
            while (parsableByteArray.a() >= 188 && (i2 = a2 + TsExtractor.D) <= g2) {
                long c2 = TsUtil.c(parsableByteArray2, (a2 = TsUtil.a(parsableByteArray.e(), parsableByteArray.f(), g2)), this.f14491c);
                if (c2 != C.f9084b) {
                    long b2 = this.f14489a.b(c2);
                    if (b2 > j2) {
                        return j7 == C.f9084b ? BinarySearchSeeker.TimestampSearchResult.d(b2, j4) : BinarySearchSeeker.TimestampSearchResult.e(j4 + j6);
                    }
                    if (100000 + b2 > j2) {
                        return BinarySearchSeeker.TimestampSearchResult.e(j4 + ((long) a2));
                    }
                    j6 = (long) a2;
                    j7 = b2;
                }
                parsableByteArray2.Y(i2);
                j5 = (long) i2;
            }
            return j7 != C.f9084b ? BinarySearchSeeker.TimestampSearchResult.f(j7, j4 + j5) : BinarySearchSeeker.TimestampSearchResult.f12959h;
        }

        public BinarySearchSeeker.TimestampSearchResult a(ExtractorInput extractorInput, long j2) throws IOException {
            long position = extractorInput.getPosition();
            int min = (int) Math.min((long) this.f14492d, extractorInput.getLength() - position);
            this.f14490b.U(min);
            extractorInput.s(this.f14490b.e(), 0, min);
            return c(this.f14490b, j2, position);
        }

        public void b() {
            this.f14490b.V(Util.f9651f);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TsBinarySearchSeeker(androidx.media3.common.util.TimestampAdjuster r17, long r18, long r20, int r22, int r23) {
        /*
            r16 = this;
            androidx.media3.extractor.BinarySearchSeeker$DefaultSeekTimestampConverter r1 = new androidx.media3.extractor.BinarySearchSeeker$DefaultSeekTimestampConverter
            r1.<init>()
            androidx.media3.extractor.ts.TsBinarySearchSeeker$TsPcrSeeker r2 = new androidx.media3.extractor.ts.TsBinarySearchSeeker$TsPcrSeeker
            r0 = r17
            r3 = r22
            r4 = r23
            r2.<init>(r3, r0, r4)
            r3 = 1
            long r7 = r18 + r3
            r13 = 188(0xbc, double:9.3E-322)
            r15 = 940(0x3ac, float:1.317E-42)
            r5 = 0
            r9 = 0
            r0 = r16
            r3 = r18
            r11 = r20
            r0.<init>(r1, r2, r3, r5, r7, r9, r11, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.TsBinarySearchSeeker.<init>(androidx.media3.common.util.TimestampAdjuster, long, long, int, int):void");
    }
}
