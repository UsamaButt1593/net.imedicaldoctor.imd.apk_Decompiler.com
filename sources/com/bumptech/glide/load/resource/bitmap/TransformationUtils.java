package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import net.imedicaldoctor.imd.BuildConfig;

public final class TransformationUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18333a = "TransformationUtils";

    /* renamed from: b  reason: collision with root package name */
    public static final int f18334b = 6;

    /* renamed from: c  reason: collision with root package name */
    private static final Paint f18335c = new Paint(6);

    /* renamed from: d  reason: collision with root package name */
    private static final int f18336d = 7;

    /* renamed from: e  reason: collision with root package name */
    private static final Paint f18337e = new Paint(7);

    /* renamed from: f  reason: collision with root package name */
    private static final Paint f18338f;

    /* renamed from: g  reason: collision with root package name */
    private static final Set<String> f18339g;

    /* renamed from: h  reason: collision with root package name */
    private static final Lock f18340h;

    private interface DrawRoundedCornerFn {
        void a(Canvas canvas, Paint paint, RectF rectF);
    }

    private static final class NoLock implements Lock {
        NoLock() {
        }

        public void lock() {
        }

        public void lockInterruptibly() throws InterruptedException {
        }

        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        public boolean tryLock() {
            return true;
        }

        public void unlock() {
        }

        public boolean tryLock(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        f18339g = hashSet;
        f18340h = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new NoLock();
        Paint paint = new Paint(7);
        f18338f = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private TransformationUtils() {
    }

    private static void a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Lock lock = f18340h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f18335c);
            e(canvas);
            lock.unlock();
        } catch (Throwable th) {
            f18340h.unlock();
            throw th;
        }
    }

    public static Bitmap b(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        float f2;
        float f3;
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f4 = 0.0f;
        if (bitmap.getWidth() * i3 > bitmap.getHeight() * i2) {
            f3 = ((float) i3) / ((float) bitmap.getHeight());
            f4 = (((float) i2) - (((float) bitmap.getWidth()) * f3)) * 0.5f;
            f2 = 0.0f;
        } else {
            f3 = ((float) i2) / ((float) bitmap.getWidth());
            f2 = (((float) i3) - (((float) bitmap.getHeight()) * f3)) * 0.5f;
        }
        matrix.setScale(f3, f3);
        matrix.postTranslate((float) ((int) (f4 + 0.5f)), (float) ((int) (f2 + 0.5f)));
        Bitmap f5 = bitmapPool.f(i2, i3, k(bitmap));
        t(bitmap, f5);
        a(bitmap, f5, matrix);
        return f5;
    }

    public static Bitmap c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
            if (Log.isLoggable(f18333a, 2)) {
                Log.v(f18333a, "requested target size too big for input, fit centering instead");
            }
            return f(bitmapPool, bitmap, i2, i3);
        }
        if (Log.isLoggable(f18333a, 2)) {
            Log.v(f18333a, "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    public static Bitmap d(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        int min = Math.min(i2, i3);
        float f2 = (float) min;
        float f3 = f2 / 2.0f;
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float max = Math.max(f2 / width, f2 / height);
        float f4 = width * max;
        float f5 = max * height;
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f2 - f5) / 2.0f;
        RectF rectF = new RectF(f6, f7, f4 + f6, f5 + f7);
        Bitmap g2 = g(bitmapPool, bitmap);
        Bitmap f8 = bitmapPool.f(min, min, h(bitmap));
        f8.setHasAlpha(true);
        Lock lock = f18340h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(f8);
            canvas.drawCircle(f3, f3, f3, f18337e);
            canvas.drawBitmap(g2, (Rect) null, rectF, f18338f);
            e(canvas);
            lock.unlock();
            if (!g2.equals(bitmap)) {
                bitmapPool.e(g2);
            }
            return f8;
        } catch (Throwable th) {
            f18340h.unlock();
            throw th;
        }
    }

    private static void e(Canvas canvas) {
        canvas.setBitmap((Bitmap) null);
    }

    public static Bitmap f(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            if (Log.isLoggable(f18333a, 2)) {
                Log.v(f18333a, "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(((float) i2) / ((float) bitmap.getWidth()), ((float) i3) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable(f18333a, 2)) {
                Log.v(f18333a, "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap f2 = bitmapPool.f((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), k(bitmap));
        t(bitmap, f2);
        if (Log.isLoggable(f18333a, 2)) {
            Log.v(f18333a, "request: " + i2 + "x" + i3);
            Log.v(f18333a, "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v(f18333a, "toReuse: " + f2.getWidth() + "x" + f2.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(min);
            Log.v(f18333a, sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, f2, matrix);
        return f2;
    }

    private static Bitmap g(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap) {
        Bitmap.Config h2 = h(bitmap);
        if (h2.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap f2 = bitmapPool.f(bitmap.getWidth(), bitmap.getHeight(), h2);
        new Canvas(f2).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return f2;
    }

    @NonNull
    private static Bitmap.Config h(@NonNull Bitmap bitmap) {
        return (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16;
    }

    public static Lock i() {
        return f18340h;
    }

    public static int j(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return BuildConfig.f29478d;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return TIFFConstants.e0;
            default:
                return 0;
        }
    }

    @NonNull
    private static Bitmap.Config k(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    @VisibleForTesting
    static void l(int i2, Matrix matrix) {
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
        matrix.postScale(-1.0f, 1.0f);
    }

    public static boolean m(int i2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap n(@NonNull Bitmap bitmap, int i2) {
        if (i2 == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) i2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e2) {
            if (!Log.isLoggable(f18333a, 6)) {
                return bitmap;
            }
            Log.e(f18333a, "Exception when trying to orient image", e2);
            return bitmap;
        }
    }

    public static Bitmap o(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2) {
        if (!m(i2)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        l(i2, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap f2 = bitmapPool.f(Math.round(rectF.width()), Math.round(rectF.height()), k(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        f2.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, f2, matrix);
        return f2;
    }

    public static Bitmap p(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, final float f2, final float f3, final float f4, final float f5) {
        return s(bitmapPool, bitmap, new DrawRoundedCornerFn() {
            public void a(Canvas canvas, Paint paint, RectF rectF) {
                Path path = new Path();
                float f2 = f2;
                float f3 = f3;
                float f4 = f4;
                float f5 = f5;
                path.addRoundRect(rectF, new float[]{f2, f2, f3, f3, f4, f4, f5, f5}, Path.Direction.CW);
                canvas.drawPath(path, paint);
            }
        });
    }

    public static Bitmap q(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, final int i2) {
        Preconditions.a(i2 > 0, "roundingRadius must be greater than 0.");
        return s(bitmapPool, bitmap, new DrawRoundedCornerFn() {
            public void a(Canvas canvas, Paint paint, RectF rectF) {
                int i2 = i2;
                canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
            }
        });
    }

    @Deprecated
    public static Bitmap r(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3, int i4) {
        return q(bitmapPool, bitmap, i4);
    }

    private static Bitmap s(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, DrawRoundedCornerFn drawRoundedCornerFn) {
        Bitmap.Config h2 = h(bitmap);
        Bitmap g2 = g(bitmapPool, bitmap);
        Bitmap f2 = bitmapPool.f(g2.getWidth(), g2.getHeight(), h2);
        f2.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(g2, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, (float) f2.getWidth(), (float) f2.getHeight());
        Lock lock = f18340h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(f2);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            drawRoundedCornerFn.a(canvas, paint, rectF);
            e(canvas);
            lock.unlock();
            if (!g2.equals(bitmap)) {
                bitmapPool.e(g2);
            }
            return f2;
        } catch (Throwable th) {
            f18340h.unlock();
            throw th;
        }
    }

    public static void t(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
