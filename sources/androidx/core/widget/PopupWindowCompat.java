package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6756a = "PopupWindowCompatApi21";

    /* renamed from: b  reason: collision with root package name */
    private static Method f6757b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f6758c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f6759d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f6760e;

    /* renamed from: f  reason: collision with root package name */
    private static Field f6761f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f6762g;

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        @DoNotInline
        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        @DoNotInline
        static void c(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        @DoNotInline
        static void d(PopupWindow popupWindow, int i2) {
            popupWindow.setWindowLayoutType(i2);
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean a(@NonNull PopupWindow popupWindow) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(popupWindow);
        }
        if (!f6762g) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f6761f = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.i(f6756a, "Could not fetch mOverlapAnchor field from PopupWindow", e2);
            }
            f6762g = true;
        }
        Field field = f6761f;
        if (field == null) {
            return false;
        }
        try {
            return ((Boolean) field.get(popupWindow)).booleanValue();
        } catch (IllegalAccessException e3) {
            Log.i(f6756a, "Could not get overlap anchor field in PopupWindow", e3);
            return false;
        }
    }

    public static int b(@NonNull PopupWindow popupWindow) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.b(popupWindow);
        }
        if (!f6760e) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", (Class[]) null);
                f6759d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f6760e = true;
        }
        Method method = f6759d;
        if (method == null) {
            return 0;
        }
        try {
            return ((Integer) method.invoke(popupWindow, (Object[]) null)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void c(@NonNull PopupWindow popupWindow, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.c(popupWindow, z);
            return;
        }
        if (!f6762g) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f6761f = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.i(f6756a, "Could not fetch mOverlapAnchor field from PopupWindow", e2);
            }
            f6762g = true;
        }
        Field field = f6761f;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException e3) {
                Log.i(f6756a, "Could not set overlap anchor field in PopupWindow", e3);
            }
        }
    }

    public static void d(@NonNull PopupWindow popupWindow, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.d(popupWindow, i2);
            return;
        }
        if (!f6758c) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f6757b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f6758c = true;
        }
        Method method = f6757b;
        if (method != null) {
            try {
                method.invoke(popupWindow, new Object[]{Integer.valueOf(i2)});
            } catch (Exception unused2) {
            }
        }
    }

    public static void e(@NonNull PopupWindow popupWindow, @NonNull View view, int i2, int i3, int i4) {
        popupWindow.showAsDropDown(view, i2, i3, i4);
    }
}
