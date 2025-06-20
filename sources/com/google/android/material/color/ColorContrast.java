package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import java.util.LinkedHashSet;
import java.util.Set;

public class ColorContrast {

    /* renamed from: a  reason: collision with root package name */
    private static final float f21013a = 0.33333334f;

    /* renamed from: b  reason: collision with root package name */
    private static final float f21014b = 0.6666667f;

    @RequiresApi(34)
    private static class ColorContrastActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final ColorContrastOptions X;
        @Nullable
        private UiModeManager.ContrastChangeListener Y;
        /* access modifiers changed from: private */
        public final Set<Activity> s = new LinkedHashSet();

        ColorContrastActivityLifecycleCallbacks(ColorContrastOptions colorContrastOptions) {
            this.X = colorContrastOptions;
        }

        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        public void onActivityDestroyed(@NonNull Activity activity) {
            this.s.remove(activity);
            UiModeManager uiModeManager = (UiModeManager) activity.getSystemService("uimode");
            if (uiModeManager != null && this.Y != null && this.s.isEmpty()) {
                uiModeManager.removeContrastChangeListener(this.Y);
                this.Y = null;
            }
        }

        public void onActivityPaused(@NonNull Activity activity) {
        }

        public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            UiModeManager uiModeManager = (UiModeManager) activity.getSystemService("uimode");
            if (uiModeManager != null && this.s.isEmpty() && this.Y == null) {
                this.Y = new UiModeManager.ContrastChangeListener() {
                    public void onContrastChanged(float f2) {
                        for (Activity recreate : ColorContrastActivityLifecycleCallbacks.this.s) {
                            recreate.recreate();
                        }
                    }
                };
                uiModeManager.addContrastChangeListener(ContextCompat.o(activity.getApplicationContext()), this.Y);
            }
            this.s.add(activity);
            if (uiModeManager != null) {
                ColorContrast.b(activity, this.X);
            }
        }

        public void onActivityResumed(@NonNull Activity activity) {
        }

        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        public void onActivityStarted(@NonNull Activity activity) {
        }

        public void onActivityStopped(@NonNull Activity activity) {
        }
    }

    private ColorContrast() {
    }

    public static void a(@NonNull Application application, @NonNull ColorContrastOptions colorContrastOptions) {
        if (d()) {
            application.registerActivityLifecycleCallbacks(new ColorContrastActivityLifecycleCallbacks(colorContrastOptions));
        }
    }

    public static void b(@NonNull Activity activity, @NonNull ColorContrastOptions colorContrastOptions) {
        int c2;
        if (d() && (c2 = c(activity, colorContrastOptions)) != 0) {
            ThemeUtils.a(activity, c2);
        }
    }

    private static int c(Context context, ColorContrastOptions colorContrastOptions) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        if (d() && uiModeManager != null) {
            float a2 = uiModeManager.getContrast();
            int b2 = colorContrastOptions.b();
            int a3 = colorContrastOptions.a();
            if (a2 >= f21014b) {
                return a3 == 0 ? b2 : a3;
            }
            if (a2 >= f21013a) {
                return b2 == 0 ? a3 : b2;
            }
        }
        return 0;
    }

    @ChecksSdkIntAtLeast(api = 34)
    public static boolean d() {
        return Build.VERSION.SDK_INT >= 34;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r2 = c(r1, r2);
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Context e(@androidx.annotation.NonNull android.content.Context r1, @androidx.annotation.NonNull com.google.android.material.color.ColorContrastOptions r2) {
        /*
            boolean r0 = d()
            if (r0 != 0) goto L_0x0007
            return r1
        L_0x0007:
            int r2 = c(r1, r2)
            if (r2 != 0) goto L_0x000e
            return r1
        L_0x000e:
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.ColorContrast.e(android.content.Context, com.google.android.material.color.ColorContrastOptions):android.content.Context");
    }
}
