package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import androidx.annotation.RequiresApi;
import java.util.Map;

@RequiresApi(api = 30)
final class ResourcesLoaderUtils {
    private ResourcesLoaderUtils() {
    }

    static boolean a(Context context, Map<Integer, Integer> map) {
        ResourcesLoader a2 = ColorResourcesLoaderCreator.a(context, map);
        if (a2 == null) {
            return false;
        }
        context.getResources().addLoaders(new ResourcesLoader[]{a2});
        return true;
    }

    static boolean b(int i2) {
        return 28 <= i2 && i2 <= 31;
    }
}
