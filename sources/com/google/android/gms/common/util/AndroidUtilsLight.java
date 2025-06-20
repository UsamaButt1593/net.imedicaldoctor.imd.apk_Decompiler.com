package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import com.itextpdf.text.pdf.security.SecurityConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@ShowFirstParty
@KeepForSdk
public class AndroidUtilsLight {

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f20359a = -1;

    @Nullable
    @KeepForSdk
    @Deprecated
    public static byte[] a(@NonNull Context context, @NonNull String str) throws PackageManager.NameNotFoundException {
        MessageDigest b2;
        PackageInfo f2 = Wrappers.a(context).f(str, 64);
        Signature[] signatureArr = f2.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (b2 = b(SecurityConstants.o)) == null) {
            return null;
        }
        return b2.digest(f2.signatures[0].toByteArray());
    }

    @Nullable
    public static MessageDigest b(@NonNull String str) {
        int i2 = 0;
        while (i2 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i2++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }
}
