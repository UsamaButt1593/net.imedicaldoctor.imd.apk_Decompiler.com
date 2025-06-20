package androidx.media3.exoplayer;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.MediaSource;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class ExoPlaybackException extends PlaybackException {
    @UnstableApi
    public static final int W3 = 0;
    @UnstableApi
    public static final int X3 = 1;
    @UnstableApi
    public static final int Y3 = 2;
    @UnstableApi
    public static final int Z3 = 3;
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<ExoPlaybackException> a4 = new C0315k();
    private static final String b4 = Util.d1(1001);
    private static final String c4 = Util.d1(1002);
    private static final String d4 = Util.d1(1003);
    private static final String e4 = Util.d1(1004);
    private static final String f4 = Util.d1(AnalyticsListener.K);
    private static final String g4 = Util.d1(1006);
    @UnstableApi
    public final int P3;
    @UnstableApi
    @Nullable
    public final String Q3;
    @UnstableApi
    public final int R3;
    @UnstableApi
    @Nullable
    public final Format S3;
    @UnstableApi
    public final int T3;
    @UnstableApi
    @Nullable
    public final MediaSource.MediaPeriodId U3;
    final boolean V3;

    @UnstableApi
    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private ExoPlaybackException(int i2, Throwable th, int i3) {
        this(i2, th, (String) null, i3, (String) null, -1, (Format) null, 4, false);
    }

    public static /* synthetic */ ExoPlaybackException i(Bundle bundle) {
        return new ExoPlaybackException(bundle);
    }

    @UnstableApi
    public static ExoPlaybackException k(String str) {
        return new ExoPlaybackException(3, (Throwable) null, str, 1001, (String) null, -1, (Format) null, 4, false);
    }

    @UnstableApi
    public static ExoPlaybackException l(Throwable th, String str, int i2, @Nullable Format format, int i3, boolean z, int i4) {
        return new ExoPlaybackException(1, th, (String) null, i4, str, i2, format, format == null ? 4 : i3, z);
    }

    @UnstableApi
    public static ExoPlaybackException m(IOException iOException, int i2) {
        return new ExoPlaybackException(0, iOException, i2);
    }

    @UnstableApi
    @Deprecated
    public static ExoPlaybackException n(RuntimeException runtimeException) {
        return o(runtimeException, 1000);
    }

    @UnstableApi
    public static ExoPlaybackException o(RuntimeException runtimeException, int i2) {
        return new ExoPlaybackException(2, runtimeException, i2);
    }

    private static String p(int i2, @Nullable String str, @Nullable String str2, int i3, @Nullable Format format, int i4) {
        String str3;
        if (i2 == 0) {
            str3 = "Source error";
        } else if (i2 != 1) {
            str3 = i2 != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i3 + ", format=" + format + ", format_supported=" + Util.v0(i4);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    @UnstableApi
    public static ExoPlaybackException q(Bundle bundle) {
        return new ExoPlaybackException(bundle);
    }

    @UnstableApi
    public Bundle a() {
        Bundle a2 = super.a();
        a2.putInt(b4, this.P3);
        a2.putString(c4, this.Q3);
        a2.putInt(d4, this.R3);
        Format format = this.S3;
        if (format != null) {
            a2.putBundle(e4, format.a());
        }
        a2.putInt(f4, this.T3);
        a2.putBoolean(g4, this.V3);
        return a2;
    }

    public boolean d(@Nullable PlaybackException playbackException) {
        if (!super.d(playbackException)) {
            return false;
        }
        ExoPlaybackException exoPlaybackException = (ExoPlaybackException) Util.o(playbackException);
        return this.P3 == exoPlaybackException.P3 && Util.g(this.Q3, exoPlaybackException.Q3) && this.R3 == exoPlaybackException.R3 && Util.g(this.S3, exoPlaybackException.S3) && this.T3 == exoPlaybackException.T3 && Util.g(this.U3, exoPlaybackException.U3) && this.V3 == exoPlaybackException.V3;
    }

    /* access modifiers changed from: package-private */
    @CheckResult
    public ExoPlaybackException j(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return new ExoPlaybackException((String) Util.o(getMessage()), getCause(), this.s, this.P3, this.Q3, this.R3, this.S3, this.T3, mediaPeriodId, this.X, this.V3);
    }

    @UnstableApi
    public Exception r() {
        boolean z = true;
        if (this.P3 != 1) {
            z = false;
        }
        Assertions.i(z);
        return (Exception) Assertions.g(getCause());
    }

    @UnstableApi
    public IOException s() {
        Assertions.i(this.P3 == 0);
        return (IOException) Assertions.g(getCause());
    }

    @UnstableApi
    public RuntimeException t() {
        Assertions.i(this.P3 == 2);
        return (RuntimeException) Assertions.g(getCause());
    }

    private ExoPlaybackException(int i2, @Nullable Throwable th, @Nullable String str, int i3, @Nullable String str2, int i4, @Nullable Format format, int i5, boolean z) {
        this(p(i2, str, str2, i4, format, i5), th, i3, i2, str2, i4, format, i5, (MediaSource.MediaPeriodId) null, SystemClock.elapsedRealtime(), z);
    }

    private ExoPlaybackException(Bundle bundle) {
        super(bundle);
        this.P3 = bundle.getInt(b4, 2);
        this.Q3 = bundle.getString(c4);
        this.R3 = bundle.getInt(d4, -1);
        Bundle bundle2 = bundle.getBundle(e4);
        this.S3 = bundle2 == null ? null : Format.f(bundle2);
        this.T3 = bundle.getInt(f4, 4);
        this.V3 = bundle.getBoolean(g4, false);
        this.U3 = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ExoPlaybackException(String str, @Nullable Throwable th, int i2, int i3, @Nullable String str2, int i4, @Nullable Format format, int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, long j2, boolean z) {
        super(str, th, i2, j2);
        int i6 = i3;
        boolean z2 = z;
        boolean z3 = false;
        Assertions.a(!z2 || i6 == 1);
        Assertions.a((th != null || i6 == 3) ? true : z3);
        this.P3 = i6;
        this.Q3 = str2;
        this.R3 = i4;
        this.S3 = format;
        this.T3 = i5;
        this.U3 = mediaPeriodId;
        this.V3 = z2;
    }
}
