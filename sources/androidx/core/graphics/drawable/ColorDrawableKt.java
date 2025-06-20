package androidx.core.graphics.drawable;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0004H\b¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "Landroid/graphics/drawable/ColorDrawable;", "a", "(I)Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/Color;", "b", "(Landroid/graphics/Color;)Landroid/graphics/drawable/ColorDrawable;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class ColorDrawableKt {
    @NotNull
    public static final ColorDrawable a(@ColorInt int i2) {
        return new ColorDrawable(i2);
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final ColorDrawable b(@NotNull Color color) {
        return new ColorDrawable(color.toArgb());
    }
}
