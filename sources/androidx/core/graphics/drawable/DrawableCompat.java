package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5893a = "DrawableCompat";

    /* renamed from: b  reason: collision with root package name */
    private static Method f5894b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f5895c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f5896d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f5897e;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        @DoNotInline
        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        @DoNotInline
        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        @DoNotInline
        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        @DoNotInline
        static void e(Drawable drawable, float f2, float f3) {
            drawable.setHotspot(f2, f3);
        }

        @DoNotInline
        static void f(Drawable drawable, int i2, int i3, int i4, int i5) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }

        @DoNotInline
        static void g(Drawable drawable, int i2) {
            drawable.setTint(i2);
        }

        @DoNotInline
        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        @DoNotInline
        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        @DoNotInline
        static boolean b(Drawable drawable, int i2) {
            return drawable.setLayoutDirection(i2);
        }
    }

    private DrawableCompat() {
    }

    public static void a(@NonNull Drawable drawable, @NonNull Resources.Theme theme) {
        Api21Impl.a(drawable, theme);
    }

    public static boolean b(@NonNull Drawable drawable) {
        return Api21Impl.b(drawable);
    }

    public static void c(@NonNull Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        Drawable b2;
        int i2 = Build.VERSION.SDK_INT;
        drawable.clearColorFilter();
        if (i2 < 23) {
            if (drawable instanceof InsetDrawable) {
                b2 = ((InsetDrawable) drawable).getDrawable();
            } else if (drawable instanceof WrappedDrawable) {
                b2 = ((WrappedDrawable) drawable).b();
            } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
                int childCount = drawableContainerState.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    Drawable child = drawableContainerState.getChild(i3);
                    if (child != null) {
                        c(child);
                    }
                }
                return;
            } else {
                return;
            }
            c(b2);
        }
    }

    public static int d(@NonNull Drawable drawable) {
        return drawable.getAlpha();
    }

    @Nullable
    public static ColorFilter e(@NonNull Drawable drawable) {
        return Api21Impl.c(drawable);
    }

    public static int f(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(drawable);
        }
        if (!f5897e) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", (Class[]) null);
                f5896d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i(f5893a, "Failed to retrieve getLayoutDirection() method", e2);
            }
            f5897e = true;
        }
        Method method = f5896d;
        if (method == null) {
            return 0;
        }
        try {
            return ((Integer) method.invoke(drawable, (Object[]) null)).intValue();
        } catch (Exception e3) {
            Log.i(f5893a, "Failed to invoke getLayoutDirection() via reflection", e3);
            f5896d = null;
            return 0;
        }
    }

    public static void g(@NonNull Drawable drawable, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Api21Impl.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean h(@NonNull Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    @Deprecated
    public static void i(@NonNull Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(@NonNull Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static void k(@NonNull Drawable drawable, float f2, float f3) {
        Api21Impl.e(drawable, f2, f3);
    }

    public static void l(@NonNull Drawable drawable, int i2, int i3, int i4, int i5) {
        Api21Impl.f(drawable, i2, i3, i4, i5);
    }

    public static boolean m(@NonNull Drawable drawable, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.b(drawable, i2);
        }
        if (!f5895c) {
            Class<Drawable> cls = Drawable.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f5894b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i(f5893a, "Failed to retrieve setLayoutDirection(int) method", e2);
            }
            f5895c = true;
        }
        Method method = f5894b;
        if (method != null) {
            try {
                method.invoke(drawable, new Object[]{Integer.valueOf(i2)});
                return true;
            } catch (Exception e3) {
                Log.i(f5893a, "Failed to invoke setLayoutDirection(int) via reflection", e3);
                f5894b = null;
            }
        }
        return false;
    }

    public static void n(@NonNull Drawable drawable, @ColorInt int i2) {
        Api21Impl.g(drawable, i2);
    }

    public static void o(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList) {
        Api21Impl.h(drawable, colorStateList);
    }

    public static void p(@NonNull Drawable drawable, @Nullable PorterDuff.Mode mode) {
        Api21Impl.i(drawable, mode);
    }

    public static <T extends Drawable> T q(@NonNull Drawable drawable) {
        return drawable instanceof WrappedDrawable ? ((WrappedDrawable) drawable).b() : drawable;
    }

    @NonNull
    public static Drawable r(@NonNull Drawable drawable) {
        return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof TintAwareDrawable)) ? new WrappedDrawableApi21(drawable) : drawable;
    }
}
