package androidx.media3.extractor.ts;

import androidx.media3.common.C;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.PositionHolder;
import java.io.IOException;

final class TsDurationReader {

    /* renamed from: j  reason: collision with root package name */
    private static final String f14493j = "TsDurationReader";

    /* renamed from: a  reason: collision with root package name */
    private final int f14494a;

    /* renamed from: b  reason: collision with root package name */
    private final TimestampAdjuster f14495b = new TimestampAdjuster(0);

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f14496c = new ParsableByteArray();

    /* renamed from: d  reason: collision with root package name */
    private boolean f14497d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14498e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14499f;

    /* renamed from: g  reason: collision with root package name */
    private long f14500g = C.f9084b;

    /* renamed from: h  reason: collision with root package name */
    private long f14501h = C.f9084b;

    /* renamed from: i  reason: collision with root package name */
    private long f14502i = C.f9084b;

    TsDurationReader(int i2) {
        this.f14494a = i2;
    }

    private int a(ExtractorInput extractorInput) {
        this.f14496c.V(Util.f9651f);
        this.f14497d = true;
        extractorInput.n();
        return 0;
    }

    private int f(ExtractorInput extractorInput, PositionHolder positionHolder, int i2) throws IOException {
        int min = (int) Math.min((long) this.f14494a, extractorInput.getLength());
        long j2 = (long) 0;
        if (extractorInput.getPosition() != j2) {
            positionHolder.f13111a = j2;
            return 1;
        }
        this.f14496c.U(min);
        extractorInput.n();
        extractorInput.s(this.f14496c.e(), 0, min);
        this.f14500g = g(this.f14496c, i2);
        this.f14498e = true;
        return 0;
    }

    private long g(ParsableByteArray parsableByteArray, int i2) {
        int g2 = parsableByteArray.g();
        for (int f2 = parsableByteArray.f(); f2 < g2; f2++) {
            if (parsableByteArray.e()[f2] == 71) {
                long c2 = TsUtil.c(parsableByteArray, f2, i2);
                if (c2 != C.f9084b) {
                    return c2;
                }
            }
        }
        return C.f9084b;
    }

    private int h(ExtractorInput extractorInput, PositionHolder positionHolder, int i2) throws IOException {
        long length = extractorInput.getLength();
        int min = (int) Math.min((long) this.f14494a, length);
        long j2 = length - ((long) min);
        if (extractorInput.getPosition() != j2) {
            positionHolder.f13111a = j2;
            return 1;
        }
        this.f14496c.U(min);
        extractorInput.n();
        extractorInput.s(this.f14496c.e(), 0, min);
        this.f14501h = i(this.f14496c, i2);
        this.f14499f = true;
        return 0;
    }

    private long i(ParsableByteArray parsableByteArray, int i2) {
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        for (int i3 = g2 - 188; i3 >= f2; i3--) {
            if (TsUtil.b(parsableByteArray.e(), f2, g2, i3)) {
                long c2 = TsUtil.c(parsableByteArray, i3, i2);
                if (c2 != C.f9084b) {
                    return c2;
                }
            }
        }
        return C.f9084b;
    }

    public long b() {
        return this.f14502i;
    }

    public TimestampAdjuster c() {
        return this.f14495b;
    }

    public boolean d() {
        return this.f14497d;
    }

    public int e(ExtractorInput extractorInput, PositionHolder positionHolder, int i2) throws IOException {
        if (i2 <= 0) {
            return a(extractorInput);
        }
        if (!this.f14499f) {
            return h(extractorInput, positionHolder, i2);
        }
        if (this.f14501h == C.f9084b) {
            return a(extractorInput);
        }
        if (!this.f14498e) {
            return f(extractorInput, positionHolder, i2);
        }
        long j2 = this.f14500g;
        if (j2 == C.f9084b) {
            return a(extractorInput);
        }
        this.f14502i = this.f14495b.c(this.f14501h) - this.f14495b.b(j2);
        return a(extractorInput);
    }
}
