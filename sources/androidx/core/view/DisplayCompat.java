package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

public final class DisplayCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final int f6370a = 3840;

    /* renamed from: b  reason: collision with root package name */
    private static final int f6371b = 2160;

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @NonNull
        static ModeCompat a(@NonNull Context context, @NonNull Display display) {
            Display.Mode mode = display.getMode();
            Point a2 = DisplayCompat.a(context, display);
            return (a2 == null || d(mode, a2)) ? new ModeCompat(mode, true) : new ModeCompat(mode, a2);
        }

        @SuppressLint({"ArrayReturn"})
        @NonNull
        public static ModeCompat[] b(@NonNull Context context, @NonNull Display display) {
            Display.Mode[] supportedModes = display.getSupportedModes();
            ModeCompat[] modeCompatArr = new ModeCompat[supportedModes.length];
            Display.Mode mode = display.getMode();
            Point a2 = DisplayCompat.a(context, display);
            if (a2 == null || d(mode, a2)) {
                for (int i2 = 0; i2 < supportedModes.length; i2++) {
                    modeCompatArr[i2] = new ModeCompat(supportedModes[i2], e(supportedModes[i2], mode));
                }
            } else {
                for (int i3 = 0; i3 < supportedModes.length; i3++) {
                    modeCompatArr[i3] = e(supportedModes[i3], mode) ? new ModeCompat(supportedModes[i3], a2) : new ModeCompat(supportedModes[i3], false);
                }
            }
            return modeCompatArr;
        }

        static boolean c(@NonNull Display display) {
            Display.Mode mode = display.getMode();
            for (Display.Mode mode2 : display.getSupportedModes()) {
                if (mode.getPhysicalHeight() < mode2.getPhysicalHeight() || mode.getPhysicalWidth() < mode2.getPhysicalWidth()) {
                    return false;
                }
            }
            return true;
        }

        static boolean d(Display.Mode mode, Point point) {
            return (mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x);
        }

        static boolean e(Display.Mode mode, Display.Mode mode2) {
            return mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight();
        }
    }

    public static final class ModeCompat {

        /* renamed from: a  reason: collision with root package name */
        private final Display.Mode f6372a;

        /* renamed from: b  reason: collision with root package name */
        private final Point f6373b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f6374c;

        @RequiresApi(23)
        static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            static int a(Display.Mode mode) {
                return mode.getPhysicalHeight();
            }

            @DoNotInline
            static int b(Display.Mode mode) {
                return mode.getPhysicalWidth();
            }
        }

        ModeCompat(@NonNull Point point) {
            Preconditions.m(point, "physicalSize == null");
            this.f6373b = point;
            this.f6372a = null;
            this.f6374c = true;
        }

        public int a() {
            return this.f6373b.y;
        }

        public int b() {
            return this.f6373b.x;
        }

        @Deprecated
        public boolean c() {
            return this.f6374c;
        }

        @RequiresApi(23)
        @Nullable
        public Display.Mode d() {
            return this.f6372a;
        }

        @RequiresApi(23)
        ModeCompat(@NonNull Display.Mode mode, @NonNull Point point) {
            Preconditions.m(mode, "mode == null, can't wrap a null reference");
            Preconditions.m(point, "physicalSize == null");
            this.f6373b = point;
            this.f6372a = mode;
            this.f6374c = true;
        }

        @RequiresApi(23)
        ModeCompat(@NonNull Display.Mode mode, boolean z) {
            Preconditions.m(mode, "mode == null, can't wrap a null reference");
            this.f6373b = new Point(Api23Impl.b(mode), Api23Impl.a(mode));
            this.f6372a = mode;
            this.f6374c = z;
        }
    }

    private DisplayCompat() {
    }

    static Point a(@NonNull Context context, @NonNull Display display) {
        Point j2 = j(Build.VERSION.SDK_INT < 28 ? "sys.display-size" : "vendor.display-size", display);
        if (j2 != null) {
            return j2;
        }
        if (!g(context) || !f(display)) {
            return null;
        }
        return new Point(f6370a, f6371b);
    }

    @NonNull
    private static Point b(@NonNull Context context, @NonNull Display display) {
        Point a2 = a(context, display);
        if (a2 != null) {
            return a2;
        }
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }

    @NonNull
    public static ModeCompat c(@NonNull Context context, @NonNull Display display) {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.a(context, display) : new ModeCompat(b(context, display));
    }

    @SuppressLint({"ArrayReturn"})
    @NonNull
    public static ModeCompat[] d(@NonNull Context context, @NonNull Display display) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.b(context, display);
        }
        return new ModeCompat[]{c(context, display)};
    }

    @Nullable
    private static String e(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception unused) {
            return null;
        }
    }

    static boolean f(@NonNull Display display) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.c(display);
        }
        return true;
    }

    private static boolean g(@NonNull Context context) {
        return h(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
    }

    private static boolean h(@NonNull Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    private static Point i(@NonNull String str) throws NumberFormatException {
        String[] split = str.trim().split("x", -1);
        if (split.length == 2) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt > 0 && parseInt2 > 0) {
                return new Point(parseInt, parseInt2);
            }
        }
        throw new NumberFormatException();
    }

    @Nullable
    private static Point j(@NonNull String str, @NonNull Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        String e2 = e(str);
        if (!TextUtils.isEmpty(e2) && e2 != null) {
            try {
                return i(e2);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }
}
