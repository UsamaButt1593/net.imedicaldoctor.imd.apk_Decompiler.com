package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.media3.common.C;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PackageInfoCompat {

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        @Nullable
        static Signature[] a(@NonNull SigningInfo signingInfo) {
            return signingInfo.getApkContentsSigners();
        }

        @DoNotInline
        static long b(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }

        @DoNotInline
        @Nullable
        static Signature[] c(@NonNull SigningInfo signingInfo) {
            return signingInfo.getSigningCertificateHistory();
        }

        @DoNotInline
        static boolean d(@NonNull SigningInfo signingInfo) {
            return signingInfo.hasMultipleSigners();
        }

        @DoNotInline
        static boolean e(@NonNull PackageManager packageManager, @NonNull String str, @NonNull byte[] bArr, int i2) {
            return packageManager.hasSigningCertificate(str, bArr, i2);
        }
    }

    private PackageInfoCompat() {
    }

    private static boolean a(@NonNull byte[][] bArr, @NonNull byte[] bArr2) {
        for (byte[] equals : bArr) {
            if (Arrays.equals(bArr2, equals)) {
                return true;
            }
        }
        return false;
    }

    private static byte[] b(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA256").digest(bArr);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Device doesn't support SHA256 cert checking", e2);
        }
    }

    public static long c(@NonNull PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.b(packageInfo) : (long) packageInfo.versionCode;
    }

    @NonNull
    public static List<Signature> d(@NonNull PackageManager packageManager, @NonNull String str) throws PackageManager.NameNotFoundException {
        Signature[] signatureArr;
        if (Build.VERSION.SDK_INT >= 28) {
            SigningInfo a2 = packageManager.getPackageInfo(str, C.S0).signingInfo;
            signatureArr = Api28Impl.d(a2) ? Api28Impl.a(a2) : Api28Impl.c(a2);
        } else {
            signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        }
        return signatureArr == null ? Collections.emptyList() : Arrays.asList(signatureArr);
    }

    public static boolean e(@NonNull PackageManager packageManager, @NonNull String str, @Size(min = 1) @NonNull Map<byte[], Integer> map, boolean z) throws PackageManager.NameNotFoundException {
        byte[][] bArr;
        if (map.isEmpty()) {
            return false;
        }
        Set<byte[]> keySet = map.keySet();
        for (byte[] next : keySet) {
            if (next != null) {
                Integer num = map.get(next);
                if (num != null) {
                    int intValue = num.intValue();
                    if (intValue != 0 && intValue != 1) {
                        throw new IllegalArgumentException("Unsupported certificate type " + num + " when verifying " + str);
                    }
                } else {
                    throw new IllegalArgumentException("Type must be specified for cert when verifying " + str);
                }
            } else {
                throw new IllegalArgumentException("Cert byte array cannot be null when verifying " + str);
            }
        }
        List<Signature> d2 = d(packageManager, str);
        if (z || Build.VERSION.SDK_INT < 28) {
            if (d2.size() != 0 && map.size() <= d2.size() && (!z || map.size() == d2.size())) {
                if (map.containsValue(1)) {
                    bArr = new byte[d2.size()][];
                    for (int i2 = 0; i2 < d2.size(); i2++) {
                        bArr[i2] = b(d2.get(i2).toByteArray());
                    }
                } else {
                    bArr = null;
                }
                Iterator<byte[]> it2 = keySet.iterator();
                if (it2.hasNext()) {
                    byte[] next2 = it2.next();
                    Integer num2 = map.get(next2);
                    int intValue2 = num2.intValue();
                    if (intValue2 != 0) {
                        if (intValue2 != 1) {
                            throw new IllegalArgumentException("Unsupported certificate type " + num2);
                        } else if (!a(bArr, next2)) {
                            return false;
                        }
                    } else if (!d2.contains(new Signature(next2))) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
        for (byte[] next3 : keySet) {
            if (!Api28Impl.e(packageManager, str, next3, map.get(next3).intValue())) {
                return false;
            }
        }
        return true;
    }
}
