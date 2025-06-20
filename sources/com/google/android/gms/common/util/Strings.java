package com.google.android.gms.common.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

@KeepForSdk
public class Strings {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f20395a = Pattern.compile("\\$\\{(.*?)\\}");

    private Strings() {
    }

    @KeepForSdk
    @Nullable
    public static String a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    @KeepForSdk
    @EnsuresNonNullIf(expression = {"#1"}, result = false)
    public static boolean b(@Nullable String str) {
        return str == null || str.trim().isEmpty();
    }
}
