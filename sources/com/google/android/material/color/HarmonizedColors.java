package com.google.android.material.color;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ContextThemeWrapper;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import java.util.HashMap;
import java.util.Map;

public class HarmonizedColors {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21119a = "HarmonizedColors";

    private HarmonizedColors() {
    }

    @RequiresApi(api = 30)
    private static void a(@NonNull Map<Integer, Integer> map, @NonNull TypedArray typedArray, @Nullable TypedArray typedArray2, @ColorInt int i2) {
        if (typedArray2 == null) {
            typedArray2 = typedArray;
        }
        for (int i3 = 0; i3 < typedArray.getIndexCount(); i3++) {
            int resourceId = typedArray2.getResourceId(i3, 0);
            if (resourceId != 0 && typedArray.hasValue(i3) && ResourcesLoaderUtils.b(typedArray.getType(i3))) {
                map.put(Integer.valueOf(resourceId), Integer.valueOf(MaterialColors.o(typedArray.getColor(i3, 0), i2)));
            }
        }
    }

    @NonNull
    public static void b(@NonNull Context context, @NonNull HarmonizedColorsOptions harmonizedColorsOptions) {
        if (d()) {
            Map<Integer, Integer> c2 = c(context, harmonizedColorsOptions);
            int e2 = harmonizedColorsOptions.e(0);
            if (ResourcesLoaderUtils.a(context, c2) && e2 != 0) {
                ThemeUtils.a(context, e2);
            }
        }
    }

    @RequiresApi(api = 30)
    private static Map<Integer, Integer> c(Context context, HarmonizedColorsOptions harmonizedColorsOptions) {
        HashMap hashMap = new HashMap();
        int c2 = MaterialColors.c(context, harmonizedColorsOptions.b(), f21119a);
        for (int i2 : harmonizedColorsOptions.d()) {
            hashMap.put(Integer.valueOf(i2), Integer.valueOf(MaterialColors.o(ContextCompat.g(context, i2), c2)));
        }
        HarmonizedColorAttributes c3 = harmonizedColorsOptions.c();
        if (c3 != null) {
            int[] d2 = c3.d();
            if (d2.length > 0) {
                int e2 = c3.e();
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(d2);
                TypedArray obtainStyledAttributes2 = e2 != 0 ? new ContextThemeWrapper(context, e2).obtainStyledAttributes(d2) : null;
                a(hashMap, obtainStyledAttributes, obtainStyledAttributes2, c2);
                obtainStyledAttributes.recycle();
                if (obtainStyledAttributes2 != null) {
                    obtainStyledAttributes2.recycle();
                }
            }
        }
        return hashMap;
    }

    @ChecksSdkIntAtLeast(api = 30)
    public static boolean d() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @NonNull
    public static Context e(@NonNull Context context, @NonNull HarmonizedColorsOptions harmonizedColorsOptions) {
        if (!d()) {
            return context;
        }
        Map<Integer, Integer> c2 = c(context, harmonizedColorsOptions);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, harmonizedColorsOptions.e(R.style.ba));
        contextThemeWrapper.applyOverrideConfiguration(new Configuration());
        return ResourcesLoaderUtils.a(contextThemeWrapper, c2) ? contextThemeWrapper : context;
    }
}
