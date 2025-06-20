package androidx.media3.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.analytics.PlayerId;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@UnstableApi
public interface ExoMediaDrm {
    @UnstableApi

    /* renamed from: a  reason: collision with root package name */
    public static final int f11308a = 2;
    @UnstableApi

    /* renamed from: b  reason: collision with root package name */
    public static final int f11309b = 3;
    @UnstableApi

    /* renamed from: c  reason: collision with root package name */
    public static final int f11310c = 1;
    @UnstableApi

    /* renamed from: d  reason: collision with root package name */
    public static final int f11311d = 1;
    @UnstableApi

    /* renamed from: e  reason: collision with root package name */
    public static final int f11312e = 2;
    @UnstableApi

    /* renamed from: f  reason: collision with root package name */
    public static final int f11313f = 3;

    public static final class AppManagedProvider implements Provider {

        /* renamed from: a  reason: collision with root package name */
        private final ExoMediaDrm f11314a;

        public AppManagedProvider(ExoMediaDrm exoMediaDrm) {
            this.f11314a = exoMediaDrm;
        }

        public ExoMediaDrm a(UUID uuid) {
            this.f11314a.b();
            return this.f11314a;
        }
    }

    public static final class KeyRequest {

        /* renamed from: d  reason: collision with root package name */
        public static final int f11315d = Integer.MIN_VALUE;

        /* renamed from: e  reason: collision with root package name */
        public static final int f11316e = 0;

        /* renamed from: f  reason: collision with root package name */
        public static final int f11317f = 1;

        /* renamed from: g  reason: collision with root package name */
        public static final int f11318g = 2;

        /* renamed from: h  reason: collision with root package name */
        public static final int f11319h = 3;

        /* renamed from: i  reason: collision with root package name */
        public static final int f11320i = 4;

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f11321a;

        /* renamed from: b  reason: collision with root package name */
        private final String f11322b;

        /* renamed from: c  reason: collision with root package name */
        private final int f11323c;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface RequestType {
        }

        public KeyRequest(byte[] bArr, String str) {
            this(bArr, str, Integer.MIN_VALUE);
        }

        public byte[] a() {
            return this.f11321a;
        }

        public String b() {
            return this.f11322b;
        }

        public int c() {
            return this.f11323c;
        }

        public KeyRequest(byte[] bArr, String str, int i2) {
            this.f11321a = bArr;
            this.f11322b = str;
            this.f11323c = i2;
        }
    }

    public static final class KeyStatus {

        /* renamed from: a  reason: collision with root package name */
        private final int f11324a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f11325b;

        public KeyStatus(int i2, byte[] bArr) {
            this.f11324a = i2;
            this.f11325b = bArr;
        }

        public byte[] a() {
            return this.f11325b;
        }

        public int b() {
            return this.f11324a;
        }
    }

    public interface OnEventListener {
        void a(ExoMediaDrm exoMediaDrm, @Nullable byte[] bArr, int i2, int i3, @Nullable byte[] bArr2);
    }

    public interface OnExpirationUpdateListener {
        void a(ExoMediaDrm exoMediaDrm, byte[] bArr, long j2);
    }

    public interface OnKeyStatusChangeListener {
        void a(ExoMediaDrm exoMediaDrm, byte[] bArr, List<KeyStatus> list, boolean z);
    }

    public interface Provider {
        ExoMediaDrm a(UUID uuid);
    }

    public static final class ProvisionRequest {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f11326a;

        /* renamed from: b  reason: collision with root package name */
        private final String f11327b;

        public ProvisionRequest(byte[] bArr, String str) {
            this.f11326a = bArr;
            this.f11327b = str;
        }

        public byte[] a() {
            return this.f11326a;
        }

        public String b() {
            return this.f11327b;
        }
    }

    void a();

    void b();

    @Nullable
    PersistableBundle c();

    Map<String, String> d(byte[] bArr);

    void e(String str, byte[] bArr);

    String f(String str);

    ProvisionRequest g();

    List<byte[]> h();

    CryptoConfig i(byte[] bArr) throws MediaCryptoException;

    byte[] j() throws MediaDrmException;

    void k(@Nullable OnKeyStatusChangeListener onKeyStatusChangeListener);

    boolean l(byte[] bArr, String str);

    void m(byte[] bArr, byte[] bArr2);

    void n(String str, String str2);

    void o(byte[] bArr);

    byte[] p(String str);

    @Nullable
    byte[] q(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException;

    void r(@Nullable OnEventListener onEventListener);

    void s(byte[] bArr) throws DeniedByServerException;

    KeyRequest t(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i2, @Nullable HashMap<String, String> hashMap) throws NotProvisionedException;

    void u(byte[] bArr, PlayerId playerId);

    void v(@Nullable OnExpirationUpdateListener onExpirationUpdateListener);

    int w();

    void x(byte[] bArr);
}
