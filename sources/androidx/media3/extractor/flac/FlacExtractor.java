package androidx.media3.extractor.flac;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.FlacFrameReader;
import androidx.media3.extractor.FlacMetadataReader;
import androidx.media3.extractor.FlacSeekTableSeekMap;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class FlacExtractor implements Extractor {
    private static final int A = -1;
    public static final ExtractorsFactory r = new b();
    public static final int s = 1;
    private static final int t = 0;
    private static final int u = 1;
    private static final int v = 2;
    private static final int w = 3;
    private static final int x = 4;
    private static final int y = 5;
    private static final int z = 32768;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f13253d;

    /* renamed from: e  reason: collision with root package name */
    private final ParsableByteArray f13254e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f13255f;

    /* renamed from: g  reason: collision with root package name */
    private final FlacFrameReader.SampleNumberHolder f13256g;

    /* renamed from: h  reason: collision with root package name */
    private ExtractorOutput f13257h;

    /* renamed from: i  reason: collision with root package name */
    private TrackOutput f13258i;

    /* renamed from: j  reason: collision with root package name */
    private int f13259j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private Metadata f13260k;

    /* renamed from: l  reason: collision with root package name */
    private FlacStreamMetadata f13261l;

    /* renamed from: m  reason: collision with root package name */
    private int f13262m;

    /* renamed from: n  reason: collision with root package name */
    private int f13263n;
    private FlacBinarySearchSeeker o;
    private int p;
    private long q;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public FlacExtractor() {
        this(0);
    }

    private long f(ParsableByteArray parsableByteArray, boolean z2) {
        boolean z3;
        Assertions.g(this.f13261l);
        int f2 = parsableByteArray.f();
        while (true) {
            if (f2 <= parsableByteArray.g() - 16) {
                parsableByteArray.Y(f2);
                if (FlacFrameReader.d(parsableByteArray, this.f13261l, this.f13263n, this.f13256g)) {
                    break;
                }
                f2++;
            } else if (z2) {
                while (f2 <= parsableByteArray.g() - this.f13262m) {
                    parsableByteArray.Y(f2);
                    boolean z4 = false;
                    try {
                        z3 = FlacFrameReader.d(parsableByteArray, this.f13261l, this.f13263n, this.f13256g);
                    } catch (IndexOutOfBoundsException unused) {
                        z3 = false;
                    }
                    if (parsableByteArray.f() <= parsableByteArray.g()) {
                        z4 = z3;
                    }
                    if (!z4) {
                        f2++;
                    }
                }
                parsableByteArray.Y(parsableByteArray.g());
                return -1;
            } else {
                parsableByteArray.Y(f2);
                return -1;
            }
        }
        parsableByteArray.Y(f2);
        return this.f13256g.f13040a;
    }

    private void g(ExtractorInput extractorInput) throws IOException {
        this.f13263n = FlacMetadataReader.b(extractorInput);
        ((ExtractorOutput) Util.o(this.f13257h)).j(j(extractorInput.getPosition(), extractorInput.getLength()));
        this.f13259j = 5;
    }

    private SeekMap j(long j2, long j3) {
        Assertions.g(this.f13261l);
        FlacStreamMetadata flacStreamMetadata = this.f13261l;
        if (flacStreamMetadata.f13059k != null) {
            return new FlacSeekTableSeekMap(flacStreamMetadata, j2);
        }
        if (j3 == -1 || flacStreamMetadata.f13058j <= 0) {
            return new SeekMap.Unseekable(flacStreamMetadata.h());
        }
        FlacBinarySearchSeeker flacBinarySearchSeeker = new FlacBinarySearchSeeker(flacStreamMetadata, this.f13263n, j2, j3);
        this.o = flacBinarySearchSeeker;
        return flacBinarySearchSeeker.b();
    }

    private void k(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = this.f13253d;
        extractorInput.s(bArr, 0, bArr.length);
        extractorInput.n();
        this.f13259j = 2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] l() {
        return new Extractor[]{new FlacExtractor()};
    }

    private void m() {
        ((TrackOutput) Util.o(this.f13258i)).f((this.q * 1000000) / ((long) ((FlacStreamMetadata) Util.o(this.f13261l)).f13053e), 1, this.p, 0, (TrackOutput.CryptoData) null);
    }

    private int n(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        Assertions.g(this.f13258i);
        Assertions.g(this.f13261l);
        FlacBinarySearchSeeker flacBinarySearchSeeker = this.o;
        if (flacBinarySearchSeeker != null && flacBinarySearchSeeker.d()) {
            return this.o.c(extractorInput, positionHolder);
        }
        if (this.q == -1) {
            this.q = FlacFrameReader.i(extractorInput, this.f13261l);
            return 0;
        }
        int g2 = this.f13254e.g();
        if (g2 < 32768) {
            int read = extractorInput.read(this.f13254e.e(), g2, 32768 - g2);
            z2 = read == -1;
            if (!z2) {
                this.f13254e.X(g2 + read);
            } else if (this.f13254e.a() == 0) {
                m();
                return -1;
            }
        } else {
            z2 = false;
        }
        int f2 = this.f13254e.f();
        int i2 = this.p;
        int i3 = this.f13262m;
        if (i2 < i3) {
            ParsableByteArray parsableByteArray = this.f13254e;
            parsableByteArray.Z(Math.min(i3 - i2, parsableByteArray.a()));
        }
        long f3 = f(this.f13254e, z2);
        int f4 = this.f13254e.f() - f2;
        this.f13254e.Y(f2);
        this.f13258i.d(this.f13254e, f4);
        this.p += f4;
        if (f3 != -1) {
            m();
            this.p = 0;
            this.q = f3;
        }
        if (this.f13254e.a() < 16) {
            int a2 = this.f13254e.a();
            System.arraycopy(this.f13254e.e(), this.f13254e.f(), this.f13254e.e(), 0, a2);
            this.f13254e.Y(0);
            this.f13254e.X(a2);
        }
        return 0;
    }

    private void o(ExtractorInput extractorInput) throws IOException {
        this.f13260k = FlacMetadataReader.d(extractorInput, !this.f13255f);
        this.f13259j = 1;
    }

    private void p(ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.FlacStreamMetadataHolder flacStreamMetadataHolder = new FlacMetadataReader.FlacStreamMetadataHolder(this.f13261l);
        boolean z2 = false;
        while (!z2) {
            z2 = FlacMetadataReader.e(extractorInput, flacStreamMetadataHolder);
            this.f13261l = (FlacStreamMetadata) Util.o(flacStreamMetadataHolder.f13044a);
        }
        Assertions.g(this.f13261l);
        this.f13262m = Math.max(this.f13261l.f13051c, 6);
        ((TrackOutput) Util.o(this.f13258i)).e(this.f13261l.i(this.f13253d, this.f13260k));
        this.f13259j = 4;
    }

    private void q(ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.i(extractorInput);
        this.f13259j = 3;
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        long j4 = 0;
        if (j2 == 0) {
            this.f13259j = 0;
        } else {
            FlacBinarySearchSeeker flacBinarySearchSeeker = this.o;
            if (flacBinarySearchSeeker != null) {
                flacBinarySearchSeeker.h(j3);
            }
        }
        if (j3 != 0) {
            j4 = -1;
        }
        this.q = j4;
        this.p = 0;
        this.f13254e.U(0);
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f13257h = extractorOutput;
        this.f13258i = extractorOutput.d(0, 1);
        extractorOutput.o();
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.c(extractorInput, false);
        return FlacMetadataReader.a(extractorInput);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2 = this.f13259j;
        if (i2 == 0) {
            o(extractorInput);
            return 0;
        } else if (i2 == 1) {
            k(extractorInput);
            return 0;
        } else if (i2 == 2) {
            q(extractorInput);
            return 0;
        } else if (i2 == 3) {
            p(extractorInput);
            return 0;
        } else if (i2 == 4) {
            g(extractorInput);
            return 0;
        } else if (i2 == 5) {
            return n(extractorInput, positionHolder);
        } else {
            throw new IllegalStateException();
        }
    }

    public FlacExtractor(int i2) {
        this.f13253d = new byte[42];
        this.f13254e = new ParsableByteArray(new byte[32768], 0);
        this.f13255f = (i2 & 1) == 0 ? false : true;
        this.f13256g = new FlacFrameReader.SampleNumberHolder();
        this.f13259j = 0;
    }
}
