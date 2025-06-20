package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;
import java.util.Objects;

public final class ViewConfigurationCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6515a = "ViewConfigCompat";

    /* renamed from: b  reason: collision with root package name */
    private static final int f6516b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private static final int f6517c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private static final int f6518d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static final int f6519e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static Method f6520f;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        @DoNotInline
        static float b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        @DoNotInline
        static boolean b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    @RequiresApi(34)
    static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static int a(@NonNull ViewConfiguration viewConfiguration, int i2, int i3, int i4) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i2, i3, i4);
        }

        @DoNotInline
        static int b(@NonNull ViewConfiguration viewConfiguration, int i2, int i3, int i4) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i2, i3, i4);
        }
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f6520f = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", (Class[]) null);
            } catch (Exception unused) {
                Log.i(f6515a, "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    private ViewConfigurationCompat() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r1.getDimensionPixelSize(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(android.content.res.Resources r1, int r2, androidx.core.util.Supplier<java.lang.Integer> r3, int r4) {
        /*
            r0 = -1
            if (r2 == r0) goto L_0x000e
            if (r2 == 0) goto L_0x000d
            int r1 = r1.getDimensionPixelSize(r2)
            if (r1 >= 0) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r4 = r1
        L_0x000d:
            return r4
        L_0x000e:
            java.lang.Object r1 = r3.get()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewConfigurationCompat.a(android.content.res.Resources, int, androidx.core.util.Supplier, int):int");
    }

    private static float b(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = f6520f) != null) {
            try {
                return (float) ((Integer) method.invoke(viewConfiguration, (Object[]) null)).intValue();
            } catch (Exception unused) {
                Log.i(f6515a, "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    private static int c(Resources resources, String str, String str2) {
        return resources.getIdentifier(str, str2, "android");
    }

    private static int d(Resources resources, int i2, int i3) {
        if (i2 == 4194304 && i3 == 26) {
            return c(resources, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    private static int e(Resources resources, int i2, int i3) {
        if (i2 == 4194304 && i3 == 26) {
            return c(resources, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static float f(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.a(viewConfiguration) : b(viewConfiguration, context);
    }

    public static int g(@NonNull ViewConfiguration viewConfiguration) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.a(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static int h(@NonNull Context context, @NonNull ViewConfiguration viewConfiguration, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.a(viewConfiguration, i2, i3, i4);
        }
        if (!m(i2, i3, i4)) {
            return Integer.MIN_VALUE;
        }
        Resources resources = context.getResources();
        int d2 = d(resources, i4, i3);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, d2, new J(viewConfiguration), Integer.MIN_VALUE);
    }

    public static int i(@NonNull Context context, @NonNull ViewConfiguration viewConfiguration, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.b(viewConfiguration, i2, i3, i4);
        }
        if (!m(i2, i3, i4)) {
            return Integer.MAX_VALUE;
        }
        Resources resources = context.getResources();
        int e2 = e(resources, i4, i3);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, e2, new K(viewConfiguration), Integer.MAX_VALUE);
    }

    @Deprecated
    public static int j(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float k(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.b(viewConfiguration) : b(viewConfiguration, context);
    }

    @Deprecated
    public static boolean l(ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    private static boolean m(int i2, int i3, int i4) {
        InputDevice device = InputDevice.getDevice(i2);
        return (device == null || device.getMotionRange(i3, i4) == null) ? false : true;
    }

    public static boolean n(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.b(viewConfiguration);
        }
        Resources resources = context.getResources();
        int c2 = c(resources, "config_showMenuShortcutsWhenKeyboardPresent", "bool");
        return c2 != 0 && resources.getBoolean(c2);
    }
}
