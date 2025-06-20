package androidx.core.graphics;

import android.graphics.Paint;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/graphics/Paint;", "Landroidx/core/graphics/BlendModeCompat;", "blendModeCompat", "", "a", "(Landroid/graphics/Paint;Landroidx/core/graphics/BlendModeCompat;)Z", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class PaintKt {
    public static final boolean a(@NotNull Paint paint, @Nullable BlendModeCompat blendModeCompat) {
        return PaintCompat.c(paint, blendModeCompat);
    }
}
