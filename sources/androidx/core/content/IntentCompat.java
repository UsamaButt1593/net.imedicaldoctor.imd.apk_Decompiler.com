package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;

public final class IntentCompat {
    @SuppressLint({"ActionValue"})

    /* renamed from: a  reason: collision with root package name */
    public static final String f5641a = "android.intent.action.CREATE_REMINDER";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5642b = "android.intent.extra.HTML_TEXT";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5643c = "android.intent.extra.START_PLAYBACK";
    @SuppressLint({"ActionValue"})

    /* renamed from: d  reason: collision with root package name */
    public static final String f5644d = "android.intent.extra.TIME";

    /* renamed from: e  reason: collision with root package name */
    public static final String f5645e = "android.intent.category.LEANBACK_LAUNCHER";

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static <T> T[] a(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
            return intent.getParcelableArrayExtra(str, cls);
        }

        @DoNotInline
        static <T> ArrayList<T> b(@NonNull Intent intent, @Nullable String str, @NonNull Class<? extends T> cls) {
            return intent.getParcelableArrayListExtra(str, cls);
        }

        @DoNotInline
        static <T> T c(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
            return intent.getParcelableExtra(str, cls);
        }

        @DoNotInline
        static <T extends Serializable> T d(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
            return intent.getSerializableExtra(str, cls);
        }
    }

    private IntentCompat() {
    }

    @NonNull
    public static Intent a(@NonNull Context context, @NonNull String str) {
        if (PackageManagerCompat.a(context.getPackageManager())) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 31) {
                return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", str, (String) null));
            }
            Intent data = new Intent(PackageManagerCompat.f5677b).setData(Uri.fromParts("package", str, (String) null));
            return i2 >= 30 ? data : data.setPackage((String) Preconditions.l(PackageManagerCompat.b(context.getPackageManager())));
        }
        throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
    }

    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @Nullable
    public static Parcelable[] b(@NonNull Intent intent, @Nullable String str, @NonNull Class<? extends Parcelable> cls) {
        return Build.VERSION.SDK_INT >= 34 ? (Parcelable[]) Api33Impl.a(intent, str, cls) : intent.getParcelableArrayExtra(str);
    }

    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    @Nullable
    public static <T> ArrayList<T> c(@NonNull Intent intent, @Nullable String str, @NonNull Class<? extends T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.b(intent, str, cls) : intent.getParcelableArrayListExtra(str);
    }

    @Nullable
    public static <T> T d(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.c(intent, str, cls);
        }
        T parcelableExtra = intent.getParcelableExtra(str);
        if (cls.isInstance(parcelableExtra)) {
            return parcelableExtra;
        }
        return null;
    }

    @Nullable
    public static <T extends Serializable> T e(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.d(intent, str, cls);
        }
        T serializableExtra = intent.getSerializableExtra(str);
        if (cls.isInstance(serializableExtra)) {
            return serializableExtra;
        }
        return null;
    }

    @NonNull
    public static Intent f(@NonNull String str, @NonNull String str2) {
        return Intent.makeMainSelectorActivity(str, str2);
    }
}
