package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeUtils;

public class BlendModeColorFilterCompat {

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static ColorFilter a(int i2, Object obj) {
            return new BlendModeColorFilter(i2, (BlendMode) obj);
        }
    }

    private BlendModeColorFilterCompat() {
    }

    @Nullable
    public static ColorFilter a(int i2, @NonNull BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object a2 = BlendModeUtils.Api29Impl.a(blendModeCompat);
            if (a2 != null) {
                return Api29Impl.a(i2, a2);
            }
            return null;
        }
        PorterDuff.Mode a3 = BlendModeUtils.a(blendModeCompat);
        if (a3 != null) {
            return new PorterDuffColorFilter(i2, a3);
        }
        return null;
    }
}
