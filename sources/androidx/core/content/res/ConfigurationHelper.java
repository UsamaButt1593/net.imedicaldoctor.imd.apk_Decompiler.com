package androidx.core.content.res;

import android.content.res.Resources;
import androidx.annotation.NonNull;

public final class ConfigurationHelper {
    private ConfigurationHelper() {
    }

    public static int a(@NonNull Resources resources) {
        return resources.getConfiguration().densityDpi;
    }
}
