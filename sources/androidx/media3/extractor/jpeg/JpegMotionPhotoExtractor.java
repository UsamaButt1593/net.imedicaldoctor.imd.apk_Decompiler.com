package androidx.media3.extractor.jpeg;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.d;
import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;

@UnstableApi
final class JpegMotionPhotoExtractor implements Extractor {

    /* renamed from: n  reason: collision with root package name */
    private static final int f13320n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 4;
    private static final int r = 5;
    private static final int s = 6;
    private static final int t = 6;
    private static final long u = 1165519206;
    private static final int v = 65496;
    private static final int w = 65498;
    private static final int x = 65504;
    private static final int y = 65505;
    private static final String z = "http://ns.adobe.com/xap/1.0/";

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f13321d = new ParsableByteArray(6);

    /* renamed from: e  reason: collision with root package name */
    private ExtractorOutput f13322e;

    /* renamed from: f  reason: collision with root package name */
    private int f13323f;

    /* renamed from: g  reason: collision with root package name */
    private int f13324g;

    /* renamed from: h  reason: collision with root package name */
    private int f13325h;

    /* renamed from: i  reason: collision with root package name */
    private long f13326i = -1;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private MotionPhotoMetadata f13327j;

    /* renamed from: k  reason: collision with root package name */
    private ExtractorInput f13328k;

    /* renamed from: l  reason: collision with root package name */
    private StartOffsetExtractorInput f13329l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private Mp4Extractor f13330m;

    private void b(ExtractorInput extractorInput) throws IOException {
        this.f13321d.U(2);
        extractorInput.s(this.f13321d.e(), 0, 2);
        extractorInput.j(this.f13321d.R() - 2);
    }

    private void f() {
        ((ExtractorOutput) Assertions.g(this.f13322e)).o();
        this.f13322e.j(new SeekMap.Unseekable(C.f9084b));
        this.f13323f = 6;
    }

    @Nullable
    private static MotionPhotoMetadata g(String str, long j2) throws IOException {
        MotionPhotoDescription a2;
        if (j2 == -1 || (a2 = XmpMotionPhotoDescriptionParser.a(str)) == null) {
            return null;
        }
        return a2.a(j2);
    }

    private void j(MotionPhotoMetadata motionPhotoMetadata) {
        ((ExtractorOutput) Assertions.g(this.f13322e)).d(1024, 4).e(new Format.Builder().O(MimeTypes.Q0).d0(new Metadata(motionPhotoMetadata)).I());
    }

    private int k(ExtractorInput extractorInput) throws IOException {
        this.f13321d.U(2);
        extractorInput.s(this.f13321d.e(), 0, 2);
        return this.f13321d.R();
    }

    private void l(ExtractorInput extractorInput) throws IOException {
        int i2;
        this.f13321d.U(2);
        extractorInput.readFully(this.f13321d.e(), 0, 2);
        int R = this.f13321d.R();
        this.f13324g = R;
        if (R == w) {
            if (this.f13326i != -1) {
                i2 = 4;
            } else {
                f();
                return;
            }
        } else if ((R < 65488 || R > 65497) && R != 65281) {
            i2 = 1;
        } else {
            return;
        }
        this.f13323f = i2;
    }

    private void m(ExtractorInput extractorInput) throws IOException {
        String F;
        if (this.f13324g == y) {
            ParsableByteArray parsableByteArray = new ParsableByteArray(this.f13325h);
            extractorInput.readFully(parsableByteArray.e(), 0, this.f13325h);
            if (this.f13327j == null && "http://ns.adobe.com/xap/1.0/".equals(parsableByteArray.F()) && (F = parsableByteArray.F()) != null) {
                MotionPhotoMetadata g2 = g(F, extractorInput.getLength());
                this.f13327j = g2;
                if (g2 != null) {
                    this.f13326i = g2.Z;
                }
            }
        } else {
            extractorInput.o(this.f13325h);
        }
        this.f13323f = 0;
    }

    private void n(ExtractorInput extractorInput) throws IOException {
        this.f13321d.U(2);
        extractorInput.readFully(this.f13321d.e(), 0, 2);
        this.f13325h = this.f13321d.R() - 2;
        this.f13323f = 2;
    }

    private void o(ExtractorInput extractorInput) throws IOException {
        if (extractorInput.h(this.f13321d.e(), 0, 1, true)) {
            extractorInput.n();
            if (this.f13330m == null) {
                this.f13330m = new Mp4Extractor(SubtitleParser.Factory.f13783a, 8);
            }
            StartOffsetExtractorInput startOffsetExtractorInput = new StartOffsetExtractorInput(extractorInput, this.f13326i);
            this.f13329l = startOffsetExtractorInput;
            if (this.f13330m.h(startOffsetExtractorInput)) {
                this.f13330m.d(new StartOffsetExtractorOutput(this.f13326i, (ExtractorOutput) Assertions.g(this.f13322e)));
                p();
                return;
            }
        }
        f();
    }

    private void p() {
        j((MotionPhotoMetadata) Assertions.g(this.f13327j));
        this.f13323f = 5;
    }

    public void a() {
        Mp4Extractor mp4Extractor = this.f13330m;
        if (mp4Extractor != null) {
            mp4Extractor.a();
        }
    }

    public void c(long j2, long j3) {
        if (j2 == 0) {
            this.f13323f = 0;
            this.f13330m = null;
        } else if (this.f13323f == 5) {
            ((Mp4Extractor) Assertions.g(this.f13330m)).c(j2, j3);
        }
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f13322e = extractorOutput;
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        if (k(extractorInput) != v) {
            return false;
        }
        int k2 = k(extractorInput);
        this.f13324g = k2;
        if (k2 == x) {
            b(extractorInput);
            this.f13324g = k(extractorInput);
        }
        if (this.f13324g != y) {
            return false;
        }
        extractorInput.j(2);
        this.f13321d.U(6);
        extractorInput.s(this.f13321d.e(), 0, 6);
        return this.f13321d.N() == u && this.f13321d.R() == 0;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2 = this.f13323f;
        if (i2 == 0) {
            l(extractorInput);
            return 0;
        } else if (i2 == 1) {
            n(extractorInput);
            return 0;
        } else if (i2 == 2) {
            m(extractorInput);
            return 0;
        } else if (i2 == 4) {
            long position = extractorInput.getPosition();
            long j2 = this.f13326i;
            if (position != j2) {
                positionHolder.f13111a = j2;
                return 1;
            }
            o(extractorInput);
            return 0;
        } else if (i2 == 5) {
            if (this.f13329l == null || extractorInput != this.f13328k) {
                this.f13328k = extractorInput;
                this.f13329l = new StartOffsetExtractorInput(extractorInput, this.f13326i);
            }
            int i3 = ((Mp4Extractor) Assertions.g(this.f13330m)).i(this.f13329l, positionHolder);
            if (i3 == 1) {
                positionHolder.f13111a += this.f13326i;
            }
            return i3;
        } else if (i2 == 6) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }
}
