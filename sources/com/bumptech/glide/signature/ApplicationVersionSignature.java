package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class ApplicationVersionSignature {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18516a = "AppVersionSignature";

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentMap<String, Key> f18517b = new ConcurrentHashMap();

    private ApplicationVersionSignature() {
    }

    @Nullable
    private static PackageInfo a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(f18516a, "Cannot resolve info for" + context.getPackageName(), e2);
            return null;
        }
    }

    @NonNull
    private static String b(@Nullable PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    @NonNull
    public static Key c(@NonNull Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, Key> concurrentMap = f18517b;
        Key key = concurrentMap.get(packageName);
        if (key != null) {
            return key;
        }
        Key d2 = d(context);
        Key putIfAbsent = concurrentMap.putIfAbsent(packageName, d2);
        return putIfAbsent == null ? d2 : putIfAbsent;
    }

    @NonNull
    private static Key d(@NonNull Context context) {
        return new ObjectKey(b(a(context)));
    }

    @VisibleForTesting
    static void e() {
        f18517b.clear();
    }
}
