package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.dataflow.qual.SideEffectFree;

@UnstableApi
public interface Extractor {

    /* renamed from: a  reason: collision with root package name */
    public static final int f13036a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f13037b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f13038c = -1;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReadResult {
    }

    void a();

    void c(long j2, long j3);

    void d(ExtractorOutput extractorOutput);

    @SideEffectFree
    Extractor e();

    boolean h(ExtractorInput extractorInput) throws IOException;

    int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException;
}
