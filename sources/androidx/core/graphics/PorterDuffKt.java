package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/graphics/PorterDuff$Mode;", "Landroid/graphics/PorterDuffXfermode;", "b", "(Landroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuffXfermode;", "", "color", "Landroid/graphics/PorterDuffColorFilter;", "a", "(Landroid/graphics/PorterDuff$Mode;I)Landroid/graphics/PorterDuffColorFilter;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class PorterDuffKt {
    @NotNull
    public static final PorterDuffColorFilter a(@NotNull PorterDuff.Mode mode, int i2) {
        return new PorterDuffColorFilter(i2, mode);
    }

    @NotNull
    public static final PorterDuffXfermode b(@NotNull PorterDuff.Mode mode) {
        return new PorterDuffXfermode(mode);
    }
}
