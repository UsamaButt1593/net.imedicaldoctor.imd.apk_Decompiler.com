package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/graphics/Bitmap;", "Landroid/content/res/Resources;", "resources", "Landroid/graphics/drawable/BitmapDrawable;", "a", "(Landroid/graphics/Bitmap;Landroid/content/res/Resources;)Landroid/graphics/drawable/BitmapDrawable;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class BitmapDrawableKt {
    @NotNull
    public static final BitmapDrawable a(@NotNull Bitmap bitmap, @NotNull Resources resources) {
        return new BitmapDrawable(resources, bitmap);
    }
}
