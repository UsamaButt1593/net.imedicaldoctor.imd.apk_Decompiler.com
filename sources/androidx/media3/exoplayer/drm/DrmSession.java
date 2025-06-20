package androidx.media3.exoplayer.drm;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.UUID;

@UnstableApi
public interface DrmSession {

    /* renamed from: a  reason: collision with root package name */
    public static final int f11289a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f11290b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f11291c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f11292d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f11293e = 4;

    public static class DrmSessionException extends IOException {
        public final int s;

        public DrmSessionException(Throwable th, int i2) {
            super(th);
            this.s = i2;
        }
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    @Nullable
    DrmSessionException e();

    void f(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher);

    UUID g();

    int getState();

    boolean h();

    @Nullable
    Map<String, String> i();

    void j(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher);

    @Nullable
    byte[] k();

    boolean l(String str);

    @Nullable
    CryptoConfig m();
}
