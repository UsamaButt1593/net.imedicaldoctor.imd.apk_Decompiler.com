package com.airbnb.lottie.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

public final class Utils {

    /* renamed from: a  reason: collision with root package name */
    public static final int f17347a = 1000000000;

    /* renamed from: b  reason: collision with root package name */
    private static final PathMeasure f17348b = new PathMeasure();

    /* renamed from: c  reason: collision with root package name */
    private static final Path f17349c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private static final Path f17350d = new Path();

    /* renamed from: e  reason: collision with root package name */
    private static final float[] f17351e = new float[4];

    /* renamed from: f  reason: collision with root package name */
    private static final float f17352f = ((float) (Math.sqrt(2.0d) / 2.0d));

    /* renamed from: g  reason: collision with root package name */
    private static float f17353g = -1.0f;

    private Utils() {
    }

    public static void a(Path path, float f2, float f3, float f4) {
        L.a("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f17348b;
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            L.b("applyTrimPathIfNeeded");
        } else if (length < 1.0f || ((double) Math.abs((f3 - f2) - 1.0f)) < 0.01d) {
            L.b("applyTrimPathIfNeeded");
        } else {
            float f5 = f2 * length;
            float f6 = f3 * length;
            float f7 = f4 * length;
            float min = Math.min(f5, f6) + f7;
            float max = Math.max(f5, f6) + f7;
            if (min >= length && max >= length) {
                min = (float) MiscUtils.f(min, length);
                max = (float) MiscUtils.f(max, length);
            }
            if (min < 0.0f) {
                min = (float) MiscUtils.f(min, length);
            }
            if (max < 0.0f) {
                max = (float) MiscUtils.f(max, length);
            }
            int i2 = (min > max ? 1 : (min == max ? 0 : -1));
            if (i2 == 0) {
                path.reset();
            } else {
                if (i2 >= 0) {
                    min -= length;
                }
                Path path2 = f17349c;
                path2.reset();
                pathMeasure.getSegment(min, max, path2, true);
                if (max > length) {
                    Path path3 = f17350d;
                    path3.reset();
                    pathMeasure.getSegment(0.0f, max % length, path3, true);
                    path2.addPath(path3);
                } else if (min < 0.0f) {
                    Path path4 = f17350d;
                    path4.reset();
                    pathMeasure.getSegment(min + length, length, path4, true);
                    path2.addPath(path4);
                }
                path.set(path2);
            }
            L.b("applyTrimPathIfNeeded");
        }
    }

    public static void b(Path path, @Nullable TrimPathContent trimPathContent) {
        if (trimPathContent != null && !trimPathContent.j()) {
            a(path, ((FloatKeyframeAnimation) trimPathContent.h()).o() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.e()).o() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.g()).o() / 360.0f);
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f2 = pointF.x;
            float f3 = pointF2.x;
            float f4 = pointF2.y;
            path.cubicTo(pointF3.x + f2, pointF.y + pointF3.y, f3 + pointF4.x, f4 + pointF4.y, f3, f4);
        }
        return path;
    }

    public static float e() {
        if (f17353g == -1.0f) {
            f17353g = Resources.getSystem().getDisplayMetrics().density;
        }
        return f17353g;
    }

    public static float f(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float g(Matrix matrix) {
        float[] fArr = f17351e;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = f17352f;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        return (float) Math.hypot((double) (fArr[2] - fArr[0]), (double) (fArr[3] - fArr[1]));
    }

    public static boolean h(Matrix matrix) {
        float[] fArr = f17351e;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static int i(float f2, float f3, float f4, float f5) {
        int i2 = f2 != 0.0f ? (int) (((float) MetaDo.w) * f2) : 17;
        if (f3 != 0.0f) {
            i2 = (int) (((float) (i2 * 31)) * f3);
        }
        if (f4 != 0.0f) {
            i2 = (int) (((float) (i2 * 31)) * f4);
        }
        return f5 != 0.0f ? (int) (((float) (i2 * 31)) * f5) : i2;
    }

    public static boolean j(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        if (i3 < i6) {
            return false;
        }
        return i3 > i6 || i4 >= i7;
    }

    public static boolean k(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static Bitmap l(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, false);
        Bitmap createBitmap = Bitmap.createBitmap((int) rectF.right, (int) rectF.bottom, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        LPaint lPaint = new LPaint();
        lPaint.setAntiAlias(true);
        lPaint.setColor(-16776961);
        canvas.drawPath(path, lPaint);
        return createBitmap;
    }

    public static Bitmap m(Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static void n(Canvas canvas, RectF rectF, Paint paint) {
        o(canvas, rectF, paint, 31);
    }

    public static void o(Canvas canvas, RectF rectF, Paint paint, int i2) {
        L.a("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i2);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        L.b("Utils#saveLayer");
    }
}
