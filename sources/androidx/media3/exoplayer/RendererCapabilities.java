package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public interface RendererCapabilities {
    @Deprecated
    public static final int A = 1;
    @Deprecated
    public static final int B = 0;
    public static final int C = 24;
    public static final int D = 16;
    public static final int E = 8;
    public static final int F = 0;
    public static final int G = 32;
    public static final int H = 32;
    public static final int I = 0;
    public static final int J = 64;
    public static final int K = 64;
    public static final int L = 0;
    public static final int M = 384;
    public static final int N = 256;
    public static final int O = 128;
    public static final int P = 0;
    public static final int Q = 3584;
    public static final int R = 2048;
    public static final int S = 1024;
    public static final int T = 512;
    public static final int U = 0;
    public static final int w = 7;
    @Deprecated
    public static final int x = 4;
    @Deprecated
    public static final int y = 3;
    @Deprecated
    public static final int z = 2;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdaptiveSupport {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioOffloadSupport {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Capabilities {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DecoderSupport {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    public @interface FormatSupport {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HardwareAccelerationSupport {
    }

    public interface Listener {
        void a(Renderer renderer);
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TunnelingSupport {
    }

    int b(Format format) throws ExoPlaybackException;

    String getName();

    int i();

    void k();

    void t(Listener listener);

    int y() throws ExoPlaybackException;
}
