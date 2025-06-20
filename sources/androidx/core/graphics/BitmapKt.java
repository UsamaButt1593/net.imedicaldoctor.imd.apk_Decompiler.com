package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a$\u0010\u000b\u001a\u00020\b*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\n¢\u0006\u0004\b\u000b\u0010\f\u001a.\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\bH\n¢\u0006\u0004\b\u000e\u0010\u000f\u001a.\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a*\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a>\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010!\u001a\u00020\u0012*\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH\n¢\u0006\u0004\b!\u0010\"\u001a\u001c\u0010$\u001a\u00020\u0012*\u00020\u00002\u0006\u0010 \u001a\u00020#H\n¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroid/graphics/Bitmap;", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "(Landroid/graphics/Bitmap;Lkotlin/jvm/functions/Function1;)Landroid/graphics/Bitmap;", "", "x", "y", "h", "(Landroid/graphics/Bitmap;II)I", "color", "k", "(Landroid/graphics/Bitmap;III)V", "width", "height", "", "filter", "i", "(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap$Config;", "config", "d", "(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;", "hasAlpha", "Landroid/graphics/ColorSpace;", "colorSpace", "e", "(IILandroid/graphics/Bitmap$Config;ZLandroid/graphics/ColorSpace;)Landroid/graphics/Bitmap;", "Landroid/graphics/Point;", "p", "b", "(Landroid/graphics/Bitmap;Landroid/graphics/Point;)Z", "Landroid/graphics/PointF;", "c", "(Landroid/graphics/Bitmap;Landroid/graphics/PointF;)Z", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class BitmapKt {
    @NotNull
    public static final Bitmap a(@NotNull Bitmap bitmap, @NotNull Function1<? super Canvas, Unit> function1) {
        function1.f(new Canvas(bitmap));
        return bitmap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r3 = r3.y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean b(@org.jetbrains.annotations.NotNull android.graphics.Bitmap r2, @org.jetbrains.annotations.NotNull android.graphics.Point r3) {
        /*
            int r0 = r2.getWidth()
            int r1 = r3.x
            if (r1 < 0) goto L_0x0016
            if (r1 >= r0) goto L_0x0016
            int r3 = r3.y
            if (r3 < 0) goto L_0x0016
            int r2 = r2.getHeight()
            if (r3 >= r2) goto L_0x0016
            r2 = 1
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BitmapKt.b(android.graphics.Bitmap, android.graphics.Point):boolean");
    }

    public static final boolean c(@NotNull Bitmap bitmap, @NotNull PointF pointF) {
        float f2 = pointF.x;
        if (f2 >= 0.0f && f2 < ((float) bitmap.getWidth())) {
            float f3 = pointF.y;
            return f3 >= 0.0f && f3 < ((float) bitmap.getHeight());
        }
    }

    @NotNull
    public static final Bitmap d(int i2, int i3, @NotNull Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final Bitmap e(int i2, int i3, @NotNull Bitmap.Config config, boolean z, @NotNull ColorSpace colorSpace) {
        return Bitmap.createBitmap(i2, i3, config, z, colorSpace);
    }

    public static /* synthetic */ Bitmap f(int i2, int i3, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    public static /* synthetic */ Bitmap g(int i2, int i3, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        if ((i4 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        return Bitmap.createBitmap(i2, i3, config, z, colorSpace);
    }

    public static final int h(@NotNull Bitmap bitmap, int i2, int i3) {
        return bitmap.getPixel(i2, i3);
    }

    @NotNull
    public static final Bitmap i(@NotNull Bitmap bitmap, int i2, int i3, boolean z) {
        return Bitmap.createScaledBitmap(bitmap, i2, i3, z);
    }

    public static /* synthetic */ Bitmap j(Bitmap bitmap, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z = true;
        }
        return Bitmap.createScaledBitmap(bitmap, i2, i3, z);
    }

    public static final void k(@NotNull Bitmap bitmap, int i2, int i3, @ColorInt int i4) {
        bitmap.setPixel(i2, i3, i4);
    }
}
