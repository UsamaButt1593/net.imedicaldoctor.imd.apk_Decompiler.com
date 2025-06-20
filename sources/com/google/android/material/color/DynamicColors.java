package com.google.android.material.color;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.os.BuildCompat;
import com.google.android.material.R;
import com.google.android.material.color.DynamicColorsOptions;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.SchemeContent;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DynamicColors {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f21097a = {R.attr.r6};

    /* renamed from: b  reason: collision with root package name */
    private static final DeviceSupportCondition f21098b;
    @SuppressLint({"PrivateApi"})

    /* renamed from: c  reason: collision with root package name */
    private static final DeviceSupportCondition f21099c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, DeviceSupportCondition> f21100d;

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, DeviceSupportCondition> f21101e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f21102f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static final String f21103g = DynamicColors.class.getSimpleName();

    private interface DeviceSupportCondition {
        boolean a();
    }

    private static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final DynamicColorsOptions s;

        DynamicColorsActivityLifecycleCallbacks(@NonNull DynamicColorsOptions dynamicColorsOptions) {
            this.s = dynamicColorsOptions;
        }

        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        public void onActivityPaused(@NonNull Activity activity) {
        }

        public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            DynamicColors.j(activity, this.s);
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

    public interface OnAppliedCallback {
        void a(@NonNull Activity activity);
    }

    public interface Precondition {
        boolean a(@NonNull Activity activity, @StyleRes int i2);
    }

    static {
        AnonymousClass1 r0 = new DeviceSupportCondition() {
            public boolean a() {
                return true;
            }
        };
        f21098b = r0;
        AnonymousClass2 r1 = new DeviceSupportCondition() {

            /* renamed from: a  reason: collision with root package name */
            private Long f21104a;

            public boolean a() {
                if (this.f21104a == null) {
                    try {
                        Method declaredMethod = Build.class.getDeclaredMethod("getLong", new Class[]{String.class});
                        declaredMethod.setAccessible(true);
                        Long l2 = (Long) declaredMethod.invoke((Object) null, new Object[]{"ro.build.version.oneui"});
                        l2.longValue();
                        this.f21104a = l2;
                    } catch (Exception unused) {
                        this.f21104a = -1L;
                    }
                }
                return this.f21104a.longValue() >= 40100;
            }
        };
        f21099c = r1;
        HashMap hashMap = new HashMap();
        hashMap.put("fcnt", r0);
        hashMap.put("google", r0);
        hashMap.put("hmd global", r0);
        hashMap.put("infinix", r0);
        hashMap.put("infinix mobility limited", r0);
        hashMap.put("itel", r0);
        hashMap.put("kyocera", r0);
        hashMap.put("lenovo", r0);
        hashMap.put("lge", r0);
        hashMap.put("meizu", r0);
        hashMap.put("motorola", r0);
        hashMap.put("nothing", r0);
        hashMap.put("oneplus", r0);
        hashMap.put("oppo", r0);
        hashMap.put("realme", r0);
        hashMap.put("robolectric", r0);
        hashMap.put("samsung", r1);
        hashMap.put("sharp", r0);
        hashMap.put("shift", r0);
        hashMap.put("sony", r0);
        hashMap.put("tcl", r0);
        hashMap.put("tecno", r0);
        hashMap.put("tecno mobile limited", r0);
        hashMap.put("vivo", r0);
        hashMap.put("wingtech", r0);
        hashMap.put("xiaomi", r0);
        f21100d = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("asus", r0);
        hashMap2.put("jio", r0);
        f21101e = Collections.unmodifiableMap(hashMap2);
    }

    private DynamicColors() {
    }

    @Deprecated
    public static void a(@NonNull Activity activity) {
        i(activity);
    }

    @Deprecated
    public static void b(@NonNull Activity activity, @StyleRes int i2) {
        j(activity, new DynamicColorsOptions.Builder().k(i2).f());
    }

    @Deprecated
    public static void c(@NonNull Activity activity, @NonNull Precondition precondition) {
        j(activity, new DynamicColorsOptions.Builder().j(precondition).f());
    }

    public static void d(@NonNull Application application) {
        h(application, new DynamicColorsOptions.Builder().f());
    }

    @Deprecated
    public static void e(@NonNull Application application, @StyleRes int i2) {
        h(application, new DynamicColorsOptions.Builder().k(i2).f());
    }

    @Deprecated
    public static void f(@NonNull Application application, @StyleRes int i2, @NonNull Precondition precondition) {
        h(application, new DynamicColorsOptions.Builder().k(i2).j(precondition).f());
    }

    @Deprecated
    public static void g(@NonNull Application application, @NonNull Precondition precondition) {
        h(application, new DynamicColorsOptions.Builder().j(precondition).f());
    }

    public static void h(@NonNull Application application, @NonNull DynamicColorsOptions dynamicColorsOptions) {
        application.registerActivityLifecycleCallbacks(new DynamicColorsActivityLifecycleCallbacks(dynamicColorsOptions));
    }

    public static void i(@NonNull Activity activity) {
        j(activity, new DynamicColorsOptions.Builder().f());
    }

    public static void j(@NonNull Activity activity, @NonNull DynamicColorsOptions dynamicColorsOptions) {
        if (m()) {
            int k2 = dynamicColorsOptions.d() == null ? dynamicColorsOptions.g() == 0 ? k(activity, f21097a) : dynamicColorsOptions.g() : 0;
            if (dynamicColorsOptions.f().a(activity, k2)) {
                if (dynamicColorsOptions.d() != null) {
                    SchemeContent schemeContent = new SchemeContent(Hct.b(dynamicColorsOptions.d().intValue()), !MaterialColors.r(activity), (double) l(activity));
                    ColorResourcesOverride a2 = i.a();
                    if (a2 == null || !a2.b(activity, MaterialColorUtilitiesHelper.a(schemeContent))) {
                        return;
                    }
                } else {
                    ThemeUtils.a(activity, k2);
                }
                dynamicColorsOptions.e().a(activity);
            }
        }
    }

    private static int k(@NonNull Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static float l(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        if (uiModeManager == null || Build.VERSION.SDK_INT < 34) {
            return 0.0f;
        }
        return uiModeManager.getContrast();
    }

    @SuppressLint({"DefaultLocale"})
    @ChecksSdkIntAtLeast(api = 31)
    public static boolean m() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        if (BuildCompat.k()) {
            return true;
        }
        Map<String, DeviceSupportCondition> map = f21100d;
        String str = Build.MANUFACTURER;
        Locale locale = Locale.ROOT;
        DeviceSupportCondition deviceSupportCondition = map.get(str.toLowerCase(locale));
        if (deviceSupportCondition == null) {
            deviceSupportCondition = f21101e.get(Build.BRAND.toLowerCase(locale));
        }
        return deviceSupportCondition != null && deviceSupportCondition.a();
    }

    @NonNull
    public static Context n(@NonNull Context context) {
        return o(context, 0);
    }

    @NonNull
    public static Context o(@NonNull Context context, @StyleRes int i2) {
        return p(context, new DynamicColorsOptions.Builder().k(i2).f());
    }

    @NonNull
    public static Context p(@NonNull Context context, @NonNull DynamicColorsOptions dynamicColorsOptions) {
        if (!m()) {
            return context;
        }
        int g2 = dynamicColorsOptions.g();
        if (g2 == 0) {
            g2 = k(context, f21097a);
        }
        if (g2 == 0) {
            return context;
        }
        if (dynamicColorsOptions.d() != null) {
            SchemeContent schemeContent = new SchemeContent(Hct.b(dynamicColorsOptions.d().intValue()), !MaterialColors.r(context), (double) l(context));
            ColorResourcesOverride a2 = i.a();
            if (a2 != null) {
                return a2.a(context, MaterialColorUtilitiesHelper.a(schemeContent));
            }
        }
        return new ContextThemeWrapper(context, g2);
    }
}
