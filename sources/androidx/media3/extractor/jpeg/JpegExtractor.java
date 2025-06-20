package androidx.media3.extractor.jpeg;

import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;
import androidx.media3.extractor.d;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class JpegExtractor implements Extractor {

    /* renamed from: e  reason: collision with root package name */
    public static final int f13316e = 1;

    /* renamed from: f  reason: collision with root package name */
    private static final int f13317f = 65496;

    /* renamed from: g  reason: collision with root package name */
    private static final int f13318g = 2;

    /* renamed from: d  reason: collision with root package name */
    private final Extractor f13319d;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public JpegExtractor() {
        this(0);
    }

    public void a() {
        this.f13319d.a();
    }

    public void c(long j2, long j3) {
        this.f13319d.c(j2, j3);
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f13319d.d(extractorOutput);
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        return this.f13319d.h(extractorInput);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        return this.f13319d.i(extractorInput, positionHolder);
    }

    public JpegExtractor(int i2) {
        this.f13319d = (i2 & 1) != 0 ? new SingleSampleExtractor(f13317f, 2, MimeTypes.Q0) : new JpegMotionPhotoExtractor();
    }
}
