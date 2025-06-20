package androidx.media3.exoplayer.source;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public interface SampleStream {
    public static final int V = 1;
    public static final int W = 2;
    public static final int a0 = 4;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReadDataResult {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReadFlags {
    }

    void b() throws IOException;

    boolean d();

    int j(long j2);

    int o(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2);
}
