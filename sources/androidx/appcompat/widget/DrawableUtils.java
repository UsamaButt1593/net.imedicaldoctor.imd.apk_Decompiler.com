package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DrawableUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3189a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f3190b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Rect f3191c = new Rect();

    static class Api18Impl {

        /* renamed from: a  reason: collision with root package name */
        private static final boolean f3192a;

        /* renamed from: b  reason: collision with root package name */
        private static final Method f3193b;

        /* renamed from: c  reason: collision with root package name */
        private static final Field f3194c;

        /* renamed from: d  reason: collision with root package name */
        private static final Field f3195d;

        /* renamed from: e  reason: collision with root package name */
        private static final Field f3196e;

        /* renamed from: f  reason: collision with root package name */
        private static final Field f3197f;

        /* JADX WARNING: Removed duplicated region for block: B:43:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0063  */
        static {
            /*
                r0 = 1
                r1 = 0
                r2 = 0
                java.lang.String r3 = "android.graphics.Insets"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ NoSuchMethodException -> 0x004e, ClassNotFoundException -> 0x004a, NoSuchFieldException -> 0x0046 }
                java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
                java.lang.String r5 = "getOpticalInsets"
                java.lang.reflect.Method r4 = r4.getMethod(r5, r1)     // Catch:{ NoSuchMethodException -> 0x004e, ClassNotFoundException -> 0x004a, NoSuchFieldException -> 0x0046 }
                java.lang.String r5 = "left"
                java.lang.reflect.Field r5 = r3.getField(r5)     // Catch:{ NoSuchMethodException -> 0x0042, ClassNotFoundException -> 0x003e, NoSuchFieldException -> 0x003a }
                java.lang.String r6 = "top"
                java.lang.reflect.Field r6 = r3.getField(r6)     // Catch:{ NoSuchMethodException -> 0x0037, ClassNotFoundException -> 0x0034, NoSuchFieldException -> 0x0030 }
                java.lang.String r7 = "right"
                java.lang.reflect.Field r7 = r3.getField(r7)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException -> 0x002d }
                java.lang.String r8 = "bottom"
                java.lang.reflect.Field r3 = r3.getField(r8)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException -> 0x002b }
                r8 = 1
                goto L_0x0054
            L_0x002b:
                goto L_0x0052
            L_0x002d:
                r7 = r1
                goto L_0x0052
            L_0x0030:
                r6 = r1
            L_0x0032:
                r7 = r6
                goto L_0x0052
            L_0x0034:
                r6 = r1
                goto L_0x0032
            L_0x0037:
                r6 = r1
                goto L_0x0032
            L_0x003a:
                r5 = r1
            L_0x003c:
                r6 = r5
                goto L_0x0032
            L_0x003e:
                r5 = r1
            L_0x0040:
                r6 = r5
                goto L_0x0032
            L_0x0042:
                r5 = r1
            L_0x0044:
                r6 = r5
                goto L_0x0032
            L_0x0046:
                r4 = r1
                r5 = r4
                goto L_0x003c
            L_0x004a:
                r4 = r1
                r5 = r4
                goto L_0x0040
            L_0x004e:
                r4 = r1
                r5 = r4
                goto L_0x0044
            L_0x0052:
                r3 = r1
                r8 = 0
            L_0x0054:
                if (r8 == 0) goto L_0x0063
                f3193b = r4
                f3194c = r5
                f3195d = r6
                f3196e = r7
                f3197f = r3
                f3192a = r0
                goto L_0x006f
            L_0x0063:
                f3193b = r1
                f3194c = r1
                f3195d = r1
                f3196e = r1
                f3197f = r1
                f3192a = r2
            L_0x006f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DrawableUtils.Api18Impl.<clinit>():void");
        }

        private Api18Impl() {
        }

        @NonNull
        static Rect a(@NonNull Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && f3192a) {
                try {
                    Object invoke = f3193b.invoke(drawable, (Object[]) null);
                    if (invoke != null) {
                        return new Rect(f3194c.getInt(invoke), f3195d.getInt(invoke), f3196e.getInt(invoke), f3197f.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return DrawableUtils.f3191c;
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    private DrawableUtils() {
    }

    @Deprecated
    public static boolean a(@NonNull Drawable drawable) {
        return true;
    }

    static void b(@NonNull Drawable drawable) {
        String name = drawable.getClass().getName();
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) || (i2 >= 29 && i2 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name))) {
            c(drawable);
        }
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f3189a);
        } else {
            drawable.setState(f3190b);
        }
        drawable.setState(state);
    }

    @NonNull
    public static Rect d(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT < 29) {
            return Api18Impl.a(DrawableCompat.q(drawable));
        }
        Insets a2 = Api29Impl.a(drawable);
        return new Rect(a2.left, a2.top, a2.right, a2.bottom);
    }

    public static PorterDuff.Mode e(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
