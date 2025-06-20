package androidx.media3.common;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class PlaybackException extends Exception implements Bundleable {
    public static final int A3 = 6004;
    public static final int B3 = 6005;
    public static final int C3 = 6006;
    public static final int D3 = 6007;
    public static final int E3 = 6008;
    @UnstableApi
    public static final int F3 = 7000;
    @UnstableApi
    public static final int G3 = 7001;
    public static final int H3 = 1000000;
    private static final String I3 = Util.d1(0);
    private static final String J3 = Util.d1(1);
    private static final String K3 = Util.d1(2);
    private static final String L3 = Util.d1(3);
    private static final String M3 = Util.d1(4);
    @UnstableApi
    protected static final int N3 = 1000;
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<PlaybackException> O3 = new I();
    public static final int X2 = 1002;
    public static final int Y = 1000;
    public static final int Y2 = 1003;
    public static final int Z = 1001;
    public static final int Z2 = 1004;
    public static final int a3 = 2000;
    public static final int b3 = 2001;
    public static final int c3 = 2002;
    public static final int d3 = 2003;
    public static final int e3 = 2004;
    public static final int f3 = 2005;
    public static final int g3 = 2006;
    public static final int h3 = 2007;
    public static final int i3 = 2008;
    public static final int j3 = 3001;
    public static final int k3 = 3002;
    public static final int l3 = 3003;
    public static final int m3 = 3004;
    public static final int n3 = 4001;
    public static final int o3 = 4002;
    public static final int p3 = 4003;
    public static final int q3 = 4004;
    public static final int r3 = 4005;
    public static final int s3 = 5001;
    public static final int t3 = 5002;
    @UnstableApi
    public static final int u3 = 5003;
    @UnstableApi
    public static final int v3 = 5004;
    public static final int w3 = 6000;
    public static final int x3 = 6001;
    public static final int y3 = 6002;
    public static final int z3 = 6003;
    public final long X;
    public final int s;

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    @UnstableApi
    protected PlaybackException(Bundle bundle) {
        this(bundle.getString(K3), f(bundle), bundle.getInt(I3, 1000), bundle.getLong(J3, SystemClock.elapsedRealtime()));
    }

    private static RemoteException b(@Nullable String str) {
        return new RemoteException(str);
    }

    private static Throwable c(Class<?> cls, @Nullable String str) throws Exception {
        return (Throwable) cls.getConstructor(new Class[]{String.class}).newInstance(new Object[]{str});
    }

    @UnstableApi
    public static PlaybackException e(Bundle bundle) {
        return new PlaybackException(bundle);
    }

    @Nullable
    private static Throwable f(Bundle bundle) {
        String string = bundle.getString(L3);
        String string2 = bundle.getString(M3);
        Throwable th = null;
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(string, true, PlaybackException.class.getClassLoader());
            if (Throwable.class.isAssignableFrom(cls)) {
                th = c(cls, string2);
            }
            if (th != null) {
                return th;
            }
        } catch (Throwable unused) {
        }
        return b(string2);
    }

    public static String h(int i2) {
        if (i2 == 7000) {
            return "ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED";
        }
        if (i2 == 7001) {
            return "ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED";
        }
        switch (i2) {
            case 1000:
                return "ERROR_CODE_UNSPECIFIED";
            case 1001:
                return "ERROR_CODE_REMOTE_ERROR";
            case 1002:
                return "ERROR_CODE_BEHIND_LIVE_WINDOW";
            case 1003:
                return "ERROR_CODE_TIMEOUT";
            case 1004:
                return "ERROR_CODE_FAILED_RUNTIME_CHECK";
            default:
                switch (i2) {
                    case 2000:
                        return "ERROR_CODE_IO_UNSPECIFIED";
                    case b3 /*2001*/:
                        return "ERROR_CODE_IO_NETWORK_CONNECTION_FAILED";
                    case c3 /*2002*/:
                        return "ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT";
                    case d3 /*2003*/:
                        return "ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE";
                    case e3 /*2004*/:
                        return "ERROR_CODE_IO_BAD_HTTP_STATUS";
                    case f3 /*2005*/:
                        return "ERROR_CODE_IO_FILE_NOT_FOUND";
                    case g3 /*2006*/:
                        return "ERROR_CODE_IO_NO_PERMISSION";
                    case h3 /*2007*/:
                        return "ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED";
                    case 2008:
                        return "ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE";
                    default:
                        switch (i2) {
                            case j3 /*3001*/:
                                return "ERROR_CODE_PARSING_CONTAINER_MALFORMED";
                            case k3 /*3002*/:
                                return "ERROR_CODE_PARSING_MANIFEST_MALFORMED";
                            case l3 /*3003*/:
                                return "ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED";
                            case m3 /*3004*/:
                                return "ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED";
                            default:
                                switch (i2) {
                                    case n3 /*4001*/:
                                        return "ERROR_CODE_DECODER_INIT_FAILED";
                                    case o3 /*4002*/:
                                        return "ERROR_CODE_DECODER_QUERY_FAILED";
                                    case p3 /*4003*/:
                                        return "ERROR_CODE_DECODING_FAILED";
                                    case q3 /*4004*/:
                                        return "ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES";
                                    case r3 /*4005*/:
                                        return "ERROR_CODE_DECODING_FORMAT_UNSUPPORTED";
                                    default:
                                        switch (i2) {
                                            case s3 /*5001*/:
                                                return "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
                                            case t3 /*5002*/:
                                                return "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
                                            case u3 /*5003*/:
                                                return "ERROR_CODE_AUDIO_TRACK_OFFLOAD_WRITE_FAILED";
                                            case v3 /*5004*/:
                                                return "ERROR_CODE_AUDIO_TRACK_OFFLOAD_INIT_FAILED";
                                            default:
                                                switch (i2) {
                                                    case w3 /*6000*/:
                                                        return "ERROR_CODE_DRM_UNSPECIFIED";
                                                    case x3 /*6001*/:
                                                        return "ERROR_CODE_DRM_SCHEME_UNSUPPORTED";
                                                    case y3 /*6002*/:
                                                        return "ERROR_CODE_DRM_PROVISIONING_FAILED";
                                                    case z3 /*6003*/:
                                                        return "ERROR_CODE_DRM_CONTENT_ERROR";
                                                    case A3 /*6004*/:
                                                        return "ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED";
                                                    case B3 /*6005*/:
                                                        return "ERROR_CODE_DRM_DISALLOWED_OPERATION";
                                                    case C3 /*6006*/:
                                                        return "ERROR_CODE_DRM_SYSTEM_ERROR";
                                                    case D3 /*6007*/:
                                                        return "ERROR_CODE_DRM_DEVICE_REVOKED";
                                                    case E3 /*6008*/:
                                                        return "ERROR_CODE_DRM_LICENSE_EXPIRED";
                                                    default:
                                                        return i2 >= 1000000 ? "custom error code" : "invalid error code";
                                                }
                                        }
                                }
                        }
                }
        }
    }

    @CallSuper
    @UnstableApi
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(I3, this.s);
        bundle.putLong(J3, this.X);
        bundle.putString(K3, getMessage());
        Throwable cause = getCause();
        if (cause != null) {
            bundle.putString(L3, cause.getClass().getName());
            bundle.putString(M3, cause.getMessage());
        }
        return bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r3 == null) goto L_0x0041;
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(@androidx.annotation.Nullable androidx.media3.common.PlaybackException r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r7 == 0) goto L_0x0060
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L_0x0012
            goto L_0x0060
        L_0x0012:
            java.lang.Throwable r2 = r6.getCause()
            java.lang.Throwable r3 = r7.getCause()
            if (r2 == 0) goto L_0x003c
            if (r3 == 0) goto L_0x003c
            java.lang.String r4 = r2.getMessage()
            java.lang.String r5 = r3.getMessage()
            boolean r4 = androidx.media3.common.util.Util.g(r4, r5)
            if (r4 != 0) goto L_0x002d
            return r1
        L_0x002d:
            java.lang.Class r2 = r2.getClass()
            java.lang.Class r3 = r3.getClass()
            boolean r2 = androidx.media3.common.util.Util.g(r2, r3)
            if (r2 != 0) goto L_0x0041
            return r1
        L_0x003c:
            if (r2 != 0) goto L_0x0060
            if (r3 == 0) goto L_0x0041
            goto L_0x0060
        L_0x0041:
            int r2 = r6.s
            int r3 = r7.s
            if (r2 != r3) goto L_0x005e
            java.lang.String r2 = r6.getMessage()
            java.lang.String r3 = r7.getMessage()
            boolean r2 = androidx.media3.common.util.Util.g(r2, r3)
            if (r2 == 0) goto L_0x005e
            long r2 = r6.X
            long r4 = r7.X
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            return r0
        L_0x0060:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.PlaybackException.d(androidx.media3.common.PlaybackException):boolean");
    }

    public final String g() {
        return h(this.s);
    }

    @UnstableApi
    public PlaybackException(@Nullable String str, @Nullable Throwable th, int i2) {
        this(str, th, i2, Clock.f9502a.b());
    }

    @UnstableApi
    protected PlaybackException(@Nullable String str, @Nullable Throwable th, int i2, long j2) {
        super(str, th);
        this.s = i2;
        this.X = j2;
    }
}
