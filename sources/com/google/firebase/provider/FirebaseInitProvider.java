package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.StartupTime;
import java.util.concurrent.atomic.AtomicBoolean;

public class FirebaseInitProvider extends ContentProvider {
    @Nullable
    private static StartupTime X = StartupTime.e();
    @NonNull
    private static AtomicBoolean Y = new AtomicBoolean(false);
    @VisibleForTesting
    static final String Z = "com.google.firebase.firebaseinitprovider";
    private static final String s = "FirebaseInitProvider";

    private static void a(@NonNull ProviderInfo providerInfo) {
        Preconditions.s(providerInfo, "FirebaseInitProvider ProviderInfo cannot be null.");
        if (Z.equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }

    @Nullable
    public static StartupTime b() {
        return X;
    }

    public static boolean c() {
        return Y.get();
    }

    public void attachInfo(@NonNull Context context, @NonNull ProviderInfo providerInfo) {
        a(providerInfo);
        super.attachInfo(context, providerInfo);
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        try {
            Y.set(true);
            Log.i(s, FirebaseApp.x(getContext()) == null ? "FirebaseApp initialization unsuccessful" : "FirebaseApp initialization successful");
            return false;
        } finally {
            Y.set(false);
        }
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
