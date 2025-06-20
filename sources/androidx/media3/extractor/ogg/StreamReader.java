package androidx.media3.extractor.ogg;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

abstract class StreamReader {

    /* renamed from: n  reason: collision with root package name */
    private static final int f13742n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 3;

    /* renamed from: a  reason: collision with root package name */
    private final OggPacket f13743a = new OggPacket();

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f13744b;

    /* renamed from: c  reason: collision with root package name */
    private ExtractorOutput f13745c;

    /* renamed from: d  reason: collision with root package name */
    private OggSeeker f13746d;

    /* renamed from: e  reason: collision with root package name */
    private long f13747e;

    /* renamed from: f  reason: collision with root package name */
    private long f13748f;

    /* renamed from: g  reason: collision with root package name */
    private long f13749g;

    /* renamed from: h  reason: collision with root package name */
    private int f13750h;

    /* renamed from: i  reason: collision with root package name */
    private int f13751i;

    /* renamed from: j  reason: collision with root package name */
    private SetupData f13752j = new SetupData();

    /* renamed from: k  reason: collision with root package name */
    private long f13753k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13754l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f13755m;

    static class SetupData {

        /* renamed from: a  reason: collision with root package name */
        Format f13756a;

        /* renamed from: b  reason: collision with root package name */
        OggSeeker f13757b;

        SetupData() {
        }
    }

    private static final class UnseekableOggSeeker implements OggSeeker {
        private UnseekableOggSeeker() {
        }

        public SeekMap a() {
            return new SeekMap.Unseekable(C.f9084b);
        }

        public long b(ExtractorInput extractorInput) {
            return -1;
        }

        public void c(long j2) {
        }
    }

    @EnsuresNonNull({"trackOutput", "extractorOutput"})
    private void a() {
        Assertions.k(this.f13744b);
        Util.o(this.f13745c);
    }

    @EnsuresNonNullIf(expression = {"setupData.format"}, result = true)
    private boolean i(ExtractorInput extractorInput) throws IOException {
        while (this.f13743a.d(extractorInput)) {
            this.f13753k = extractorInput.getPosition() - this.f13748f;
            if (!h(this.f13743a.c(), this.f13748f, this.f13752j)) {
                return true;
            }
            this.f13748f = extractorInput.getPosition();
        }
        this.f13750h = 3;
        return false;
    }

    @RequiresNonNull({"trackOutput"})
    private int j(ExtractorInput extractorInput) throws IOException {
        if (!i(extractorInput)) {
            return -1;
        }
        Format format = this.f13752j.f13756a;
        this.f13751i = format.t3;
        if (!this.f13755m) {
            this.f13744b.e(format);
            this.f13755m = true;
        }
        OggSeeker oggSeeker = this.f13752j.f13757b;
        if (oggSeeker == null) {
            if (extractorInput.getLength() == -1) {
                oggSeeker = new UnseekableOggSeeker();
            } else {
                OggPageHeader b2 = this.f13743a.b();
                this.f13746d = new DefaultOggSeeker(this, this.f13748f, extractorInput.getLength(), (long) (b2.f13738h + b2.f13739i), b2.f13733c, (b2.f13732b & 4) != 0);
                this.f13750h = 2;
                this.f13743a.f();
                return 0;
            }
        }
        this.f13746d = oggSeeker;
        this.f13750h = 2;
        this.f13743a.f();
        return 0;
    }

    @RequiresNonNull({"trackOutput", "oggSeeker", "extractorOutput"})
    private int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        ExtractorInput extractorInput2 = extractorInput;
        long b2 = this.f13746d.b(extractorInput2);
        if (b2 >= 0) {
            positionHolder.f13111a = b2;
            return 1;
        }
        if (b2 < -1) {
            e(-(b2 + 2));
        }
        if (!this.f13754l) {
            this.f13745c.j((SeekMap) Assertions.k(this.f13746d.a()));
            this.f13754l = true;
        }
        if (this.f13753k > 0 || this.f13743a.d(extractorInput2)) {
            this.f13753k = 0;
            ParsableByteArray c2 = this.f13743a.c();
            long f2 = f(c2);
            if (f2 >= 0) {
                long j2 = this.f13749g;
                if (j2 + f2 >= this.f13747e) {
                    long b3 = b(j2);
                    this.f13744b.d(c2, c2.g());
                    this.f13744b.f(b3, 1, c2.g(), 0, (TrackOutput.CryptoData) null);
                    this.f13747e = -1;
                }
            }
            this.f13749g += f2;
            return 0;
        }
        this.f13750h = 3;
        return -1;
    }

    /* access modifiers changed from: protected */
    public long b(long j2) {
        return (j2 * 1000000) / ((long) this.f13751i);
    }

    /* access modifiers changed from: protected */
    public long c(long j2) {
        return (((long) this.f13751i) * j2) / 1000000;
    }

    /* access modifiers changed from: package-private */
    public void d(ExtractorOutput extractorOutput, TrackOutput trackOutput) {
        this.f13745c = extractorOutput;
        this.f13744b = trackOutput;
        l(true);
    }

    /* access modifiers changed from: protected */
    public void e(long j2) {
        this.f13749g = j2;
    }

    /* access modifiers changed from: protected */
    public abstract long f(ParsableByteArray parsableByteArray);

    /* access modifiers changed from: package-private */
    public final int g(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        a();
        int i2 = this.f13750h;
        if (i2 == 0) {
            return j(extractorInput);
        }
        if (i2 == 1) {
            extractorInput.o((int) this.f13748f);
            this.f13750h = 2;
            return 0;
        } else if (i2 == 2) {
            Util.o(this.f13746d);
            return k(extractorInput, positionHolder);
        } else if (i2 == 3) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean h(ParsableByteArray parsableByteArray, long j2, SetupData setupData) throws IOException;

    /* access modifiers changed from: protected */
    public void l(boolean z) {
        int i2;
        if (z) {
            this.f13752j = new SetupData();
            this.f13748f = 0;
            i2 = 0;
        } else {
            i2 = 1;
        }
        this.f13750h = i2;
        this.f13747e = -1;
        this.f13749g = 0;
    }

    /* access modifiers changed from: package-private */
    public final void m(long j2, long j3) {
        this.f13743a.e();
        if (j2 == 0) {
            l(!this.f13754l);
        } else if (this.f13750h != 0) {
            this.f13747e = c(j3);
            ((OggSeeker) Util.o(this.f13746d)).c(this.f13747e);
            this.f13750h = 2;
        }
    }
}
