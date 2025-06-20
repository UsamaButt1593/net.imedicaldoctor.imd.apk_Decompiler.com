package androidx.media3.extractor.ts;

import androidx.media3.common.C;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.BinarySearchSeeker;
import androidx.media3.extractor.ExtractorInput;
import com.google.common.base.Ascii;
import java.io.IOException;

final class PsBinarySearchSeeker extends BinarySearchSeeker {

    /* renamed from: f  reason: collision with root package name */
    private static final long f14441f = 100000;

    /* renamed from: g  reason: collision with root package name */
    private static final int f14442g = 1000;

    /* renamed from: h  reason: collision with root package name */
    private static final int f14443h = 20000;

    private static final class PsScrSeeker implements BinarySearchSeeker.TimestampSeeker {

        /* renamed from: a  reason: collision with root package name */
        private final TimestampAdjuster f14444a;

        /* renamed from: b  reason: collision with root package name */
        private final ParsableByteArray f14445b;

        private PsScrSeeker(TimestampAdjuster timestampAdjuster) {
            this.f14444a = timestampAdjuster;
            this.f14445b = new ParsableByteArray();
        }

        private BinarySearchSeeker.TimestampSearchResult c(ParsableByteArray parsableByteArray, long j2, long j3) {
            int i2 = -1;
            long j4 = -9223372036854775807L;
            int i3 = -1;
            while (parsableByteArray.a() >= 4) {
                if (PsBinarySearchSeeker.k(parsableByteArray.e(), parsableByteArray.f()) != 442) {
                    parsableByteArray.Z(1);
                } else {
                    parsableByteArray.Z(4);
                    long l2 = PsDurationReader.l(parsableByteArray);
                    if (l2 != C.f9084b) {
                        long b2 = this.f14444a.b(l2);
                        if (b2 > j2) {
                            return j4 == C.f9084b ? BinarySearchSeeker.TimestampSearchResult.d(b2, j3) : BinarySearchSeeker.TimestampSearchResult.e(j3 + ((long) i3));
                        }
                        if (100000 + b2 > j2) {
                            return BinarySearchSeeker.TimestampSearchResult.e(j3 + ((long) parsableByteArray.f()));
                        }
                        i3 = parsableByteArray.f();
                        j4 = b2;
                    }
                    d(parsableByteArray);
                    i2 = parsableByteArray.f();
                }
            }
            return j4 != C.f9084b ? BinarySearchSeeker.TimestampSearchResult.f(j4, j3 + ((long) i2)) : BinarySearchSeeker.TimestampSearchResult.f12959h;
        }

        private static void d(ParsableByteArray parsableByteArray) {
            int g2 = parsableByteArray.g();
            if (parsableByteArray.a() < 10) {
                parsableByteArray.Y(g2);
                return;
            }
            parsableByteArray.Z(9);
            int L = parsableByteArray.L() & 7;
            if (parsableByteArray.a() < L) {
                parsableByteArray.Y(g2);
                return;
            }
            parsableByteArray.Z(L);
            if (parsableByteArray.a() < 4) {
                parsableByteArray.Y(g2);
                return;
            }
            if (PsBinarySearchSeeker.k(parsableByteArray.e(), parsableByteArray.f()) == 443) {
                parsableByteArray.Z(4);
                int R = parsableByteArray.R();
                if (parsableByteArray.a() < R) {
                    parsableByteArray.Y(g2);
                    return;
                }
                parsableByteArray.Z(R);
            }
            while (parsableByteArray.a() >= 4 && (r1 = PsBinarySearchSeeker.k(parsableByteArray.e(), parsableByteArray.f())) != 442 && r1 != 441 && (r1 >>> 8) == 1) {
                parsableByteArray.Z(4);
                if (parsableByteArray.a() < 2) {
                    parsableByteArray.Y(g2);
                    return;
                } else {
                    parsableByteArray.Y(Math.min(parsableByteArray.g(), parsableByteArray.f() + parsableByteArray.R()));
                }
            }
        }

        public BinarySearchSeeker.TimestampSearchResult a(ExtractorInput extractorInput, long j2) throws IOException {
            long position = extractorInput.getPosition();
            int min = (int) Math.min(20000, extractorInput.getLength() - position);
            this.f14445b.U(min);
            extractorInput.s(this.f14445b.e(), 0, min);
            return c(this.f14445b, j2, position);
        }

        public void b() {
            this.f14445b.V(Util.f9651f);
        }
    }

    public PsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long j2, long j3) {
        super(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new PsScrSeeker(timestampAdjuster), j2, 0, j2 + 1, 0, j3, 188, 1000);
    }

    /* access modifiers changed from: private */
    public static int k(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << Ascii.B) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }
}
