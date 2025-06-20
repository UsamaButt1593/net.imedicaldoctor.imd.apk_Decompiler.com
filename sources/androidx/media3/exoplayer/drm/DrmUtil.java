package androidx.media3.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.W0;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class DrmUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final int f11302a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f11303b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f11304c = 3;

    @RequiresApi(18)
    private static final class Api18 {
        private Api18() {
        }

        @DoNotInline
        public static boolean a(@Nullable Throwable th) {
            return th instanceof DeniedByServerException;
        }

        @DoNotInline
        public static boolean b(@Nullable Throwable th) {
            return th instanceof DefaultDrmSessionManager.MissingSchemeDataException;
        }

        @DoNotInline
        public static boolean c(@Nullable Throwable th) {
            return th instanceof NotProvisionedException;
        }
    }

    @RequiresApi(21)
    private static final class Api21 {
        private Api21() {
        }

        @DoNotInline
        public static boolean a(@Nullable Throwable th) {
            return th instanceof MediaDrm.MediaDrmStateException;
        }

        @DoNotInline
        public static int b(Throwable th) {
            return Util.t0(Util.u0(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
        }
    }

    @RequiresApi(23)
    private static final class Api23 {
        private Api23() {
        }

        @DoNotInline
        public static boolean a(@Nullable Throwable th) {
            return W0.a(th);
        }
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorSource {
    }

    private DrmUtil() {
    }

    public static int a(Throwable th, int i2) {
        int i3 = Util.f9646a;
        if (i3 >= 21 && Api21.a(th)) {
            return Api21.b(th);
        }
        if (i3 >= 23 && Api23.a(th)) {
            return PlaybackException.C3;
        }
        if ((i3 >= 18 && Api18.c(th)) || b(th)) {
            return PlaybackException.y3;
        }
        if (i3 >= 18 && Api18.a(th)) {
            return PlaybackException.D3;
        }
        if (th instanceof UnsupportedDrmException) {
            return PlaybackException.x3;
        }
        if (i3 >= 18 && Api18.b(th)) {
            return PlaybackException.z3;
        }
        if (th instanceof KeysExpiredException) {
            return PlaybackException.E3;
        }
        if (i2 == 1) {
            return PlaybackException.C3;
        }
        if (i2 == 2) {
            return PlaybackException.A3;
        }
        if (i2 == 3) {
            return PlaybackException.y3;
        }
        throw new IllegalArgumentException();
    }

    public static boolean b(@Nullable Throwable th) {
        return Util.f9646a == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/NotProvisionedException;.<init>(");
    }

    public static boolean c(@Nullable Throwable th) {
        return Util.f9646a == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/ResourceBusyException;.<init>(");
    }
}
