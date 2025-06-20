package androidx.media3.extractor.ogg;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorUtil;
import java.io.IOException;

final class OggPageHeader {

    /* renamed from: l  reason: collision with root package name */
    public static final int f13728l = 27;

    /* renamed from: m  reason: collision with root package name */
    public static final int f13729m = 255;

    /* renamed from: n  reason: collision with root package name */
    public static final int f13730n = 65025;
    public static final int o = 65307;
    private static final int p = 1332176723;
    private static final int q = 4;

    /* renamed from: a  reason: collision with root package name */
    public int f13731a;

    /* renamed from: b  reason: collision with root package name */
    public int f13732b;

    /* renamed from: c  reason: collision with root package name */
    public long f13733c;

    /* renamed from: d  reason: collision with root package name */
    public long f13734d;

    /* renamed from: e  reason: collision with root package name */
    public long f13735e;

    /* renamed from: f  reason: collision with root package name */
    public long f13736f;

    /* renamed from: g  reason: collision with root package name */
    public int f13737g;

    /* renamed from: h  reason: collision with root package name */
    public int f13738h;

    /* renamed from: i  reason: collision with root package name */
    public int f13739i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f13740j = new int[255];

    /* renamed from: k  reason: collision with root package name */
    private final ParsableByteArray f13741k = new ParsableByteArray(255);

    OggPageHeader() {
    }

    public boolean a(ExtractorInput extractorInput, boolean z) throws IOException {
        b();
        this.f13741k.U(27);
        if (!ExtractorUtil.b(extractorInput, this.f13741k.e(), 0, 27, z) || this.f13741k.N() != 1332176723) {
            return false;
        }
        int L = this.f13741k.L();
        this.f13731a = L;
        if (L == 0) {
            this.f13732b = this.f13741k.L();
            this.f13733c = this.f13741k.y();
            this.f13734d = this.f13741k.A();
            this.f13735e = this.f13741k.A();
            this.f13736f = this.f13741k.A();
            int L2 = this.f13741k.L();
            this.f13737g = L2;
            this.f13738h = L2 + 27;
            this.f13741k.U(L2);
            if (!ExtractorUtil.b(extractorInput, this.f13741k.e(), 0, this.f13737g, z)) {
                return false;
            }
            for (int i2 = 0; i2 < this.f13737g; i2++) {
                this.f13740j[i2] = this.f13741k.L();
                this.f13739i += this.f13740j[i2];
            }
            return true;
        } else if (z) {
            return false;
        } else {
            throw ParserException.e("unsupported bit stream revision");
        }
    }

    public void b() {
        this.f13731a = 0;
        this.f13732b = 0;
        this.f13733c = 0;
        this.f13734d = 0;
        this.f13735e = 0;
        this.f13736f = 0;
        this.f13737g = 0;
        this.f13738h = 0;
        this.f13739i = 0;
    }

    public boolean c(ExtractorInput extractorInput) throws IOException {
        return d(extractorInput, -1);
    }

    public boolean d(ExtractorInput extractorInput, long j2) throws IOException {
        int i2;
        Assertions.a(extractorInput.getPosition() == extractorInput.i());
        this.f13741k.U(4);
        while (true) {
            i2 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
            if ((i2 == 0 || extractorInput.getPosition() + 4 < j2) && ExtractorUtil.b(extractorInput, this.f13741k.e(), 0, 4, true)) {
                this.f13741k.Y(0);
                if (this.f13741k.N() == 1332176723) {
                    extractorInput.n();
                    return true;
                }
                extractorInput.o(1);
            }
        }
        do {
            if ((i2 != 0 && extractorInput.getPosition() >= j2) || extractorInput.b(1) == -1) {
                return false;
            }
            break;
        } while (extractorInput.b(1) == -1);
        return false;
    }
}
