package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Pair;

public final class PaintCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5828a = "󟿽";

    /* renamed from: b  reason: collision with root package name */
    private static final String f5829b = "m";

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<Pair<Rect, Rect>> f5830c = new ThreadLocal<>();

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void a(Paint paint, Object obj) {
            paint.setBlendMode((BlendMode) obj);
        }
    }

    private PaintCompat() {
    }

    public static boolean a(@NonNull Paint paint, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(paint, str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText(f5828a);
        float measureText2 = paint.measureText(f5829b);
        float measureText3 = paint.measureText(str);
        float f2 = 0.0f;
        if (measureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > measureText2 * 2.0f) {
                return false;
            }
            int i2 = 0;
            while (i2 < length) {
                int charCount = Character.charCount(str.codePointAt(i2)) + i2;
                f2 += paint.measureText(str, i2, charCount);
                i2 = charCount;
            }
            if (measureText3 >= f2) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        Pair<Rect, Rect> b2 = b();
        paint.getTextBounds(f5828a, 0, 2, (Rect) b2.f6296a);
        paint.getTextBounds(str, 0, length, (Rect) b2.f6297b);
        return !((Rect) b2.f6296a).equals(b2.f6297b);
    }

    private static Pair<Rect, Rect> b() {
        ThreadLocal<Pair<Rect, Rect>> threadLocal = f5830c;
        Pair<Rect, Rect> pair = threadLocal.get();
        if (pair == null) {
            Pair<Rect, Rect> pair2 = new Pair<>(new Rect(), new Rect());
            threadLocal.set(pair2);
            return pair2;
        }
        ((Rect) pair.f6296a).setEmpty();
        ((Rect) pair.f6297b).setEmpty();
        return pair;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: android.graphics.PorterDuffXfermode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.graphics.PorterDuffXfermode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.graphics.PorterDuffXfermode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.graphics.PorterDuffXfermode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: android.graphics.PorterDuffXfermode} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(@androidx.annotation.NonNull android.graphics.Paint r4, @androidx.annotation.Nullable androidx.core.graphics.BlendModeCompat r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            r2 = 1
            r3 = 0
            if (r0 < r1) goto L_0x0012
            if (r5 == 0) goto L_0x000e
            java.lang.Object r3 = androidx.core.graphics.BlendModeUtils.Api29Impl.a(r5)
        L_0x000e:
            androidx.core.graphics.PaintCompat.Api29Impl.a(r4, r3)
            return r2
        L_0x0012:
            if (r5 == 0) goto L_0x0027
            android.graphics.PorterDuff$Mode r5 = androidx.core.graphics.BlendModeUtils.a(r5)
            if (r5 == 0) goto L_0x001f
            android.graphics.PorterDuffXfermode r3 = new android.graphics.PorterDuffXfermode
            r3.<init>(r5)
        L_0x001f:
            r4.setXfermode(r3)
            if (r5 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            return r2
        L_0x0027:
            r4.setXfermode(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PaintCompat.c(android.graphics.Paint, androidx.core.graphics.BlendModeCompat):boolean");
    }
}
