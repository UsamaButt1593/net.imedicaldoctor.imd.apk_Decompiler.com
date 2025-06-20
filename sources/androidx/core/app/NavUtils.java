package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class NavUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5284a = "NavUtils";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5285b = "android.support.PARENT_ACTIVITY";

    private NavUtils() {
    }

    @Nullable
    public static Intent a(@NonNull Activity activity) {
        Intent parentActivityIntent = activity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        String d2 = d(activity);
        if (d2 == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, d2);
        try {
            return e(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(f5284a, "getParentActivityIntent: bad parentActivityName '" + d2 + "' in manifest");
            return null;
        }
    }

    @Nullable
    public static Intent b(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        String e2 = e(context, componentName);
        if (e2 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), e2);
        return e(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    @Nullable
    public static Intent c(@NonNull Context context, @NonNull Class<?> cls) throws PackageManager.NameNotFoundException {
        String e2 = e(context, new ComponentName(context, cls));
        if (e2 == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(context, e2);
        return e(context, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
    }

    @Nullable
    public static String d(@NonNull Activity activity) {
        try {
            return e(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Nullable
    public static String e(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i2 = Build.VERSION.SDK_INT;
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i2 >= 29 ? 269222528 : i2 >= 24 ? 787072 : 640);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString(f5285b)) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static void f(@NonNull Activity activity) {
        Intent a2 = a(activity);
        if (a2 != null) {
            g(activity, a2);
            return;
        }
        throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void g(@NonNull Activity activity, @NonNull Intent intent) {
        activity.navigateUpTo(intent);
    }

    public static boolean h(@NonNull Activity activity, @NonNull Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }
}
