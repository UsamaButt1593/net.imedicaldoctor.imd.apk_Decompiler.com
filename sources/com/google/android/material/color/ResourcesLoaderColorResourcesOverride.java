package com.google.android.material.color;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.R;
import java.util.Map;

@RequiresApi(api = 30)
class ResourcesLoaderColorResourcesOverride implements ColorResourcesOverride {

    private static class ResourcesLoaderColorResourcesOverrideSingleton {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final ResourcesLoaderColorResourcesOverride f21142a = new ResourcesLoaderColorResourcesOverride();

        private ResourcesLoaderColorResourcesOverrideSingleton() {
        }
    }

    private ResourcesLoaderColorResourcesOverride() {
    }

    static ColorResourcesOverride c() {
        return ResourcesLoaderColorResourcesOverrideSingleton.f21142a;
    }

    @NonNull
    public Context a(Context context, Map<Integer, Integer> map) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, R.style.na);
        contextThemeWrapper.applyOverrideConfiguration(new Configuration());
        return ResourcesLoaderUtils.a(contextThemeWrapper, map) ? contextThemeWrapper : context;
    }

    public boolean b(Context context, Map<Integer, Integer> map) {
        if (!ResourcesLoaderUtils.a(context, map)) {
            return false;
        }
        ThemeUtils.a(context, R.style.na);
        return true;
    }
}
