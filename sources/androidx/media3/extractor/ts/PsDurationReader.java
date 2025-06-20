package androidx.media3.extractor.ts;

import androidx.media3.common.C;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.PositionHolder;
import com.google.common.base.Ascii;
import java.io.IOException;

final class PsDurationReader {

    /* renamed from: i  reason: collision with root package name */
    private static final String f14446i = "PsDurationReader";

    /* renamed from: j  reason: collision with root package name */
    private static final int f14447j = 20000;

    /* renamed from: a  reason: collision with root package name */
    private final TimestampAdjuster f14448a = new TimestampAdjuster(0);

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f14449b = new ParsableByteArray();

    /* renamed from: c  reason: collision with root package name */
    private boolean f14450c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14451d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14452e;

    /* renamed from: f  reason: collision with root package name */
    private long f14453f = C.f9084b;

    /* renamed from: g  reason: collision with root package name */
    private long f14454g = C.f9084b;

    /* renamed from: h  reason: collision with root package name */
    private long f14455h = C.f9084b;

    PsDurationReader() {
    }

    private static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    private int b(ExtractorInput extractorInput) {
        this.f14449b.V(Util.f9651f);
        this.f14450c = true;
        extractorInput.n();
        return 0;
    }

    private int f(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << Ascii.B) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    private int h(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int min = (int) Math.min(20000, extractorInput.getLength());
        long j2 = (long) 0;
        if (extractorInput.getPosition() != j2) {
            positionHolder.f13111a = j2;
            return 1;
        }
        this.f14449b.U(min);
        extractorInput.n();
        extractorInput.s(this.f14449b.e(), 0, min);
        this.f14453f = i(this.f14449b);
        this.f14451d = true;
        return 0;
    }

    private long i(ParsableByteArray parsableByteArray) {
        int g2 = parsableByteArray.g();
        for (int f2 = parsableByteArray.f(); f2 < g2 - 3; f2++) {
            if (f(parsableByteArray.e(), f2) == 442) {
                parsableByteArray.Y(f2 + 4);
                long l2 = l(parsableByteArray);
                if (l2 != C.f9084b) {
                    return l2;
                }
            }
        }
        return C.f9084b;
    }

    private int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        long length = extractorInput.getLength();
        int min = (int) Math.min(20000, length);
        long j2 = length - ((long) min);
        if (extractorInput.getPosition() != j2) {
            positionHolder.f13111a = j2;
            return 1;
        }
        this.f14449b.U(min);
        extractorInput.n();
        extractorInput.s(this.f14449b.e(), 0, min);
        this.f14454g = k(this.f14449b);
        this.f14452e = true;
        return 0;
    }

    private long k(ParsableByteArray parsableByteArray) {
        int f2 = parsableByteArray.f();
        for (int g2 = parsableByteArray.g() - 4; g2 >= f2; g2--) {
            if (f(parsableByteArray.e(), g2) == 442) {
                parsableByteArray.Y(g2 + 4);
                long l2 = l(parsableByteArray);
                if (l2 != C.f9084b) {
                    return l2;
                }
            }
        }
        return C.f9084b;
    }

    public static long l(ParsableByteArray parsableByteArray) {
        int f2 = parsableByteArray.f();
        if (parsableByteArray.a() < 9) {
            return C.f9084b;
        }
        byte[] bArr = new byte[9];
        parsableByteArray.n(bArr, 0, 9);
        parsableByteArray.Y(f2);
        return !a(bArr) ? C.f9084b : m(bArr);
    }

    private static long m(byte[] bArr) {
        byte b2 = bArr[0];
        byte b3 = bArr[2];
        return (((((long) b2) & 56) >> 3) << 30) | ((((long) b2) & 3) << 28) | ((((long) bArr[1]) & 255) << 20) | (((((long) b3) & 248) >> 3) << 15) | ((((long) b3) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public long c() {
        return this.f14455h;
    }

    public TimestampAdjuster d() {
        return this.f14448a;
    }

    public boolean e() {
        return this.f14450c;
    }

    public int g(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        if (!this.f14452e) {
            return j(extractorInput, positionHolder);
        }
        if (this.f14454g == C.f9084b) {
            return b(extractorInput);
        }
        if (!this.f14451d) {
            return h(extractorInput, positionHolder);
        }
        long j2 = this.f14453f;
        if (j2 == C.f9084b) {
            return b(extractorInput);
        }
        this.f14455h = this.f14448a.c(this.f14454g) - this.f14448a.b(j2);
        return b(extractorInput);
    }
}
