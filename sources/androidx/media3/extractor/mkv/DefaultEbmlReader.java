package androidx.media3.extractor.mkv;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;
import java.util.ArrayDeque;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class DefaultEbmlReader implements EbmlReader {

    /* renamed from: h  reason: collision with root package name */
    private static final int f13396h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static final int f13397i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static final int f13398j = 2;

    /* renamed from: k  reason: collision with root package name */
    private static final int f13399k = 4;

    /* renamed from: l  reason: collision with root package name */
    private static final int f13400l = 8;

    /* renamed from: m  reason: collision with root package name */
    private static final int f13401m = 8;

    /* renamed from: n  reason: collision with root package name */
    private static final int f13402n = 4;
    private static final int o = 8;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f13403a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<MasterElement> f13404b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private final VarintReader f13405c = new VarintReader();

    /* renamed from: d  reason: collision with root package name */
    private EbmlProcessor f13406d;

    /* renamed from: e  reason: collision with root package name */
    private int f13407e;

    /* renamed from: f  reason: collision with root package name */
    private int f13408f;

    /* renamed from: g  reason: collision with root package name */
    private long f13409g;

    private static final class MasterElement {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f13410a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f13411b;

        private MasterElement(int i2, long j2) {
            this.f13410a = i2;
            this.f13411b = j2;
        }
    }

    @RequiresNonNull({"processor"})
    private long c(ExtractorInput extractorInput) throws IOException {
        extractorInput.n();
        while (true) {
            extractorInput.s(this.f13403a, 0, 4);
            int c2 = VarintReader.c(this.f13403a[0]);
            if (c2 != -1 && c2 <= 4) {
                int a2 = (int) VarintReader.a(this.f13403a, c2, false);
                if (this.f13406d.c(a2)) {
                    extractorInput.o(c2);
                    return (long) a2;
                }
            }
            extractorInput.o(1);
        }
    }

    private double d(ExtractorInput extractorInput, int i2) throws IOException {
        long e2 = e(extractorInput, i2);
        return i2 == 4 ? (double) Float.intBitsToFloat((int) e2) : Double.longBitsToDouble(e2);
    }

    private long e(ExtractorInput extractorInput, int i2) throws IOException {
        extractorInput.readFully(this.f13403a, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | ((long) (this.f13403a[i3] & 255));
        }
        return j2;
    }

    private static String f(ExtractorInput extractorInput, int i2) throws IOException {
        if (i2 == 0) {
            return "";
        }
        byte[] bArr = new byte[i2];
        extractorInput.readFully(bArr, 0, i2);
        while (i2 > 0 && bArr[i2 - 1] == 0) {
            i2--;
        }
        return new String(bArr, 0, i2);
    }

    public void a(EbmlProcessor ebmlProcessor) {
        this.f13406d = ebmlProcessor;
    }

    public boolean b(ExtractorInput extractorInput) throws IOException {
        Assertions.k(this.f13406d);
        while (true) {
            MasterElement peek = this.f13404b.peek();
            if (peek == null || extractorInput.getPosition() < peek.f13411b) {
                if (this.f13407e == 0) {
                    long d2 = this.f13405c.d(extractorInput, true, false, 4);
                    if (d2 == -2) {
                        d2 = c(extractorInput);
                    }
                    if (d2 == -1) {
                        return false;
                    }
                    this.f13408f = (int) d2;
                    this.f13407e = 1;
                }
                if (this.f13407e == 1) {
                    this.f13409g = this.f13405c.d(extractorInput, false, true, 8);
                    this.f13407e = 2;
                }
                int b2 = this.f13406d.b(this.f13408f);
                if (b2 == 0) {
                    extractorInput.o((int) this.f13409g);
                    this.f13407e = 0;
                } else if (b2 == 1) {
                    long position = extractorInput.getPosition();
                    this.f13404b.push(new MasterElement(this.f13408f, this.f13409g + position));
                    this.f13406d.g(this.f13408f, position, this.f13409g);
                    this.f13407e = 0;
                    return true;
                } else if (b2 == 2) {
                    long j2 = this.f13409g;
                    if (j2 <= 8) {
                        this.f13406d.h(this.f13408f, e(extractorInput, (int) j2));
                        this.f13407e = 0;
                        return true;
                    }
                    throw ParserException.a("Invalid integer size: " + this.f13409g, (Throwable) null);
                } else if (b2 == 3) {
                    long j3 = this.f13409g;
                    if (j3 <= 2147483647L) {
                        this.f13406d.d(this.f13408f, f(extractorInput, (int) j3));
                        this.f13407e = 0;
                        return true;
                    }
                    throw ParserException.a("String element size: " + this.f13409g, (Throwable) null);
                } else if (b2 == 4) {
                    this.f13406d.f(this.f13408f, (int) this.f13409g, extractorInput);
                    this.f13407e = 0;
                    return true;
                } else if (b2 == 5) {
                    long j4 = this.f13409g;
                    if (j4 == 4 || j4 == 8) {
                        this.f13406d.e(this.f13408f, d(extractorInput, (int) j4));
                        this.f13407e = 0;
                        return true;
                    }
                    throw ParserException.a("Invalid float size: " + this.f13409g, (Throwable) null);
                } else {
                    throw ParserException.a("Invalid element type " + b2, (Throwable) null);
                }
            } else {
                this.f13406d.a(this.f13404b.pop().f13410a);
                return true;
            }
        }
    }

    public void reset() {
        this.f13407e = 0;
        this.f13404b.clear();
        this.f13405c.e();
    }
}
