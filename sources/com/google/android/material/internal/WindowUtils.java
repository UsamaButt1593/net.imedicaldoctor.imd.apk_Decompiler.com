package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WindowUtils {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f21593a = "WindowUtils";

    private static class Api14Impl {
        private Api14Impl() {
        }

        @NonNull
        static Rect a(@NonNull WindowManager windowManager) {
            int i2;
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point b2 = b(defaultDisplay);
            Rect rect = new Rect();
            int i3 = b2.x;
            if (i3 == 0 || (i2 = b2.y) == 0) {
                defaultDisplay.getRectSize(rect);
            } else {
                rect.right = i3;
                rect.bottom = i2;
            }
            return rect;
        }

        private static Point b(Display display) {
            Point point = new Point();
            try {
                Method declaredMethod = Display.class.getDeclaredMethod("getRealSize", new Class[]{Point.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(display, new Object[]{point});
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                Log.w(WindowUtils.f21593a, e2);
            }
            return point;
        }
    }

    @RequiresApi(api = 17)
    private static class Api17Impl {
        private Api17Impl() {
        }

        @NonNull
        static Rect a(@NonNull WindowManager windowManager) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            Rect rect = new Rect();
            rect.right = point.x;
            rect.bottom = point.y;
            return rect;
        }
    }

    @RequiresApi(api = 30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        @NonNull
        static Rect a(@NonNull WindowManager windowManager) {
            return windowManager.getCurrentWindowMetrics().getBounds();
        }
    }

    private WindowUtils() {
    }

    @NonNull
    public static Rect b(@NonNull Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        return Build.VERSION.SDK_INT >= 30 ? Api30Impl.a(windowManager) : Api17Impl.a(windowManager);
    }
}
