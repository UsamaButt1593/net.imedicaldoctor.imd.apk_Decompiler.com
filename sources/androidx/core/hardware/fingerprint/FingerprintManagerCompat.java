package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FingerprintManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5933a;

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        static void a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i2, Object obj3, Handler handler) {
            ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i2, (FingerprintManager.AuthenticationCallback) obj3, handler);
        }

        @DoNotInline
        static FingerprintManager.CryptoObject b(Object obj) {
            return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
        }

        @DoNotInline
        public static FingerprintManager c(Context context) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 != 23 && (i2 <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint"))) {
                return null;
            }
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        static boolean d(Object obj) {
            return ((FingerprintManager) obj).hasEnrolledFingerprints();
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        static boolean e(Object obj) {
            return ((FingerprintManager) obj).isHardwareDetected();
        }

        @DoNotInline
        public static CryptoObject f(Object obj) {
            FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        @DoNotInline
        public static FingerprintManager.CryptoObject g(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.a() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.a());
            }
            if (cryptoObject.c() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.c());
            }
            if (cryptoObject.b() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.b());
            }
            return null;
        }
    }

    public static abstract class AuthenticationCallback {
        public void a(int i2, @NonNull CharSequence charSequence) {
        }

        public void b() {
        }

        public void c(int i2, @NonNull CharSequence charSequence) {
        }

        public void d(@NonNull AuthenticationResult authenticationResult) {
        }
    }

    public static final class AuthenticationResult {

        /* renamed from: a  reason: collision with root package name */
        private final CryptoObject f5935a;

        public AuthenticationResult(@NonNull CryptoObject cryptoObject) {
            this.f5935a = cryptoObject;
        }

        @NonNull
        public CryptoObject a() {
            return this.f5935a;
        }
    }

    public static class CryptoObject {

        /* renamed from: a  reason: collision with root package name */
        private final Signature f5936a;

        /* renamed from: b  reason: collision with root package name */
        private final Cipher f5937b;

        /* renamed from: c  reason: collision with root package name */
        private final Mac f5938c;

        public CryptoObject(@NonNull Signature signature) {
            this.f5936a = signature;
            this.f5937b = null;
            this.f5938c = null;
        }

        @Nullable
        public Cipher a() {
            return this.f5937b;
        }

        @Nullable
        public Mac b() {
            return this.f5938c;
        }

        @Nullable
        public Signature c() {
            return this.f5936a;
        }

        public CryptoObject(@NonNull Cipher cipher) {
            this.f5937b = cipher;
            this.f5936a = null;
            this.f5938c = null;
        }

        public CryptoObject(@NonNull Mac mac) {
            this.f5938c = mac;
            this.f5937b = null;
            this.f5936a = null;
        }
    }

    private FingerprintManagerCompat(Context context) {
        this.f5933a = context;
    }

    @NonNull
    public static FingerprintManagerCompat c(@NonNull Context context) {
        return new FingerprintManagerCompat(context);
    }

    @RequiresApi(23)
    @Nullable
    private static FingerprintManager d(@NonNull Context context) {
        return Api23Impl.c(context);
    }

    @RequiresApi(23)
    static CryptoObject g(FingerprintManager.CryptoObject cryptoObject) {
        return Api23Impl.f(cryptoObject);
    }

    @RequiresApi(23)
    private static FingerprintManager.AuthenticationCallback h(final AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback() {
            public void onAuthenticationError(int i2, CharSequence charSequence) {
                AuthenticationCallback.this.a(i2, charSequence);
            }

            public void onAuthenticationFailed() {
                AuthenticationCallback.this.b();
            }

            public void onAuthenticationHelp(int i2, CharSequence charSequence) {
                AuthenticationCallback.this.c(i2, charSequence);
            }

            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                AuthenticationCallback.this.d(new AuthenticationResult(FingerprintManagerCompat.g(Api23Impl.b(authenticationResult))));
            }
        };
    }

    @RequiresApi(23)
    private static FingerprintManager.CryptoObject i(CryptoObject cryptoObject) {
        return Api23Impl.g(cryptoObject);
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public void a(@Nullable CryptoObject cryptoObject, int i2, @Nullable CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        FingerprintManager d2;
        if (Build.VERSION.SDK_INT >= 23 && (d2 = d(this.f5933a)) != null) {
            Api23Impl.a(d2, i(cryptoObject), cancellationSignal, i2, h(authenticationCallback), handler);
        }
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void b(@Nullable CryptoObject cryptoObject, int i2, @Nullable androidx.core.os.CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        a(cryptoObject, i2, cancellationSignal != null ? (CancellationSignal) cancellationSignal.b() : null, authenticationCallback, handler);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = d(r3.f5933a);
     */
    @androidx.annotation.RequiresPermission("android.permission.USE_FINGERPRINT")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            r2 = 0
            if (r0 < r1) goto L_0x0016
            android.content.Context r0 = r3.f5933a
            android.hardware.fingerprint.FingerprintManager r0 = d(r0)
            if (r0 == 0) goto L_0x0016
            boolean r0 = androidx.core.hardware.fingerprint.FingerprintManagerCompat.Api23Impl.d(r0)
            if (r0 == 0) goto L_0x0016
            r2 = 1
        L_0x0016:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.hardware.fingerprint.FingerprintManagerCompat.e():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = d(r3.f5933a);
     */
    @androidx.annotation.RequiresPermission("android.permission.USE_FINGERPRINT")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f() {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            r2 = 0
            if (r0 < r1) goto L_0x0016
            android.content.Context r0 = r3.f5933a
            android.hardware.fingerprint.FingerprintManager r0 = d(r0)
            if (r0 == 0) goto L_0x0016
            boolean r0 = androidx.core.hardware.fingerprint.FingerprintManagerCompat.Api23Impl.e(r0)
            if (r0 == 0) goto L_0x0016
            r2 = 1
        L_0x0016:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.hardware.fingerprint.FingerprintManagerCompat.f():boolean");
    }
}
