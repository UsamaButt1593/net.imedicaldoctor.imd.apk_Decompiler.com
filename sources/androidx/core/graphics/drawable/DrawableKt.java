package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a1\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0003\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a3\u0010\t\u001a\u0004\u0018\u00010\u0006*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0003\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\b\u001a9\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\b\b\u0003\u0010\n\u001a\u00020\u00012\b\b\u0003\u0010\u000b\u001a\u00020\u00012\b\b\u0003\u0010\f\u001a\u00020\u00012\b\b\u0003\u0010\r\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroid/graphics/drawable/Drawable;", "", "width", "height", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/Bitmap;", "a", "(Landroid/graphics/drawable/Drawable;IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;", "c", "left", "top", "right", "bottom", "", "e", "(Landroid/graphics/drawable/Drawable;IIII)V", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDrawable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Drawable.kt\nandroidx/core/graphics/drawable/DrawableKt\n+ 2 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n1#1,118:1\n38#2:119\n49#2:120\n60#2:121\n71#2:122\n*S KotlinDebug\n*F\n+ 1 Drawable.kt\nandroidx/core/graphics/drawable/DrawableKt\n*L\n66#1:119\n66#1:120\n66#1:121\n66#1:122\n*E\n"})
public final class DrawableKt {
    @NotNull
    public static final Bitmap a(@NotNull Drawable drawable, @Px int i2, @Px int i3, @Nullable Bitmap.Config config) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            } else if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                return (i2 == bitmapDrawable.getBitmap().getWidth() && i3 == bitmapDrawable.getBitmap().getHeight()) ? bitmapDrawable.getBitmap() : Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i2, i3, true);
            }
        }
        Rect bounds = drawable.getBounds();
        int i4 = bounds.left;
        int i5 = bounds.top;
        int i6 = bounds.right;
        int i7 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config);
        drawable.setBounds(0, 0, i2, i3);
        drawable.draw(new Canvas(createBitmap));
        drawable.setBounds(i4, i5, i6, i7);
        return createBitmap;
    }

    public static /* synthetic */ Bitmap b(Drawable drawable, int i2, int i3, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = drawable.getIntrinsicWidth();
        }
        if ((i4 & 2) != 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        if ((i4 & 4) != 0) {
            config = null;
        }
        return a(drawable, i2, i3, config);
    }

    @Nullable
    public static final Bitmap c(@NotNull Drawable drawable, @Px int i2, @Px int i3, @Nullable Bitmap.Config config) {
        if (!(drawable instanceof BitmapDrawable) || ((BitmapDrawable) drawable).getBitmap() != null) {
            return a(drawable, i2, i3, config);
        }
        return null;
    }

    public static /* synthetic */ Bitmap d(Drawable drawable, int i2, int i3, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = drawable.getIntrinsicWidth();
        }
        if ((i4 & 2) != 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        if ((i4 & 4) != 0) {
            config = null;
        }
        return c(drawable, i2, i3, config);
    }

    public static final void e(@NotNull Drawable drawable, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        drawable.setBounds(i2, i3, i4, i5);
    }

    public static /* synthetic */ void f(Drawable drawable, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = drawable.getBounds().left;
        }
        if ((i6 & 2) != 0) {
            i3 = drawable.getBounds().top;
        }
        if ((i6 & 4) != 0) {
            i4 = drawable.getBounds().right;
        }
        if ((i6 & 8) != 0) {
            i5 = drawable.getBounds().bottom;
        }
        e(drawable, i2, i3, i4, i5);
    }
}
