package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.core.content.IntentCompat;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class AppLaunchChecker {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5222a = "android.support.AppLaunchChecker";

    /* renamed from: b  reason: collision with root package name */
    private static final String f5223b = "startedFromLauncher";

    public static boolean a(@NonNull Context context) {
        return context.getSharedPreferences(f5222a, 0).getBoolean(f5223b, false);
    }

    public static void b(@NonNull Activity activity) {
        Intent intent;
        SharedPreferences sharedPreferences = activity.getSharedPreferences(f5222a, 0);
        if (sharedPreferences.getBoolean(f5223b, false) || (intent = activity.getIntent()) == null || !"android.intent.action.MAIN".equals(intent.getAction())) {
            return;
        }
        if (intent.hasCategory("android.intent.category.LAUNCHER") || intent.hasCategory(IntentCompat.f5645e)) {
            sharedPreferences.edit().putBoolean(f5223b, true).apply();
        }
    }
}
